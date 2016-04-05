/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clineq.Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clineq.data.*;
import clineq.business.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.http.HttpSession;

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
    private Studies study = null;
    private Organizations sponsor = null;
    private ArrayList<Studies> studyArrayList = null;
    private ArrayList<String> studyStatusList = null;
    private ArrayList<String> sponsorNameList = null;
    private ArrayList<Users> userArrayList = null;
    private ArrayList<Organizations> orgArrayList = null;

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        System.out.println("enter study controller dopost!");
        String requestURI = request.getRequestURI();
        String userid = request.getParameter("inpUserName");
        System.out.println("in study controler, userid="+userid); 
        String url = "/siteHome";
        System.out.println("dopost NCTId=" + request.getParameter("NCTId"));
                System.out.println("dopost NCTId=" + request.getParameter("NCTId"));
        System.out.println("URI=" + requestURI);

        System.out.println("dopost CoSponStudyId=" + request.getParameter("CoSponStudyId"));
        System.out.println("dopost study start date=" + request.getParameter("StudyStartDate"));

        if (requestURI.endsWith("/displaySiteList")) {
            url = displaySiteList(request, response,userid);
            //   if ("STUDYLIST_NODATA" url equal())
            System.out.println("the list is not empty!");
        } else if (requestURI.endsWith("/createNewStudy")) {
            url = createNewStudy(request, response);
        } else if (requestURI.endsWith("/newStudySponsor")) {
            url = newStudySponsor(request, response);
        } else if (requestURI.endsWith("/saveNewStudy")) {
            url = saveNewStudy(request, response, "Pending");
        } else if (requestURI.endsWith("/saveNewStudyDraft")) {
            url = saveNewStudy(request, response, "Draft");
        } else if (requestURI.endsWith("/AddSponsorToStudy")) {
            url = addSponsorToStudy(request, response);
        } else {
            url = "/siteHome/error.jsp";
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String requestURI = request.getRequestURI();
        String url = "/siteHome";

        if (requestURI.endsWith("/displaySiteList")) {
            url = displaySiteList(request, response,request.getParameter("inpUserName"));
        } else if (requestURI.endsWith("/createNewStudy")) {
            url = createNewStudy(request, response);
        } else if (requestURI.endsWith("/newStudySponsor")) {
            url = newStudySponsor(request, response);
        } else {
            url = "/siteHome/error.jsp";
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    private String displaySiteList(HttpServletRequest request,
            HttpServletResponse response,String userId) throws IOException {

        try {
            studyArrayList = StudyDB.selectAllStudy(userId); 
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
            url = "/siteHome/index.jsp";
            System.out.println("url " + url);
            return url;
        } else {
            //System.out.println("url " );
            return "/siteHome/index.jsp";
        }
    }

    private String createNewStudy(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        String url;

        HttpSession session = request.getSession();

        url = "/siteHome/newStudyMain.jsp";
        System.out.println("url " + url);
        return url;

    }

    private String newStudySponsor(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        String url;

        HttpSession session = request.getSession();
        try {
            study = getStudy(request);
            session.setAttribute("newStudy", study);
        } catch (Exception e) {
            e.printStackTrace();
        }
        url = "/siteHome/newStudySponsor.jsp";
        System.out.println("url " + url);
        return url;

    }

    private String addSponsorToStudy(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        String url;

        HttpSession session = request.getSession();
        try {
            for (Organizations item : orgArrayList) {
                System.out.println("request.getParameter(optionsRadios):" + request.getParameter("optionsRadios"));
                System.out.println("item.getEqOrgId():" + item.getEqOrgId());
                if (item.getEqOrgId().equals(request.getParameter("optionsRadios"))) {
                    session.setAttribute("sponsor", item);
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        url = "/siteHome/newStudySponsor.jsp";
        System.out.println("url " + url);
        return url;

    }

    private String saveNewStudy(HttpServletRequest request,
            HttpServletResponse response, String status) throws IOException {

        String url;
        HttpSession session = request.getSession();
        try {
            //sponsor = (Organizations) session.getAttribute("sponsor");
            sponsor = getOrganization(request);
            if (sponsor != null) {
                OrganizationDB.saveOrg(sponsor);
            }
            study = getStudy(request);
            if (study != null) {
                study.setStudyStatus(status);
                if (sponsor != null)
                {
                    study.setSponStudyId(sponsor.getEqOrgId());
                }
                
                StudyDB.saveStudy(study);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        url = "/siteHome/newStudySponsor.jsp";
        System.out.println("url " + url);
        return url;

    }

    private String displayOrganizationList(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        ArrayList<Organizations> orgArrayList = null;

        try {
            orgArrayList = OrganizationDB.selectAllOrganization();

        } catch (DBException e) {
            System.err.println();
        }

        String url = "/siteHome/newStudySponsor.jsp";
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

    public Studies getStudy(HttpServletRequest request)
            throws IOException, ServletException {
        Studies study = new Studies();
        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");

        try {
            study.setNctid(request.getParameter("NCTId"));
            study.setEuStudyId(request.getParameter("EUStudyId"));
            study.setStudyAname(request.getParameter("StudyAname"));
            study.setStudyTitle(request.getParameter("StudyTitle"));
            study.setSponStudyId(request.getParameter("SponStudyId"));
            study.setCoSponStudyId(request.getParameter("CoSponStudyId"));
            System.out.println("CoSponStudyId=" + request.getParameter("CoSponStudyId"));
            System.out.println("study start date=" + request.getParameter("StudyStartDate"));
            study.setStudyStartDate(formatter.parse(request.getParameter("StudyStartDate")));
            study.setStudyEndDate(formatter.parse(request.getParameter("StudyEndDate")));
            study.setPlannedPatientsNum(Integer.parseInt(request.getParameter("PlanSubNum")));
            study.setStudyEqInitDate(formatter.parse(request.getParameter("EQSetDate")));
            study.setStudyEqCloseDate(formatter.parse(request.getParameter("EQClsDate")));
            study.setStudyStatus(request.getParameter("StudyStatus"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return study;
    }
    
    public Organizations getOrganization(HttpServletRequest request)
            throws IOException, ServletException {
        Organizations org = new Organizations();

        try {
            org.setEqOrgId(request.getParameter("EqSponId"));
            org.setOrgFullName(request.getParameter("SponName"));
            org.setOrgNameAbbr(request.getParameter("SponAB"));
            org.setOrgType(request.getParameter("SponType"));
            org.setOrgCategory(request.getParameter("SponCate"));
            org.setAddress1(request.getParameter("Address1"));
            org.setAddress2(request.getParameter("Address2"));
            org.setCity(request.getParameter("City"));
            org.setState(request.getParameter("State"));
            org.setZip(request.getParameter("Zip"));
            org.setCountry(request.getParameter("Country"));
            org.setPhone(request.getParameter("Phone"));
            org.setFax(request.getParameter("Fax"));
            org.setOrgUrl(request.getParameter("SponUrl"));
            org.setFax(request.getParameter("Fax"));
            org.setStatus(request.getParameter("Status"));
            
            


        } catch (Exception e) {
            e.printStackTrace();
        }
        return org;
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
