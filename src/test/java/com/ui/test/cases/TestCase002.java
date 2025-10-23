package com.ui.test.cases;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.automation.core.base.TestBase;
import com.ui.test.helper.HomePageFlow;
import com.ui.test.helper.UserLoginFlow;


public class TestCase002 extends TestBase{

	private static final Logger logger = LogManager.getLogger(TestCase002.class);
	private HomePageFlow homePageFlow;
	private UserLoginFlow loginUserFlow;
	
	@BeforeClass
	public void testSetup() {
		logger.debug("@BeforeClass initializing homePageFlow and loginUserFlow");
		homePageFlow = new HomePageFlow(driver);
		loginUserFlow = new UserLoginFlow(driver);
	}
	
	
	@Test(priority = 1, description = "user login positive", groups = {"regression", "functional", "login"})
	public void Test_002_Login_Positive() {
		homePageFlow.verifyCurrentlyOnHomePage();
		homePageFlow.navigateToSignupLoginPage();
		loginUserFlow.verifyLoginIsVisible();
		loginUserFlow.login(config.getProperty("email"), config.getProperty("password"));
		homePageFlow.verifyUsernameVisibilityFromHomePage();
	}
	
}
