package com.ui.test.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ui.page.pages.ContactUsPage;

public class ContactUsFlow {
	private static final Logger logger = LogManager.getLogger(ContactUsFlow.class);
	private ContactUsPage contactUsPage;

	public ContactUsFlow(WebDriver driver) {
		contactUsPage = new ContactUsPage(driver);
		logger.debug("ContactUsHelper constructed");
	}

	public void verifyGetInTouchIsVisible() {
		boolean getInTouchVisibility = contactUsPage.getGetInTouchElement().getText()
				.equals("GET IN TOUCH");
		Assert.assertTrue(getInTouchVisibility, "GET IN TOUCH Visibility Failed");
		logger.debug("verifyGetInTouchIsVisible");
	}

	public void fillOutFeedback(String name, String email, String message, String attachmentPath) {
		contactUsPage
				.fillForm(name, email, "subject", message, attachmentPath);		
	}

	public void submitFeedBack() {
		contactUsPage
		.clickSubmit()
		.clickOkButton();
		logger.debug("submitFeedBack");
	}
	
	public void verifyFeedbackSubmissionSuccess() {
		boolean feedbackSubmissionSuccess = contactUsPage.getSubmitSuccessMessageElement()
		.getText()
		.equals("Success! Your details have been submitted successfully.");
		Assert.assertTrue(feedbackSubmissionSuccess, "Feedback Submission Failed");
		logger.debug("verifyFeedbackSubmissionSuccess");
	}

	public void navigateToHomePage() {
		contactUsPage
		.clickHomeButton();
		logger.debug("navigateToHomePage");
	}
	
}
