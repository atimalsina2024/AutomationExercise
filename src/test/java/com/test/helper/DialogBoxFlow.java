package com.test.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.page.pages.DialogBoxPage;

public class DialogBoxFlow {
	
	private static final Logger logger = LogManager.getLogger(DialogBoxFlow.class);
	private WebDriver driver;
	
	public DialogBoxFlow(WebDriver driver) {
		this.driver = driver;
		logger.debug("DialogPageFlow constructor");
	}
	
	public void continueShopping() {
		new DialogBoxPage(driver)
		.clickContinueShopping();
		logger.debug("continueShopping");
	}
	
	
	public void gotoCart() {
		new DialogBoxPage(driver)
		.clickViewCart();
		logger.debug("gotoCart");
	}

	public void proceedToLoginRegister() {
		new DialogBoxPage(driver)
		.clickLoginRegisterButton();
		logger.debug("proceedToLoginRegister");
	}
	

}
