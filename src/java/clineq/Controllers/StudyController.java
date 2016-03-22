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
public class StudyController extends HttpServlet {

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

        System.out.println("enter study controller dopost!");
        String requestURI = request.getRequestURI();
        String url = "/eqhome";

        if (requestURI.endsWith("/displayStudyList")) {
            url = displayStudyList(request, response);
            //   if ("STUDYLIST_NODATA" url equal())
            System.out.println("the list is not empty!");
        } else if (requestURI.endsWith("/createNewStudy")) {
            url = createNewStudy(request, response);
        } else if (requestURI.endsWith("/newStudySponsor")) {
            url = newStudySponsor(request, response);
        } else {
            url = "/eqhome/error.jsp";
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String requestURI = request.getRequestURI();
        String url = "/EQHome";

        if (requestURI.endsWith("/displayStudyList")) {
            url = displayStudyList(request, response);
        } else if (requestURI.endsWith("/createNewStudy")) {
            url = createNewStudy(request, response);
        } else if (requestURI.endsWith("/newStudySponsor")) {
            url = newStudySponsor(request, response);
        } else {
            url = "/eqhome/error.jsp";
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    private String displayStudyList(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        ArrayList<Studies> studyArrayList = null;
        ArrayList<String> studyStatusList = null;
        ArrayList<String> sponsorNameList = null;
        ArrayList<Users> userArrayList = null;
        ArrayList<Organizations> orgArrayList = null;

        try {
            studyArrayList = StudyDB.selectAllStudy();
            studyStatusList = StudyDB.selectAllStudyStatus();
            sponsorNameList = StudyDB.selectAllStudySponsorName();
            userArrayList = UserDB.selectAllUser();
            orgArrayList = OrganizationDB.selectAllOrganization();

        } catch (DBException e) {
            System.err.println();
        }

        String url;

        HttpSession session = request.getSession();

        if (studyArrayList != null) {
            System.out.println("i checking array");
            session.setAttribute("studyArrayList", studyArrayList);
            session.setAttribute("studyStatusList", studyStatusList);
            session.setAttribute("sponsorNameList", sponsorNameList);
            session.setAttribute("userArrayList", userArrayList);
            session.setAttribute("orgArrayList", orgArrayList);
            url = "/eqhome/index.jsp";
            System.out.println("url " + url);
            return url;
        } else {
            //System.out.println("url " );
            return "/eqhome/index.jsp";
        }
    }

    private String createNewStudy(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        //   ArrayList<Studies> studyArrayList = null;
        // try{
        //   studyArrayList = StudyDB.selectAllStudy();
        // }
        // catch (DBException e)
        // {
        //    System.err.println();
        //}
        String url;
        //if (unprocessedInvoices != null) {
        //    if (unprocessedInvoices.size() <= 0) {
        //        unprocessedInvoices = null;
        //   }
        // }

        HttpSession session = request.getSession();

        //if (studyArrayList != null) {
        //   System.out.println("i checking array");
        // session.setAttribute("studyArrayList", studyArrayList);
        url = "/eqhome/newStudyMain.jsp";
        System.out.println("url " + url);
        return url;
        //}else {
        //System.out.println("url " );
        //  return "/eqhome/index.jsp";
        //}
    }

    private String newStudySponsor(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        //   ArrayList<Studies> studyArrayList = null;
        // try{
        //   studyArrayList = StudyDB.selectAllStudy();
        // }
        // catch (DBException e)
        // {
        //    System.err.println();
        //}
        String url;
        //if (unprocessedInvoices != null) {
        //    if (unprocessedInvoices.size() <= 0) {
        //        unprocessedInvoices = null;
        //   }
        // }

        HttpSession session = request.getSession();

        //if (studyArrayList != null) {
        //   System.out.println("i checking array");
        // session.setAttribute("studyArrayList", studyArrayList);
        url = "/eqhome/newStudySponsor.jsp";
        System.out.println("url " + url);
        return url;
        //}else {
        //System.out.println("url " );
        //  return "/eqhome/index.jsp";
        //}
    }

    private String displayOrganizationList(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        ArrayList<Organizations> orgArrayList = null;

        try {
            orgArrayList = OrganizationDB.selectAllOrganization();

        } catch (DBException e) {
            System.err.println();
        }

        String url = "/eqhome/newStudySponsor.jsp";
        //if (unprocessedInvoices != null) {
        //    if (unprocessedInvoices.size() <= 0) {
        //        unprocessedInvoices = null;
        //   }
        // }

        HttpSession session = request.getSession();

        if (orgArrayList != null) {

            session.setAttribute("orgArrayList", orgArrayList);

        }
        return url;
    }
}

/*
+ private String displayInvoices(HttpServletRequest request,
+            HttpServletResponse response) throws IOException {
+
+        List<Invoice> unprocessedInvoices
+                = InvoiceDB.selectUnprocessedInvoices();
+       
+        String url;
+        if (unprocessedInvoices != null) {
+            if (unprocessedInvoices.size() <= 0) {
+                unprocessedInvoices = null;
+            }
+        }
+       
+        HttpSession session = request.getSession();
+        session.setAttribute("unprocessedInvoices", unprocessedInvoices);
+        url = "/admin/invoices.jsp";
+        return url;
+    }
+ */
//////////////////////
/*
 private String displayInvoices(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        List<Invoice> unprocessedInvoices
                = InvoiceDB.selectUnprocessedInvoices();
       
        String url;
        if (unprocessedInvoices != null) {
            if (unprocessedInvoices.size() <= 0) {
                unprocessedInvoices = null;
            }
        }
       
        HttpSession session = request.getSession();
        session.setAttribute("unprocessedInvoices", unprocessedInvoices);
        url = "/admin/invoices.jsp";
        return url;
    }
 */
