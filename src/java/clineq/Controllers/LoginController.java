
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clineq.Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clineq.data.*;
import clineq.business.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import javax.servlet.http.*;

/**
 *
 * @author songy04
 */
public class LoginController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //private static final String defaultURL = "/views/EQHome/iindex.jsp";
    private Users user = new Users();

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        System.out.println("doPost enter user controller dopost!");
        String requestURI = request.getRequestURI();
        String url = null;
        String userid = request.getParameter("inpUserName");
        String pwd = request.getParameter("inpPassword");
        HttpSession session = request.getSession();
        
        try {
            user = UserDB.selectUser(userid, pwd);
        } catch (Exception e) {
        }
        if (user != null) {
            String user_type = user.getUserType();
            if ("CLINEQ".equals(user_type)) {
                url = "/study/displayStudyList";
            } else if ("SITE".endsWith(user_type)) {
                url = "/site/displaySiteList";
            } else if ("SPONSOR".endsWith(user_type)) {
                url = "/sponsor/displaySponsorList";
            }
            session.setAttribute("loginResult", "");
            session.setAttribute("loginUserID", userid);
        } else {
//            response.sendRedirect("/login.jsp");
//            return;
            //request.getSession().invalidate();
            //url = "/eqhome/login.jsp";
            session.setAttribute("loginResult", "Incorrect User or Password");
            url = "../login.jsp";
            response.sendRedirect(url);
            return;
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        //RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String url = "/eqhome";
        System.out.println("doGet!");
        HttpSession session = request.getSession();
        session.removeAttribute("loginResult");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

}
