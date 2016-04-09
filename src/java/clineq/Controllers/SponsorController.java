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

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException; 
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 *
 * @author songy04
 */
public class SponsorController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    private Organizations sponsor = null;
    private ArrayList<Organizations> sponsorArrayList = null;
 //   private ArrayList<String> studyStatusList = null;
   // private ArrayList<String> orgStatusList = null;
   // private ArrayList<String> sponsorNameList = null;
   // private ArrayList<Users> userArrayList = null;
   // private ArrayList<Organizations> orgArrayList = null;
   // private ArrayList<SiteLocations> siteArrayList = null;

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
            url = displaySponsorList(request, response);
            //   if ("STUDYLIST_NODATA" url equal())
            System.out.println("the list is not empty!");
        } else if (requestURI.endsWith("/createNewStudy")) {
 //           url = createNewStudy(request, response);
        } else if (requestURI.endsWith("/newStudySponsor")) {
       //     url = newStudySponsor(request, response);
        } else {
            url = "/eqhome/error.jsp";
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doPost(request, response);
    }
    private String displaySponsorList(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        
        ObjectMapper mapper = new ObjectMapper();
       
        try {
            sponsorArrayList = OrganizationDB.selectOrganizationByType("SPONSOR");
           // studyStatusList = StudyDB.selectAllStudyStatus();
           //orgStatusList = StudyDB.selectAllOrgStatus();
           //sponsorNameList = StudyDB.selectAllStudySponsorName();

        } catch (DBException e) {
            System.err.println();
        }

        String url;

        HttpSession session = request.getSession();

        if (sponsorArrayList != null) {
            
            
            
            System.out.println("i checking array");
            String jsonStrSponsorList = mapper.writeValueAsString(sponsorArrayList);
            session.setAttribute("sponsorList", jsonStrSponsorList );
      
            url = "/eqhome/sponsor.jsp";
            System.out.println("url " + url);
            return url;
        } else {
            //System.out.println("url " );
            return "/eqhome/index.jsp";
        }
    }

 }
 

/*
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
}
*/
/*
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
*/

