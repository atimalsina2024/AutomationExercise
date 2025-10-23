package com.ui.page.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ui.page.base.PageBase;
import com.ui.test.models.CreditCard;
import com.ui.test.models.ExpirationDate;

import utils.WaitUtils;


public class PaymentPage extends PageBase{

	@FindBy(name = "name_on_card")
	private WebElement nameOnCard;
	
	@FindBy(name = "card_number")
	private WebElement cardNumber;
	
	@FindBy(name = "cvc")
	private WebElement cvc;
	
	@FindBy(name = "expiry_month")
	private WebElement expirationMonth;
	
	@FindBy(name = "expiry_year")
	private WebElement expirationYear;
	
	@FindBy(id = "submit")
	private WebElement payAndConfirmButton;
	
	@FindBy(xpath = "//p[contains(text(),'Congratulations!')]")
	private WebElement successMessage;
	
	public PaymentPage(WebDriver driver) {
		super(driver);
	}
	
	public void setName(String name) {
		this.nameOnCard.sendKeys(name);
	}
	
	public void setCardNumber(String cardNum) {
		this.cardNumber.sendKeys(cardNum);
	}
	
	public void setCvc(String cv) {
		this.cvc.sendKeys(cv);
	}
	
	public void setExpiryMonth(String expiryMonth) {
		this.expirationMonth.sendKeys(expiryMonth);
	}
	
	public void setExpiryYear(String expYear) {
		this.expirationYear.sendKeys(expYear);
	}
	
	public void setExpiryDateUtility(ExpirationDate date) {
		setExpiryYear(date.getYear());
		setExpiryMonth(date.getMonth());
	}
	
	public PaymentPage clickPaymentButton() {
		WaitUtils.waitForElementToBeClickable(driver, this.payAndConfirmButton);
		this.payAndConfirmButton.click();
		return this;
	}
	
	public PaymentPage fillPaymentInfo(CreditCard card) {
		setName(card.getNameOnCard());
		setCardNumber(card.getNumber());
		setCvc(card.getCvc());
		setExpiryDateUtility(card.getDate());
		return this;
	}
	
	public WebElement getSuccessMessage() {
		return this.successMessage;
	}
	

}
