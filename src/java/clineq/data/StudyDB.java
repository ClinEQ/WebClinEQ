/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clineq.data;

import clineq.business.Users;
import clineq.business.Studies;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSetMetaData;
import clineq.data.DBUtil;


/**
 *
 * @author songy04
 */

public class StudyDB {
    

 //   public boolean addNew(Study obj) 
 //   {
 //       String sql = "INSERT INTO clineq.studies(EQ_STUDY_ID, EQ_SPON_ID, NCTID, STUDY_ANAME, STUDY_TITLE,STUDY_STATUS) VALUES(?,?,?,?,?, ?)";
              
       
        //try ( Connection conn = DBConnect.getConnection();
          //    PreparedStatement ps = conn.prepareStatement(sql))
 //       {
       
    
    public static ArrayList<Studies> selectAllStudy() throws DBException {   
  //   public  List<AtomObj> getAll() throws DBException { 
        String sql = "SELECT * FROM CLINEQ.STUDIES";
        
        ArrayList<Studies> studylist = new ArrayList<>();
      //  Connection connection = DBConnect.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
      
        try { 
            Connection conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(); //{
            while (rs.next()) {
                Studies s = new Studies();
                s.setEqStudyId(rs.getString("EQ_STUDY_ID"));
                s.setEqCoSponId(rs.getString("EQ_CO_SPON_ID"));
                s.setNctid(rs.getString("NCTID"));
                s.setEuStudyId(rs.getString("STUDY_ANAME"));
                s.setStudyAname(rs.getString("STUDY_ANAME"));
                s.setStudyTitle(rs.getString("STUDY_TITLE"));
                s.setSponStudyId(rs.getString("SPON_STUDY_ID"));
                s.setCoSponStudyId(rs.getString("CO_SPON_STUDY_ID"));
                s.setStudyStartDate(rs.getDate("STUDY_START_DATE"));
                s.setStudyEndDate(rs.getDate("STUDY_END_DATE"));
                s.setStudyEqInitDate(rs.getDate("STUDY_EQ_INIT_DATE"));
                s.setStudyEqCloseDate(rs.getDate("STUDY_EQ_CLOSE_DATE"));
                s.setPlannedPatientsNum(rs.getInt("PLANNED_PATIENTS_NUM"));
                s.setEqIwrsId(rs.getString("EQ_IWRS_ID"));
                s.setChartGroupId(rs.getString("CHART_GROUP_ID"));
                s.setStudyStatus(rs.getString("STUDY_STATUS"));
      
                studylist.add(s);
            }
            return studylist;
        } catch (SQLException e) {
            System.err.println("in studyDB = error"+ e.getMessage());
            return null;
        } finally {
           DBUtil.closeResultSet(rs);
           DBUtil.closePreparedStatement(ps);
        }
    }
}
