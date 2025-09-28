package com.page.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.page.base.PageBase;

import utils.WaitUtils;

public class SignupLogin extends PageBase{

	public SignupLogin(WebDriver driver) {
		super(driver);
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

	public void enterSignupName(String name) {
		this.signupName.sendKeys(name);		
	}

	public void clickSignupButton() {
		this.signupButton.click();		
	}

	public void enterSignupEmail(String email) {
		this.signupEmail.sendKeys(email);		
	}

	public WebElement getLoginElement() {
		WaitUtils.waitForElementToBeVisible(driver, this.loginHeaderElement);
		return this.loginHeaderElement;
	}

	public String getLoginElementText() {
		return this.loginHeaderElement.getText();
	}

	public void setLoginEmail(String email) {
		this.loginEmail.sendKeys(email);
	}

	public void setLoginPassword(String password) {
		this.loginPassword.sendKeys(password);
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
