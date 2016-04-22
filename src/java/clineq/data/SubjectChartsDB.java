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
import clineq.business.SubjectCharts;
import clineq.business.SubjectChartsPK;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSetMetaData;
import clineq.data.DBUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class SubjectChartsDB {
    public static ArrayList<SubjectCharts> selectSiteSubjectCharts(String subjectid) throws DBException { 
        String sql = "SELECT * FROM CLINEQ.SUBJECT_CHARTS"
                + " WHERE EQ_SUBJECT_ID ='" + subjectid +"'";
        System.out.println("in selectSiteSubjectCharts, sql="+sql);
        ArrayList<SubjectCharts> objList = new ArrayList<>();
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
                SubjectCharts obj = new SubjectCharts();
                //obj.setEqStudyId(rs.getString("EQ_STUDY_ID"));
                //Studies eqSubjectId = StudyDB.selectOneStudy(rs.getString("EQ_SUBJECT_ID"));
                //obj.getSubjectChartsPK().setEqSubjectId(rs.getString("EQ_SUBJECT_ID"));
                obj.setEqSubjectId(rs.getString("EQ_SUBJECT_ID"));
                obj.setUploadType(rs.getString("UPLOAD_TYPE"));
                obj.setDocName(rs.getString("DOC_NAME"));
                obj.setUploadTimestamp(rs.getDate("UPLOAD_TIMESTAMP"));
                obj.setReviewStatus(rs.getString("REVIEW_STATUS"));
 
                
                objList.add(obj);
            }
            return objList;
        } catch (SQLException e) {
            System.err.println("Error in StudyCategoryDB selectCategory:" + e.getMessage());
            return null;
        } finally {
           DBUtil.closeResultSet(rs);
           DBUtil.closePreparedStatement(ps);
        }
       
    }
    
    public static boolean InsertPdf(String fileName,String uploadtype,String subcategoryid) {
 try {
File file = new File(fileName);
FileInputStream fs = new FileInputStream(file);
Connection conn = DBConnect.getConnection();
PreparedStatement ps = null;
        Statement stmt = null;
        ResultSet rs = null;
        String id = null;
       
            ps = conn.prepareStatement("select count(CHART_SUBCATEGORY_ID)  Count from clineq.subject_charts where CHART_SUBCATEGORY_ID='" + subcategoryid + "'");
            rs = ps.executeQuery();
            int count=0;
            if(rs.next()){
                count = rs.getInt("Count");
                System.out.println("get Count!");
            }
            
            ps = conn.prepareStatement("select max(TO_NUMBER(EQ_SUBJECT_CHART_ID))  MAX from clineq.subject_charts"); 
            ResultSet rs1 = ps.executeQuery();
            int maxid=0;
            if(rs1.next()){
                maxid = rs1.getInt("MAX");
                System.out.println("get Max:"+maxid);
            }
            if(count == 0 ) {
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
            }
            else
            {
                System.out.println("Record update");
                ps = conn.prepareStatement("update clineq.subject_charts set DOC_CONTENT= ? where EQ_SUBJECT_CHART_ID = ?");
            //ps = conn.prepareStatement(sql);
               
                id = String.valueOf(maxid);
                ps.setBinaryStream(1,fs,fs.available());
                ps.setString(2,subcategoryid);
                int i = ps.executeUpdate();
                System.out.println("Record updated");
            }
      }catch (SQLException e) {
            System.err.println("Error in image insert "+ e.getMessage());
        }catch (FileNotFoundException ex){
            System.err.println("Error in image insert "+ ex.getMessage());
            }catch (IOException eio){
            System.err.println("Error in image insert "+ eio.getMessage());
            }
      
      return true;
    }

}