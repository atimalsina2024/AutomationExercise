package com.test.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.page.pages.ContactUsPage;

public class ContactUsFlow {
	private static final Logger logger = LogManager.getLogger(ContactUsFlow.class);
	private WebDriver driver;

	public ContactUsFlow(WebDriver driver) {
		this.driver = driver;
		logger.debug("ContactUsHelper constructed");
	}

	public void verifyGetInTouchIsVisible() {
		boolean getInTouchVisibility = new ContactUsPage(driver).getGetInTouchElement().getText()
				.equals("GET IN TOUCH");
		Assert.assertTrue(getInTouchVisibility, "GET IN TOUCH Visibility Failed");
		logger.debug("verifyGetInTouchIsVisible");
	}

	public void fillOutFeedback(String name, String email, String message, String attachmentPath) {
		new ContactUsPage(driver)
				.fillForm(name, email, "subject", message, attachmentPath);		
	}

	public void submitFeedBack() {
		new ContactUsPage(driver)
		.clickSubmit()
		.clickOkButton();
		logger.debug("submitFeedBack");
	}
	
	public void verifyFeedbackSubmissionSuccess() {
		boolean feedbackSubmissionSuccess = new ContactUsPage(driver).getSubmitSuccessMessageElement()
		.getText()
		.equals("Success! Your details have been submitted successfully.");
		Assert.assertTrue(feedbackSubmissionSuccess, "Feedback Submission Failed");
		logger.debug("verifyFeedbackSubmissionSuccess");
	}

	public void navigateToHomePage() {
		new ContactUsPage(driver)
		.clickHomeButton();
		logger.debug("navigateToHomePage");
	}
	
}
