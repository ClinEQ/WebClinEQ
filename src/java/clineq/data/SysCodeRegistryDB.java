/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clineq.data;

import clineq.business.Users;
import clineq.business.Organizations;
import clineq.business.Studies;
import clineq.business.SysCodeRegistry;
import clineq.business.SysCodeRegistryPK;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSetMetaData;
import clineq.data.DBUtil;
import java.math.BigInteger;
import java.sql.Statement;


/**
 *
 * @author Calum
 */

public class SysCodeRegistryDB {
    
    
        public static ArrayList<SysCodeRegistry> selectAllSysCodeRegistry() throws DBException {    
        String sql = "SELECT * FROM CLINEQ.SYS_CODE_REGISTRY";
        
        ArrayList<SysCodeRegistry> objList = new ArrayList<>();
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
                SysCodeRegistry obj = new SysCodeRegistry();

                eqOrgId = rs.getString("EQ_ORG_ID");
                SysCodeRegistryPK sysCodeRegistryPK = new SysCodeRegistryPK();
                sysCodeRegistryPK.setEqOrgId(eqOrgId);
                sysCodeRegistryPK.setCodeGroupName(rs.getString("CODE_GROUP_NAME"));
                sysCodeRegistryPK.setInGroupSeq(rs.getBigDecimal("IN_GROUP_SEQ").toBigInteger());
                obj.setSysCodeRegistryPK(sysCodeRegistryPK);
                obj.setCodeName(rs.getString("CODE_NAME"));
                obj.setCodeValue(rs.getString("CODE_VALUE"));
                obj.setCodeDesc(rs.getString("CODE_DESC"));
                obj.setCodeType(rs.getString("CODE_TYPE"));
                obj.setStatus(rs.getString("STATUS"));
                obj.setNotes(rs.getString("NOTES"));

                objList.add(obj);
            }
            return objList;
        } catch (SQLException e) {
            System.err.println("Erro in SysCodeRegistryDB selectAllSysCodeRegistry: "+ e.getMessage());
            return null;
        } finally {
           DBUtil.closeResultSet(rs);
           DBUtil.closePreparedStatement(ps);
        }
    }
    
            public static ArrayList<String> selectAllStudyStatus() throws DBException {
        //   public  List<AtomObj> getAll() throws DBException { 
        String sql = "SELECT DISTINCT CODE_VALUE FROM CLINEQ.SYS_CODE_REGISTRY WHERE CODE_GROUP_NAME = 'STUDY_STATUS'";

        ArrayList<String> statusList = new ArrayList<>();
        //  Connection connection = DBConnect.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Connection conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(); //{
            while (rs.next()) {
                statusList.add(rs.getString("CODE_VALUE"));
            }
            return statusList;
        } catch (SQLException e) {
            System.err.println("Error in SysCodeRegistryDB " + e.getMessage());
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
    }
            
            public static ArrayList<String> selectAllOrgStatus() throws DBException {
        //   public  List<AtomObj> getAll() throws DBException { 
        String sql = "SELECT DISTINCT CODE_VALUE FROM CLINEQ.SYS_CODE_REGISTRY WHERE CODE_GROUP_NAME = 'ORG_STATUS'";

        ArrayList<String> statusList = new ArrayList<>();
        //  Connection connection = DBConnect.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Connection conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(); //{
            while (rs.next()) {
                statusList.add(rs.getString("CODE_VALUE"));
            }
            return statusList;
        } catch (SQLException e) {
            System.err.println("Error in SysCodeRegistryDB selectAllOrgStatus" + e.getMessage());
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
    }            
    
}
