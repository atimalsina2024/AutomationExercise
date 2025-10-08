package com.page.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.page.base.PageBase;

public class OrderPlaced extends PageBase{

	@FindBy(css = "a[data-qa='continue-button']")
	private WebElement continueButton;
	
	public OrderPlaced(WebDriver driver) {
		super(driver);
	}
	
	public HomePage clickContinueButton() {
		this.continueButton.click();
		return new HomePage(driver);
	}

}
