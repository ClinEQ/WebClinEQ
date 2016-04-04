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

/**
 *
 * @author Calum
 */
public class UserDB {

    //   public boolean addNew(Study obj) 
    //   {
    //       String sql = "INSERT INTO clineq.studies(EQ_STUDY_ID, EQ_SPON_ID, NCTID, STUDY_ANAME, STUDY_TITLE,STUDY_STATUS) VALUES(?,?,?,?,?, ?)";
    //try ( Connection conn = DBConnect.getConnection();
    //    PreparedStatement ps = conn.prepareStatement(sql))
    //       {
    public static void deleteOneUser(String userid) throws DBException {
        //   public  List<AtomObj> getAll() throws DBException { 
        String sql = "DELETE * FROM CLINEQ.USERS WHERE EQ_USER_ID =" + userid;

        ArrayList<Users> objList = new ArrayList<>();
        PreparedStatement ps = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Connection conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
//            stmt = conn.createStatement();
//            rs = stmt.executeQuery(sql); 

        } catch (SQLException e) {
            System.err.println("Error in userDB deleteOneUser " + e.getMessage());

        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
        return;
    }

    public static ArrayList<Users> selectAllUser() throws DBException {
        //   public  List<AtomObj> getAll() throws DBException { 
        String sql = "SELECT * FROM CLINEQ.USERS";

        ArrayList<Users> objList = new ArrayList<>();
        PreparedStatement ps = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Connection conn = DBConnect.getConnection();
//            ps = conn.prepareStatement(sql);
//            rs = ps.executeQuery();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Users obj = new Users();
                obj.setEqUserId(rs.getString("EQ_USER_ID"));

                Organizations org = OrganizationDB.selectOneOrganization(rs.getString("EQ_ORG_ID"));
                System.out.println("org id: " + org.getEqOrgId());
                System.out.println("org name: " + org.getOrgFullName());

                obj.setEqOrgId(org);
                obj.setLname(rs.getString("LNAME"));
                obj.setFname(rs.getString("FNAME"));
                obj.setTitle(rs.getString("TITLE"));
                obj.setSetupDate(rs.getDate("SETUP_DATE"));
                obj.setLastUpdateDate(rs.getDate("LAST_UPDATE_DATE"));
                obj.setAddress1(rs.getString("ADDRESS1"));
                obj.setAddress2(rs.getString("ADDRESS2"));
                obj.setZip(rs.getString("ZIP"));
                obj.setPhone(rs.getString("PHONE"));
                obj.setEmail(rs.getString("EMAIL"));
                obj.setCity(rs.getString("CITY"));
                obj.setState(rs.getString("STATE"));
                obj.setCountry(rs.getString("COUNTRY"));
                obj.setStatus(rs.getString("STATUS"));
                obj.setExternalDeptName(rs.getString("EXTERNAL_EMPLOYER_ID"));
                obj.setExternalDeptName(rs.getString("EXTERNAL_DEPT_NAME"));
                obj.setUserType(rs.getString("USER_TYPE"));
                obj.setUserRole(rs.getString("USER_ROLE"));
                obj.setUserLoginId(rs.getString("USER_LOGIN_ID"));
                obj.setUserLoginPwd(rs.getString("USER_LOGIN_PWD"));
                objList.add(obj);
            }
            return objList;
        } catch (SQLException e) {
            System.err.println("Error in userDB selectAllUser : " + e.getMessage());
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
    }

    public static void saveUser(Users user) throws DBException {
        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
        if (user == null) {
            return;
        }

        /*
        insert into clineq.users 
(
  EQ_USER_ID   ,
  EQ_ORG_ID            ,
  LNAME                ,
  FNAME                ,
  TITLE               ,
  SETUP_DATE          ,
  LAST_UPDATE_DATE      ,
  ADDRESS1             ,
  ADDRESS2             ,
  ZIP                   ,
  PHONE                ,
  EMAIL                 ,
  CITY                  ,
  STATE                ,
  COUNTRY               ,
  STATUS                ,
  EXTERNAL_EMPLOYER_ID  ,
  EXTERNAL_DEPT_NAME    ,
  USER_TYPE             ,
  USER_ROLE             ,
  USER_LOGIN_ID         ,
  USER_LOGIN_PWD        ,
  FAX                  
)
values(
'1',
'1',
'John',
'smitch',
'study manager',
sysdate,
sysdate,
'address1',
'address2',
'10019',
'21222224444',
'james@yahoo.com',
'Edison',
'NY',
'US',
'ACTIVE',
'BMS123',
'pharm',
'SPONSOR',
'LEVEL ONE MANAGER',
'JOHN01',
'john123',
'2122222222');
         */
        PreparedStatement ps = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Connection conn = DBConnect.getConnection();
            ps = conn.prepareStatement("select clineq.seq_equserid.nextval from dual");
            rs = ps.executeQuery();
            String EQ_USER_ID = null;
            while (rs.next()) {
                EQ_USER_ID = Integer.toString(rs.getInt("NEXTVAL"));
            }

            String sql = "INSERT INTO CLINEQ.USERS ( EQ_USER_ID, EQ_ORG_ID, LNAME, FNAME, TITLE, SETUP_DATE, "
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
        } catch (SQLException e) {
            System.err.println("in userDB = error" + e.getMessage());
            return;
        }
    }
}
