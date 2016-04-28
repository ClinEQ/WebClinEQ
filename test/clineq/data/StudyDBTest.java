/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clineq.data;

import clineq.business.Studies;
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
public class StudyDBTest {
    
    public StudyDBTest() {
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
     * Test of selectAllStudy method, of class StudyDB.
     */
//    @Test
//    public void testSelectAllStudy() throws Exception {
//        System.out.println("selectAllStudy");
//        ArrayList<Studies> expResult = null;
//        ArrayList<Studies> result = StudyDB.selectAllStudy();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of selectOneStudy method, of class StudyDB.
//     */
//    @Test
//    public void testSelectOneStudy() throws Exception {
//        System.out.println("selectOneStudy");
//        String EQ_STUDY_ID = "";
//        Studies expResult = null;
//        Studies result = StudyDB.selectOneStudy(EQ_STUDY_ID);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of selectAllStudyStatus method, of class StudyDB.
//     */
//    @Test
//    public void testSelectAllStudyStatus() throws Exception {
//        System.out.println("selectAllStudyStatus");
//        ArrayList<String> expResult = null;
//        ArrayList<String> result = StudyDB.selectAllStudyStatus();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of selectAllStudySponsorName method, of class StudyDB.
//     */
//    @Test
//    public void testSelectAllStudySponsorName() throws Exception {
//        System.out.println("selectAllStudySponsorName");
//        ArrayList<String> expResult = null;
//        ArrayList<String> result = StudyDB.selectAllStudySponsorName();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of saveStudy method, of class StudyDB.
//     */
//    @Test
//    public void testSaveStudy() throws Exception {
//        System.out.println("saveStudy");
//        Studies study = null;
//        StudyDB.saveStudy(study);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of selectAllStudy method, of class StudyDB.
//     */
//    @Test
//    public void testSelectAllStudy_String() throws Exception {
//        System.out.println("selectAllStudy");
//        String userId = "";
//        ArrayList<Studies> expResult = null;
//        ArrayList<Studies> result = StudyDB.selectAllStudy(userId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of selectAllStudy method, of class StudyDB.
//     */
//    @Test
//    public void testSelectAllStudy_0args() throws Exception {
//        System.out.println("selectAllStudy");
//        ArrayList<Studies> expResult = null;
//        ArrayList<Studies> result = StudyDB.selectAllStudy();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of selectStudies method, of class StudyDB.
//     */
//    @Test
//    public void testSelectStudies() throws Exception {
//        System.out.println("selectStudies");
//        String eqSponsorID = "";
//        ArrayList<Studies> expResult = null;
//        ArrayList<Studies> result = StudyDB.selectStudies(eqSponsorID);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of selectAllOrgStatus method, of class StudyDB.
//     */
//    @Test
//    public void testSelectAllOrgStatus() throws Exception {
//        System.out.println("selectAllOrgStatus");
//        ArrayList<String> expResult = null;
//        ArrayList<String> result = StudyDB.selectAllOrgStatus();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of generateStudyID method, of class StudyDB.
     * Increase by 1 before run the test
     */
    @Test
    public void testGenerateStudyID() throws Exception {
        System.out.println("generateStudyID");
        String expResult = "eqstu00019";
        String result = StudyDB.generateStudyID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
