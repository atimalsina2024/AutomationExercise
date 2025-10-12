package com.test.helper;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.page.pages.HomePage;
import com.page.pages.ProductPage;

public class HomePageFlow {

	private WebDriver driver;
	private static final Logger logger = LogManager.getLogger(HomePageFlow.class);
	
	public HomePageFlow(WebDriver driver) {
		this.driver = driver;
		logger.debug("HomePageFlow initialized");
	}
	
	public void verifyCurrentlyOnHomePage() {
		boolean homeButtonSelected = new HomePage(driver)
		.isHomeButtonSelected();
		
		Assert.assertTrue(homeButtonSelected, "Home button is not selected");
		logger.debug("verifyCurrentlyOnHomePage");
	}
	
	public void navigateToSignupLoginPage() {		
		new HomePage(driver)
		.clickSignupLoginButton();
		logger.debug("navigateToSignupLoginPageFromHomePage");
	}
	
	public void verifyUsernameVisibilityFromHomePage() {
		boolean userNameVisibility = new HomePage(driver).getLoggedUserNameElement()
		.isDisplayed();
		Assert.assertTrue(userNameVisibility, "Username not visible");
		logger.debug("verifyUsernameVisibilityFromHomePage");
	}

	public void logOutFromHomePage() {
		new HomePage(driver)
		.userLogout();
		logger.debug("logOutFromHomePage");
	}

	public void navigateToContactUsPage() {
		new HomePage(driver)
		.clickContactUsButton();
	}

	public void navigateToTestCasePage() {
			new HomePage(driver)
			.clickTestCaseButton();
			logger.debug("navigateToTestCasePage");
	}

	public void navigateToProductPage() {
		new HomePage(driver)
		.clickProductButton();
		logger.debug("navigateToProductPage");
	}

	public void scrollToFooter() {
		new HomePage(driver)
				.scrollToSubscription();	
	}

	public void verifySubscriptionIsVisible() {
		boolean isSubscriptionVisible = new HomePage(driver)
		.getSubscriptionElement()
		.getText()
		.toUpperCase()
		.equals("SUBSCRIPTION");
		
		Assert.assertTrue(isSubscriptionVisible, "Subscription Message visibility fail");
		logger.debug("verifySubscriptionIsVisible");
	}
	
	public void enterSubscriptionEmailAndVerifySubscriptionMessage(String email) {
		boolean subsConfirmation = new HomePage(driver)
		.enterSubscriptionEmailAddress(email)
		.clickSubscribeButton()
		.getSubscriptionConfirmationMessage()
		.getText()
		.equals("You have been successfully subscribed!");
		
		Assert.assertTrue(subsConfirmation, "Subscription failed");
		logger.debug("enterSubscriptionEmailAndVerifySubscriptionMessage");
	}

	public void navigateToCartPage() {
		new HomePage(driver)
				.clickCartButtonOnHomePage();
		logger.debug("navigateToCartPage");
		
	}

	public void verifyCategoriesAreVisible() {
		boolean catgs = new HomePage(driver)
				.getCategories()
				.equals(new ArrayList<String>(Arrays.asList("WOMEN", "MEN", "KIDS")));
				
				Assert.assertTrue(catgs);		
	}
	//need to refactor this
	public void clickAndVerifyWomensDress() {
		boolean womensCat = new HomePage(driver)
		.expandWomenCategory()
		.clickWomensDress()
		.getProductPageHeader()
		.getText()
		.equals("WOMEN - DRESS PRODUCTS");
		
		Assert.assertTrue(womensCat);
		logger.debug("clickAndVerifyWomensDress");
	}
	//refactor this in future
	public void clickAndVerifyMensDress() {
		boolean mensCat = new ProductPage(driver)
		.expandMensCategory()
		.clickMensJeans()
		.getProductPageHeader()
		.getText()
		.equals("MEN - JEANS PRODUCTS");
		
		Assert.assertTrue(mensCat);
		logger.debug("clickAndVerifyMensDress");
	}
	
	public void verifyRecommendedItemsIsVisible() {
		boolean recoHeader = new HomePage(driver)
		.getRemmendedItemHeader()
		.getText()
		.toUpperCase()
		.equals("RECOMMENDED ITEMS");

		Assert.assertTrue(recoHeader, "Recommendation header");
		logger.debug("verifyRecommendedItemsIsVisible");
	}
	
	public void addARecommendedProductToCart() {
		new HomePage(driver)
		.addRecommendedProductToCart();
		logger.debug("verifyRecommendedItemsIsVisible");
	}
	
	public void deleteUserFrom() {
		new HomePage(driver)
		.deleteUser();
		logger.debug("deleteUserFrom");
	}

	public void scrollToTopUsingArrow() {
		new HomePage(driver).clickScrollUpArrow();
		logger.debug("scrollToTopUsingArrow");
		}
	
	public void verifyPageBodyMessageIsSeen() {
		boolean msg = new HomePage(driver)
		.getLandingCarousel()
		.isDisplayed();
		
		Assert.assertTrue(msg);
		logger.debug("verifyPageBodyMessageIsSeen");
	}

	public void scrollToTop() {
		new HomePage(driver)
		.scrollToHomePageWithoutClickingArrow();
		logger.debug("scrollToTop");
	}
}
