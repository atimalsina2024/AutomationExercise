package com.ui.page.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ui.page.base.PageBase;

public class OrderPlaced extends PageBase{

	@FindBy(css = "a[data-qa='continue-button']")
	private WebElement continueButton;
	
	@FindBy(css = "a.check_out")
	private WebElement downloadInvoice;
	
	public OrderPlaced(WebDriver driver) {
		super(driver);
	}
	
	public HomePage clickContinueButton() {
		this.continueButton.click();
		return new HomePage(driver);
	}
	
	public OrderPlaced clickDownloadInvoiceButton() {
		this.downloadInvoice.click();
		return this;
	}

}
