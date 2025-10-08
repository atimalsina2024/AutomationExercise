package com.test.cases;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.page.pages.AccountCreated;
import com.page.pages.AccountInformation;
import com.page.pages.CartPage;
import com.page.pages.HomePage;
import com.page.pages.OrderPlaced;
import com.test.base.TestBase;
import com.test.models.CreditCard;
import com.test.models.CustomerInfo;

import utils.JsonUtil;

public class TestCaseFourteen extends TestBase {
	CustomerInfo customer;
	String msg = "message";
	private static final Logger logger = LogManager.getLogger(TestCaseFourteen.class);

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
	@Test(description = "tc 14")
	public void TC_014_Place_Order_Register_While_Checkout() {
		TestCaseOne.verifyHomePageIsVisibleSuccessfully();
		TestCaseTwelve.hoverAndAddFirstProductToCartAndContinueShopping();
		TestCaseTwelve.hoverAndAddSecondProductToCartAndGoToCart();
		TestCaseTwelve.verifyBothProductsAreAddedToCart();
		TestCaseTwelve.verifyPriceQuantityAndTotalPrice(1);
		getCustomerData();
		proceedToCheckOutAndRegisterNewAccount(customer.getEmail(), customer.getFirstName());
		fillOutAccountInformationForNewAccount();
		verifyAccountCreationAndVerifyUserName();
		proceedTocart();
		String billingAddress = customer.getCompany().concat(" ")
				.concat(customer.getAddress().getStreet().concat(" ")
				.concat(customer.getAddress().getApt()));
		String shippingAddress = customer.getCompany().concat(" ")
				.concat(customer.getAddress().getStreet().concat(" ")
				.concat(customer.getAddress().getApt()));
		verifyShippingAndBillingAddress(billingAddress,shippingAddress);
		addMessagePlaceOrderAndVerifySuccessMessage(msg, customer.getCreditCard());
		deleteAccount();
	}

	public void getCustomerData() {
		logger.info("getCustomerData Entry");
		customer = JsonUtil.parseAcctInfoJson(
				"/Users/work/eclipse-workspace/AutomationExercise/src/test/resources/newAccount.json");
	}

	public void proceedToCheckOutAndRegisterNewAccount(String email, String name) {
		logger.info("proceedToCheckOutAndRegisterNewAccount Entry");
		new CartPage(driver).clickCheckOutButton().clickLoginRegisterButton().enterSignupEmail(email)
				.enterSignupName(name).clickSignupButton();
	}

	public void fillOutAccountInformationForNewAccount() {
		logger.info("fillOutAccountInformationForNewAccount Entry");
		new AccountInformation(driver).fillInformation(customer).clickCreateAccountButton();
	}

	public void verifyAccountCreationAndVerifyUserName() {
		logger.info("verifyAccountCreationAndVerifyUserName entry");
		AccountCreated ac = new AccountCreated(driver);
		boolean acctCreated = ac.getTitleText().toUpperCase().equals("ACCOUNT CREATED!");
		Assert.assertTrue(acctCreated);
		boolean userName = ac.clickContinueButton().getLoggedUserNameElement().getText()
				.equals(customer.getFirstName());
		Assert.assertTrue(userName);
	}

	public void proceedTocart() {
		logger.info("proceedTocart entry");
		new HomePage(driver).clickCartButton().proceedToCheckOutWhenLoggedIn();
	}

	public void verifyShippingAndBillingAddress(String billingAdd, String shippingAdd) {
		logger.info("verifyShippingAndBillingAddress entry");
		CartPage cp = new CartPage(driver);
		Map<String, String> billingAddress = cp.getBillingAddress();
		Map<String, String> shippingAddress = cp.getDeliveryAddress();
		Assert.assertEquals(billingAddress.get("streetAddress"), billingAdd);
		Assert.assertEquals(shippingAddress.get("streetAddress"), shippingAdd);
	}

	public void addMessagePlaceOrderAndVerifySuccessMessage(String msg, CreditCard card) {
		logger.info("addMessagePlaceOrderAndVerifySuccessMessage entry");
		boolean successMsg = new CartPage(driver).setOrderMessage(msg).clickCheckoutButton().fillPaymentInfo(card)
				.clickPaymentButton().getSuccessMessage().getText()
				.equals("Congratulations! Your order has been confirmed!");

		Assert.assertTrue(successMsg);
	}

	public void deleteAccount() {
		logger.info("deleteAccount entry");
		boolean acctDeletion = new OrderPlaced(driver).clickContinueButton().deleteUser().getTitleElement().getText()
				.equals("ACCOUNT DELETED!");

		Assert.assertTrue(acctDeletion);
	}

}
