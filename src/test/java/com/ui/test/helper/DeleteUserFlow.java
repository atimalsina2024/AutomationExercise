package com.ui.test.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ui.page.pages.DeleteUser;

public class DeleteUserFlow {
	
	private static final Logger logger = LogManager.getLogger(DeleteUserFlow.class);
	private DeleteUser deleteUser;
	
	public DeleteUserFlow(WebDriver driver) {
		deleteUser = new DeleteUser(driver);
		logger.debug("DeleteUserFlow constructed");
	}
	
	public void verifyDeletionConfirmation() {
		boolean isAccountDeleted = deleteUser
		.getDeletionMessage()
		.getText()
		.equals("ACCOUNT DELETED!");
		
		Assert.assertTrue(isAccountDeleted, "User deletion failed");
		logger.debug("verifyDeletionConfirmation");
		
	}
	
	public void continueToHomePageAfterUserDeletionConfirmation() {
		deleteUser
		.clickContinueButton();
		logger.debug("continueToHomePageAfterUserDeletionConfirmation");
	}
}
