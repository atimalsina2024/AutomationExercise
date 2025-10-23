package com.ui.test.helper;

import org.testng.Assert;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.ui.page.pages.AccountCreated;
import com.ui.page.pages.AccountInformation;
import com.ui.page.pages.SignupLogin;
import com.ui.test.models.CustomerInfo;

public class NewUserRegistrationFlow {
	private static final Logger logger = LogManager.getLogger(NewUserRegistrationFlow.class);
	private SignupLogin signupLogin;
	private AccountInformation accountInformation;
	private AccountCreated accountCreated;
	private WebDriver driver;
	public NewUserRegistrationFlow(WebDriver driver) {
		this.driver = driver;
		signupLogin = new SignupLogin(driver);
		//accountInformation = new AccountInformation(driver);
		//accountCreated = new AccountCreated(driver);
		logger.debug("NewUserRegistrationFlow constructed");
	}
	
	public void verifySignupInformationIsVisible() {
		boolean signUpDisplayed = signupLogin
				.getNewUserSignUpElement().isDisplayed();
		Assert.assertTrue(signUpDisplayed, "Verify 'New User Signup!' is visible failed");
		logger.debug("verifySignupInformationIsVisible");
	}
	
	public void signupNewUserPositive(CustomerInfo custo) {
		signupLogin
		.enterSignupEmail(custo.getEmail())
		.enterSignupName(custo.getFirstName()+" " + custo.getLastName())
		.clickSignupButton();
		logger.debug("signupNewUserPosive");
	}
	
	public void signupNewUserNegative(String email, String name) {
		signupLogin
		.enterSignupEmail(email)
		.enterSignupName(name)
		.clickSignupButton();
		logger.debug("signupNewUserNegative");
	}
	
	public void verifyNavigationToAccountInformationPage() {
		accountInformation = new AccountInformation(driver);
		boolean acctPageConfirmation = accountInformation
		.getPageTitleElement()
		.getText()
		.toUpperCase()
		.equals("ENTER ACCOUNT INFORMATION");
		
		Assert.assertTrue(acctPageConfirmation, "Navigating to new Account Information Page Failed");
		logger.debug("verifyNavigationToAccountInformationPage");
	}
	
	public void fillAccountDetailsAndCreateAccount(CustomerInfo custo) {
		accountInformation
		.fillInformation(custo)
		.clickCreateAccountButton();;
		logger.debug("fillAccountDetailsAndCreateAccount");
	}
	
	public void verifyAccountCreated() {
		accountCreated = new AccountCreated(driver);
		boolean rslt = accountCreated
				.getTitleElement()
				.getText()
				.toUpperCase()
				.equals("ACCOUNT CREATED!");
		
		Assert.assertTrue(rslt, "Account Creation Failed");
		logger.debug("verifyAccountCreated");
	}
	
	public void continueToHomePageFromAccountRegistrationPage() {
		accountCreated
		.clickContinueButton();
		logger.debug("continueToHomePageFromAccountRegistrationPage");
	}

	public void verifySignupFailure() {
		boolean result = signupLogin
				.getSignupEmailErrorMsgElement()
				.isDisplayed();
		Assert.assertTrue(result, "sign up email negative test fail");
		logger.debug("verifySignupFailure");
	}



}
