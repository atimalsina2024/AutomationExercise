package com.page.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.page.base.PageBase;

import utils.WaitUtils;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "ul.nav a[href='/']")
	WebElement homeButton;
	
	@FindBy(css = "a[href='/login']")
	WebElement logonSignupButton;
	
	@FindBy(css = "ul.navbar-nav b")
	WebElement loggedUserName;
	
	@FindBy(css = "a[href='/delete_account']")
	WebElement deleteUser;
	
	@FindBy(css = "a[href='/logout']")
	WebElement logoutButton;
	
	@FindBy(css = "a[href='/contact_us']")
	WebElement contactUsButton;
	
	@FindBy(css = "a[href='/test_cases']")
	WebElement testCaseButton;
	
	public WebElement getHomeElement() {
		return this.homeButton;
	}
	public boolean isElementSelected(WebElement homeBtn) {
		if(homeBtn.getAttribute("style").equals("color: orange;")) {
			return true;
		}
		return false;
	}
	
	public WebElement getLoggedUserNameElement() {
		WaitUtils.waitForElementToBeVisible(driver, this.loggedUserName);
		//waitForElementToBeVisible(this.loggedUserName);
		return this.loggedUserName;
	}
	
	public void clickSignupLoginButton() {
		this.logonSignupButton.click();
	}
	/*
	public static void waitForElementToBeVisible(WebElement element) {
		waitUtil.waitForElementToBeVisible(element);
	}
	*/
	public String getLoggedUserNameText() {
		WaitUtils.waitForElementToBeVisible(driver, this.loggedUserName);
		//waitForElementToBeVisible(this.loggedUserName);
		return this.loggedUserName.getText();
	}
	public void deleteUser() {
		this.deleteUser.click();
	}
	public void userLogout() {
		this.logoutButton.click();
	}
	
	public ContactUsPage clickContactUsButton() {
		this.contactUsButton.click();
		return new ContactUsPage(driver);
	}
	
	public TestCasesPage clickTestCaseButton() {
		this.testCaseButton.click();
		return new TestCasesPage(driver);
	}
		

}
