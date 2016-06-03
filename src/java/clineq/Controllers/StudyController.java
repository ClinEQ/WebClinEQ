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
import java.util.Set;

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
    private Organizations savedSponsor = null;
    private Organizations savedIWRS = null;
    private Organizations savedEDC = null;

    private Collection<Users> userCollection = null;
    private ArrayList<Studies> studyArrayList = null;
    private ArrayList<String> currStudyStatusList = null;
    private ArrayList<String> allStudyStatusList = null;
    private ArrayList<String> orgStatusList = null;
    private ArrayList<String> userStatusList = null;
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
//    private String nextStudyID = null;
//    private String nextOrgID = null;
//    private String nextUserID = null;
    private String currPage = null;
    boolean firstSelectOneSiteUsers = true;
    boolean iwrsPicked = false;

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        boolean isAjax = false;

//        System.out.println("enter study controller dopost!");
        String requestURI = request.getRequestURI();
        String url = "/eqhome";

//        System.out.println("dopost NCTId=" + request.getParameter("NCTId"));
//        System.out.println("dopost CoSponStudyId=" + request.getParameter("CoSponStudyId"));
//        System.out.println("dopost study start date=" + request.getParameter("StudyStartDate"));
        System.out.println("requestURI=" + requestURI);
        if (requestURI.endsWith("displayStudyList")) {
            url = displayStudyList(request, response);
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
        } else if (requestURI.endsWith("addOrgToStudy")) {
            url = addOrgToStudy(request, response);
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
        } else if (requestURI.endsWith("clearForm")) {
            url = clearForm(request, response);
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

        System.out.println("doGet requestURI=" + requestURI);
        if (requestURI.endsWith("/displayStudyList")) {
            url = displayStudyList(request, response);
        } else if (requestURI.endsWith("newStudyMain")) {
            url = newStudyMain(request, response);
        } else if (requestURI.endsWith("newStudyMain0")) {
            url = newStudyMain0(request, response);
        } else if (requestURI.endsWith("newStudySponsor")) {
            url = newStudySponsor(request, response);
        } else if (requestURI.endsWith("newStudySponsorUserList")) {
            url = newStudySponsorUserList(request, response);
        } else if (requestURI.endsWith("/newStudySite")) {
            url = newStudySite(request, response);
        } else if (requestURI.endsWith("newStudySiteUserList")) {
            url = newStudySiteUserList(request, response);
        } else if (requestURI.endsWith("newStudyIWRS")) {
            url = newStudyIWRS(request, response);
        } else if (requestURI.endsWith("newStudyEDC")) {
            url = newStudyEDC(request, response);
        } else if (requestURI.endsWith("removeUserFromOrg")) {
            url = removeUserFromOrg(request, response);
        } else if (requestURI.endsWith("removeSiteFromStudy")) {
            url = removeSiteFromStudy(request, response);
        } else if (requestURI.endsWith("clearForm")) {
            url = clearForm(request, response);
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

        //Studies study = mapper.readValue(jsonInStudy, Studies.class);
        return jsonInStudy;
    }

    private String displayStudyList(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        try {
            studyArrayList = StudyDB.selectAllStudy();
            allStudyStatusList = SysCodeRegistryDB.selectAllStudyStatus();
            currStudyStatusList = StudyDB.selectAllStudyStatus();
            sponsorNameList = StudyDB.selectAllStudySponsorName();

        } catch (DBException e) {
            System.err.println("DBException displayStudyList");
        } catch (Exception e) {
            System.err.println("Exception displayStudyList");
        }

        String url;

        HttpSession session = request.getSession();

        if (studyArrayList != null) {
//            System.out.println("i checking array");
            session.setAttribute("studyArrayList", studyArrayList);
            session.setAttribute("currStudyStatusList", currStudyStatusList);
            session.setAttribute("allStudyStatusList", allStudyStatusList);
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

        currPage = "newStudyMain";
        HttpSession session = request.getSession();
        session.removeAttribute("newStudy");
        session.removeAttribute("sponsor");
        session.removeAttribute("orgUsersArrayList");

        session.removeAttribute("oneSite");
        newSponsorUserArrayList = null;
        newSiteArrayList = null;
        oneSiteUserArrayList = null;

        oneSite = null;
        orgUsersArrayList = null;
        sponsor = null;
        savedIWRS = null;
        savedSponsor = null;
        savedEDC = null;
        session.removeAttribute("newSiteArrayList");
        session.removeAttribute("sponsorPicked");
        session.removeAttribute("iwrsPicked");
        iwrsPicked = false;
        session.removeAttribute("edcPicked");

        url = "/eqhome/newStudyMain.jsp";
        System.out.println("url " + url);
        return url;

    }

    private String newStudyMain(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        currPage = "newStudyMain";
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

            orgStatusList = SysCodeRegistryDB.selectAllOrgStatus();
            orgArrayList = OrganizationDB.selectOrganizationByType("SPONSOR");

            if ("newStudyMain".equals(currPage)) {
                study = getStudy(request);
                session.setAttribute("newStudy", study);
            }
            currPage = "newStudySponsor";

        } catch (DBException e) {
            System.err.println("DBException newStudySponsor");
        } catch (Exception e) {
            System.err.println("Exception newStudySponsor");
        }
        ObjectMapper mapper = new ObjectMapper();
        if (orgArrayList != null) {

            session.setAttribute("orgStatusList", orgStatusList);

            String jsonInOrgArrayList = mapper.writeValueAsString(orgArrayList);
            session.setAttribute("orgArrayList", orgArrayList);

            session.setAttribute("jsonInOrgArr", jsonInOrgArrayList);

            session.setAttribute("sponsorArrayList", sponsorArrayList);
//            session.setAttribute("nextStudyID", nextStudyID);
//            session.setAttribute("nextSponsorID", nextOrgID);
//            session.setAttribute("nextUserID", nextUserID);

            session.setAttribute("sponsorArrayList", sponsorArrayList);
        }

        url = "/eqhome/newStudySponsor.jsp";
        System.out.println("url " + url);
        return url;

    }

    private String addOrgToStudy(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        String url = null;

        HttpSession session = request.getSession();
        try {
            for (Organizations item : orgArrayList) {
                System.out.println("request.getParameter(optionsRadiosaddOrgToStudy):" + request.getParameter("optionsRadiosaddOrgToStudy"));
                System.out.println("item.getEqOrgId():" + item.getEqOrgId());
                if (item.getEqOrgId().equals(request.getParameter("optionsRadiosaddOrgToStudy"))) {
                    sponsor = item;
                    newSponsorUserArrayList = null;
                    if ("newStudySponsor".equals(currPage)) {
                        savedSponsor = sponsor;

                        if (htOrg == null) {
                            htOrg = new Hashtable();
                        }
                        if (sponsor != null) {
                            System.out.println("sponsor eq id=" + sponsor.getEqOrgId());
                            htOrg.put(sponsor.getEqOrgId(), sponsor);
                        }
                        url = "/eqhome/newStudySponsor.jsp";
                        session.setAttribute("sponsorPicked", true);
                    } else if ("IWRS".equals(currPage)) {
                        savedIWRS = sponsor;
                        url = "/eqhome/newStudyIWRS.jsp";
                        iwrsPicked = true;
                        session.setAttribute("iwrsPicked", iwrsPicked);
                    } else if ("EDC".equals(currPage)) {
                        savedEDC = sponsor;
                        url = "/eqhome/newStudyEDC.jsp";
                        session.setAttribute("edcPicked", true);
                    }
                    session.setAttribute("sponsor", item);
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

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
                    if (!newSiteArrayList.contains(item)) {
                        newSiteArrayList.add(item);
                    }
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
            if ("SPONSOR".equals(currPage)) {
                savedSponsor = sponsor;
                if (htOrg == null) {
                    htOrg = new Hashtable();
                }
                if (sponsor != null) {
                    System.out.println("sponsor eq id=" + sponsor.getEqOrgId());
                    htOrg.put(sponsor.getEqOrgId(), sponsor);
                }

            } else if ("IWRS".equals(currPage)) {
                savedIWRS = sponsor;

            }
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
            oneSite.setOrgType("SITE");
            oneSite.setEqOrgId(OrganizationDB.generateOrgID());
            if (newSiteArrayList == null) {
                newSiteArrayList = new ArrayList<Organizations>();
            }
            newSiteArrayList.add(oneSite);
            session.setAttribute("newSiteArrayList", newSiteArrayList);
            session.setAttribute("oneSite", oneSite);
            if (htOrg == null) {
                htOrg = new Hashtable();
            }
            if (oneSite != null) {
                System.out.println("oneSite eq id=" + oneSite.getEqOrgId());
                htOrg.put(oneSite.getEqOrgId(), oneSite);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        url = "/eqhome/newStudySite.jsp";
        System.out.println("url " + url);
        return url;

    }

    private String removeSiteFromStudy(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        String url;

        HttpSession session = request.getSession();
        String deleteSiteID = request.getParameter("deleteSiteID");
        try {
            for (Organizations item : newSiteArrayList) {
                if (item.getEqOrgId().equals(deleteSiteID)) {
                    newSiteArrayList.remove(item);
                }
            }

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
                    if ("SPONSOR".equals(currPage)) {
                        if (newSponsorUserArrayList == null) {
                            newSponsorUserArrayList = new ArrayList<Users>();
                        }

                        System.out.println("add to collection");
                        boolean itemAdded = false;
                        for (Users newitem : newSponsorUserArrayList) {
                            // Already added
                            if (item.getEqUserId().equals(newitem.getEqUserId())) {
                                System.out.println("added before");
                                itemAdded = true;
                                break;
                            }

                        }
                        if (!itemAdded) {
                            System.out.println("not added yet");
                            newSponsorUserArrayList.add(item);
                            sponsor.setUsersCollection(newSponsorUserArrayList);
                            session.setAttribute("sponsor", sponsor);
                            savedSponsor = sponsor;
                            if (htOrg == null) {
                                htOrg = new Hashtable();
                            }
                            if (sponsor != null) {
                                System.out.println("sponsor eq id=" + sponsor.getEqOrgId());
                                htOrg.put(sponsor.getEqOrgId(), sponsor);
                            }
                        }

                        System.out.println("add to session");
                        break;
                    } else if ("SITE".equals(currPage) && oneSite != null) {

//                        if (firstSelectOneSiteUsers) {
//                            oneSiteUserArrayList = UserDB.selectUsers(oneSite.getEqOrgId(), "SITE");
//                            firstSelectOneSiteUsers = false;
//                        }
                        if (oneSiteUserArrayList == null) {
                            oneSiteUserArrayList = new ArrayList<Users>();
                        }
                        boolean itemAdded = false;
                        for (Users newitem : oneSiteUserArrayList) {
                            // Already added
                            if (item.getEqUserId().equals(newitem.getEqUserId())) {
                                System.out.println("added before");
                                itemAdded = true;
                                break;
                            }

                        }
                        if (!itemAdded) {
                            oneSiteUserArrayList.add(item);

                            oneSite.setUsersCollection(oneSiteUserArrayList);
                            session.setAttribute("oneSiteUserArrayList", oneSiteUserArrayList);
                            session.setAttribute("oneSite", oneSite);
                            if (htOrg == null) {
                                htOrg = new Hashtable();
                            }
                            if (oneSite != null) {
                                System.out.println("oneSite eq id=" + oneSite.getEqOrgId());
                                htOrg.put(oneSite.getEqOrgId(), oneSite);
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        if ("SITE".equals(currPage)) {
            url = "/eqhome/newStudySiteUserList.jsp";
        } else if ("SPONSOR".equals(currPage)) {
            url = "/eqhome/newStudySponsorUserList.jsp";
        }

        System.out.println("url " + url);
        return url;

    }

    private String removeUserFromOrg(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        String url = null;
        System.out.println("removeUserFromOrg");
        HttpSession session = request.getSession();
        String deleteUserID = request.getParameter("deleteUserID");
        if ("SPONSOR".equals(currPage)) {
            for (Users item : newSponsorUserArrayList) {
                if (item.getEqUserId().equals(deleteUserID)) {
                    newSponsorUserArrayList.remove(item);
                    sponsor.setUsersCollection(newSponsorUserArrayList);

                    session.setAttribute("sponsor", sponsor);
                    savedSponsor = sponsor;
                    if (htOrg == null) {
                        htOrg = new Hashtable();
                    }
                    if (sponsor != null) {
                        System.out.println("sponsor eq id=" + sponsor.getEqOrgId());
                        htOrg.put(sponsor.getEqOrgId(), sponsor);
                    }
                    break;
                }
            }
            url = "/eqhome/newStudySponsorUserList.jsp";
        } else if ("SITE".equals(currPage)) {
            for (Users item : oneSiteUserArrayList) {
                if (item.getEqUserId().equals(deleteUserID)) {
                    oneSiteUserArrayList.remove(item);
                    oneSite.setUsersCollection(oneSiteUserArrayList);

                    session.setAttribute("oneSite", oneSite);
                    if (htOrg == null) {
                        htOrg = new Hashtable();
                    }
                    if (oneSite != null) {
                        System.out.println("oneSite eq id=" + oneSite.getEqOrgId());
                        htOrg.put(oneSite.getEqOrgId(), oneSite);
                    }
                    break;
                }
            }
            url = "/eqhome/newStudySiteUserList.jsp";
        }

        System.out.println("url " + url);
        return url;

    }

    private String inputUserToOrg(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        String url = null;

        HttpSession session = request.getSession();
        try {

            Users user = getUser(request);
            user.setEqUserId(UserDB.generateUserID());

            if (currPage.equals("SPONSOR")) {
                user.setEqOrgId(sponsor);
                user.setUserType("SPONSOR");
                if (newSponsorUserArrayList == null) {
                    newSponsorUserArrayList = new ArrayList<Users>();
                }

                newSponsorUserArrayList.add(user);
                sponsor.setUsersCollection(newSponsorUserArrayList);

                session.setAttribute("sponsor", sponsor);
                if (htOrg == null) {
                    htOrg = new Hashtable();
                }
                if (sponsor != null) {
                    System.out.println("sponsor eq id=" + sponsor.getEqOrgId());
                    htOrg.put(sponsor.getEqOrgId(), sponsor);
                }
            } else if (currPage.equals("SITE")) {
                user.setEqOrgId(oneSite);
                user.setUserType("SITE");
//                if (firstSelectOneSiteUsers) {
//                    oneSiteUserArrayList = UserDB.selectUsers(oneSite.getEqOrgId(), "SITE");
//                    firstSelectOneSiteUsers = false;
//                }
                if (oneSiteUserArrayList == null) {
                    oneSiteUserArrayList = new ArrayList<Users>();
                }
                oneSiteUserArrayList.add(user);
//                int i=1;
//                for (Users auser : oneSiteUserArrayList)
//                {
//                    System.out.println(i + " " + auser.getEqUserId());
//                    i++;
//                }
                oneSite.setUsersCollection(oneSiteUserArrayList);
                session.setAttribute("oneSiteUserArrayList", oneSiteUserArrayList);
                session.setAttribute("oneSite", oneSite);
                if (htOrg == null) {
                    htOrg = new Hashtable();
                }
                if (oneSite != null) {
                    System.out.println("oneSite eq id=" + oneSite.getEqOrgId());
                    htOrg.put(oneSite.getEqOrgId(), oneSite);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        if ("SITE".equals(currPage)) {
            url = "/eqhome/newStudySiteUserList.jsp";
        } else if ("SPONSOR".equals(currPage)) {
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

            if (savedEDC == null) {
                // User input EDC info. instead of pick from the list
                sponsor = getOrganization(request);
                if (sponsor.getEqOrgId() == null || sponsor.getEqOrgId().equals("")) {
                    sponsor.setEqOrgId(OrganizationDB.generateOrgID());
                }
                savedEDC = sponsor;
                session.removeAttribute("sponsor");
                sponsor = null;
            }
            if (savedSponsor != null) {
                savedSponsor.setOrgType("SPONSOR");
            }
            if (savedIWRS != null) {
                savedIWRS.setOrgType("IWRS");
            }
            if (savedEDC != null) {
                savedEDC.setOrgType("EDC");
            }
            OrganizationDB.saveOrg(savedSponsor);
            OrganizationDB.saveOrg(savedIWRS);
            OrganizationDB.saveOrg(savedEDC);

            //study = (Studies) session.getAttribute("newStudy");
            if (study != null) {
                study.setEqStudyId(StudyDB.generateStudyID());
                study.setEqSponId(savedSponsor.getEqOrgId());
                study.setEqIwrsId(savedIWRS.getEqOrgId());
                study.setEqEDCId(savedEDC.getEqOrgId());
                StudyDB.saveStudy(study);
            }

            /*newOrgArrayList = (ArrayList<Organizations>) session.getAttribute("newOrgArrayList");
            if (newOrgArrayList != null) {
                for (int i = 0; i < newOrgArrayList.size(); i++) {
                    OrganizationDB.saveOrgNUserNMap(study.getEqStudyId(), newOrgArrayList.get(i));
                }
            }*/
            Set<String> keys = htOrg.keySet();
            Organizations aSite = null;
            for (String key : keys) {
                aSite = (Organizations) htOrg.get(key);
                OrganizationDB.saveOrg(aSite);
                OrganizationDB.saveUserNMap(study.getEqStudyId(), aSite);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        url = displayStudyList(request, response);

        System.out.println(
                "url " + url);
        return url;

    }

    private String newStudySponsorUserList(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        String url;
        HttpSession session = request.getSession();

        // Back button from newStudySite
//        if ("newStudySite".equals(currPage)) {
//            url = "/eqhome/newStudySponsorUserList.jsp";
//            return url;
//        }
        currPage = "SPONSOR";

        try {
userStatusList = SysCodeRegistryDB.selectAllUserStatus();
            if (savedSponsor == null) {
                // User input sponsor info. instead of pick from the list
                sponsor = getOrganization(request);
            } else {
                // Saved before, either pick from the list or back from Site page

                sponsor = savedSponsor;
                System.out.println("Find  save sponsor" + sponsor.getEqOrgId());
            }

            if (sponsor.getEqOrgId() == null || sponsor.getEqOrgId().equals("")) {
                sponsor.setEqOrgId(OrganizationDB.generateOrgID());
            }

            //sponsor.setUsersCollection(newSponsorUserArrayList);
            savedSponsor = sponsor;
            if (htOrg == null) {
                htOrg = new Hashtable();
            }
            if (sponsor != null) {
                System.out.println("sponsor eq id=" + sponsor.getEqOrgId());
                htOrg.put(sponsor.getEqOrgId(), sponsor);
            }

            // Used for search user
            orgUsersArrayList = UserDB.selectUsers(sponsor.getEqOrgId(), "SPONSOR");

            session.setAttribute("sponsor", sponsor);
            session.setAttribute("orgUsersArrayList", orgUsersArrayList);
            session.setAttribute("userStatusList", userStatusList);

        } catch (DBException e) {
            System.err.println("DBException newStudySponsorUserList");
        } catch (Exception e) {
            System.err.println("Exception newStudySponsorUserList");
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
        String selectedSite = request.getParameter("sltStudySiteUserList");
        session.setAttribute("selectedSite", selectedSite);
        System.out.println("selectedSite=" + selectedSite);
        try {

            // select the current select site
            boolean firstTime = true;
            if (newSiteArrayList != null) {
                for (Organizations site : newSiteArrayList) {
                    // Deal with the first site from the dropdown which will be the default value when come to this page
                    System.out.println("inside for loop");
                    if (firstTime) {
                        oneSite = site;
                        firstTime = false;
                    }
                    if (site != null && site.getEqOrgId().equals(selectedSite)) {
                        oneSite = site;
                        break;
                    }
                }
            }

            // Not first time, already saved before
            if (oneSite != null) {
                System.out.println("oneSite!=null");
                oneSiteUserArrayList = (ArrayList) oneSite.getUsersCollection();
                oneSite.setUsersCollection(oneSiteUserArrayList);
//                if (oneSiteUserArrayList == null) {
//                    System.out.println("oneSiteUserArrayList==null oneSite.getEqOrgId()=" + oneSite.getEqOrgId());
//                    oneSiteUserArrayList = UserDB.selectUsers(oneSite.getEqOrgId(), "SITE");
//                    oneSite.setUsersCollection(oneSiteUserArrayList);
//                }            // Find existing users
                orgUsersArrayList = UserDB.selectUsers(oneSite.getEqOrgId(), "SITE");
            }

            session.setAttribute("orgUsersArrayList", orgUsersArrayList);

            //System.out.println("sponsor address1" + sponsor.getAddress1());
            //System.out.println("sponsor full name" + sponsor.getOrgFullName());
            session.setAttribute("oneSiteUserArrayList", oneSiteUserArrayList);
            session.setAttribute("oneSite", oneSite);

        } catch (DBException e) {
            System.err.println(" DB exception in newStudySiteUserList ");
        } catch (Exception e) {
            System.err.println(" Exeption in newStudySiteUserList ");
        }

        url = "/eqhome/newStudySiteUserList.jsp";
        System.out.println("url " + url);
        return url;

    }

    private String newStudySite(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        String url;
        HttpSession session = request.getSession();
        currPage = "newStudySite";

        try {
            siteArrayList = OrganizationDB.selectOrganizationByType("SITE");

            if (htOrg == null) {
                htOrg = new Hashtable();
            }
            if (sponsor != null) {
                System.out.println("sponsor eq id=" + sponsor.getEqOrgId());
                htOrg.put(sponsor.getEqOrgId(), sponsor);
            }

        } catch (DBException e) {
            System.err.println(" DB exception in newStudySite ");
        } catch (Exception e) {
            System.err.println(" Exeption in newStudySite ");
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

        // come from "next" button
        if (!("IWRS".equals(currPage))) {
            System.out.println("newStudyIWRS - remove sponsor");
            session.removeAttribute("sponsor");
        }

        // If saved before
        sponsor = savedIWRS;
        if (savedIWRS != null) {
            System.out.println("saved IWRS" + savedIWRS.getStatus());
        }
        session.removeAttribute("sponsor");
        session.setAttribute("sponsor", sponsor);

        if (sponsor != null) {
            System.out.println("current IWRS" + sponsor.getStatus());
            System.out.println("newStudyIWRS savedIWRS" + sponsor.getEqOrgId());
        }

        currPage = "IWRS";

        try {
            arrayIWRSList = OrganizationDB.selectOrganizationByType("IWRS");

        } catch (DBException e) {
            System.err.println(" DB exception in newStudyIWRS ");
        } catch (Exception e) {
            System.err.println(" Exception in newStudyIWRS ");
        }

        //System.out.println("after get list");
        if (arrayIWRSList != null) {
            session.setAttribute("arrayIWRSList", arrayIWRSList);
        }
        orgArrayList = arrayIWRSList;
        session.setAttribute("orgArrayList", orgArrayList);
        url = "/eqhome/newStudyIWRS.jsp";
        System.out.println("url " + url);
        return url;

    }

    private String newStudyEDC(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        String url;
        HttpSession session = request.getSession();

        // come from "next" button
//        if ("IWRS".equals(currPage)) {
//            session.removeAttribute("sponsor");
//        }
        currPage = "EDC";
        try {
            arrayEDCList = OrganizationDB.selectOrganizationByType("EDC");
            if (!iwrsPicked) {
                // User input IWRS info. instead of pick from the list
                System.out.println("User input from IWRS");
                sponsor = getOrganization(request);
                if (sponsor.getEqOrgId() == null || sponsor.getEqOrgId().equals("")) {
                    sponsor.setEqOrgId(OrganizationDB.generateOrgID());
                }
                savedIWRS = sponsor;
                System.out.println("savedIWRS" + sponsor.getStatus());
                System.out.println("newStudyEDC savedIWRS" + savedIWRS.getEqOrgId());
                session.removeAttribute("sponsor");
                sponsor = null;
            }

            // IWRS Saved before
            sponsor = savedEDC;
            session.setAttribute("sponsor", sponsor);
            //System.out.println("Find  save IWRS" + sponsor.getEqOrgId());

//            System.out.println("savedIWRS " + savedIWRS.getEqOrgId());
//            System.out.println("savedIWRS " + savedIWRS.getOrgFullName());
//
//            System.out.println("after remove sponsor savedIWRS " + savedIWRS.getEqOrgId());
//            System.out.println("after remove sponsor savedIWRS " + savedIWRS.getOrgFullName());
        } catch (DBException e) {
            System.err.println("DBException newStudyEDC");
        } catch (Exception e) {
            System.err.println("Exception newStudyEDC");
        }

        if (arrayEDCList != null) {
            session.setAttribute("arrayEDCList", arrayEDCList);
        }
        orgArrayList = arrayEDCList;
        session.setAttribute("orgArrayList", orgArrayList);

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
            System.err.println("DBException displayOrganizationList");
        } catch (Exception e) {
            System.err.println("Exception displayOrganizationList");
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
//            System.out.println("CoSponStudyId=" + request.getParameter("CoSponStudyId"));
//            System.out.println("study start date=" + request.getParameter("StudyStartDate"));

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
            org.setNotes(request.getParameter("Note"));
            org.setStatus(request.getParameter("sponsorStatus"));

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

    public String clearForm(HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        String url = null;

        HttpSession session = request.getSession();
        if ("newStudySponsor".equals(currPage)) {
            sponsor = null;
            savedSponsor = null;
            session.removeAttribute("sponsorPicked");
            session.removeAttribute("sponsor");
            url = "/eqhome/newStudySponsor.jsp";
        } else if ("IWRS".equals(currPage)) {
            sponsor = null;
            savedIWRS = null;
            session.removeAttribute("iwrsPicked");
            iwrsPicked = false;
            session.removeAttribute("sponsor");
            url = "/eqhome/newStudyIWRS.jsp";
        } else if ("EDC".equals(currPage)) {
            sponsor = null;
            savedEDC = null;
            session.removeAttribute("edcPicked");
            session.removeAttribute("sponsor");
            url = "/eqhome/newStudyEDC.jsp";
        }
        return url;

    }

}
