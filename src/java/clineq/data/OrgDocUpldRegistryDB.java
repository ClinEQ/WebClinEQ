/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clineq.data;

import clineq.business.Users;
import clineq.business.OrgDocUpldRegistry;
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
import java.text.SimpleDateFormat;
/**
 *
 * @author User
 */
public class OrgDocUpldRegistryDB {
    
    //public static boolean InsertNewInfo(String orgdocuploadid, String studyid, String subjectid,String orgid, String categoryid, String startdate, String userid, String enddate, String status, String remoteip)
     
    public static boolean InsertNewInfo(String studyid, String subjectid, String categoryid, String startdate, String userloginid, String enddate, String status, String remoteip)
             {
 try {

Connection conn = DBConnect.getConnection();
PreparedStatement ps = null;
        Statement stmt = null;
        ResultSet rs = null;
        String id = null;
        String orgid = null;
        String userid = null;
        String orgdocuploadid = null;
        
        ps = conn.prepareStatement("select max(TO_NUMBER(ORG_DOC_UPLOAD_ID))  MAX from clineq.org_doc_upld_registry"); 
            ResultSet rs1 = ps.executeQuery();
            int maxid=0;
            if(rs1.next()){
                maxid = rs1.getInt("MAX");
                System.out.println("get upload Max:"+maxid);
            }
            orgdocuploadid = String.valueOf(maxid+1);
            
            ps = conn.prepareStatement("select eq_org_id,eq_user_id from clineq.users where user_login_id='"+userloginid+"'");
           rs1 = ps.executeQuery();
            if(rs1.next()){
                orgid = rs1.getString("EQ_ORG_ID");
                userid= rs1.getString("EQ_USER_ID");
                System.out.println("get user and org id");
            }
        String sql ="INSERT INTO clineq.org_doc_upld_registry values('"
                + orgdocuploadid + "','"
                + studyid + "','"
                + subjectid + "','"
                + orgid + "','"
                + categoryid + "',"
                + startdate + ",'"
                + userid + "',"
                + enddate + ",'"
                + status + "','"
                + remoteip + "')";
        System.out.println("org_doc_upld_registry, sql="+sql);
        ps = conn.prepareStatement(sql);
        int i = ps.executeUpdate();
            if(i!=0)
            {
               System.out.println("inser upload good"); 
            }
            else
            {
                 System.out.println("inser upload bad");
            }
                
      }catch (SQLException e) {
            System.err.println("Error in image insert "+ e.getMessage());
       /* }catch (FileNotFoundException ex){
            System.err.println("Error in image insert "+ ex.getMessage());
            }catch (IOException eio){
            System.err.println("Error in image insert "+ eio.getMessage());*/
            }
      
      return true;
    }

    
}
