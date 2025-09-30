package com.page.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.page.base.PageBase;

import utils.JavascriptUtils;
import utils.WaitUtils;

public class CartPage extends PageBase{

	@FindBy(css = "div.single-widget h2")
	private WebElement subscription;
	
	@FindBy(id = "susbscribe_email")
	private WebElement subscriptionEmail;
	
	@FindBy(id = "subscribe")
	private WebElement subscriptionButton;
	
	private String subscriptionConfirmationMessageLocator = "alert-success";
	
	@FindBy()
	private WebElement singleDescription;
	
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement scrollToSubscribe() {
		JavascriptUtils.javascriptScrollToView(driver, this.subscription);
		return this.subscription;
	}
	
	public CartPage enterSubscrptionEmail(String email) {
		this.subscriptionEmail.sendKeys(email);
		return this;
	}
	
	public CartPage clickSubscrbeButton() {
		this.subscriptionButton.click();
		return this;
	}
	
	public WebElement getSubscriptionConfirmationMessage() {
		return WaitUtils.waitForToastElement(driver, By.className(subscriptionConfirmationMessageLocator));
	}
	
	

}
