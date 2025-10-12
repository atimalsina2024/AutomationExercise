package com.test.cases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.base.TestBase;
import com.test.helper.CartPageFlow;
import com.test.helper.DeleteUserFlow;
import com.test.helper.DialogBoxFlow;
import com.test.helper.HomePageFlow;
import com.test.helper.NewUserRegistrationFlow;
import com.test.helper.PaymentPageFlow;
import com.test.models.CustomerInfo;

import utils.JsonUtil;
import utils.PropertyUtil;

public class TestCase024 extends TestBase{
	private static final Logger logger = LogManager.getLogger(TestCase024.class);
	private HomePageFlow homePageFlow;
	private NewUserRegistrationFlow newUserRegistrationFlow;
	private DeleteUserFlow deleteUserFlow;
	private CustomerInfo customer;
	private DialogBoxFlow dialogBoxFlow;
	private CartPageFlow cartPageFlow;
	private PaymentPageFlow paymentPageFlow;
	
	@BeforeClass
	public void testSetup() {
		logger.debug("@BeforeClass TestCase024");
		homePageFlow = new HomePageFlow(driver);
		deleteUserFlow = new DeleteUserFlow(driver);
		customer = JsonUtil.parseAcctInfoJson(PropertyUtil.get("account.registration.data"));
		dialogBoxFlow = new DialogBoxFlow(driver);
		cartPageFlow = new CartPageFlow(driver);
		paymentPageFlow = new PaymentPageFlow(driver);
		newUserRegistrationFlow = new NewUserRegistrationFlow(driver);
	}	
//	✅ Test Case 24: Download Invoice after purchase order
//
//	1. Launch browser
//	2. Navigate to url 'http://automationexercise.com'
//	3. Verify that home page is visible successfull
//	4. Add products to cart
//	5. Click 'Cart' button
//	6. Verify that cart page is displayed
//	7. Click Proceed To Checkout
//	8. Click 'Register / Login' button
//	9. Fill all details in Signup and create account
//	10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
//	11. Verify ' Logged in as username' at top
//	12. Click 'Cart' button
//	13. Click 'Proceed To Checkout' button
//	14. Verify Address Details and Review Your Order
//	15. Enter description in comment text area and click 'Place Order'
//	16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
//	17. Click 'Pay and Confirm Order' button
//	18. Verify success message 'Congratulations! Your order has been confirmed!'
//	19. Click 'Download Invoice' button and verify invoice is downloaded successfully
//	20. Click 'Continue' button
//	21. Click 'Delete Account' button
//	22. Verify 'ACCOUNT DELETED!' and click 'Continue' button
	@Test(description = "Test Case 24: Download Invoice after purchase order")
	public void TC_024_Download_Invoice_After_Purchase_Order() {
		homePageFlow.verifyCurrentlyOnHomePage();
		homePageFlow.addARecommendedProductToCart();
		dialogBoxFlow.gotoCart();
		cartPageFlow.proceedToCheckout();
		dialogBoxFlow.proceedToLoginRegister();
		newUserRegistrationFlow.verifySignupInformationIsVisible();
		newUserRegistrationFlow.signupNewUserPositive(customer);
		newUserRegistrationFlow.verifyNavigationToAccountInformationPage();
		newUserRegistrationFlow.fillAccountDetailsAndCreateAccount(customer);
		newUserRegistrationFlow.verifyAccountCreated();
		newUserRegistrationFlow.continueToHomePageFromAccountRegistrationPage();
		homePageFlow.navigateToCartPage();
		cartPageFlow.proceedToCheckout();
		cartPageFlow.addMessageAndPlaceOrder(PropertyUtil.get("order.message"));
		paymentPageFlow.makePaymentAndVerifyOrderSuccess(customer.getCreditCard());
		paymentPageFlow.downloadInvoiceAndVerifyDownload();
		paymentPageFlow.proceedToHomePageFromSuccessfulOrderPlacement();
		homePageFlow.deleteUserFrom();
		deleteUserFlow.verifyDeletionConfirmation();
		deleteUserFlow.continueToHomePageAfterUserDeletionConfirmation();
	}
}
