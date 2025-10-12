package com.test.helper;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.page.pages.HomePage;
import com.page.pages.ProductPage;
import com.page.pages.SearchProductPage;

public class ProductPageFlow {
	private static final Logger logger = LogManager.getLogger(ProductPageFlow.class);
	private WebDriver driver;

	public ProductPageFlow(WebDriver driver) {
		this.driver = driver;
		logger.debug("ProductPageFlow constructed");
	}

	public void verifyLandingOnProductsPage() {
		boolean landedOnProductPage = new HomePage(driver)
				.clickProductButton()
				.getProductPageHeader()
				.getText()
				.equals("ALL PRODUCTS");
		Assert.assertTrue(landedOnProductPage, "Landing on Product page failed");
		logger.debug("verifyLandingOnProductsPage");
	}

	public void clickOnBlueTopDetail() {
		new ProductPage(driver)
		.clickViewProduct();
		logger.debug("clickOnBlueTopDetail");
	}

	public void searchAProduct(String text) {
		new ProductPage(driver)
				.enterSearchTextToSearchTextBox(text)
				.clickSearchButton();
		logger.debug("searchAProduct");
	}

	public void verifySearchedProductTitleIsVisible() {
		boolean searchLandingVisible = new ProductPage(driver)
		.getLandingHeader()
		.getText()
		.toUpperCase()
		.equals("SEARCHED PRODUCTS");		
		Assert.assertTrue(searchLandingVisible);
		logger.debug("verifySearchedProductTitleIsVisible");
		
	}

	public void verifySearchedProductsAreDisplayedInSearchResult(String string) {
		List<String> names = new SearchProductPage(driver)
				.getAllSearchResultProductName();
				for(String name: names) {
					Assert.assertTrue(name.toLowerCase().contains(string.toLowerCase()));
				}
		logger.debug("verifySearchedProductsAreDisplayedInSearchResult");		
	}

	public void hoverAndAddFirstProduct() {
		new ProductPage(driver)
		.hoverOnFirstProduct()
		.clickAddToCartFirstProduct();
		logger.debug("hoverAndAddFirstProduct");
	}

	public void hoverAndAddSecondProduct() {
		new ProductPage(driver)
		.hoverOnSecondProduct()
		.clickAddToCartSecondProduct();
		logger.debug("hoverAndAddSecondProduct");
	}
	
	public void verifyBrandsOnProductPage() {
		boolean brandHeader = new ProductPage(driver)
		.getBrandHeader()
		.getText()
		.equals("BRANDS");
		
		Assert.assertTrue(brandHeader);
		logger.debug("verifyBrandsOnProductPage");
	}
	
	public void clickOnPoloAndVerifyLandingOnPoloPage() {
		boolean poloLanding = new ProductPage(driver)
		.clickPolo()
		.getProductPageHeader()
		.getText()
		.equals("BRAND - POLO PRODUCTS");
		
		Assert.assertTrue(poloLanding);
		logger.debug("clickOnPoloAndVerifyLandingOnPoloPage");
	}

	//need to refactor this. Need to move clickContinueToDialogPageFlow
	public void addAllSearchedProductsToCart() {
		SearchProductPage sp = new SearchProductPage(driver);
		sp.getSearchedProductElements()
		.stream()
		.forEach(element ->{
			sp.hoverOnProduct(element)
			.addProductToCart(element)
			.clickContinueShopping();
		});
		logger.debug("addAllSearchedProductsToCart");
	}

	public void navigateToCartPage() {
		new SearchProductPage(driver)
		.clickCartButton();
		logger.debug("addAllSearchedProductsToCart");
	}
}
