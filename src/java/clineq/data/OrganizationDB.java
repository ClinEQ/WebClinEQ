/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clineq.data;

import clineq.business.Users;
import clineq.business.Organizations;
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
 * @author Calum
 */

public class OrganizationDB {
    

 //   public boolean addNew(Study obj) 
 //   {
 //       String sql = "INSERT INTO clineq.studies(EQ_STUDY_ID, EQ_SPON_ID, NCTID, STUDY_ANAME, STUDY_TITLE,STUDY_STATUS) VALUES(?,?,?,?,?, ?)";
              
       
        //try ( Connection conn = DBConnect.getConnection();
          //    PreparedStatement ps = conn.prepareStatement(sql))
 //       {
       
    
    public static ArrayList<Organizations> selectAllOrganization() throws DBException {
        //   public  List<AtomObj> getAll() throws DBException { 
        String sql = "SELECT * FROM CLINEQ.ORGANIZATIONS";

        ArrayList<Organizations> objList = new ArrayList<>();
        //  Connection connection = DBConnect.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Connection conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(); //{
            while (rs.next()) {
                Organizations obj = new Organizations();
                obj.setEqOrgId(rs.getString("EQ_ORG_ID"));
                obj.setOrgFullName(rs.getString("ORG_FULL_NAME"));
                obj.setOrgNameAbbr(rs.getString("ORG_NAME_ABBR"));
                obj.setOrgDisplayName(rs.getString("ORG_DISPLAY_NAME"));
                obj.setOrgType(rs.getString("ORG_TYPE"));
                obj.setOrgCategory(rs.getString("ORG_CATEGORY"));
                obj.setAddress1(rs.getString("ADDRESS1"));
                obj.setAddress2(rs.getString("ADDRESS2"));
                obj.setCity(rs.getString("CITY"));
                obj.setState(rs.getString("STATE"));
                obj.setZip(rs.getString("ZIP"));
                obj.setCountry(rs.getString("COUNTRY"));
                obj.setPhone(rs.getString("PHONE"));
                obj.setFax(rs.getString("FAX"));
                obj.setOrgUrl(rs.getString("ORG_URL"));
                obj.setNotes(rs.getString("NOTES"));
                obj.setStatus(rs.getString("STATUS"));

                objList.add(obj);
            }
            return objList;
        } catch (SQLException e) {
            System.err.println("in organizationDB = error" + e.getMessage());
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
    }
    
     public static String getOrgName(String orgid) throws DBException {
        //   public  List<AtomObj> getAll() throws DBException { 
        String sql = "SELECT ORG_FULL_NAME FROM CLINEQ.ORGANIZATIONS WHERE EQ_ORG_ID = " + orgid;

        String orgname = null;
        //  Connection connection = DBConnect.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        

        try {
            Connection conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(); //{
            while (rs.next()) {
                orgname = rs.getString("ORG_FULL_NAME");
            }
        } catch (SQLException e) {
            System.err.println("Error in organizationDB getOrgName " + e.getMessage());
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
        return orgname;
    } 
}
