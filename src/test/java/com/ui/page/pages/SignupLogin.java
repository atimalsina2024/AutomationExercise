package com.ui.page.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ui.page.base.PageBase;

import utils.WaitUtils;

public class SignupLogin extends PageBase{
	private static final Logger logger = LogManager.getLogger(SignupLogin.class);
	
	public SignupLogin(WebDriver driver) {
		super(driver);
		logger.debug("SignupLogin constructed");
	}
	
	@FindBy(xpath = "//h2[text()='New User Signup!']")
	WebElement newUserSignUpElement;

	@FindBy(css = "input[data-qa='signup-name']")
	WebElement signupName;
	
	@FindBy(css = "input[data-qa='signup-email']")
	WebElement signupEmail;
	
	@FindBy(css = "button[data-qa='signup-button']")
	WebElement signupButton;
	
	@FindBy(xpath = "//p[text()='Email Address already exist!']")
	WebElement duplicateSignupEmailErrorElement;
	
	@FindBy(xpath = "//h2[text()='Login to your account']")
	WebElement loginHeaderElement;
	
	@FindBy(css = "input[data-qa='login-email']")
	WebElement loginEmail;
	
	@FindBy(css = "input[data-qa='login-password']")
	WebElement loginPassword;
	
	@FindBy(css = "button[data-qa='login-button']")
	WebElement loginButton;
	
	@FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
	WebElement incorrectLoginEmailOrPasswordErrorMessage;
	
	public WebElement getNewUserSignUpElement() {
		return newUserSignUpElement;
	}

	public SignupLogin enterSignupName(String name) {
		this.signupName.sendKeys(name);
		return this;
	}

	public void clickSignupButton() {
		this.signupButton.click();	
	}

	public SignupLogin enterSignupEmail(String email) {
		this.signupEmail.sendKeys(email);
		return this;
	}

	public WebElement getLoginElement() {
		WaitUtils.waitForElementToBeVisible(driver, this.loginHeaderElement);
		return this.loginHeaderElement;
	}

	public String getLoginElementText() {
		return this.loginHeaderElement.getText();
	}

	public SignupLogin setLoginEmail(String email) {
		this.loginEmail.sendKeys(email);
		return this;
	}

	public SignupLogin setLoginPassword(String password) {
		this.loginPassword.sendKeys(password);
		return this;
	}

	public void clickLoginButton() {
		this.loginButton.click();
	}
	
	public WebElement getLoginFailErrorElement() {
		WaitUtils.waitForElementToBeVisible(driver, this.incorrectLoginEmailOrPasswordErrorMessage);
		return this.incorrectLoginEmailOrPasswordErrorMessage;
	}
	
	public WebElement getSignupEmailErrorMsgElement() {
		WaitUtils.waitForElementToBeVisible(driver, duplicateSignupEmailErrorElement);
		return duplicateSignupEmailErrorElement;
	}
	
	

}
