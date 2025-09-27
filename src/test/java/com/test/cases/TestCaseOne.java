package com.test.cases;

import static org.testng.Assert.assertTrue;

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
	@Test(priority = 2, description = "after refactoring")
	public void Test_001_RegisterUser() {
		verifyHomePageIsVisibleSuccessfully();
		clickSignUpButton();
		verifySignupInformationIsVisible();
		signUp("user5", "oiwer@mnf.com");
		verifyAccountInformationIsVisible();
		fillAccountDetail();
		verifyAccountCreated();
		continueToHomePageAfterAccountCreation();
		verifyUsernameIsVisible();
		deleteUser();
		verifyAccountDeletion();
		continueToHomePageAfterDelete();
	}
	
	
	//----------------------
	//Test Steps
	//----------------------
	
	public static void verifyHomePageIsVisibleSuccessfully() {
		HomePage hp = new HomePage(driver);
		assertTrue(hp.isElementSelected(hp.getHomeElement()), "Home Button is not orange");
	}
	
	public static void clickSignUpButton() {
		new HomePage(driver).clickSignupLoginButton();
	}
	
	public void verifySignupInformationIsVisible() {
		boolean signUpDisplayed = new SignupLogin(driver).getNewUserSignUpElement().isDisplayed();
		assertTrue(signUpDisplayed, "Verify 'New User Signup!' is visible failed");
	}
	
	public void signUp(String user, String email) {
		SignupLogin sl = new SignupLogin(driver);
		sl.enterSignupName(user);
		sl.enterSignupEmail(email);
		sl.clickSignupButton();
	}
	
	public void verifyAccountInformationIsVisible() {
		boolean result =new AccountInformation(driver).getPageTitleElement().getText().toUpperCase().equals("ENTER ACCOUNT INFORMATION");
		assertTrue(result);
	}
	
	public void fillAccountDetail() {
		AccountInformation info = new AccountInformation(driver);
		info.setTitle("Mr");
		info.setPassword("pword");
		info.setDataOfBirth("1980-07-25");
		info.signUpForNewsLetter();
		info.receiveSpecialOffers();
		info.setFirstName("Fname");
		info.setLastName("Lname");
		info.setCompany("Cmp");
		info.setStreetAddressOne("123 Test St");
		info.setStreetAddressTwo("apt 15");
		info.clickCountryDropdown();
		info.setCountry("United States");
		info.setState("Texas");
		info.setCity("Dallas");
		info.setZipcode("76025");
		info.setMobileNumber("7172721121");
		info.clickCreateAccountButton();
	}
	
	public void verifyAccountCreated() {
		boolean rslt = new AccountCreated(driver).getTitleText().toUpperCase().equals("ACCOUNT CREATED!");
		assertTrue(rslt);
	}
	
	public void continueToHomePageAfterAccountCreation() {
		new AccountCreated(driver).clickContinueButton();
	}
	
	public void verifyUsernameIsVisible() {
		boolean rslt = new HomePage(driver).getLoggedUserNameElement().isDisplayed();
		assertTrue(rslt);
	}
	
	public void deleteUser() {
		new HomePage(driver).deleteUser();
	}
	
	public void verifyAccountDeletion() {
		boolean rslt = new DeleteUser(driver).getTitleElementText().equals("ACCOUNT DELETED!");
		assertTrue(rslt);
	}
	
	public void continueToHomePageAfterDelete() {
		new DeleteUser(driver).clickContinueButton();
	}
	
	
	
	
	
	

}
