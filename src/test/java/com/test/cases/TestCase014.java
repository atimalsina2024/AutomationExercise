package com.test.cases;

import java.util.ArrayList;
import java.util.Arrays;

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
import com.test.helper.ProductPageFlow;
import com.test.models.CustomerInfo;

import utils.JsonUtil;
import utils.PropertyUtil;

public class TestCase014 extends TestBase {
	private static final Logger logger = LogManager.getLogger(TestCase014.class);
	private HomePageFlow homePageFlow;
	private ProductPageFlow productPageFlow;
	private NewUserRegistrationFlow accountRegistrationFlow;
	private DeleteUserFlow deleteUserFlow;
	private CustomerInfo customer;
	private String msg = "message";
	private DialogBoxFlow dialogBoxFlow;
	private CartPageFlow cartPageFlow;
	private PaymentPageFlow paymentPageFlow;
	@BeforeClass
	public void testSetup() {
		logger.debug("@BeforeClass");
		homePageFlow = new HomePageFlow(driver);
		productPageFlow = new ProductPageFlow(driver);
		accountRegistrationFlow = new NewUserRegistrationFlow(driver);
		deleteUserFlow = new DeleteUserFlow(driver);
		customer = JsonUtil.parseAcctInfoJson(PropertyUtil.get("account.registration.data"));
		dialogBoxFlow = new DialogBoxFlow(driver);
		cartPageFlow = new CartPageFlow(driver);
		paymentPageFlow = new PaymentPageFlow(driver);
	}	
//✅ Test Case 14: Place Order: Register while Checkout
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
	@Test(description = "Place Order: Register while Checkout")
	public void TC_014_Place_Order_Register_While_Checkout() {
		homePageFlow.verifyCurrentlyOnHomePage();
		productPageFlow.hoverAndAddFirstProduct();
		dialogBoxFlow.continueShopping();
		productPageFlow.hoverAndAddSecondProduct();
		dialogBoxFlow.gotoCart();
		cartPageFlow.verifyAddedProductsPresentInCart(new ArrayList<String>(Arrays.asList(PropertyUtil.get("first.product"),PropertyUtil.get("second.product") )));
		cartPageFlow.verifyPriceQuantityAndTotalPriceOfAddedProducts(1);
		cartPageFlow.proceedToCheckout();
		dialogBoxFlow.proceedToLoginRegister();
		accountRegistrationFlow.verifySignupInformationIsVisible();
		accountRegistrationFlow.signupNewUserPositive(customer);
		accountRegistrationFlow.verifyNavigationToAccountInformationPage();
		accountRegistrationFlow.fillAccountDetailsAndCreateAccount(customer);
		accountRegistrationFlow.verifyAccountCreated();
		accountRegistrationFlow.continueToHomePageFromAccountRegistrationPage();
		homePageFlow.proceedToCart();
		cartPageFlow.proceedToCheckout();
		cartPageFlow.verifyShippingAndBillingAddress(customer);
		cartPageFlow.addMessageAndPlaceOrder(msg);
		paymentPageFlow.makePaymentAndVerifyOrderSuccess(customer.getCreditCard());
		paymentPageFlow.proceedToHomePageFromSuccessfulOrderPlacement();
		deleteUserFlow.deleteUserFromHomePageAndVerifyDeletion();
	}
}
