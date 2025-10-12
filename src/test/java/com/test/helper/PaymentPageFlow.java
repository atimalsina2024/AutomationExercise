package com.test.helper;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.page.pages.OrderPlaced;
import com.page.pages.PaymentPage;
import com.test.models.CreditCard;

import utils.FileHandlerUtils;
import utils.PropertyUtil;

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
		logger.debug("makePaymentAndVerifyOrderSuccess");
	}
	
	public void proceedToHomePageFromSuccessfulOrderPlacement() {
		new OrderPlaced(driver)
		.clickContinueButton();
		logger.debug("proceedToHomePageFromSuccessfulOrderPlacement");
	}

	public void downloadInvoiceAndVerifyDownload() {
			new OrderPlaced(driver)
			.clickDownloadInvoiceButton();
			boolean isFileDownloaded;
			try {
				isFileDownloaded = FileHandlerUtils.validateFileInAFolder(System.getProperty("user.dir") + File.separator + PropertyUtil.get("download.path"), "invoice");
			} catch (IOException e) {
				isFileDownloaded = false;
				logger.error("file not found");
				e.printStackTrace();
			}
			Assert.assertTrue(isFileDownloaded);
			logger.debug("downloadInvoiceAndVerifyDownload");
		}
}
