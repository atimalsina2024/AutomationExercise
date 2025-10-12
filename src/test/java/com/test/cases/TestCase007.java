package com.test.cases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.helper.HomePageFlow;
import com.test.helper.TestCaseFlow;

public class TestCase007 extends TestBase{
	private static final Logger logger = LogManager.getLogger(TestCase007.class);
	private HomePageFlow homePageFlow;
	private TestCaseFlow testCaseFlow;
	
	@BeforeClass
	public void testSetup() {
		logger.debug("@BeforeClass TestCase007");
		homePageFlow = new HomePageFlow(driver);
		testCaseFlow = new TestCaseFlow(driver);
	}
	@Test(description = "verify landing on test cases page", groups = {"regression"})
	public void TC_007_Verify_Test_Case_Page() {
//		1. Launch browser
//		2. Navigate to url 'http://automationexercise.com'
//		3. Verify that home page is visible successfully
//		4. Click on 'Test Cases' button
//		5. Verify user is navigated to test cases page successfully
		homePageFlow.verifyCurrentlyOnHomePage();
		homePageFlow.navigateToTestCasePage();
		testCaseFlow.verifyCurrentlyOnTestCasePage();
	}
	

}
