/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clineq.data;

import clineq.business.SiteLocations;
import clineq.business.SysCodeRegistry;
import clineq.business.SysCodeRegistryPK;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author a03538
 */
public class SiteLocationDB {
            public static ArrayList<SiteLocations> selectAllSiteLocations() throws DBException {    
        String sql = "SELECT * FROM CLINEQ.SITE_LOCATIONS";
        
        ArrayList<SiteLocations> objList = new ArrayList<>();
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
                SiteLocations obj = new SiteLocations();

                obj.setEqLocationId(rs.getString("EQ_LOCATION_ID"));
                obj.setEqSiteId(rs.getString("EQ_SITE_ID"));
                obj.setSponSiteId(rs.getString("SPON_SITE_ID"));
                obj.setAddress1(rs.getString("ADDRESS1"));
                obj.setAddress2(rs.getString("ADDRESS2"));
                obj.setCity(rs.getString("CITY"));
                obj.setState(rs.getString("STATE"));
                obj.setCountry(rs.getString("COUNTRY"));
                obj.setPhone(rs.getString("PHONE"));
                obj.setZip(rs.getString("ZIP"));
                obj.setEmrType(rs.getString("EMR_TYPE"));
                obj.setSiteLocationName(rs.getString("SITE_LOCATION_NAME"));
                

                objList.add(obj);
            }
            return objList;
        } catch (SQLException e) {
            System.err.println("Erro in SiteLocationsDB : "+ e.getMessage());
            return null;
        } finally {
           DBUtil.closeResultSet(rs);
           DBUtil.closePreparedStatement(ps);
        }
    }
}
