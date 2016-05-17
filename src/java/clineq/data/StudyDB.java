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
import java.sql.Statement;
import java.text.SimpleDateFormat;

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
    public static ArrayList<Studies> selectAllStudy(String userId) throws DBException {
        //   public  List<AtomObj> getAll() throws DBException { 
        String sql = "SELECT S.EQ_STUDY_ID, EQ_CO_SPON_ID, NCTID, EU_STUDY_ID, "
                + "EQ_SPON_ID, STUDY_ANAME, STUDY_TITLE, SPON_STUDY_ID, "
                + "CO_SPON_STUDY_ID, STUDY_START_DATE, STUDY_END_DATE, "
                + "STUDY_EQ_INIT_DATE, STUDY_EQ_CLOSE_DATE, PLANNED_PATIENTS_NUM, "
                + "EQ_IWRS_ID, CHART_GROUP_ID, STUDY_STATUS, ORG_FULL_NAME,USER,USER_LOGIN_ID"
                + " FROM CLINEQ.STUDIES S, CLINEQ.ORGANIZATIONS O, CLINEQ.USERS U, CLINEQ.STUDY_USER_MAP M"
                + " WHERE S.EQ_SPON_ID = O.EQ_ORG_ID"
                + " AND S.EQ_STUDY_ID=M.EQ_STUDY_ID"
                + " AND M.EQ_USER_ID=U.EQ_USER_ID"
                + " AND USER_LOGIN_ID='" + userId + "'";
        System.out.println("sql=" + sql);
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
                s.setEuStudyId(rs.getString("EU_STUDY_ID"));

                s.setEqSponId(rs.getString("EQ_SPON_ID"));
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
                s.setEqSponName(rs.getString("ORG_FULL_NAME"));
                s.setEqUserName(rs.getString("USER_LOGIN_ID"));
                studylist.add(s);
            }
            return studylist;
        } catch (SQLException e) {
            System.err.println("in studyDB = error" + e.getMessage());
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
    }

    public static ArrayList<Studies> selectAllStudy() throws DBException {
        //   public  List<AtomObj> getAll() throws DBException { 
        String sql = "SELECT EQ_STUDY_ID, EQ_CO_SPON_ID, NCTID, EU_STUDY_ID, "
                + "EQ_SPON_ID, STUDY_ANAME, STUDY_TITLE, SPON_STUDY_ID, "
                + "CO_SPON_STUDY_ID, STUDY_START_DATE, STUDY_END_DATE, "
                + "STUDY_EQ_INIT_DATE, STUDY_EQ_CLOSE_DATE, PLANNED_PATIENTS_NUM, "
                + "EQ_IWRS_ID, CHART_GROUP_ID, STUDY_STATUS, ORG_FULL_NAME "
                + "FROM CLINEQ.STUDIES S, CLINEQ.ORGANIZATIONs O "
                + "WHERE S.EQ_SPON_ID = O.EQ_ORG_ID";

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
                s.setEuStudyId(rs.getString("EU_STUDY_ID"));

                s.setEqSponId(rs.getString("EQ_SPON_ID"));
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
                s.setEqSponName(rs.getString("ORG_FULL_NAME"));
                studylist.add(s);
            }
            return studylist;
        } catch (SQLException e) {
            System.err.println("in studyDB = error" + e.getMessage());
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
    }

    public static ArrayList<Studies> selectStudies(String eqSponsorID) throws DBException {
        if ("ALL".equals(eqSponsorID)) {
            return selectAllStudy();
        }
        String sql = "SELECT EQ_STUDY_ID, EQ_CO_SPON_ID, NCTID, EU_STUDY_ID, "
                + "EQ_SPON_ID, STUDY_ANAME, STUDY_TITLE, SPON_STUDY_ID, "
                + "CO_SPON_STUDY_ID, STUDY_START_DATE, STUDY_END_DATE, "
                + "STUDY_EQ_INIT_DATE, STUDY_EQ_CLOSE_DATE, PLANNED_PATIENTS_NUM, "
                + "EQ_IWRS_ID, CHART_GROUP_ID, STUDY_STATUS, ORG_FULL_NAME "
                + "FROM CLINEQ.STUDIES S, CLINEQ.ORGANIZATIONs O "
                + "WHERE S.EQ_SPON_ID = O.EQ_ORG_ID "
                + "AND EQ_SPON_ID = '" + eqSponsorID + "'";

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
                s.setEuStudyId(rs.getString("EU_STUDY_ID"));

                s.setEqSponId(rs.getString("EQ_SPON_ID"));
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
                s.setEqSponName(rs.getString("ORG_FULL_NAME"));
                studylist.add(s);
            }
            return studylist;
        } catch (SQLException e) {
            System.err.println("in studyDB = error" + e.getMessage());
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
    }

    public static Studies selectOneStudy(String EQ_STUDY_ID) throws DBException {
        //   public  List<AtomObj> getAll() throws DBException { 
        String sql = "SELECT EQ_STUDY_ID, EQ_CO_SPON_ID, NCTID, EU_STUDY_ID, "
                + "EQ_SPON_ID, STUDY_ANAME, STUDY_TITLE, SPON_STUDY_ID, "
                + "CO_SPON_STUDY_ID, STUDY_START_DATE, STUDY_END_DATE, "
                + "STUDY_EQ_INIT_DATE, STUDY_EQ_CLOSE_DATE, PLANNED_PATIENTS_NUM, "
                + "EQ_IWRS_ID, CHART_GROUP_ID, STUDY_STATUS, ORG_FULL_NAME "
                + "FROM CLINEQ.STUDIES S, CLINEQ.ORGANIZATIONs O "
                + "WHERE S.EQ_SPON_ID = O.EQ_ORG_ID "
                + "AND EQ_STUDY_ID='" + EQ_STUDY_ID + "'";

        Studies s = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Connection conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(); //{
            while (rs.next()) {
                s = new Studies();
                s.setEqStudyId(rs.getString("EQ_STUDY_ID"));
                s.setEqCoSponId(rs.getString("EQ_CO_SPON_ID"));
                s.setNctid(rs.getString("NCTID"));
                s.setEuStudyId(rs.getString("EU_STUDY_ID"));

                s.setEqSponId(rs.getString("EQ_SPON_ID"));
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
                s.setEqSponName(rs.getString("ORG_FULL_NAME"));

            }
            return s;
        } catch (SQLException e) {
            System.err.println("Error in studyDB selectOneStudy" + e.getMessage());
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
    }

    public static ArrayList<String> selectAllStudyStatus() throws DBException {
        //   public  List<AtomObj> getAll() throws DBException { 
        String sql = "SELECT distinct study_status FROM CLINEQ.STUDIES";

        ArrayList<String> statusList = new ArrayList<>();
        //  Connection connection = DBConnect.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Connection conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(); //{
            while (rs.next()) {
                statusList.add(rs.getString("study_status"));
            }
            return statusList;
        } catch (SQLException e) {
            System.err.println("in studyDB = error" + e.getMessage());
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
    }

    public static ArrayList<String> selectAllOrgStatus() throws DBException {
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

    public static ArrayList<String> selectAllStudySponsorName() throws DBException {
        //   public  List<AtomObj> getAll() throws DBException { 
        String sql = "SELECT DISTINCT ORG_FULL_NAME FROM CLINEQ.ORGANIZATIONS O, CLINEQ.STUDIES S WHERE O.EQ_ORG_ID = S.EQ_SPON_ID";

        ArrayList<String> sponsorNameList = new ArrayList<>();
        //  Connection connection = DBConnect.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        //sponsorNameList.add("All");

        try {
            Connection conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(); //{
            while (rs.next()) {
                sponsorNameList.add(rs.getString("ORG_FULL_NAME"));
            }
            return sponsorNameList;
        } catch (SQLException e) {
            System.err.println("in studyDB = error" + e.getMessage());
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
        }
    }

    public static void saveStudy(Studies study) throws DBException {
        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
        if (study == null) {
            return;
        }

        /* INSERT INTO Customers (CustomerName, ContactName, Address, City, PostalCode, Country)
VALUES ('Cardinal','Tom B. Erichsen','Skagen 21','Stavanger','4006','Norway'); */
        PreparedStatement ps = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Connection conn = DBConnect.getConnection();
            //ps = conn.prepareStatement("select clineq.seq_eqstuddyid.nextval from dual");
            //rs = ps.executeQuery();
            String strStudyStart = (study.getStudyStartDate()!=null)? "to_date('" + (formatter.format(study.getStudyStartDate().getTime())) + "','mm/dd/yyyy'),":"null,";
            String strStudyEnd = (study.getStudyEndDate()!=null)? "to_date('" + (formatter.format(study.getStudyEndDate().getTime())) + "','mm/dd/yyyy'),":"null,";
            String strEqInit = (study.getStudyEqInitDate()!=null)? "to_date('" + (formatter.format(study.getStudyEqInitDate().getTime())) + "','mm/dd/yyyy'),":"null,";
            String strEqClose = (study.getStudyEqCloseDate()!=null)? "to_date('" + (formatter.format(study.getStudyEqCloseDate().getTime())) + "','mm/dd/yyyy'),":"null,";

            String sql = "INSERT INTO CLINEQ.STUDIES ( EQ_STUDY_ID, EQ_CO_SPON_ID, NCTID, EU_STUDY_ID, "
                    + "EQ_SPON_ID, STUDY_ANAME, STUDY_TITLE, SPON_STUDY_ID, "
                    + "CO_SPON_STUDY_ID, STUDY_START_DATE, STUDY_END_DATE, "
                    + "STUDY_EQ_INIT_DATE, STUDY_EQ_CLOSE_DATE, PLANNED_PATIENTS_NUM, "
                    + "EQ_IWRS_ID, CHART_GROUP_ID, STUDY_STATUS, EQ_EDC_ID ) VALUES ("
                    + "'" + study.getEqStudyId() + "',"
                    + "'" + study.getEqCoSponId() + "',"
                    + "'" + study.getNctid() + "',"
                    + "'" + study.getEuStudyId() + "',"
                    + "'" + study.getEqSponId() + "',"
                    + "'" + study.getStudyAname() + "',"
                    + "'" + study.getStudyTitle() + "',"
                    + "'" + study.getSponStudyId() + "',"
                    + "'" + study.getCoSponStudyId() + "',"
                    //+ to_date('01/01/2015','mm/dd/yyyy'),
                    + strStudyStart
                    + strStudyEnd
                    + strEqInit
                    + strEqClose
                    + study.getPlannedPatientsNum() + ","
                    + "'" + study.getEqIwrsId() + "',"
                    + "'" + study.getChartGroupId() + "',"
                    + "'" + study.getStudyStatus() + "',"
                    + "'" + study.getEqEDCId()+ "'"
                    + ")";

            System.out.println("insert sql=" + sql);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.err.println("Error in studyDB saveStudy : " + e.getMessage());
            return;
        }
    }
    
     
    public static String generateStudyID() throws DBException {

        PreparedStatement ps = null;
        Statement stmt = null;
        ResultSet rs = null;
        String EQ_STUDY_ID = null;
        
        try {
            Connection conn = DBConnect.getConnection();
            ps = conn.prepareStatement("select clineq.seq_eqstuddyid.nextval from dual");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                EQ_STUDY_ID = Integer.toString(rs.getInt("NEXTVAL"));
                EQ_STUDY_ID = "eqstu" + ("00000" + EQ_STUDY_ID).substring(EQ_STUDY_ID.length());
            }
            


        } catch (SQLException e) {
            System.err.println("Error in studyDB saveStudy : " + e.getMessage());
            
        }
        return EQ_STUDY_ID;
    }
}
