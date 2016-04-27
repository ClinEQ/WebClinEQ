/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clineq.data;

import clineq.business.Users;
import clineq.business.Organizations;
import clineq.business.Studies;
import clineq.business.StudyChartCategory;
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
 * @author User
 */
public class CategoryDB {
    
     public static ArrayList<StudyChartCategory> selectSiteSponsorCategory(String studyid) throws DBException {   
  //   public  List<AtomObj> getAll() throws DBException { 
        String sql = "SELECT * FROM CLINEQ.STUDY_CHART_CATEGORY"
                + " WHERE EQ_STUDY_ID ='" + studyid +"'";
        
        System.out.println("in selectSiteSponsorCategory, sql="+sql);
        
        ArrayList<StudyChartCategory> objList = new ArrayList<>();
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
                StudyChartCategory obj = new StudyChartCategory();
                /*Studies eqStudyId = StudyDB.selectOneStudy(rs.getString("EQ_STUDY_ID"));
                obj.setEqStudyId(eqStudyId);
                obj.setChartCategoryName(rs.getString("CHART_CATEGORY_NAME"));
                obj.setStatus(rs.getString("STATUS"));
                obj.setLastUpdateDate(rs.getDate("LAST_UPDATE_DATE"));
               
                objList.add(obj);*/
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
     public static int selectSiteSponsorCategoryCount(String studyid) throws DBException {   
  //   public  List<AtomObj> getAll() throws DBException { 
        String sql = "SELECT count(*) count FROM CLINEQ.STUDY_CHART_CATEGORY"
                + " WHERE EQ_STUDY_ID ='" + studyid +"'";
        System.out.println("in selectSiteSponsorCategoryCount, sql="+sql);
        ArrayList<StudyChartCategory> objList = new ArrayList<>();
        PreparedStatement ps = null;
        Statement stmt = null;
        ResultSet rs = null;
      
        try { 
            Connection conn = DBConnect.getConnection();
//            ps = conn.prepareStatement(sql);
//            rs = ps.executeQuery();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql); 
            //String eqOrgId = null;
            while (rs.next()) {
                //StudyChartCategory obj = new StudyChartCategory();
                int Count = rs.getInt("count");
                return Count;
                
            }
            return 0;
        } catch (SQLException e) {
            System.err.println("Error in StudyCategoryDB selectCategory:" + e.getMessage());
            return -1;
        } finally {
           DBUtil.closeResultSet(rs);
           DBUtil.closePreparedStatement(ps);
        }
    }
    
}
