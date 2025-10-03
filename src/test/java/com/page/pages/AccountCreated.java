package com.page.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.page.base.PageBase;

import utils.WaitUtils;

public class AccountCreated extends PageBase{

	public AccountCreated(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//b[text()='Account Created!']")
	WebElement pageHeader;
	
	@FindBy(css = "a[data-qa='continue-button']")
	WebElement continueButton;

	public WebElement getTitleElement() {
		WaitUtils.waitForElementToBeVisible(driver, this.pageHeader);
		return this.pageHeader;
	}

	public String getTitleText() {
		WaitUtils.waitForElementToBeVisible(driver, this.pageHeader);
		return this.pageHeader.getText();
	}

	public HomePage clickContinueButton() {
		this.continueButton.click();
		return new HomePage(driver);
	}
	

}
