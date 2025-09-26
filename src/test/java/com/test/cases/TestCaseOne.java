package com.test.cases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.page.pages.AccountCreated;
import com.page.pages.AccountInformation;
import com.page.pages.DeleteUser;
import com.page.pages.HomePage;
import com.page.pages.SignupLogin;
import com.test.base.TestBase;

public class TestCaseOne extends TestBase{
	
	@BeforeTest
	public void testSetup() {
		setup();
		driver.get("http://automationexercise.com");
		
	}
	
	@AfterTest
	public void testTeardown() {
		teardown();
	}
	@Test
	public void Test_001_Register_User() {
//		1. Launch browser -- done in test base
//		2. Navigate to url 'http://automationexercise.com' -- done in testSetup() method
//		3. Verify that home page is visible successfully
		HomePage hp = new HomePage(driver);
		WebElement homeBtn = hp.getHomeElement();
		boolean homeColor = hp.isElementSelected(homeBtn);
		assertTrue(homeColor);
//		4. Click on 'Signup / Login' button
		hp.clickSignupLoginButton();
//		5. Verify 'New User Signup!' is visible
		SignupLogin sl = new SignupLogin(driver);
		WebElement newUserSignupElement = sl.getNewUserSignUpElement();
		assertTrue(newUserSignupElement.isDisplayed());
//		6. Enter name and email address
		sl.enterSignupName("user");
		sl.enterSignupEmail("a4@test.com");
//		7. Click 'Signup' button
		sl.clickSignupButton();
//		8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
		AccountInformation acctInfo = new AccountInformation(driver);
		acctInfo.waitForElementToBeVisible(acctInfo.getPageTitleElement());
		assertTrue(acctInfo.getPageTitleText().toUpperCase().equals("ENTER ACCOUNT INFORMATION"));
//		9. Fill details: Title, Name, Email, Password, Date of birth
		acctInfo.setTitle("Mr");
		acctInfo.setPassword("pword");
		acctInfo.setDataOfBirth("1980-07-25");
//		10. Select checkbox 'Sign up for our newsletter!'
		acctInfo.signUpForNewsLetter();
//		11. Select checkbox 'Receive special offers from our partners!'
		acctInfo.receiveSpecialOffers();
//		12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
		acctInfo.setFirstName("Fname");
		acctInfo.setLastName("Lname");
		acctInfo.setCompany("Cmp");
		acctInfo.setStreetAddressOne("123 Test St");
		acctInfo.setStreetAddressTwo("apt 15");
		acctInfo.clickCountryDropdown();
		acctInfo.setCountry("United States");
		acctInfo.setState("Texas");
		acctInfo.setCity("Dallas");
		acctInfo.setZipcode("76025");
		acctInfo.setMobileNumber("7172721121");
//		13. Click 'Create Account button'
		acctInfo.clickCreateAccountButton();
//		14. Verify that 'ACCOUNT CREATED!' is visible
		AccountCreated ac = new AccountCreated(driver);
		ac.waitForElementToBeVisible(ac.getTitleElement());
		assertTrue(ac.getTitleText().toUpperCase().equals("ACCOUNT CREATED!"));
//		15. Click 'Continue' button
		ac.clickContinueButton();
//		16. Verify that 'Logged in as username' is visible
		hp.waitForElementToBeVisible(hp.getLoggedUserNameElement());
		assertTrue(hp.getLoggedUserNameText().equals("user"));
//		17. Click 'Delete Account' button
		hp.deleteUser();
//		18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
		DeleteUser du = new DeleteUser(driver);
		du.waitForElementToBeVisible(du.getTitleElement());
		assertTrue(du.getTitleElementText().toUpperCase().equals("ACCOUNT DELETED!"));
	}

}
