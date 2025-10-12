package com.test.cases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.helper.HomePageFlow;
import com.test.helper.UserLoginFlow;

import utils.PropertyUtil;

public class TestCase004 extends TestBase{

	private static final Logger logger = LogManager.getLogger(TestCase004.class);
	private HomePageFlow homePageFlow;
	private UserLoginFlow userLoginFlow;
	
	@BeforeClass
	public void testSetup() {
		homePageFlow = new HomePageFlow(driver);
		userLoginFlow = new UserLoginFlow(driver);
		logger.debug("TestCaseFour @BeforeClass");
	}
	
	@Test(priority = 1, description = "logout test", groups = {"regression", "login", "functional"})
	public void Test_004_LogoutTest() {
//		1. Launch browser
//		2. Navigate to url 'http://automationexercise.com'
//		3. Verify that home page is visible successfully
//		4. Click on 'Signup / Login' button
//		5. Verify 'Login to your account' is visible
//		6. Enter correct email address and password
//		7. Click 'login' button
//		8. Verify that 'Logged in as username' is visible
//		9. Click 'Logout' button
//		10. Verify that user is navigated to login page
		homePageFlow.verifyCurrentlyOnHomePage();
		homePageFlow.navigateToSignupLoginPage();
		userLoginFlow.loginFromSignupLoginPage(PropertyUtil.get("email"), PropertyUtil.get("password"));
		homePageFlow.verifyUsernameVisibilityFromHomePage();
		homePageFlow.logOutFromHomePage();
		userLoginFlow.verifyLoginIsVisible();
	}

}
