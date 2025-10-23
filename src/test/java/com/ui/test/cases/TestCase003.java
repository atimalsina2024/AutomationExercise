package com.ui.test.cases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.core.base.TestBase;
import com.ui.test.helper.HomePageFlow;
import com.ui.test.helper.UserLoginFlow;

public class TestCase003 extends TestBase{
	private static final Logger logger = LogManager.getLogger(TestCase003.class);
	
	private HomePageFlow homePageFlow;
	private UserLoginFlow userLoginFlow;
	@BeforeClass
	public void testSetup() {
		logger.debug("TestCaseThree setup");
		homePageFlow = new HomePageFlow(driver);
		userLoginFlow = new UserLoginFlow(driver);
	}
	
	@Test(priority = 1, description = "user login negative", groups = {"regression", "functional", "login", "negative"})
	public void Test_003() {
//		1. Launch browser
//		2. Navigate to url 'http://automationexercise.com'
//		3. Verify that home page is visible successfully
//		4. Click on 'Signup / Login' button
//		5. Verify 'Login to your account' is visible
//		6. Enter incorrect email address and password
//		7. Click 'login' button
//		8. Verify error 'Your email or password is incorrect!' is visible
		homePageFlow.verifyCurrentlyOnHomePage();
		homePageFlow.navigateToSignupLoginPage();
		userLoginFlow.login("login@test.com", "test2");
		userLoginFlow.verifyLoginFailure();
		
	}

}
