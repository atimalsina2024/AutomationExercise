package com.ui.page.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ui.page.base.PageBase;

import utils.WaitUtils;

public class DeleteUser extends PageBase{

	public DeleteUser(WebDriver driver) {
		super(driver);
	}
		
	@FindBy(css = "h2[data-qa='account-deleted'] b")
	WebElement deleteHeader;
	
	@FindBy(css = "a[data-qa='continue-button']")
	WebElement continueButton;

	public WebElement getDeletionMessage() {
		WaitUtils.waitForElementToBeVisible(driver, this.deleteHeader);
		return this.deleteHeader;
	}
	
	public String getTitleElementText() {
		WaitUtils.waitForElementToBeVisible(driver, this.deleteHeader);
		return this.deleteHeader.getText();
	}

	
	public void clickContinueButton() {
		this.continueButton.click();
	}
	
	
	
	
	
	

}
