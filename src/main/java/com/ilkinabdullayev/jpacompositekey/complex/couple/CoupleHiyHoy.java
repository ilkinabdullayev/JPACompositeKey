/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ilkinabdullayev.jpacompositekey.complex.couple;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

/**
 *
 * @author ilkinabdullayev
 */
@WebServlet(name = "CoupleHiyHoy", urlPatterns = {"/CoupleHiyHoy"})
public class CoupleHiyHoy extends HttpServlet {

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

        if (action.equals("catInsert")) {
            try {
                ut.begin();

                for (int i = 1; i <= 111; i++) {
                    CatHouse ch = new CatHouse();
                    ch.setBrand("Brand" + i);

                    Cat cat = new Cat();
                    cat.setCatId(i);
                    cat.setName("Cat" + i);
                    em.persist(cat);

                    ch.setCat(cat);
                    //
                    Owner o = new Owner();
                    o.setOwnerId(i);
                    o.setName("Owner" + i);
                    em.persist(o);

                    ch.setOwner(o);
                    em.persist(ch);
                }

                ut.commit();

                print(request, response, "<h1>Insert successfull</h1>");
            } catch (Exception ex) {
                try {
                    ut.rollback();
                    Logger.getLogger(CoupleHiyHoy.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex1) {
                    Logger.getLogger(CoupleHiyHoy.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        } else if (action.equals("catFind")) {
            int catId = Integer.parseInt(request.getParameter("catId"));
            int ownerId = Integer.parseInt(request.getParameter("ownerId"));

            CatHouseId chId = new CatHouseId(ownerId, catId);
            CatHouse ch = em.find(CatHouse.class, chId);
            if (ch != null) {
                print(request, response, "<h1>" + ch.toString() + "</h1>");
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
