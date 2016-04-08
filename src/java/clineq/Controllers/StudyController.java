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
import java.text.ParseException;
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
    private ArrayList<String> orgStatusList = null;
    private ArrayList<String> sponsorNameList = null;
    private ArrayList<Users> userArrayList = null;
    private ArrayList<Organizations> orgArrayList = null;
    private ArrayList<Organizations> siteArrayList = null;
    private ArrayList<Organizations> arrayIWRSList = null;
    private ArrayList<Organizations> arrayEDCList = null;

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        System.out.println("enter study controller dopost!");
        String requestURI = request.getRequestURI();
        String url = "/eqhome";
        System.out.println("dopost NCTId=" + request.getParameter("NCTId"));
        System.out.println("dopost CoSponStudyId=" + request.getParameter("CoSponStudyId"));
        System.out.println("dopost study start date=" + request.getParameter("StudyStartDate"));

        if (requestURI.endsWith("/displayStudyList")) {
            url = displayStudyList(request, response);
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
        } else if (requestURI.endsWith("/newStudySite")) {
            url = newStudySite(request, response);
        } else if (requestURI.endsWith("/newStudyIWRS")) {
            url = newStudyIWRS(request, response);
        } else if (requestURI.endsWith("/newStudyEDC")) {
            url = newStudyEDC(request, response);
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
        } else if (requestURI.endsWith("/newStudySite")) {
            url = newStudySite(request, response);
        } else {
            url = "/eqhome/error.jsp";
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    private String displayStudyList(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        try {
            studyArrayList = StudyDB.selectAllStudy();
            studyStatusList = StudyDB.selectAllStudyStatus();
            //orgStatusList = StudyDB.selectAllOrgStatus();
            sponsorNameList = StudyDB.selectAllStudySponsorName();
//            userArrayList = UserDB.selectAllUser();
//            orgArrayList = OrganizationDB.selectAllOrganization();
//            siteArrayList = SiteLocationDB.selectAllSiteLocations();

        } catch (DBException e) {
            System.err.println();
        }

        String url;

        HttpSession session = request.getSession();

        if (studyArrayList != null) {
            System.out.println("i checking array");
            session.setAttribute("studyArrayList", studyArrayList);
            session.setAttribute("studyStatusList", studyStatusList);
            //session.setAttribute("orgStatusList", orgStatusList);
            session.setAttribute("sponsorNameList", sponsorNameList);
//            session.setAttribute("userArrayList", userArrayList);
//            session.setAttribute("orgArrayList", orgArrayList);
//            session.setAttribute("siteArrayList", siteArrayList);
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

        String url;

        HttpSession session = request.getSession();

        url = "/eqhome/newStudyMain.jsp";
        System.out.println("url " + url);
        return url;

    }

    private String newStudySponsor(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        String url;

        HttpSession session = request.getSession();

        try {

            orgStatusList = StudyDB.selectAllOrgStatus();
            userArrayList = UserDB.selectAllUser();
            orgArrayList = OrganizationDB.selectAllOrganization();

            study = getStudy(request);
            session.setAttribute("newStudy", study);
        } catch (DBException e) {
            System.err.println();
        } catch (Exception e) {
            System.err.println();
        }

        if (orgArrayList != null) {

            session.setAttribute("orgStatusList", orgStatusList);
            session.setAttribute("userArrayList", userArrayList);
            session.setAttribute("orgArrayList", orgArrayList);
        }

        url = "/eqhome/newStudySponsor.jsp";
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
        url = "/eqhome/newStudySponsor.jsp";
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
                if (sponsor != null) {
                    study.setSponStudyId(sponsor.getEqOrgId());
                }

                StudyDB.saveStudy(study);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        url = "/eqhome/newStudySponsor.jsp";
        System.out.println("url " + url);
        return url;

    }

    private String newStudySite(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        String url;
        HttpSession session = request.getSession();

        try {
            siteArrayList = OrganizationDB.selectOrganizationByType("SITE");

        } catch (DBException e) {
            System.err.println();
        }

        if (siteArrayList != null) {
            session.setAttribute("siteArrayList", siteArrayList);
        }

//        try {
//
//            sponsor = getOrganization(request);
//            if (sponsor != null) {
//                OrganizationDB.saveOrg(sponsor);
//            }
//            study = getStudy(request);
//            if (study != null) {
//                if (sponsor != null) {
//                    study.setSponStudyId(sponsor.getEqOrgId());
//                }
//
//                StudyDB.saveStudy(study);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        url = "/eqhome/newStudySite.jsp";
        System.out.println("url " + url);
        return url;

    }

    private String newStudyIWRS(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        String url;
        HttpSession session = request.getSession();

        try {
            arrayIWRSList = OrganizationDB.selectOrganizationByType("IWRS");

        } catch (DBException e) {
            System.err.println();
        }

        if (siteArrayList != null) {
            session.setAttribute("arrayIWRSList", arrayIWRSList);
        }

        url = "/eqhome/newStudyIWRS.jsp";
        System.out.println("url " + url);
        return url;

    }
    
       private String newStudyEDC(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        String url;
        HttpSession session = request.getSession();

        try {
            arrayEDCList = OrganizationDB.selectOrganizationByType("EDC");

        } catch (DBException e) {
            System.err.println();
        }

        if (siteArrayList != null) {
            session.setAttribute("arrayEDCList", arrayEDCList);
        }

        url = "/eqhome/newStudyEDC.jsp";
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

    public Studies getStudy(HttpServletRequest request)
            throws IOException, ServletException {
        Studies study = new Studies();
        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");

        String studyStartDate = null;
        String studyEndDate = null;
        String eQSetDate = null;
        String eQClsDate = null;
        String planSubNum = null;

        try {
            study.setNctid(request.getParameter("NCTId"));
            study.setEuStudyId(request.getParameter("EUStudyId"));
            study.setStudyAname(request.getParameter("StudyAname"));
            study.setStudyTitle(request.getParameter("StudyTitle"));
            study.setSponStudyId(request.getParameter("SponStudyId"));
            study.setCoSponStudyId(request.getParameter("CoSponStudyId"));
            System.out.println("CoSponStudyId=" + request.getParameter("CoSponStudyId"));
            System.out.println("study start date=" + request.getParameter("StudyStartDate"));

            studyStartDate = request.getParameter("StudyStartDate");
            if (studyStartDate != null && !studyStartDate.equals("")) {
                try {
                    study.setStudyStartDate(formatter.parse(studyStartDate));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            studyEndDate = request.getParameter("StudyEndDate");
            if (studyEndDate != null && !studyEndDate.equals("")) {

                try {
                    study.setStudyEndDate(formatter.parse(studyEndDate));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            planSubNum = request.getParameter("PlanSubNum");
            if (planSubNum != null && !planSubNum.equals("")) {
                try {
                    study.setPlannedPatientsNum(Integer.parseInt(planSubNum));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            eQSetDate = request.getParameter("EQSetDate");
            if (eQSetDate != null && !eQSetDate.equals("")) {

                try {
                    study.setStudyEqInitDate(formatter.parse(eQSetDate));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            eQClsDate = request.getParameter("EQClsDate");
            if (eQClsDate != null && !eQClsDate.equals("")) {

                try {
                    study.setStudyEqCloseDate(formatter.parse(eQClsDate));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

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
            return null;
        }
        return org;
    }

    public Users getUser(HttpServletRequest request)
            throws IOException, ServletException {
        Users user = new Users();
        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
        String formCNUAccSetDate = null;
        try {

            user.setLname(request.getParameter("FormCNULastName"));
            user.setFname(request.getParameter("FormCNUFirstName"));
            user.setTitle(request.getParameter("FormCNUTitle"));
            user.setAddress1(request.getParameter("FormCNUAddress1"));
            user.setAddress2(request.getParameter("FormCNUAddress2"));
            user.setCity(request.getParameter("FormCNUCity"));
            user.setState(request.getParameter("FormCNUState"));
            user.setZip(request.getParameter("FormCNUZip"));
            user.setCountry(request.getParameter("FormCNUCountry"));
            user.setPhone(request.getParameter("FormCNUPhone"));
            user.setFax(request.getParameter("FormCNUFax"));
            user.setExternalEmployerId(request.getParameter("FormCNUExEmId"));
            user.setUserType(request.getParameter("FormCNUUserType"));
            user.setUserRole(request.getParameter("FormCNUUserRole"));
            user.setUserLoginId(request.getParameter("FormCNUUserLogId"));
            user.setUserLoginPwd(request.getParameter("FormCNUUserPass"));
            user.setExternalDeptName(request.getParameter("FormCNUExDep"));

            formCNUAccSetDate = request.getParameter("FormCNUAccSetDate");
            if (formCNUAccSetDate != null && !formCNUAccSetDate.equals("")) {
                study.setStudyStartDate(formatter.parse(formCNUAccSetDate));
            }

            user.setStatus(request.getParameter("FormCNUStatus"));

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
        return user;
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
