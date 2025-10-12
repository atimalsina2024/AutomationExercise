package com.test.cases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.test.base.TestBase;
import com.test.helper.ContactUsFlow;
import com.test.helper.HomePageFlow;


import utils.PropertyUtil;

public class TestCase006 extends TestBase{
	private static final Logger logger = LogManager.getLogger(TestCase006.class);
	private HomePageFlow homePageFlow;
	private ContactUsFlow contactUsFlow;
	
	@BeforeClass
	public void testSetup() {
		logger.debug("@BeforeClass TestCase006");
		homePageFlow = new HomePageFlow(driver);
		contactUsFlow = new ContactUsFlow(driver);
	}
	
	@Test(description = "submit contact us form positive scenario", groups = {"regression", "functional", "positive"})
	public void Test_006_Contact_Us_Form() {
//		1. Launch browser
//		2. Navigate to url 'http://automationexercise.com'
//		3. Verify that home page is visible successfully
//		4. Click on 'Contact Us' button
//		5. Verify 'GET IN TOUCH' is visible
//		6. Enter name, email, subject and message
//		7. Upload file
//		8. Click 'Submit' button
//		9. Click OK button
//		10. Verify success message 'Success! Your details have been submitted successfully.' is visible
//		11. Click 'Home' button and verify that landed to home page successfully
		
		homePageFlow.verifyCurrentlyOnHomePage();
		homePageFlow.navigateToContactUsPage();
		contactUsFlow.verifyGetInTouchIsVisible();
		contactUsFlow.fillOutFeedback(PropertyUtil.get("name"),PropertyUtil.get("email"), PropertyUtil.get("feedback.message"),PropertyUtil.get("account.registration.data") );
		contactUsFlow.submitFeedBack();
		contactUsFlow.verifyFeedbackSubmissionSuccess();
		contactUsFlow.navigateToHomePage();
		contactUsFlow.navigateToHomePage();
		homePageFlow.verifyCurrentlyOnHomePage();
	}
	
}
