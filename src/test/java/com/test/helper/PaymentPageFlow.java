package com.test.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.page.pages.OrderPlaced;
import com.page.pages.PaymentPage;
import com.test.models.CreditCard;

public class PaymentPageFlow {
	private static final Logger logger = LogManager.getLogger(PaymentPageFlow.class);
	private WebDriver driver;
	
	public PaymentPageFlow(WebDriver driver) {
		this.driver = driver;
		logger.debug("PaymentPageFlow constructor");
	}

	public void makePaymentAndVerifyOrderSuccess(CreditCard creditCard) {
		boolean isOrderSuccessfullyPlaced = new PaymentPage(driver)
		.fillPaymentInfo(creditCard)
		.clickPaymentButton()
		.getSuccessMessage()
		.getText()
		.equals("Congratulations! Your order has been confirmed!");
		
		Assert.assertTrue(isOrderSuccessfullyPlaced, "Payment fail");
	}
	
	public void proceedToHomePageFromSuccessfulOrderPlacement() {
		new OrderPlaced(driver)
		.clickContinueButton();
	}
	
}
