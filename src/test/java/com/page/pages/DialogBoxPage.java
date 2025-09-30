package com.page.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.page.base.PageBase;

public class DialogBoxPage extends PageBase{

	@FindBy(css = "div.modal-body a")
	private WebElement viewCart;
	
	@FindBy(css = "div.modal-footer button")
	private WebElement continueShopping;
	
	public DialogBoxPage(WebDriver driver) {
		super(driver);
	}
	
	public CartPage clickViewCart() {
		this.viewCart.click();
		return new CartPage(driver);
	}

}
