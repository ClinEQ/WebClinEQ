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
    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        System.out.println("doPost enter user controller dopost!");
        String requestURI = request.getRequestURI();
        String url = null;
        String userid = request.getParameter("userId");
        if (userExist(userid)) {
            url = "/study/displayStudyList";
            //url = "/eqhome/index.jsp";
        } else {
//            response.sendRedirect("/login.jsp");
//            return;
            request.getSession().invalidate();
            url = "/eqhome/login.jsp";
        }

        //RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String url = "/eqhome";
        System.out.println("doGet!");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
        
   }     

    private boolean userExist(String userLoginId) {
        ArrayList<Users> userArrayList = null;
        Users user = new Users();

        try {
            userArrayList = UserDB.selectAllUser();
            for (int i=0; i<userArrayList.size(); i++)
            {
                user = userArrayList.get(i);
                if (userLoginId.equals(user.getUserLoginId()))
                {
                    return true;
                }
            }

        } catch (DBException e) {
            System.err.println();
        }
        return false;
    }


}
