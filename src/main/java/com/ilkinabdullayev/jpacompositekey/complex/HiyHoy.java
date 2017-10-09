/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ilkinabdullayev.jpacompositekey.complex;

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
@WebServlet(name = "HiyHoy", urlPatterns = {"/HiyHoy"})
public class HiyHoy extends HttpServlet {

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

        if (action.equals("dogInsert")) {
            try {
                ut.begin();

                for (int i = 1; i <= 111; i++) {
                    DogHouse dgh=new DogHouse();
                    dgh.setBrand("Brand"+i);
                    
                    Dog dog=new Dog();
                    dog.setId(i);
                    dog.setName("Dog"+i);
                    em.persist(dog);
                    
                    dgh.setDog(dog);
                    em.persist(dgh);
                }

                ut.commit();
                
                print(request, response, "<h1>Insert successfull</h1>");
            } catch (Exception ex) {
                try {
                    ut.rollback();
                    Logger.getLogger(HiyHoy.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex1) {
                    Logger.getLogger(HiyHoy.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        } else if (action.equals("dogFind")) {
            int dogId = Integer.parseInt(request.getParameter("dogId"));

            Dog dog = em.find(Dog.class,dogId);
            if (dog != null) {
                DogHouse dh = em.find(DogHouse.class, dogId);
                print(request, response, "<h1>" + dh.toString() + "</h1>");
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
