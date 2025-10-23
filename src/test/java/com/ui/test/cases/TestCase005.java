package com.ui.test.cases;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.automation.core.base.TestBase;
import com.ui.test.helper.HomePageFlow;
import com.ui.test.helper.NewUserRegistrationFlow;


public class TestCase005 extends TestBase{
	
	private static final Logger logger = LogManager.getLogger(TestCase005.class);
	private HomePageFlow homePageFlow;
	private NewUserRegistrationFlow newUserRegistrationFlow;
	
	@BeforeClass
	public void testSetup() {
		homePageFlow = new HomePageFlow(driver);
		newUserRegistrationFlow = new NewUserRegistrationFlow(driver);
		logger.debug("TestCase005 @BeforeClass");
	}

	@Test(description = "registration negative", groups = {"regression", "functional", "registration", "negative"})
	public void TC_005_Register_Negative() {
//		1. Launch browser
//		2. Navigate to url 'http://automationexercise.com'
//		3. Verify that home page is visible successfully
//		4. Click on 'Signup / Login' button
//		5. Verify 'New User Signup!' is visible
//		6. Enter name and already registered email address
//		7. Click 'Signup' button
//		8. Verify error 'Email Address already exist!' is visible
		homePageFlow.verifyCurrentlyOnHomePage();
		homePageFlow.navigateToSignupLoginPage();
		newUserRegistrationFlow.verifySignupInformationIsVisible();
		newUserRegistrationFlow.signupNewUserNegative(config.getProperty("email"),config.getProperty("name"));
		newUserRegistrationFlow.verifySignupFailure();
	}
}
