package com.page.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.page.base.PageBase;

import utils.WaitUtils;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "div.contact-form h2")
	WebElement getInTouch;
	
	@FindBy(css = "input[data-qa='name']")
	WebElement name;
	
	@FindBy(css = "input[data-qa='email']")
	WebElement email;
	
	@FindBy(css = "input[data-qa='subject']")
	WebElement subject;
	
	@FindBy(css = "input[data-qa='message']")
	WebElement message;
	
	@FindBy(name = "upload_file")
	WebElement browse;
	
	@FindBy(css = "input[data-qa='submit-button']")
	WebElement submitButton;
	
	@FindBy(css = "div.status")
	WebElement submitSuccessMessage;
	
	@FindBy(css = "a.btn-success")
	WebElement homeButton;
	
	public WebElement getGetInTouchElement() {
		WaitUtils.waitForElementToBeVisible(driver, this.getInTouch);
		return this.getInTouch;
	}
	
	public ContactUsPage fillForm(String name, String email, String subject, String message, String path) {
		this.name.sendKeys(name);
		this.email.sendKeys(email);
		this.subject.sendKeys(subject);
		this.browse.sendKeys(path);
		return this;		
	}
	
	public ContactUsPage clickSubmit() {
		this.submitButton.click();
		return this;
	}
	
	public ContactUsPage clickOkButton() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return this;
	}
	
	public WebElement getSubmitSuccessMessageElement() {
		return this.submitSuccessMessage;
	}
	
	public HomePage clickHomeButton() {
		this.homeButton.click();
		return new HomePage(driver);
	}

}
