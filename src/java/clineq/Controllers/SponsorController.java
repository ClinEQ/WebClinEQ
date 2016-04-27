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

import javax.servlet.http.Part;
 
import java.util.*;
import java.sql.*;
import java.io.*;

import clineq.data.*;
import clineq.business.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;


@MultipartConfig(
 fileSizeThreshold = 1024 * 1024 * 1,
 maxFileSize = 1024 * 1024 * 10,
 maxRequestSize = 1024 * 1024 * 15,
 location = "C:/clineq" )
//WebServlet(name = "SponsorController", urlPatterns = {"/SponsorController"})


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
    private Studies study = null;
    private Organizations sponsor = null;
    private ArrayList<Studies> studyArrayList = null;
    private ArrayList<String> studyStatusList = null;
    private ArrayList<String> sponsorNameList = null;
    private ArrayList<Users> userArrayList = null;
    private ArrayList<Organizations> orgArrayList = null;
    private ArrayList<Subjects> subjectArrayList = null;
    private ArrayList<InputStream> sPdfArrayList = null; 
    private ArrayList<Subjects> studySponsorSubjectList = null;
    private ArrayList<StudyChartCategory> sponsorSubjectCategory = null;
    private ArrayList<StudyChartSubcategory> sponsorSubjectSubcategory = null;
    private ArrayList<SubjectCharts> sponsorSubjectChart = null;
    

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        
    /*    try {  
DiskFileItemFactory factory = new DiskFileItemFactory();
ServletFileUpload sfu  = new ServletFileUpload(factory);*/
          /* if (! ServletFileUpload.isMultipartContent(request)) {
                System.out.println("sorry. No file uploaded");
               return;
           }*/
  /* try {   
//List items = sfu.parseRequest(request);
           FileItem  id = (FileItem) items.get(0);
            String photoid =  id.getString();
            
            FileItem title = (FileItem) items.get(1);
            String   phototitle =  title.getString();
   }catch(SQLException e) {
            System.err.println("Error in image insert "+ e.getMessage());
        }*/
 /*try {
File file = new File("C:/clineq/info.pdf");
FileInputStream fs = new FileInputStream(file);

Connection conn = DBConnect.getConnection();
PreparedStatement ps = null;
        Statement stmt = null;
        ResultSet rs = null;
        
            //ps = conn.prepareStatement("INSERT INTO pictures VALUES(?,?)");
            //String sql = "Select * from clineq.Studies";
            ps = conn.prepareStatement("INSERT INTO pictures VALUES(?,?)");
            //ps = conn.prepareStatement("INSERT INTO clineq.subject_charts (EQ_SUBJECT_CHART_ID,DOC_CONTENT) VALUES(?,?)");
            //ps = conn.prepareStatement(sql);
            //ps.setString(1,"40");
            ps.setInt(1,4);
            ps.setBinaryStream(2,fs,fs.available());
            int i = ps.executeUpdate();
            if(i!=0)
            {
               System.out.println("inser good"); 
            }
            else
            {
                 System.out.println("inser bad");
            }
      }catch (SQLException e) {
            System.err.println("Error in image insert "+ e.getMessage());
        }*/
 String uploadtype = "Initial";
 //boolean insertPDF = SubjectChartsDB.InsertPdf("C:/clineq/info.pdf",uploadtype,"10");
  /*try {
          InputStream sPdf;
          File targetFile = new File("C:/clineq/output5.pdf");
          OutputStream outStream = new FileOutputStream(targetFile);
          
            Connection con = DBConnect.getConnection();
            PreparedStatement psmnt;
            //String sqlSelect = "SELECT picture FROM clineq.pictures WHERE id = 4";
            //String sqlSelect = "SELECT picture from pictures where id=4";
            String sqlSelect = "SELECT DOC_CONTENT from clineq.subject_charts where EQ_SUBJECT_CHART_ID='10'";
             psmnt = con.prepareStatement(sqlSelect);             
             //psmnt.setInt(1,4);
            System.out.println("Try to get pdf");
            ResultSet rs1 = psmnt.executeQuery();
            System.out.println("Try to get pdf after running executeQuery");
             
            if(rs1.next()){ 
                byte[] bytearray = new byte[1048576];
                    //out.println(bytearray);
                int size=0;
                sPdf = rs1.getBinaryStream(1);
                //String username = rs1.getString("USERNAME");
                //System.out.println("get USER NAME="+username);
                int bytesRead;
                while ((bytesRead = sPdf.read(bytearray)) != -1) {
                    outStream.write(bytearray, 0, bytesRead);
                }
                System.out.println("get pdf....");
            }
            
}catch (SQLException e) {
            System.err.println("Error in image retrieve "+ e.getMessage());
        }*/
            
        System.out.println("enter study controller dopost! This is Sponsor Controllers ");
      
        String requestURI = request.getRequestURI();
        String userid = request.getParameter("inpUserName");
        String study_id = request.getParameter("eqStudyID");
        String subject_id = request.getParameter("eqSubjectID");
        String category_id = request.getParameter("chartCategoryID");
        String subcategory_id = request.getParameter("chartSubcategoryID");
        System.out.println("in study controler, userid="+userid);
        System.out.println("in study controler, study_id="+study_id);
        
        /*ServletContext context = request.getServletContext();
        String path = context.getRealPath("/");
        System.out.println("Real path="+path);*/
        //userid = "JOHN01";
        //System.out.println("in study controler, Hard userid="+userid);
        /*Part filePart = request.getPart("inpFile");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println("filepart name="+filePart.getName());
            System.out.println("filepart SIZE="+filePart.getSize());
            System.out.println("filepart content="+filePart.getContentType());
             
            // obtains input stream of the upload file
            // = filePart.getInputStream();
        }*/
      
        String url = "/sponsorHome";
        System.out.println("dopost NCTId=" + request.getParameter("NCTId"));
                System.out.println("dopost NCTId=" + request.getParameter("NCTId"));
        System.out.println("URI=" + requestURI);

        System.out.println("dopost CoSponStudyId=" + request.getParameter("CoSponStudyId"));
        System.out.println("dopost site start date=" + request.getParameter("StudyStartDate"));
        HttpSession session = request.getSession();
      /*  if(userType.equals("CLINEQ"))
        {
        }
        else if(userType.equals("SITE"))
        {*/
         if (requestURI.endsWith("/displayStudySponsorList")) {
            url = displaySponsorList(request, response,userid);
            //boolean ret =OrgDocUpldRegistryDB.InsertNewInfo("orgdocuploadid","studyid","subjectid","orgid","categoryid","startdate","userid","enddate","status","remoteip");
            // boolean ret =OrgDocUpldRegistryDB.InsertNewInfo("1","EQ000003","1","TO_DATE('2016-04-02','YYYY-MM-DD')","JOHN01","TO_DATE('2016-04-03','YYYY-MM-DD')","Active","255.255.255.255");
            //   if ("STUDYLIST_NODATA" url equal())
            //session.setAttribute("UID", userid);
            //subject_id = "EQ000003";
            //study_id = "1";
           //url = subjectSponsorDetails(request, response,study_id,subject_id,userid);
            System.out.println("the list is not empty!");
         } else if (requestURI.endsWith("/studySponsorDetails")) {
            // String Uid = (String)request.getAttribute("UID");
            // System.out.println("UID="+Uid);
             //String study_id = request.getParameter("eqStudyID");
            url = studySponsorDetails(request, response,study_id,userid);
            System.out.println("In sutdySponsorDetails, url=" + url);
         } else if (requestURI.endsWith("/subjectSponsorDetails")) {
             //String subject_id = request.getParameter("eqSubjectID");
            url = subjectSponsorDetails(request, response,study_id, subject_id,userid);
            System.out.println("In subjectSponsorDetails, url=" + url);
         } else if (requestURI.endsWith("/fileSponsorDetails")) {
             //String subject_id = request.getParameter("eqSubjectID");
             String pdffile = "C:/clineq/info.pdf";
            url = fileSponsorDetails(request, response,subject_id,study_id,category_id,subcategory_id,userid,pdffile);
            
            System.out.println("In fileSponsorDetails, url=" + url);
         }
        /* else if (requestURI.endsWith("/newStudySponsor")) {
            url = newStudySponsor(request, response);
         } else if (requestURI.endsWith("/saveNewStudy")) {
             
            url = saveNewStudy(request, response, "Pending");
         } else if (requestURI.endsWith("/saveNewStudyDraft")) {
            url = saveNewStudy(request, response, "Draft");
         } else if (requestURI.endsWith("/AddSponsorToStudy")) {
            url = addSponsorToStudy(request, response);
         } */
         else {
            url = "/sponsorHome/error.jsp";
         }
       /* }
        else if(userType.equals("SPONSOR"))
        {
        }
        else
        {
            System.out.println("Invalid user type!");
        }*/
     
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        /*String requestURI = request.getRequestURI();
        String url = "/sponsorHome";

        if (requestURI.endsWith("/displaySponsorList")) {
            url = displaySponsorList(request, response,request.getParameter("inpUserName"));
        } else if (requestURI.endsWith("/createNewStudy")) {
            url = createNewStudy(request, response);
        } else if (requestURI.endsWith("/newStudySponsor")) {
            url = newStudySponsor(request, response);
        } else {
            url = "/sponsorHome/error.jsp";
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);*/
        doPost(request, response);
    }

    private String displaySponsorList(HttpServletRequest request,
            HttpServletResponse response,String userId) throws IOException {

        try {
            studyArrayList = StudyDB.selectSiteSponsorAllStudy(userId); 
            studyStatusList = StudyDB.selectAllStudyStatus();
            sponsorNameList = StudyDB.selectAllStudySponsorName();
            userArrayList = UserDB.selectAllUser();
            orgArrayList = OrganizationDB.selectAllOrganization();
            String SponsorName = OrganizationDB.getSiteSponsorByUserName(userId);
            subjectArrayList = SubjectDB.selectAllSubject();
            System.out.println("subjectArrayList print");
            System.out.println("subjectArrayList="+subjectArrayList.get(1).getEqStudyId());
           

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
            session.setAttribute("UserId", userId);
            url = "/sponsorHome/index.jsp";
            System.out.println("url " + url);
            return url;
        } else {
            //System.out.println("url " );
            return "/sponsorHome/index.jsp";
        }
    }
    
 


    
  
      private String studySponsorDetails(HttpServletRequest request,
            HttpServletResponse response,String studyid,String userid) throws IOException {

        /*String url;

        HttpSession session = request.getSession();

        url = "/sponsorHome/studyDetails.jsp";
        return url;*/
        String sponsorUserByStudyId = null;
        String sponsorSponsorByStudyId = null;
        String sponsorNameByStudyId = null;
        String sponsorNCTIDByStudyId = null;
        
        try { 
            //sponsorUserByStudyId = StudyDB.selectSiteUserById(studyid);
            //select user_login_id from clineq.users U, clineq.studies S, CLINEQ.STUDY_SITE_USER_MAP M where U.eq_user_id=M.eq_user_id and M.eq_study_id=S.eq_study_id and S.eq_study_id =1
            sponsorSponsorByStudyId = StudyDB.selectSiteSponsorById(studyid); 
             //select org_full_name from clineq.organizations O, clineq.studies S where O.eq_org_id=S.eq_spon_id  and S.eq_study_id =1
            sponsorNameByStudyId = StudyDB.selectSiteSponsorNameById(studyid); 
            //select org_full_name,org_type from clineq.organizations O, clineq.studies S where O.eq_org_id=S.eq_spon_id AND org_type='SITE'
            sponsorNCTIDByStudyId = StudyDB.selectSiteSponsorNCTIDById(studyid);
            studySponsorSubjectList = SubjectDB.selectSiteSponsorSubject(studyid);
        } catch (DBException e) {
            System.err.println();
        }

        String url;

        HttpSession session = request.getSession();

        if (studySponsorSubjectList != null) {
            System.out.println("i checking array");
            //session.setAttribute("sponsorUserByStudyId", sponsorUserByStudyId);
            session.setAttribute("sponsorSponsorByStudyId", sponsorSponsorByStudyId);
            session.setAttribute("sponsorNameByStudyId", sponsorNameByStudyId);
            session.setAttribute("sponsorNCTIDByStudyId", sponsorNCTIDByStudyId);
            session.setAttribute("studySponsorSubjectList", studySponsorSubjectList);
            session.setAttribute("UserId", userid);
            url = "/sponsorHome/studyDetails.jsp";
            System.out.println("url " + url);
            return url;
        } else {
            //System.out.println("url " );
            //return "/sponsorHome/index.jsp
            return "/sponsorHome/studyDetails.jsp";
        }

    }

        private String subjectSponsorDetails(HttpServletRequest request,
            HttpServletResponse response,String studyid, String subjectid,String userid) throws IOException {
 
        try {
          
            int catCount = CategoryDB.selectSiteSponsorCategoryCount(studyid);
            System.out.println("catCount="+catCount);
            sponsorSubjectSubcategory =SubCategoryDB.selectSiteSponsorSubcategory(subjectid,catCount);
            sponsorSubjectCategory = CategoryDB.selectSiteSponsorCategory(studyid);
            sponsorSubjectChart = SubjectChartsDB.selectSiteSponsorSubjectCharts(subjectid);
            System.out.println("sponsorSubjectSubcategory print");
            System.out.println("sponsorSubjectSubcategory="+sponsorSubjectSubcategory.get(1).getChartSubcategoryName());
           /* sponsorSponsorByStudyId = StudyDB.selectSiteSponsorById(studyid); 
            sponsorNameByStudyId = StudyDB.selectSiteNameById(studyid); 
            sponsorNCTIDByStudyId = StudyDB.selectSiteNCTIDById(studyid);
            studySiteSubjectList = SubjectDB.selectSiteSubject(studyid);*/
        } catch (DBException e) {
            System.err.println("Error happened in SponsorSubjectDetails");
        }

        String url;

        HttpSession session = request.getSession();

        if (sponsorSubjectCategory != null) {
            System.out.println("i checking array");
        
            session.setAttribute("sponsorSubjectSubcategory", sponsorSubjectSubcategory);
            session.setAttribute("sponsorSubjectCategory", sponsorSubjectCategory);
            session.setAttribute("sponsorSubjectChart", sponsorSubjectChart);
            
            url = "/sponsorHome/subjectDetails.jsp";
            //url = "/sponsorHome/index.jsp";
            System.out.println("url " + url);
            return url;
        } else {
            //System.out.println("url " );
            //return "/sponsorHome/index.jsp
            return "/sponsorHome/studyDetails.jsp";
        }
    }

        private String fileSponsorDetails(HttpServletRequest request,
            HttpServletResponse response,String subjectid,String studyid, String catogoryid, String subcategoryid, String userid,String pdfFile) throws IOException {
 
        try {
          
          //boolean insertRet = InsertPdf(pdfFile);
        } catch (Exception e) {
            System.err.println();
        }

        String url;

        HttpSession session = request.getSession();

        if (studySponsorSubjectList != null) {
            System.out.println("i checking array");
        
           /* session.setAttribute("sponsorSubjectSubcategory", sponsorSubjectSubcategory);
            session.setAttribute("sponsorSubjectCategory", sponsorSubjectCategory);
            session.setAttribute("sponsorSubjectChart", sponsorSubjectChart);*/
            
            url = "/sponsorHome/fileDetails.jsp";
            System.out.println("url " + url);
            return url;
        } else {
            //System.out.println("url " );
            //return "/sponsorHome/index.jsp
            return "/sponsorHome/studyDetails.jsp";
        }
    }
    

/*public boolean InsertPdf(String fileName,String uploadtype) {
 try {
File file = new File(fileName);
FileInputStream fs = new FileInputStream(file);
Connection conn = DBConnect.getConnection();
PreparedStatement ps = null;
        Statement stmt = null;
        ResultSet rs = null;
        String id = null;
        
            //ps = conn.prepareStatement("INSERT INTO pictures VALUES(?,?)");
            //String sql = "Select * from clineq.Studies";
            ps = conn.prepareStatement("select max(TO_NUMBER(EQ_SUBJECT_CHART_ID))  MAX from clineq.subject_charts"); 
            ResultSet rs1 = ps.executeQuery();
            int maxid=0;
            if(rs1.next()){
                maxid = rs1.getInt("MAX");
                System.out.println("get Max!");
            }
             id = String.valueOf(maxid+1);
            //id = "48";
             System.out.println("In InsertPdf, fileName="+fileName+" id="+id);
            ps = conn.prepareStatement("INSERT INTO clineq.subject_charts (EQ_SUBJECT_CHART_ID,DOC_CONTENT,UPLOAD_TYPE) VALUES(?,?,'" + uploadtype +"')");
            //ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            ps.setBinaryStream(2,fs,fs.available());
            int i = ps.executeUpdate();
            if(i!=0)
            {
               System.out.println("inser good"); 
            }
            else
            {
                 System.out.println("inser bad");
            }
      }catch (SQLException e) {
            System.err.println("Error in image insert "+ e.getMessage());
        }catch (FileNotFoundException ex){
            System.err.println("Error in image insert "+ ex.getMessage());
            }catch (IOException eio){
            System.err.println("Error in image insert "+ eio.getMessage());
            }
      
      return true;
    }*/

/*public boolean RetrievePdf(String fileName) {
try {
          InputStream sPdf;
          File targetFile = new File(fileName);
          OutputStream outStream = new FileOutputStream(targetFile);
          
            Connection con = DBConnect.getConnection();
            PreparedStatement psmnt;
            //String sqlSelect = "SELECT picture FROM clineq.pictures WHERE id = 4";
            String sqlSelect = "SELECT picture from pictures where id=?";
             psmnt = con.prepareStatement(sqlSelect);             
             psmnt.setInt(1,4);
            System.out.println("Try to get pdf");
            ResultSet rs1 = psmnt.executeQuery();
            System.out.println("Try to get pdf after running executeQuery");
             
            if(rs1.next()){ 
                byte[] bytearray = new byte[1048576];
                    //out.println(bytearray);
                int size=0;
                sPdf = rs1.getBinaryStream(1);
                //String username = rs1.getString("USERNAME");
                //System.out.println("get USER NAME="+username);
                int bytesRead;
                while ((bytesRead = sPdf.read(bytearray)) != -1) {
                    outStream.write(bytearray, 0, bytesRead);
                }
                System.out.println("get pdf....");
            }
            
}catch (SQLException e) {
            System.err.println("Error in image retrieve "+ e.getMessage());
        }catch (FileNotFoundException ex){
            System.err.println("Error in image insert "+ ex.getMessage());
            }catch (IOException eio){
            System.err.println("Error in image insert "+ eio.getMessage());
            }
      return true;
   }*/

    

}
