package com.test.helper;

import org.testng.Assert;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.page.pages.AccountCreated;
import com.page.pages.AccountInformation;
import com.page.pages.SignupLogin;
import com.test.models.CustomerInfo;

public class NewUserRegistrationFlow {
	private static final Logger logger = LogManager.getLogger(NewUserRegistrationFlow.class);
	private WebDriver driver;
	
	public NewUserRegistrationFlow(WebDriver driver) {
		this.driver = driver;
		logger.debug("NewUserRegistrationFlow constructed");
	}
	
	public void verifySignupInformationIsVisible() {
		boolean signUpDisplayed = new SignupLogin(driver)
				.getNewUserSignUpElement().isDisplayed();
		Assert.assertTrue(signUpDisplayed, "Verify 'New User Signup!' is visible failed");
		logger.debug("verifySignupInformationIsVisible");
	}
	
	public void signupNewUserPositive(CustomerInfo custo) {
		new SignupLogin(driver)
		.enterSignupEmail(custo.getEmail())
		.enterSignupName(custo.getFirstName()+" " + custo.getLastName())
		.clickSignupButton();
		logger.debug("signupNewUserPosive");
	}
	
	public void signupNewUserNegative(String email, String name) {
		new SignupLogin(driver)
		.enterSignupEmail(email)
		.enterSignupName(name)
		.clickSignupButton();
		logger.debug("signupNewUserNegative");
	}
	
	public void verifyNavigationToAccountInformationPage() {
		boolean acctPageConfirmation = new AccountInformation(driver)
		.getPageTitleElement()
		.getText()
		.toUpperCase()
		.equals("ENTER ACCOUNT INFORMATION");
		
		Assert.assertTrue(acctPageConfirmation, "Navigating to new Account Information Page Failed");
		logger.debug("verifyNavigationToAccountInformationPage");
	}
	
	public void fillAccountDetailsAndCreateAccount(CustomerInfo custo) {
		new AccountInformation(driver)
		.fillInformation(custo)
		.clickCreateAccountButton();;
		logger.debug("fillAccountDetailsAndCreateAccount");
	}
	
	public void verifyAccountCreated() {
		boolean rslt = new AccountCreated(driver)
				.getTitleElement()
				.getText()
				.toUpperCase()
				.equals("ACCOUNT CREATED!");
		
		Assert.assertTrue(rslt, "Account Creation Failed");
		logger.debug("verifyAccountCreated");
	}
	
	public void continueToHomePageFromAccountRegistrationPage() {
		new AccountCreated(driver)
		.clickContinueButton();
		logger.debug("continueToHomePageFromAccountRegistrationPage");
	}

	public void verifySignupFailure() {
		boolean result = new SignupLogin(driver)
				.getSignupEmailErrorMsgElement()
				.isDisplayed();
		Assert.assertTrue(result, "sign up email negative test fail");
		logger.debug("verifySignupFailure");
	}



}
