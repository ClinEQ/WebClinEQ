/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clineq.data;

import clineq.business.SysCodeRegistry;
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
public class SysCodeRegistryDBTest {
    
    public SysCodeRegistryDBTest() {
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
     * Test of selectAllUserStatus method, of class SysCodeRegistryDB.
     */
    @Test
    public void testSelectAllUserStatus() throws Exception {
        System.out.println("selectAllUserStatus");
        ArrayList<String> expResult = null;
        ArrayList<String> result = SysCodeRegistryDB.selectAllUserStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    
}
