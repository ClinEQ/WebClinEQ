/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clineq.data;

import clineq.business.Users;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author a03538
 */
public class UserDBTest {
    
    public UserDBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of deleteOneUser method, of class UserDB.
     */
//    @Test
//    public void testDeleteOneUser() throws Exception {
//        System.out.println("deleteOneUser");
//        String userid = "";
//        UserDB.deleteOneUser(userid);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of selectAllUser method, of class UserDB.
//     */
//    @Test
//    public void testSelectAllUser() throws Exception {
//        System.out.println("selectAllUser");
//        ArrayList<Users> expResult = null;
//        ArrayList<Users> result = UserDB.selectAllUser();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of selectUsers method, of class UserDB.
//     */
//    @Test
//    public void testSelectUsers_String() throws Exception {
//        System.out.println("selectUsers");
//        String eq_org_id = "";
//        ArrayList<Users> expResult = null;
//        ArrayList<Users> result = UserDB.selectUsers(eq_org_id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of selectUsers method, of class UserDB.
//     */
//    @Test
//    public void testSelectUsers_String_String() throws Exception {
//        System.out.println("selectUsers");
//        String eq_org_id = "";
//        String user_type = "";
//        ArrayList<Users> expResult = null;
//        ArrayList<Users> result = UserDB.selectUsers(eq_org_id, user_type);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of selectUser method, of class UserDB.
//     */
//    @Test
//    public void testSelectUser() throws Exception {
//        System.out.println("selectUser");
//        String userName = "";
//        String pwd = "";
//        Users expResult = null;
//        Users result = UserDB.selectUser(userName, pwd);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of saveUser method, of class UserDB.
//     */
//    @Test
//    public void testSaveUser() throws Exception {
//        System.out.println("saveUser");
//        Users user = null;
//        UserDB.saveUser(user);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of generateUserID method, of class UserDB.
//     */
//    @Test
//    public void testGenerateUserID() throws Exception {
//        System.out.println("generateUserID");
//        String expResult = "";
//        String result = UserDB.generateUserID();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of userExist method, of class UserDB.
     */
    @Test
    public void testUserExist() throws Exception {
        System.out.println("userExist");
        String userid = "";
        boolean expResult = false;
        boolean result = UserDB.userExist("3");
        assertEquals(expResult, result);
        expResult = true;
        result = UserDB.userExist("1");
        assertEquals(expResult, result);
    }
    
}
