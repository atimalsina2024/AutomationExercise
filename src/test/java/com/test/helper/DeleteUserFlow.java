package com.test.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.page.pages.DeleteUser;

public class DeleteUserFlow {
	
	private static final Logger logger = LogManager.getLogger(DeleteUserFlow.class);
	private WebDriver driver;
	
	
	public DeleteUserFlow(WebDriver driver) {
		this.driver = driver;
		logger.debug("DeleteUserFlow constructed");
	}
	
	public void verifyDeletionConfirmation() {
		boolean isAccountDeleted = new DeleteUser(driver)
		.getDeletionMessage()
		.getText()
		.equals("ACCOUNT DELETED!");
		
		Assert.assertTrue(isAccountDeleted, "User deletion failed");
		logger.debug("verifyDeletionConfirmation");
		
	}
	
	public void continueToHomePageAfterUserDeletionConfirmation() {
		new DeleteUser(driver)
		.clickContinueButton();
		logger.debug("continueToHomePageAfterUserDeletionConfirmation");
	}
}
