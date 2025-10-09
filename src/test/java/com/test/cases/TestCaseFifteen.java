package com.test.cases;

import org.testng.annotations.Test;

import com.page.pages.CartPage;
import com.test.base.TestBase;
import com.test.models.CustomerInfo;

import utils.JsonUtil;

public class TestCaseFifteen extends TestBase{

	private CustomerInfo customer;
//✅ Test Case 15: Place Order: Register before Checkout
//
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully
//4. Click 'Signup / Login' button
//5. Fill all details in Signup and create account
//6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
//7. Verify ' Logged in as username' at top
//8. Add products to cart
//9. Click 'Cart' button
//10. Verify that cart page is displayed
//11. Click Proceed To Checkout
//12. Verify Address Details and Review Your Order
//13. Enter description in comment text area and click 'Place Order'
//14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
//15. Click 'Pay and Confirm Order' button
//16. Verify success message 'Congratulations! Your order has been confirmed!'
//17. Click 'Delete Account' button
//18. Verify that 'ACCOUNT DELETED!' and click 'Continue' button
	@Test(description = "tc 15")
	public void TC_015_Register_Before_Checkout() {
		TestCaseOne.verifyHomePageIsVisibleSuccessfully();
		getCustomerInfo();
		TestCaseOne.clickSignUpButton();
		TestCaseFourteen.registerNewAccount(customer);
		TestCaseFourteen.fillOutAccountInformationForNewAccount(customer);
		TestCaseFourteen.verifyAccountCreationAndVerifyUserName(customer);
		TestCaseTwelve.hoverAndAddFirstProductToCartAndContinueShopping();
		TestCaseTwelve.hoverAndAddSecondProductToCartAndGoToCart();
		//TestCaseFourteen.proceedTocart();
		proceedToCheckInWhenLoggedIn();
		TestCaseFourteen.verifyShippingAndBillingAddress(customer);
		TestCaseFourteen.addMessagePlaceOrderAndVerifySuccessMessage("message", customer.getCreditCard());
		TestCaseFourteen.deleteAccount();
		
	}
	public void getCustomerInfo() {
		customer = JsonUtil.parseAcctInfoJson("/Users/work/eclipse-workspace/AutomationExercise/src/test/resources/newAccount.json");
	}
	
	public static void proceedToCheckInWhenLoggedIn() {
		new CartPage(driver)
		.clickCheckOutWhenLoggedIn();
	}

}
