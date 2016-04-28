/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clineq.data;

import clineq.business.Organizations;
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
public class OrganizationDBTest {
    
    public OrganizationDBTest() {
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
     * Test of selectAllOrganization method, of class OrganizationDB.
     */
//    @Test
//    public void testSelectAllOrganization() throws Exception {
//        System.out.println("selectAllOrganization");
//        ArrayList<Organizations> expResult = null;
//        ArrayList<Organizations> result = OrganizationDB.selectAllOrganization();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of selectOrganizationByType method, of class OrganizationDB.
//     */
//    @Test
//    public void testSelectOrganizationByType() throws Exception {
//        System.out.println("selectOrganizationByType");
//        String orgType = "";
//        ArrayList<Organizations> expResult = null;
//        ArrayList<Organizations> result = OrganizationDB.selectOrganizationByType(orgType);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getOrgName method, of class OrganizationDB.
//     */
//    @Test
//    public void testGetOrgName() throws Exception {
//        System.out.println("getOrgName");
//        String orgid = "";
//        String expResult = "";
//        String result = OrganizationDB.getOrgName(orgid);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of selectOneOrganization method, of class OrganizationDB.
//     */
//    @Test
//    public void testSelectOneOrganization() throws Exception {
//        System.out.println("selectOneOrganization");
//        String EQ_ORG_ID = "";
//        Organizations expResult = null;
//        Organizations result = OrganizationDB.selectOneOrganization(EQ_ORG_ID);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of saveOrg method, of class OrganizationDB.
//     */
//    @Test
//    public void testSaveOrg() throws Exception {
//        System.out.println("saveOrg");
//        Organizations org = null;
//        OrganizationDB.saveOrg(org);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of generateOrgID method, of class OrganizationDB.
     * Increase one before run
     */
    @Test
    public void testGenerateOrgID() throws Exception {
        System.out.println("generateOrgID");
        String expResult = "eqorg00020";
        String result = OrganizationDB.generateOrgID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
