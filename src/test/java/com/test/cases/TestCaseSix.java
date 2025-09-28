package com.test.cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.page.pages.ContactUsPage;
import com.page.pages.HomePage;
import com.test.base.TestBase;

public class TestCaseSix extends TestBase{

	@Test(description = "submit contact us form positive scenario")
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
		
		TestCaseOne.verifyHomePageIsVisibleSuccessfully();
		verifyGetInTouchIsVisible();
		fillContactUsFormAndVerifySuccess();
		clickHomeButton();
		TestCaseOne.verifyHomePageIsVisibleSuccessfully();
	}
	
	public void verifyGetInTouchIsVisible() {
		String titleText = new HomePage(driver)
			.clickContactUsButton()
			.getGetInTouchElement()
			.getText();
		Assert.assertEquals(titleText, "GET IN TOUCH", "contact us page title validation");
	}
	
	public void fillContactUsFormAndVerifySuccess(){
		String submitMsg = new ContactUsPage(driver)
		.fillForm("name", "a@test.com", "subject", "test message", "/Users/work/eclipse-workspace/AutomationExercise/README.md")
		.clickSubmit()
		.clickOkButton()
		.getSubmitSuccessMessageElement()
		.getText();		
		Assert.assertEquals(submitMsg, "Success! Your details have been submitted successfully.");
	}
	
	public void clickHomeButton() {
		new ContactUsPage(driver)
		.clickHomeButton();	
	}
}
