package com.ui.test.helper;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ui.page.pages.HomePage;
import com.ui.page.pages.ProductPage;

public class HomePageFlow {

	private WebDriver driver;
	private static final Logger logger = LogManager.getLogger(HomePageFlow.class);
	private HomePage homePage;
	
	public HomePageFlow(WebDriver driver) {
		this.driver = driver;
		this.homePage = new HomePage(driver);
		logger.debug("HomePageFlow initialized");
	}
	
	public void verifyCurrentlyOnHomePage() {
		boolean homeButtonSelected = homePage
		.isHomeButtonSelected();
		
		Assert.assertTrue(homeButtonSelected, "Home button is not selected");
		logger.debug("verifyCurrentlyOnHomePage");
	}
	
	public void navigateToSignupLoginPage() {		
		homePage
		.clickSignupLoginButton();
		logger.debug("navigateToSignupLoginPageFromHomePage");
	}
	
	public void verifyUsernameVisibilityFromHomePage() {
		boolean userNameVisibility = homePage.getLoggedUserNameElement()
		.isDisplayed();
		Assert.assertTrue(userNameVisibility, "Username not visible");
		logger.debug("verifyUsernameVisibilityFromHomePage");
	}

	public void logOutFromHomePage() {
		homePage
		.userLogout();
		logger.debug("logOutFromHomePage");
	}

	public void navigateToContactUsPage() {
		homePage
		.clickContactUsButton();
	}

	public void navigateToTestCasePage() {
			homePage
			.clickTestCaseButton();
			logger.debug("navigateToTestCasePage");
	}

	public void navigateToProductPage() {
		homePage
		.clickProductButton();
		logger.debug("navigateToProductPage");
	}

	public void scrollToFooter() {
		homePage
				.scrollToSubscription();	
	}

	public void verifySubscriptionIsVisible() {
		boolean isSubscriptionVisible = homePage
		.getSubscriptionElement()
		.getText()
		.toUpperCase()
		.equals("SUBSCRIPTION");
		
		Assert.assertTrue(isSubscriptionVisible, "Subscription Message visibility fail");
		logger.debug("verifySubscriptionIsVisible");
	}
	
	public void enterSubscriptionEmailAndVerifySubscriptionMessage(String email) {
		boolean subsConfirmation = homePage
		.enterSubscriptionEmailAddress(email)
		.clickSubscribeButton()
		.getSubscriptionConfirmationMessage()
		.getText()
		.equals("You have been successfully subscribed!");
		
		Assert.assertTrue(subsConfirmation, "Subscription failed");
		logger.debug("enterSubscriptionEmailAndVerifySubscriptionMessage");
	}

	public void navigateToCartPage() {
		homePage
				.clickCartButtonOnHomePage();
		logger.debug("navigateToCartPage");
		
	}

	public void verifyCategoriesAreVisible() {
		boolean catgs = homePage
				.getCategories()
				.equals(new ArrayList<String>(Arrays.asList("WOMEN", "MEN", "KIDS")));
				
				Assert.assertTrue(catgs);		
	}
	//need to refactor this
	public void clickAndVerifyWomensDress() {
		boolean womensCat = homePage
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
		boolean recoHeader = homePage
		.getRemmendedItemHeader()
		.getText()
		.toUpperCase()
		.equals("RECOMMENDED ITEMS");

		Assert.assertTrue(recoHeader, "Recommendation header");
		logger.debug("verifyRecommendedItemsIsVisible");
	}
	
	public void addARecommendedProductToCart() {
		homePage
		.addRecommendedProductToCart();
		logger.debug("verifyRecommendedItemsIsVisible");
	}
	
	public void deleteUser() {
		homePage
		.deleteUser();
		logger.debug("deleteUserFrom");
	}

	public void scrollToTopUsingArrow() {
		homePage.clickScrollUpArrow();
		logger.debug("scrollToTopUsingArrow");
		}
	
	public void verifyPageBodyMessageIsSeen() {
		boolean msg = homePage
		.getLandingCarousel()
		.isDisplayed();
		
		Assert.assertTrue(msg);
		logger.debug("verifyPageBodyMessageIsSeen");
	}

	public void scrollToTop() {
		homePage
		.scrollToHomePageWithoutClickingArrow();
		logger.debug("scrollToTop");
	}
}
