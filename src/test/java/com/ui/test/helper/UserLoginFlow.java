package com.ui.test.helper;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ui.page.pages.SignupLogin;

public class UserLoginFlow {

	private WebDriver driver;
	private static final Logger logger = LogManager.getLogger(UserLoginFlow.class);

	public UserLoginFlow(WebDriver driver) {
		this.driver = driver;
		logger.debug("LoginUserFlow initialized");
	}
	
	public void verifyLoginIsVisible() {
		boolean loginButtonVisible = new SignupLogin(driver)
				.getLoginElement()
				.isDisplayed();
		
		Assert.assertTrue(loginButtonVisible,"Login Visible Failed");
	}
	
	public void login(String email, String password) {
		new SignupLogin(driver)
		.setLoginEmail(email)
		.setLoginPassword(password)
		.clickLoginButton();
		logger.debug("loginFromSignupLoginPage");
	}
	
	public void verifyLoginFailure() {
		boolean loginFailure = new SignupLogin(driver)
				.getLoginFailErrorElement()
				.isDisplayed();
		Assert.assertTrue(loginFailure);
	}
}
