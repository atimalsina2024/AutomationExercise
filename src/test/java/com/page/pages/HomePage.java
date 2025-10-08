package com.page.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.page.base.PageBase;

import utils.JavascriptUtils;
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
	
	@FindBy(css = "a[href='/products']")
	WebElement productButton;
	
	@FindBy(css = "div.single-widget h2")
	private WebElement subscription;
	
	@FindBy(id = "susbscribe_email")
	private WebElement subscriptionEmail;
	
	@FindBy(id = "subscribe")
	private WebElement subscriptionButton;
	
	//@FindBy(className = "alert-success")
	private String subscriptionConfirmationMessageElementLocator = "alert-success";
	
	@FindBy(css = "a[href='/view_cart']")
	private WebElement cartButton;
	
	
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
		return this.loggedUserName;
	}
	
	public void clickSignupLoginButton() {
		this.logonSignupButton.click();
	}

	public String getLoggedUserNameText() {
		WaitUtils.waitForElementToBeVisible(driver, this.loggedUserName);
		return this.loggedUserName.getText();
	}
	public DeleteUser deleteUser() {
		this.deleteUser.click();
		return new DeleteUser(driver);
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
	
	public ProductPage clickProductButton() {
		this.productButton.click();
		return new ProductPage(driver);
	}
	
	public WebElement scrollToSubscription() {
		JavascriptUtils.javascriptScrollToView(driver, this.subscription);
		return this.subscription;
	}
	
	public HomePage enterSubscriptionEmailAddress(String email) {
		this.subscriptionEmail.sendKeys(email);
		return this;
	}
	
	public HomePage clickSubscribeButton() {
		this.subscriptionButton.click();;
		return this;
	}
	
	public WebElement getSubscriptionConfirmationMessage() {
		return WaitUtils.waitForToastElement(driver, By.className(subscriptionConfirmationMessageElementLocator));
		//return this.subscriptionConfirmationMessageElement;
	}
	
	public CartPage clickCartButton() {
		this.cartButton.click();
		return new CartPage(driver);
	}
	
	
		

}
