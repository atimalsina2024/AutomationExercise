package com.ui.test.helper;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ui.page.pages.ProductPage;
import com.ui.page.pages.SearchProductPage;

public class ProductPageFlow {
	private static final Logger logger = LogManager.getLogger(ProductPageFlow.class);
	private WebDriver driver;
	private ProductPage productPage;

	public ProductPageFlow(WebDriver driver) {
		this.driver = driver;
		this.productPage = new ProductPage(driver);
		logger.debug("ProductPageFlow constructed");
	}

	public void verifyLandingOnProductsPage() {
		boolean landedOnProductPage = productPage
				.getProductPageHeader()
				.getText()
				.equals("ALL PRODUCTS");
		Assert.assertTrue(landedOnProductPage, "Landing on Product page failed");
		logger.debug("verifyLandingOnProductsPage");
	}

	public void clickOnBlueTopDetail() {
		productPage
		.clickViewProduct();
		logger.debug("clickOnBlueTopDetail");
	}

	public void searchAProduct(String text) {
		productPage
				.enterSearchTextToSearchTextBox(text)
				.clickSearchButton();
		logger.debug("searchAProduct");
	}

	public void verifySearchedProductTitleIsVisible() {
		boolean searchLandingVisible = productPage
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
		productPage
		.hoverOnFirstProduct()
		.clickAddToCartFirstProduct();
		logger.debug("hoverAndAddFirstProduct");
	}

	public void hoverAndAddSecondProduct() {
		productPage
		.hoverOnSecondProduct()
		.clickAddToCartSecondProduct();
		logger.debug("hoverAndAddSecondProduct");
	}
	
	public void verifyBrandsOnProductPage() {
		boolean brandHeader = productPage
		.getBrandHeader()
		.getText()
		.equals("BRANDS");
		
		Assert.assertTrue(brandHeader);
		logger.debug("verifyBrandsOnProductPage");
	}
	
	public void clickOnPoloAndVerifyLandingOnPoloPage() {
		boolean poloLanding = productPage
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
