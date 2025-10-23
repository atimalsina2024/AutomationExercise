package com.ui.test.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.ui.page.pages.DialogBoxPage;

public class DialogBoxFlow {
	
	private static final Logger logger = LogManager.getLogger(DialogBoxFlow.class);
	DialogBoxPage dialogBox;
	
	public DialogBoxFlow(WebDriver driver) {
		dialogBox = new DialogBoxPage(driver);
		logger.debug("DialogPageFlow constructor");
	}
	
	public void continueShopping() {
		dialogBox
		.clickContinueShopping();
		logger.debug("continueShopping");
	}
		
	public void gotoCart() {
		dialogBox
		.clickViewCart();
		logger.debug("gotoCart");
	}

	public void proceedToLoginRegister() {
		dialogBox
		.clickLoginRegisterButton();
		logger.debug("proceedToLoginRegister");
	}
	

}
