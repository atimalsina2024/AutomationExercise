package com.ui.page.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ui.page.base.PageBase;

import utils.WaitUtils;

public class AccountCreated extends PageBase{

	private static final Logger logger = LogManager.getLogger(AccountCreated.class);
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
		try {
			this.continueButton.click();
		}
		catch(ElementNotInteractableException e) {
			logger.error("ElementNotInteractableException on continue");
		}
		//this.continueButton.click();
		return new HomePage(driver);
	}
	

}
