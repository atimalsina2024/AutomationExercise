package com.test.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.page.pages.DeleteUser;
import com.page.pages.HomePage;

public class DeleteUserFlow {
	
	private static final Logger logger = LogManager.getLogger(DeleteUserFlow.class);
	private WebDriver driver;
	
	
	public DeleteUserFlow(WebDriver driver) {
		this.driver = driver;
		logger.debug("DeleteUserFlow constructed");
	}
	
	public void deleteUserFromHomePageAndVerifyDeletion() {
		logger.debug("deleteUserFromHomePageAndVerifyDeletion");
		boolean deletionConfirmation = new HomePage(driver)
		.deleteUser()
		.getDeletionMessage()
		.getText()
		.equals("ACCOUNT DELETED!");
		
		Assert.assertTrue(deletionConfirmation, "User deletion failed");
		
	}
	
	public void continueToHomePageAfterUserDeletionConfirmation() {
		logger.debug("continueToHomePageAfterUserDeletionConfirmation");
		new DeleteUser(driver)
		.clickContinueButton();
	}
}
