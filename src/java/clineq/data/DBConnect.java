package clineq.data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author songy04
 */
public class DBConnect {
    private static Connection conn;

         // office connection
	//    private static String url = "jdbc:oracle:thin:@10.95.1.50:1521:sinaidw";
          //  private static String user = "yusong";
           // private static String pass = "yusong123";
           
             // orcl connection
            private static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	    private static String user = "clineq";
	    private static String pass = "clinEQ123";
            
	     // orcl connection
        //    private static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	 //   private static String user = "clineq";
	 //   private static String pass = "yusong123";
            
	    public static Connection getConnection() throws SQLException{
	        try{
	            Class.forName("oracle.jdbc.OracleDriver").newInstance();
	        }catch(ClassNotFoundException cnfe){
	            System.out.println("Error: "+cnfe.getMessage());

	        }catch(InstantiationException ie){

	            System.out.println("Error: "+ie.getMessage());
	        }catch(IllegalAccessException iae){
	            System.out.println("Error: "+iae.getMessage());
	        }
 
	        conn = DriverManager.getConnection(url,user,pass);
	        return conn;
	    }

	//    public static Connection getConnection() throws SQLException, ClassNotFoundException{

	  //      if(conn !=null && !conn.isClosed())
	   //         return conn;
	  //      connect();
          //      return conn;
   // } 
}
