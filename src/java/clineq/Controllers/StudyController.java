/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clineq.Controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collection;
import java.util.Hashtable;

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
    private Organizations oneSite = null;

    private Collection<Users> userCollection = null;
    private ArrayList<Studies> studyArrayList = null;
    private ArrayList<String> studyStatusList = null;
    private ArrayList<String> orgStatusList = null;
    private ArrayList<String> sponsorNameList = null;
    private ArrayList<Users> orgUsersArrayList = null;
    private ArrayList<Users> newSponsorUserArrayList = null;
    private ArrayList<Users> oneSiteUserArrayList = null;
    private ArrayList<Organizations> orgArrayList = null;
    private ArrayList<Organizations> newOrgArrayList = null;
    private Hashtable htOrg = null;
    private ArrayList<Organizations> sponsorArrayList = null;
    private ArrayList<Organizations> siteArrayList = null;
    private ArrayList<Organizations> newSiteArrayList = null;
    private ArrayList<Organizations> arrayIWRSList = null;
    private ArrayList<Organizations> arrayEDCList = null;
    private String nextStudyID = null;
    private String nextOrgID = null;
    private String nextUserID = null;
    private String currPage = null;

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        boolean isAjax = false;

        System.out.println("enter study controller dopost!");
        String requestURI = request.getRequestURI();
        String url = "/eqhome";
        System.out.println("dopost NCTId=" + request.getParameter("NCTId"));
        System.out.println("dopost CoSponStudyId=" + request.getParameter("CoSponStudyId"));
        System.out.println("dopost study start date=" + request.getParameter("StudyStartDate"));

        if (requestURI.endsWith("displayStudyList")) {
            url = displayStudyList(request, response);
            //   if ("STUDYLIST_NODATA" url equal())
            System.out.println("the list is not empty!");
        } else if (requestURI.endsWith("newStudyMain")) {
            url = newStudyMain(request, response);
        } else if (requestURI.endsWith("newStudyMain0")) {
            url = newStudyMain0(request, response);
        } else if (requestURI.endsWith("newStudySponsor")) {
            url = newStudySponsor(request, response);
        } else if (requestURI.endsWith("newStudySponsorUserList")) {
            url = newStudySponsorUserList(request, response);
        } else if (requestURI.endsWith("saveNewStudy")) {
            url = saveNewStudy(request, response, "Pending");
        } else if (requestURI.endsWith("saveNewStudyDraft")) {
            url = saveNewStudy(request, response, "Draft");
        } else if (requestURI.endsWith("AddSponsorToStudy")) {
            url = addSponsorToStudy(request, response);
        } else if (requestURI.endsWith("addSiteToStudy")) {
            url = addSiteToStudy(request, response);
        } else if (requestURI.endsWith("inputSiteToStudy")) {
            url = inputSiteToStudy(request, response);
        } else if (requestURI.endsWith("inputSponsorToStudy")) {
            url = inputSponsorToStudy(request, response);
        } else if (requestURI.endsWith("addUserToOrg")) {
            url = addUserToOrg(request, response);
        } else if (requestURI.endsWith("inputUserToOrg")) {
            url = inputUserToOrg(request, response);
        } else if (requestURI.endsWith("newStudySite")) {
            url = newStudySite(request, response);
        } else if (requestURI.endsWith("newStudySiteUserList")) {
            url = newStudySiteUserList(request, response);

        } else if (requestURI.endsWith("newStudyIWRS")) {
            url = newStudyIWRS(request, response);
        } else if (requestURI.endsWith("newStudyEDC")) {
            url = newStudyEDC(request, response);
        } else if (requestURI.endsWith("/getBasicInfo")) {
            url = getBasicInfo(request, response);
            isAjax = true;
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
        } else if (requestURI.endsWith("newStudyMain")) {
            url = newStudyMain(request, response);
        } else if (requestURI.endsWith("newStudyMain0")) {
            url = newStudyMain0(request, response);
        } else if (requestURI.endsWith("newStudySponsor")) {
            url = newStudySponsor(request, response);
        } else if (requestURI.endsWith("/newStudySite")) {
            url = newStudySite(request, response);
        } else {
            url = "/eqhome/error.jsp";
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    public String getBasicInfo(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String jsonInStudy = "";
        if (br != null) {
            jsonInStudy = br.readLine();
        }

        ObjectMapper mapper = new ObjectMapper();
        System.out.println("jsonInStudy=" + jsonInStudy);

        Studies study = mapper.readValue(jsonInStudy, Studies.class);

        return jsonInStudy;
    }

    private String displayStudyList(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        try {
            studyArrayList = StudyDB.selectAllStudy();
            studyStatusList = SysCodeRegistryDB.selectAllStudyStatus();
            sponsorNameList = StudyDB.selectAllStudySponsorName();

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
            url = "/eqhome/index.jsp";
            System.out.println("url " + url);
            return url;
        } else {
            //System.out.println("url " );
            return "/eqhome/index.jsp";
        }
    }

    private String newStudyMain0(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        String url;

        HttpSession session = request.getSession();
        session.removeAttribute("newStudy");
        session.removeAttribute("sponsor");
        session.removeAttribute("newSponsorUserArrayList");
        session.removeAttribute("orgUsersArrayList");
        session.removeAttribute("newSiteArrayList");

        url = "/eqhome/newStudyMain.jsp";
        System.out.println("url " + url);
        return url;

    }

    private String newStudyMain(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String url;

        HttpSession session = request.getSession();

        // Deal with the back button for newStudySponsor page
        sponsor = getOrganization(request);
        session.setAttribute("sponsor", sponsor);
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
            orgArrayList = OrganizationDB.selectOrganizationByType("SPONSOR");
            nextStudyID = StudyDB.generateStudyID();
            nextOrgID = OrganizationDB.generateOrgID();
            nextUserID = UserDB.generateUserID();
            study = getStudy(request);
            session.setAttribute("newStudy", study);
        } catch (DBException e) {
            System.err.println();
        } catch (Exception e) {
            System.err.println();
        }
        ObjectMapper mapper = new ObjectMapper();
        if (orgArrayList != null) {

            session.setAttribute("orgStatusList", orgStatusList);

            String jsonInOrgArrayList = mapper.writeValueAsString(orgArrayList);
            session.setAttribute("orgArrayList", orgArrayList);

            session.setAttribute("jsonInOrgArr", jsonInOrgArrayList);

            session.setAttribute("sponsorArrayList", sponsorArrayList);
            session.setAttribute("nextStudyID", nextStudyID);
            session.setAttribute("nextSponsorID", nextOrgID);
            session.setAttribute("nextUserID", nextUserID);

            session.setAttribute("sponsorArrayList", sponsorArrayList);
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
                System.out.println("request.getParameter(optionsRadiosAddSponsorToStudy):" + request.getParameter("optionsRadiosAddSponsorToStudy"));
                System.out.println("item.getEqOrgId():" + item.getEqOrgId());
                if (item.getEqOrgId().equals(request.getParameter("optionsRadiosAddSponsorToStudy"))) {
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

    private String addSiteToStudy(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        String url;

        HttpSession session = request.getSession();
        try {
            for (Organizations item : siteArrayList) {
                System.out.println("request.getParameter(optionsRadiosAddSiteToStudy):" + request.getParameter("optionsRadiosAddSiteToStudy"));
                System.out.println("item.getEqOrgId():" + item.getEqOrgId());
                if (item.getEqOrgId().equals(request.getParameter("optionsRadiosAddSiteToStudy"))) {
                    if (newSiteArrayList == null) {
                        newSiteArrayList = new ArrayList<Organizations>();
                    }
                    newSiteArrayList.add(item);
                    session.setAttribute("newSiteArrayList", newSiteArrayList);
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        url = "/eqhome/newStudySite.jsp";
        System.out.println("url " + url);
        return url;

    }

    private String inputSponsorToStudy(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        String url;

        HttpSession session = request.getSession();
        try {
            sponsor = getOrganization(request);
            sponsor.setEqOrgId(OrganizationDB.generateOrgID());
            System.out.println("sponsor address1" + sponsor.getAddress1());
            System.out.println("sponsor full name" + sponsor.getOrgFullName());
            session.setAttribute("sponsor", sponsor);

        } catch (Exception e) {
            e.printStackTrace();
        }
        url = "/eqhome/newStudySponsor.jsp";
        System.out.println("url " + url);
        return url;

    }

    private String inputSiteToStudy(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        String url;

        HttpSession session = request.getSession();
        try {
            oneSite = getOrganization(request);
            oneSite.setEqOrgId(OrganizationDB.generateOrgID());
            if (newSiteArrayList == null) {
                newSiteArrayList = new ArrayList<Organizations>();
            }
            newSiteArrayList.add(oneSite);
            session.setAttribute("newSiteArrayList", newSiteArrayList);

        } catch (Exception e) {
            e.printStackTrace();
        }
        url = "/eqhome/newStudySite.jsp";
        System.out.println("url " + url);
        return url;

    }

    private String addUserToOrg(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        String url = null;
        System.out.println("addUserToOrg");
        HttpSession session = request.getSession();
        try {
            for (Users item : orgUsersArrayList) {
                System.out.println("request.getParameter(optionsRadiosSearchUser):" + request.getParameter("optionsRadiosSearchUser"));
                System.out.println("item.getEqUserId():" + item.getEqUserId());
                if (item.getEqUserId().equals(request.getParameter("optionsRadiosSearchUser"))) {
                    System.out.println("equal");
                    if (newSponsorUserArrayList == null) {
                        newSponsorUserArrayList = new ArrayList<Users>();
                    }
//                    if (currentOrg.getUsersCollection() == null)
//                    {
//                        userCollection = new ArrayList<Users>();
//                    }
                    System.out.println("add to collection");
                    newSponsorUserArrayList.add(item);
                    //userCollection.add(item);
                    sponsor.setUsersCollection(newSponsorUserArrayList);
                    //sponsor.getUsersCollection().add(item);
                    session.setAttribute("newSponsorUserArrayList", newSponsorUserArrayList);
                    session.setAttribute("sponsor", sponsor);
                    System.out.println("add to session");
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        url = "/eqhome/newStudySponsorUserList.jsp";
        if ("SPONSOR".equals(sponsor.getOrgType())) {
            url = "/eqhome/newStudySponsorUserList.jsp";
        } else if ("SITE".equals(sponsor.getOrgType())) {
            url = "/eqhome/newStudySiteUserList.jsp";
        }

        System.out.println("url " + url);
        return url;

    }

    private String inputUserToOrg(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        String url=null;

        HttpSession session = request.getSession();
        try {

            Users user = getUser(request);
            user.setEqUserId(UserDB.generateUserID());
            user.setEqOrgId(sponsor);

            if (newSponsorUserArrayList == null) {
                newSponsorUserArrayList = new ArrayList<Users>();
            }

            newSponsorUserArrayList.add(user);
            sponsor.setUsersCollection(newSponsorUserArrayList);
            //sponsor.getUsersCollection().add(item);
            session.setAttribute("newSponsorUserArrayList", newSponsorUserArrayList);
            session.setAttribute("sponsor", sponsor);

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if ("SITE".equals(currPage)) {
            url = "/eqhome/newStudySiteUserList.jsp";
        }
        else if ("SPONSOR".equals(currPage)) {
            url = "/eqhome/newStudySponsorUserList.jsp";
        }
        System.out.println("url " + url);
        return url;

    }

    private String saveNewStudy(HttpServletRequest request,
            HttpServletResponse response, String status) throws IOException {

        String url;
        HttpSession session = request.getSession();

        try {
            study = (Studies) session.getAttribute("newStudy");
            if (study != null) {
                StudyDB.saveStudy(study);
            }
            newOrgArrayList = (ArrayList<Organizations>) session.getAttribute("newOrgArrayList");
            if (newOrgArrayList != null) {
                for (int i = 0; i < newOrgArrayList.size(); i++) {
                    OrganizationDB.saveOrgNUserNMap(study.getEqStudyId(), newOrgArrayList.get(i));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        url = "/eqhome/newStudySaved.jsp";
        System.out.println("url " + url);
        return url;

    }

    private String newStudySponsorUserList(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        String url;
        HttpSession session = request.getSession();
        currPage = "SPONSOR";

        try {

            // User input sponsor info. instead of pick from the list
            sponsor = getOrganization(request);
            if (sponsor.getEqOrgId() == null && sponsor.getEqOrgId().equals("")) {
                sponsor.setEqOrgId(OrganizationDB.generateOrgID());
            }
            sponsor.setUsersCollection(newSponsorUserArrayList);

            orgUsersArrayList = UserDB.selectUsers(sponsor.getEqOrgId(), "SPONSOR");
            //System.out.println("sponsor address1" + sponsor.getAddress1());
            //System.out.println("sponsor full name" + sponsor.getOrgFullName());
            session.setAttribute("sponsor", sponsor);
            session.setAttribute("orgUsersArrayList", orgUsersArrayList);

        } catch (DBException e) {
            System.err.println();
        } catch (Exception e) {
            System.err.println();
        }

        url = "/eqhome/newStudySponsorUserList.jsp";
        System.out.println("url " + url);
        return url;

    }

    private String newStudySiteUserList(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        String url;
        HttpSession session = request.getSession();
        currPage = "SITE";

        try {

            // select the current select site
            for (Organizations site : newSiteArrayList) {
                if (site.getEqOrgId().equals(request.getParameter("sltStudySiteUserList"))) {
                    sponsor = site;
                    break;
                }
            }

            oneSiteUserArrayList = UserDB.selectUsers(sponsor.getEqOrgId(), "SITE");
            //System.out.println("sponsor address1" + sponsor.getAddress1());
            //System.out.println("sponsor full name" + sponsor.getOrgFullName());
            session.setAttribute("oneSiteUserArrayList", oneSiteUserArrayList);

        } catch (DBException e) {
            System.err.println();
        } catch (Exception e) {
            System.err.println();
        }

        url = "/eqhome/newStudySiteUserList.jsp";
        System.out.println("url " + url);
        return url;

    }

    private String newStudySite(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        String url;
        HttpSession session = request.getSession();

        try {
            siteArrayList = OrganizationDB.selectOrganizationByType("SITE");
            if (htOrg == null) {
                htOrg = new Hashtable();
            }
            htOrg.put(sponsor.getEqOrgId(), sponsor);

        } catch (DBException e) {
            System.err.println();
        } catch (Exception e) {
            System.err.println();
        }

        if (siteArrayList != null) {
            ObjectMapper mapper = new ObjectMapper();
            session.setAttribute("siteArrayList", siteArrayList);
            String jsonInSiteArrayList = mapper.writeValueAsString(siteArrayList);
            session.setAttribute("jsonInSiteArr", jsonInSiteArrayList);
        }

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
            org.setStatus(request.getParameter("StudyStatus"));

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
