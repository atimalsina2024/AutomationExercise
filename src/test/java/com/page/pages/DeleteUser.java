package com.page.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.page.base.PageBase;

public class DeleteUser extends PageBase{

	public DeleteUser(WebDriver driver) {
		super(driver);
	}
		
	@FindBy(css = "h2[data-qa='account-deleted'] b")
	WebElement deleteHeader;
	
	@FindBy(css = "a[data-qa='continue-button']")
	WebElement continueButton;

	public WebElement getTitleElement() {
		return this.deleteHeader;
	}

	public void waitForElementToBeVisible(WebElement titleElement) {
		waitUtil.waitForElementToBeVisible(titleElement);
	}

	public String getTitleElementText() {
		return this.deleteHeader.getText();
	}
	
	
	
	
	
	

}
