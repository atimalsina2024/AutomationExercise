package com.page.pages;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.page.base.PageBase;

import utils.WaitUtils;

public class DialogBoxPage extends PageBase{

	@FindBy(css = "div.modal-body a")
	private WebElement viewCart;
	
	@FindBy(css = "div.modal-footer button")
	private WebElement continueShopping;
	
	@FindBy(linkText = "Register / Login")
	private WebElement loginSignup;
	
	public DialogBoxPage(WebDriver driver) {
		super(driver);
	}
	
	public CartPage clickViewCart() {
		try {
			this.viewCart.click();
		}catch(ElementNotInteractableException e) {
			e.printStackTrace();
			WaitUtils.waitForElementToBeClickable(driver, viewCart);
			this.viewCart.click();
		}
		
		return new CartPage(driver);
	}
	
	public ProductPage clickContinueShopping() {
		try {
			this.continueShopping.click();
		}catch(ElementNotInteractableException e) {
			e.printStackTrace();
			WaitUtils.waitForElementToBeClickable(driver, continueShopping);
			this.continueShopping.click();
		}
		
		return new ProductPage(driver);
	}
	
	public SignupLogin clickLoginRegisterButton() {
		WaitUtils.waitForElementToBeVisible(driver, loginSignup);
		this.loginSignup.click();
		return new SignupLogin(driver);
	}

}
