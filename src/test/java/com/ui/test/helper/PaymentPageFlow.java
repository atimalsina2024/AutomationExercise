package com.ui.test.helper;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.automation.core.config.ConfigurationManager;
import com.ui.page.pages.OrderPlaced;
import com.ui.page.pages.PaymentPage;
import com.ui.test.models.CreditCard;

import utils.FileHandlerUtils;

public class PaymentPageFlow {
	private static final Logger logger = LogManager.getLogger(PaymentPageFlow.class);
	private PaymentPage paymentPage;
	private OrderPlaced orderPlaced;
	private ConfigurationManager config;
	
	public PaymentPageFlow(WebDriver driver) {
		paymentPage = new PaymentPage(driver);
		orderPlaced = new OrderPlaced(driver);
		config = ConfigurationManager.getInstance();
		logger.debug("PaymentPageFlow constructor");
	}

	public void makePaymentAndVerifyOrderSuccess(CreditCard creditCard) {
		boolean isOrderSuccessfullyPlaced = paymentPage
		.fillPaymentInfo(creditCard)
		.clickPaymentButton()
		.getSuccessMessage()
		.getText()
		.equals("Congratulations! Your order has been confirmed!");
		
		Assert.assertTrue(isOrderSuccessfullyPlaced, "Payment fail");
		logger.debug("makePaymentAndVerifyOrderSuccess");
	}
	
	public void proceedToHomePageFromSuccessfulOrderPlacement() {
		orderPlaced
		.clickContinueButton();
		logger.debug("proceedToHomePageFromSuccessfulOrderPlacement");
	}

	public void downloadInvoiceAndVerifyDownload() {
		orderPlaced
			.clickDownloadInvoiceButton();
			boolean isFileDownloaded;
			try {
				isFileDownloaded = FileHandlerUtils.validateFileInAFolder(System.getProperty("user.dir") + File.separator + config.getProperty("download.path"), "invoice");
			} catch (IOException e) {
				isFileDownloaded = false;
				logger.error("file not found");
				e.printStackTrace();
			}
			Assert.assertTrue(isFileDownloaded);
			logger.debug("downloadInvoiceAndVerifyDownload");
		}
}
