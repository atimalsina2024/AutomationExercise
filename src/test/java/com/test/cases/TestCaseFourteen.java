package com.test.cases;

import java.util.HashMap;

import org.testng.Assert;

import com.page.pages.AccountCreated;
import com.page.pages.AccountInformation;
import com.page.pages.CartPage;
import com.page.pages.HomePage;
import com.test.base.TestBase;

public class TestCaseFourteen extends TestBase {

	String name = "n";
	String email = "n@c.com";
	HashMap<String, String> accountInformation = new HashMap<>();

//✅ Test Case 14: Place Order: Register while Checkout
//
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully
//4. Add products to cart
//5. Click 'Cart' button
//6. Verify that cart page is displayed
//7. Click Proceed To Checkout
//8. Click 'Register / Login' button
//9. Fill all details in Signup and create account
//10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
//11. Verify ' Logged in as username' at top
//12. Click 'Cart' button
//13. Click 'Proceed To Checkout' button
//14. Verify Address Details and Review Your Order
//15. Enter description in comment text area and click 'Place Order'
//16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
//17. Click 'Pay and Confirm Order' button
//18. Verify success message 'Congratulations! Your order has been confirmed!'
//19. Click 'Delete Account' button
//20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
	public void TC_014_Place_Order_Register_While_Checkout() {
		TestCaseOne.verifyHomePageIsVisibleSuccessfully();
		TestCaseTwelve.hoverAndAddFirstProductToCartAndContinueShopping();
		TestCaseTwelve.hoverAndAddSecondProductToCartAndGoToCart();
		TestCaseTwelve.verifyBothProductsAreAddedToCart();
		TestCaseTwelve.verifyPriceQuantityAndTotalPrice(1);
		proceedToCheckOutAndRegisterNewAccount(name, email);
		fillOutAccountInformationForNewAccount(accountInformation);
		verifyAccountCreationAndVerifyUserName();
		
	}

	public void proceedToCheckOutAndRegisterNewAccount(String email, String name) {
		new CartPage(driver)
		.clickCheckOutButton()
		.clickLoginRegisterButton()
		.enterSignupEmail(email)
		.enterSignupName(name)
		.clickSignupButton();
	}
	public void fillOutAccountInformationForNewAccount(HashMap<String, String> info) {
		new AccountInformation(driver)
		.fillInformation(info)
		.clickCreateAccountButton();
	}
	
	public void verifyAccountCreationAndVerifyUserName() {
		AccountCreated ac = new AccountCreated(driver);
		boolean acctCreated = ac
		.getTitleText()
		.toUpperCase()
		.equals("Account Created!");
		Assert.assertTrue(acctCreated);
		boolean userName = ac
		.clickContinueButton()
		.getLoggedUserNameElement()
		.getText()
		.equals(name);
		Assert.assertTrue(userName);
	}
	public void clickCartAndProceedToReviewAddressAndOrderDetail() {
		new HomePage(driver)
		.clickCartButton()
		.proceedToCheckOutWhenLoggedIn();
	}
	
}
