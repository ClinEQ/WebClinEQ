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
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Collection;

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

    public static ArrayList<Organizations> selectOrganizationByType(String orgType) throws DBException {
        //   public  List<AtomObj> getAll() throws DBException { 
        String sql = "SELECT * FROM CLINEQ.ORGANIZATIONS WHERE ORG_TYPE = '" + orgType + "'";

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

    public static ArrayList<String> selectOrgStatus() throws DBException {
        //   public  List<AtomObj> getAll() throws DBException { 
        String sql = "SELECT DISTINCT STATUS FROM CLINEQ.ORGANIZATIONS";

        ArrayList<String> statusList = new ArrayList<>();
        //  Connection connection = DBConnect.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Connection conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(); //{
            while (rs.next()) {
                statusList.add(rs.getString("STATUS"));
            }
            return statusList;
        } catch (SQLException e) {
            System.err.println("Error in studyDB selectAllOrgStatus" + e.getMessage());
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

    public static Organizations selectOneOrganization(String EQ_ORG_ID) throws DBException {
        //   public  List<AtomObj> getAll() throws DBException { 
        String sql = "SELECT * FROM CLINEQ.ORGANIZATIONS WHERE EQ_ORG_ID = '" + EQ_ORG_ID + "'";

        PreparedStatement ps = null;
        ResultSet rs = null;
        Organizations obj = null;

        try {
            Connection conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(); //{
            while (rs.next()) {
                obj = new Organizations();
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

            }
            return obj;
        } catch (SQLException e) {
            System.err.println("Error in organizationDB selectOneOrganization " + e.getMessage());
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
    }

    public static void saveOrg(Organizations org) throws DBException {
        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
        if (org == null) {
            return;
        }

        /*
        insert into  ORGANIZATIONS
(
  EQ_ORG_ID       ,
  ORG_FULL_NAME     ,
  ORG_NAME_ABBR   ,
  ORG_DISPLAY_NAME ,
  ORG_TYPE          ,
  ORG_CATEGORY     ,
  ADDRESS1         ,
  ADDRESS2          ,
  CITY              ,
  STATE             ,
  ZIP               ,
  COUNTRY           ,
  PHONE             ,
  FAX               ,
  ORG_URL          ,
  NOTES             ,
  STATUS          
)
values(
'0',
'clineq llc',
'clineq',
'a owner company',
'OWNER',
'pharm server provider',
'ADDRESS1',
'ADDRESs2',
'princeton',
'NJ',
'08800',
'US',
'609880000',
'609880009',
'www.clineq.com/ourcompany/Pages/home.aspx',
'THIS IS owner COMPANY',
'ACTIVE');
        
         */
        PreparedStatement ps = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Connection conn = DBConnect.getConnection();

            String EQ_ORG_ID = generateOrgID();

            String sql = "INSERT INTO CLINEQ.ORGANIZATIONS ( EQ_ORG_ID, ORG_FULL_NAME, ORG_NAME_ABBR, "
                    + "ORG_DISPLAY_NAME, ORG_TYPE, ORG_CATEGORY, ADDRESS1, "
                    + "ADDRESS2, CITY, STATE, "
                    + "ZIP, COUNTRY, PHONE, "
                    + "FAX, ORG_URL, NOTES, STATUS ) VALUES ("
                    + "'" + EQ_ORG_ID + "',"
                    + "'" + org.getOrgFullName() + "',"
                    + "'" + org.getOrgNameAbbr() + "',"
                    + "'" + org.getOrgDisplayName() + "',"
                    + "'" + org.getOrgType() + "',"
                    + "'" + org.getOrgCategory() + "',"
                    + "'" + org.getAddress1() + "',"
                    + "'" + org.getAddress2() + "',"
                    + "'" + org.getCity() + "',"
                    + "'" + org.getState() + "',"
                    + "'" + org.getZip() + "',"
                    + "'" + org.getCountry() + "',"
                    + "'" + org.getPhone() + "',"
                    + "'" + org.getFax() + "',"
                    + "'" + org.getOrgUrl() + "',"
                    + "'" + org.getNotes() + "',"
                    + "'" + org.getStatus() + "'"
                    + ")";

            System.out.println("insert sql=" + sql);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.err.println("Error in orgDB saveOrg :" + e.getMessage());
            return;
        }
    }

    public static void saveOrgNUserNMap(String EQ_STUDY_ID, Organizations org) throws DBException {
        Collection<Users> usersCollection = org.getUsersCollection();
        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
        String EQ_USER_ID = null;

        /*
        insert into  clineq.STUDY_ORG_USER_MAP
(
  EQ_STUDY_ID       ,
        EQ_ORG_ID       ,
        EQ_USER_ID       ,
  LAST_UPDATE_DATE     ,
  STATUS   ,
  ORG_TYPE ,
  SECURITY_LEVEL  
)
values(
'1',
'1',
'1',
SYSDATE,
'ACTIVE',
'SPONSOR',
'1');
        
         */
        PreparedStatement ps = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Connection conn = DBConnect.getConnection();

            String EQ_ORG_ID = org.getEqOrgId();

            // Insert Org
            String sql = "INSERT INTO CLINEQ.ORGANIZATIONS ( EQ_ORG_ID, ORG_FULL_NAME, ORG_NAME_ABBR, "
                    + "ORG_DISPLAY_NAME, ORG_TYPE, ORG_CATEGORY, ADDRESS1, "
                    + "ADDRESS2, CITY, STATE, "
                    + "ZIP, COUNTRY, PHONE, "
                    + "FAX, ORG_URL, NOTES, STATUS ) VALUES ("
                    + "'" + EQ_ORG_ID + "',"
                    + "'" + org.getOrgFullName() + "',"
                    + "'" + org.getOrgNameAbbr() + "',"
                    + "'" + org.getOrgDisplayName() + "',"
                    + "'" + org.getOrgType() + "',"
                    + "'" + org.getOrgCategory() + "',"
                    + "'" + org.getAddress1() + "',"
                    + "'" + org.getAddress2() + "',"
                    + "'" + org.getCity() + "',"
                    + "'" + org.getState() + "',"
                    + "'" + org.getZip() + "',"
                    + "'" + org.getCountry() + "',"
                    + "'" + org.getPhone() + "',"
                    + "'" + org.getFax() + "',"
                    + "'" + org.getOrgUrl() + "',"
                    + "'" + org.getNotes() + "',"
                    + "'" + org.getStatus() + "'"
                    + ")";

            System.out.println("insert sql=" + sql);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            
            
            for (Users user : usersCollection) {
                EQ_USER_ID = user.getEqUserId();

                // Insert User
                sql = "INSERT INTO CLINEQ.USERS ( EQ_USER_ID, EQ_ORG_ID, LNAME, FNAME, TITLE, SETUP_DATE, "
                        + "LAST_UPDATE_DATE, ADDRESS1, ADDRESS2, ZIP, PHONE, EMAIL, CITY, STATE, COUNTRY, STATUS, "
                        + "EXTERNAL_EMPLOYER_ID, EXTERNAL_DEPT_NAME, USER_TYPE, USER_ROLE, "
                        + "USER_LOGIN_ID, USER_LOGIN_PWD, FAX ) VALUES ("
                        + "'" + EQ_USER_ID + "',"
                        + "'" + user.getEqOrgId().getEqOrgId() + "',"
                        + "'" + user.getLname() + "',"
                        + "'" + user.getFname() + "',"
                        + "'" + user.getTitle() + "',"
                        + "to_date('" + (formatter.format(user.getSetupDate().getTime())) + "','mm/dd/yyyy'),"
                        + "to_date('" + (formatter.format(user.getLastUpdateDate().getTime())) + "','mm/dd/yyyy'),"
                        + "'" + user.getAddress1() + "',"
                        + "'" + user.getAddress2() + "',"
                        + "'" + user.getZip() + "',"
                        + "'" + user.getPhone() + "',"
                        + "'" + user.getEmail() + "',"
                        + "'" + user.getCity() + "',"
                        + "'" + user.getState() + "',"
                        + "'" + user.getCountry() + "',"
                        + "'" + user.getStatus() + "',"
                        + "'" + user.getExternalEmployerId() + "',"
                        + "'" + user.getExternalDeptName() + "',"
                        + "'" + user.getUserType() + "',"
                        + "'" + user.getUserRole() + "',"
                        + "'" + user.getUserLoginId() + "',"
                        + "'" + user.getUserLoginPwd() + "',"
                        + "'" + user.getFax()
                        + "')";

                System.out.println("insert sql=" + sql);
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);

                
                // Insert STUDY_ORG_USER_MAP
                sql = "INSERT INTO CLINEQ.STUDY_ORG_USER_MAP ( EQ_STUDY_ID, EQ_ORG_ID, EQ_USER_ID"
                        + "LAST_UPDATE_DATE, STATUS, ORG_TYPE, SECURITY_LEVEL "
                        + ") VALUES ("
                        + "'" + EQ_STUDY_ID + "',"
                        + "'" + EQ_ORG_ID + "',"
                        + "'" + EQ_USER_ID + "',"
                        + "SYSDATE, 'ACTIVE',"
                        + "'" + org.getOrgType() + "',"
                        + "'level2'"
                        + ")";

                System.out.println("insert sql=" + sql);
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);

            }
        } catch (SQLException e) {
            System.err.println("Error in orgDB saveOrg :" + e.getMessage());
            return;
        }
    }
    
     public static String generateOrgID() throws DBException {

        PreparedStatement ps = null;
        Statement stmt = null;
        ResultSet rs = null;
        String EQ_ORG_ID = null;

        try {
            Connection conn = DBConnect.getConnection();
            ps = conn.prepareStatement("select clineq.seq_eqorgid.nextval from dual");
            rs = ps.executeQuery();

            while (rs.next()) {
                EQ_ORG_ID = Integer.toString(rs.getInt("NEXTVAL"));
                EQ_ORG_ID = "eqorg" + ("00000" + EQ_ORG_ID).substring(EQ_ORG_ID.length());
            }

        } catch (SQLException e) {
            System.err.println("Error in studyDB saveStudy : " + e.getMessage());

        }
        return EQ_ORG_ID;
    }
}
