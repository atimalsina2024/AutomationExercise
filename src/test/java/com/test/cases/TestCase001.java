package com.test.cases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.base.TestBase;
import com.test.helper.DeleteUserFlow;
import com.test.helper.HomePageFlow;
import com.test.helper.NewUserRegistrationFlow;
import com.test.models.CustomerInfo;

import utils.JsonUtil;
import utils.PropertyUtil;

public class TestCase001 extends TestBase{
	private static final Logger logger = LogManager.getLogger(TestCase001.class);
	private HomePageFlow homePageFlow;
	private NewUserRegistrationFlow accountRegistrationFlow;
	private DeleteUserFlow deleteUserFlow;
	private CustomerInfo custo;
	
	@BeforeClass
	public void testSetup() {
		logger.debug("@BeforeClass initializing homePageFlow accountRegistrationFlow deleteUserFlow and custo");
		homePageFlow = new HomePageFlow(driver);
		accountRegistrationFlow = new NewUserRegistrationFlow(driver);
		deleteUserFlow = new DeleteUserFlow(driver);
		custo = JsonUtil.parseAcctInfoJson(PropertyUtil.get("account.registration.data"));
	}
	
	@Test(priority = 1, description = "new user registration", groups = {"regression", "functional", "registration", "positive"})
	public void Test_001_RegisterNewUser() {
//		✅ Test Case 1: Register User
//		1. Launch browser
//		2. Navigate to url 'http://automationexercise.com'
//		3. Verify that home page is visible successfully
//		4. Click on 'Signup / Login' button
//		5. Verify 'New User Signup!' is visible
//		6. Enter name and email address
//		7. Click 'Signup' button
//		8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
//		9. Fill details: Title, Name, Email, Password, Date of birth
//		10. Select checkbox 'Sign up for our newsletter!'
//		11. Select checkbox 'Receive special offers from our partners!'
//		12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
//		13. Click 'Create Account button'
//		14. Verify that 'ACCOUNT CREATED!' is visible
//		15. Click 'Continue' button
//		16. Verify that 'Logged in as username' is visible
//		17. Click 'Delete Account' button
//		18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
		
		homePageFlow.verifyCurrentlyOnHomePage();
		homePageFlow.navigateToSignupLoginPage();
		accountRegistrationFlow.verifySignupInformationIsVisible();
		accountRegistrationFlow.signupNewUserPositive(custo);
		accountRegistrationFlow.verifyNavigationToAccountInformationPage();
		accountRegistrationFlow.fillAccountDetailsAndCreateAccount(custo);
		accountRegistrationFlow.verifyAccountCreated();
		accountRegistrationFlow.continueToHomePageFromAccountRegistrationPage();
		homePageFlow.verifyUsernameVisibilityFromHomePage();
		homePageFlow.deleteUserFrom();
		deleteUserFlow.verifyDeletionConfirmation();
		deleteUserFlow.continueToHomePageAfterUserDeletionConfirmation();
		
	}
}
