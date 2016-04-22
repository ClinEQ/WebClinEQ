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
import clineq.business.StudyChartSubcategory;
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
public class SubCategoryDB {
         public static ArrayList<StudyChartSubcategory> selectSiteSubcategory(String studyid,int CatCount) throws DBException {   
  //   public  List<AtomObj> getAll() throws DBException { 
        String sql = "SELECT * FROM CLINEQ.STUDY_CHART_SUBCATEGORY";
                //+ "WHERE EQ_STUDY_ID ='" + studyid +"'";
        System.out.println("in selectSiteSubCategory, sql="+sql);
        ArrayList<StudyChartSubcategory> objList = new ArrayList<>();
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
                StudyChartSubcategory obj = new StudyChartSubcategory();
                //obj.setChartSubcategoryId(rs.getString("CHART_SUBCATEGORY_ID"));
                StudyChartCategory ChartCategoryId = new StudyChartCategory(rs.getString("CHART_CATEGORY_ID"));
                obj.setChartCategoryId(ChartCategoryId);
                obj.setChartType(rs.getString("CHART_TYPE"));
                obj.setChartSubcategoryName(rs.getString("CHART_SUBCATEGORY_NAME"));
                obj.setChartSubcategorySeq(rs.getInt("CHART_SUBCATEGORY_SEQ"));
                obj.setChartSubcategoryStatus(rs.getString("CHART_SUBCATEGORY_StATUS"));
                
                //Studies eqStudyId = StudyDB.selectOneStudy(rs.getString("EQ_STUDY_ID"));
                //obj.setEqStudyId(eqStudyId);
 
                //Organizations org = OrganizationDB.selectOneOrganization(rs.getString("EQ_SITE_ID"));
               /* obj.setEqSiteId(org);
                obj.setSponSubjectId(rs.getString("SPON_SUBJECT_ID"));
                obj.setDateBirth(rs.getDate("DATE_BIRTH"));
                obj.setGender(rs.getString("GENDER"));
                obj.setLastUpdateDate(rs.getDate("LAST_UPDATE_DATE"));
                obj.setLastUpdateId(rs.getString("LAST_UPDATE_ID"));
                obj.setDeleteflag(rs.getString("DELETEFLAG"));
                obj.setDeleteby(rs.getString("DELETEBY"));
                obj.setDeleteDate(rs.getDate("DELETE_DATE"));
                obj.setSubjectStatus(rs.getString("SUBJECT_STATUS"));*/
                objList.add(obj);
            }
            return objList;
        } catch (SQLException e) {
            System.err.println("Error in StudySubcategoryDB selectSubcategory:" + e.getMessage());
            return null;
        } finally {
           DBUtil.closeResultSet(rs);
           DBUtil.closePreparedStatement(ps);
        }
    } 
}
