package com.test.cases;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.page.pages.OrderPlaced;
import com.test.base.TestBase;
import com.test.models.CustomerInfo;

import utils.FileHandlerUtils;
import utils.JsonUtil;
import utils.PropertyUtil;

public class TestCaseTwentyfour extends TestBase{

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
	private static final Logger logger = LogManager.getLogger(TestCaseTwentyfour.class);
	CustomerInfo customer;
	@Test(description = "Test Case 24: Download Invoice after purchase order")
	public void TC_024_Download_Invoice_After_Purchase_Order() {
		TestCaseOne.verifyHomePageIsVisibleSuccessfully();
		TestCaseTwentyTwo.addARecommendedProductToCartAndProceedToCart();
		TestCaseFourteen.proceedToCheckOutFromCart();
		getCustomerInfo(PropertyUtil.get("accountRegistrationData"));
		TestCaseFourteen.registerNewAccount(customer);
		TestCaseFourteen.fillOutAccountInformationForNewAccount(customer);
		TestCaseFourteen.verifyAccountCreationAndVerifyUserName(customer);
		TestCaseFourteen.proceedTocartFromHomePage();
		TestCaseFourteen.proceedToCheckoutWhenLoggedIn();
		TestCaseFourteen.verifyShippingAndBillingAddress(customer);
		TestCaseFourteen.addMessagePlaceOrderAndVerifySuccessMessage("Test", customer.getCreditCard());
		downloadInvoiceAndVedriverwnload();
		TestCaseFourteen.continueToHomeFromOrderPlacementConfirmation();
		TestCaseFourteen.deleteAccount();
		
	}
	public void getCustomerInfo(String path) {
		customer = JsonUtil.parseAcctInfoJson(path);
	}
	public void downloadInvoiceAndVedriverwnload() {
		new OrderPlaced(driver)
		.clickDownloadInvoiceButton();
		boolean isFileDownloaded;
		try {
			isFileDownloaded = FileHandlerUtils.validateFileInAFolder(System.getProperty("user.dir") + File.separator + PropertyUtil.get("download.path"), "invoice");
		} catch (IOException e) {
			isFileDownloaded = false;
			logger.error("file not found");
			e.printStackTrace();
		}
		Assert.assertTrue(isFileDownloaded);
	}
}
