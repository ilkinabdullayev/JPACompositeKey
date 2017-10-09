/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ilkinabdullayev.jpacompositekey;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author ilkinabdullayev
 */
@WebServlet(name = "HoyHiy", urlPatterns = {"/HoyHiy"})
public class HoyHiy extends HttpServlet {

    @PersistenceContext
    EntityManager em;

    @Resource
    private UserTransaction ut;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            print(request, response, "<h1>Missing params!</h1>");
            return;
        }

        if (action.equals("phoneInsert")) {
            try {
                ut.begin();

                for (int i = 1; i <= 111; i++) {
                    Phone p = new Phone();
                    p.setPhoneId(i);
                    p.setPersonId(i);
                    p.setNumber("" + (10 * (i + i)));

                    em.persist(p);
                }

                ut.commit();
                
                print(request, response, "<h1>Insert successfull</h1>");
            } catch (Exception ex) {
                try {
                    ut.rollback();
                    Logger.getLogger(HoyHiy.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex1) {
                    Logger.getLogger(HoyHiy.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        } else if (action.equals("phoneFind")) {
            long phId = Long.parseLong(request.getParameter("phoneId"));
            long personId = Long.parseLong(request.getParameter("personId"));

            PhoneId phoneId = new PhoneId(phId, personId);
            Phone phone = em.find(Phone.class, phoneId);

            if (phone != null) {
                print(request, response, "<h1>" + phone.toString() + "</h1>");
            } else {
                print(request, response, "<h1>Null object</h1>");
            }
        }else if (action.equals("emailInsert")) {
            try {
                ut.begin();

                for (int i = 1; i <= 111; i++) {
                    Email e = new Email();

                    EmailId eid = new EmailId();
                    eid.setEmailId(i);
                    eid.setPersonId(i);

                    e.setEmailId(eid);
                    e.setEmail("hellocert@cert" + i + ".com");

                    em.persist(e);
                }

                ut.commit();
                
                print(request, response, "<h1>Insert successfull</h1>");
            } catch (Exception ex) {
                try {
                    ut.rollback();
                    Logger.getLogger(HoyHiy.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex1) {
                    Logger.getLogger(HoyHiy.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        } else if (action.equals("emailFind")) {
            long eId = Long.parseLong(request.getParameter("emailId"));
            long personId = Long.parseLong(request.getParameter("personId"));

            EmailId emailId = new EmailId(eId, personId);
            Email email = em.find(Email.class, emailId);

            if (email != null) {
                print(request, response, "<h1>" + email.toString() + "</h1>");
            } else {
                print(request, response, "<h1>Null object</h1>");
            }
        }
    }

    private void print(HttpServletRequest request, HttpServletResponse response, String html) throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HoyHiy</title>");
            out.println("</head>");
            out.println("<body>");
            out.println(html);
            out.println("</body>");
            out.println("</html>");
        }
    }
}
