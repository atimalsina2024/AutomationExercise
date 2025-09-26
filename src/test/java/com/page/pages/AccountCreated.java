package com.page.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.page.base.PageBase;

public class AccountCreated extends PageBase{

	public AccountCreated(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//b[text()='Account Created!']")
	WebElement pageHeader;
	
	@FindBy(css = "a[data-qa='continue-button']")
	WebElement continueButton;

	public WebElement getTitleElement() {
		return this.pageHeader;
	}

	public void waitForElementToBeVisible(WebElement titleElement) {
		waitUtil.waitForElementToBeVisible(titleElement);
	}

	public String getTitleText() {
		return this.pageHeader.getText();
	}

	public void clickContinueButton() {
		this.continueButton.click();
	}
	

}
