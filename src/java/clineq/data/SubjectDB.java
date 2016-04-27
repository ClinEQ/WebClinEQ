/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clineq.data;

import clineq.business.Users;
import clineq.business.Organizations;
import clineq.business.Studies;
import clineq.business.Subjects;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSetMetaData;
import clineq.data.DBUtil;
import java.sql.Statement;


/**
 *
 * @author Calum
 */

public class SubjectDB {
    

 //   public boolean addNew(Study obj) 
 //   {
 //       String sql = "INSERT INTO clineq.studies(EQ_STUDY_ID, EQ_SPON_ID, NCTID, STUDY_ANAME, STUDY_TITLE,STUDY_STATUS) VALUES(?,?,?,?,?, ?)";
              
       
        //try ( Connection conn = DBConnect.getConnection();
          //    PreparedStatement ps = conn.prepareStatement(sql))
 //       {
       
    

    
        public static ArrayList<Subjects> selectAllSubject() throws DBException {   
  //   public  List<AtomObj> getAll() throws DBException { 
        String sql = "SELECT * FROM CLINEQ.SUBJECTS";
        
        ArrayList<Subjects> objList = new ArrayList<>();
        PreparedStatement ps = null;
        Statement stmt = null;
        ResultSet rs = null;
      
        try { 
            Connection conn = DBConnect.getConnection();
//            ps = conn.prepareStatement(sql);
//            rs = ps.executeQuery();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql); 
            String eqOrgId = null;
            while (rs.next()) {
                Subjects obj = new Subjects();
                obj.setEqSubjectId(rs.getString("EQ_SUBJECT_ID"));
                Studies eqStudyId = StudyDB.selectOneStudy(rs.getString("EQ_STUDY_ID"));
                obj.setEqStudyId(eqStudyId);
 
                Organizations org = OrganizationDB.selectOneOrganization(rs.getString("EQ_SITE_ID"));
                obj.setEqSiteId(org);
                obj.setSponSubjectId(rs.getString("SPON_SUBJECT_ID"));
                obj.setDateBirth(rs.getDate("DATE_BIRTH"));
                obj.setGender(rs.getString("GENDER"));
                obj.setLastUpdateDate(rs.getDate("LAST_UPDATE_DATE"));
                obj.setLastUpdateId(rs.getString("LAST_UPDATE_ID"));
                obj.setDeleteflag(rs.getString("DELETEFLAG"));
                obj.setDeleteby(rs.getString("DELETEBY"));
                obj.setDeleteDate(rs.getDate("DELETE_DATE"));
                obj.setSubjectStatus(rs.getString("SUBJECT_STATUS"));
                objList.add(obj);
            }
            return objList;
        } catch (SQLException e) {
            System.err.println("Error in subjectDB selectAllSubject:" + e.getMessage());
            return null;
        } finally {
           DBUtil.closeResultSet(rs);
           DBUtil.closePreparedStatement(ps);
        }
    }
    
        public static ArrayList<Subjects> selectSiteSponsorSubject(String studyid) throws DBException {
        //String sql = "SELECT ORG_FULL_NAME FROM CLINEQ.ORGANIZATIONS WHERE EQ_ORG_ID = " + orgid;
        
         String sql = "SELECT * FROM CLINEQ.SUBJECTS"
                 + " WHERE EQ_STUDY_ID='" + studyid +"'";
        
        ArrayList<Subjects> objList = new ArrayList<>();
        PreparedStatement ps = null;
        Statement stmt = null;
        ResultSet rs = null;
      
        try { 
            Connection conn = DBConnect.getConnection();
//            ps = conn.prepareStatement(sql);
//            rs = ps.executeQuery();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql); 
            String eqOrgId = null;
            while (rs.next()) {
                Subjects obj = new Subjects();
                obj.setEqSubjectId(rs.getString("EQ_SUBJECT_ID"));
               // Studies eqStudyId = StudyDB.selectOneStudy(rs.getString("EQ_STUDY_ID"));
                //obj.setEqStudyId(eqStudyId);
 
                //Organizations org = OrganizationDB.selectOneOrganization(rs.getString("EQ_SITE_ID"));
                //obj.setEqSiteId(org);
                obj.setSponSubjectId(rs.getString("SPON_SUBJECT_ID"));
                obj.setDateBirth(rs.getDate("DATE_BIRTH"));
                obj.setGender(rs.getString("GENDER"));
                obj.setSubjectStatus(rs.getString("SUBJECT_STATUS"));
                objList.add(obj);
            }
            return objList;
        } catch (SQLException e) {
            System.err.println("Error in subjectDB selectSiteSponsorSubject:" + e.getMessage());
            return null;
        } finally {
           DBUtil.closeResultSet(rs);
           DBUtil.closePreparedStatement(ps);
        }
    }
  
  
       public static Subjects selectOneStudy(String EQ_SUBJECT_ID) throws DBException {
        //   public  List<AtomObj> getAll() throws DBException { 
        String sql = "SELECT * "
                + "FROM CLINEQ.SUBJECTS "
                + "WHERE  EQ_SUBJECT_ID='" + EQ_SUBJECT_ID + "'";
                
                // System.out.println("one study,sql="+sql);


        Subjects s = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Connection conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(); //{
            while (rs.next()) {
                s = new Subjects();
                s.setEqSubjectId(rs.getString("EQ_SUBJECT_ID"));
            }
            return s;
        } catch (SQLException e) {
            System.err.println("Error in studyDB selectOneSubject" + e.getMessage());
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
    }
       
       
    public static String getTestCat(String studyid) {
      
      String sql = "SELECT * FROM CLINEQ.STUDY_CHART_CATEGORY"
                 + " WHERE EQ_STUDY_ID='" + studyid +"'";
      
      StringBuilder sb = new StringBuilder("");
      
      PreparedStatement ps = null;
      Statement stmt = null;
      ResultSet rs = null;
      
      String sql2 = "";
      Statement stmt2 = null;
      ResultSet rs2 = null;
        
      
        try { 
            Connection conn = DBConnect.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql); 
            
            while (rs.next()) {
                 
                sb.append("{'id':'" + rs.getString("CHART_CATEGORY_ID") + "','name':'" + rs.getString("CHART_CATEGORY_NAME") + "','children':[");  
                
                sql2 = "SELECT * FROM CLINEQ.STUDY_CHART_SUBCATEGORY WHERE CHART_CATEGORY_ID='" + rs.getString("CHART_CATEGORY_ID") +"'";
                
                stmt2 = conn.createStatement();
                rs2 = stmt2.executeQuery(sql2);
                
                boolean hasNext2 = rs2.next();
                while (hasNext2) {
                    sb.append("{'id':'" + rs2.getString("CHART_SUBCATEGORY_ID") + "','name':'" + rs2.getString("CHART_SUBCATEGORY_NAME") + "'}");
                    
                    hasNext2 = rs2.next();
                    if (hasNext2) {
                        sb.append(",");
                    }
                }
                sb.append("]},");
            }
            
            sb.append("");
            return sb.toString();
        } catch (SQLException e) {
            System.err.println("Error in subjectDB selectSiteSubject:" + e.getMessage());
            return null;
        } finally {
           DBUtil.closeResultSet(rs);
           DBUtil.closeResultSet(rs2);
           DBUtil.closePreparedStatement(ps);
        }        
       
    }
}
