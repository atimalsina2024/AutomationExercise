package com.page.pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.page.base.PageBase;

import utils.JavascriptUtils;
import utils.WaitUtils;

public class ProductPage extends PageBase{

	private static final Logger logger = LogManager.getLogger(ProductPage.class);
	@FindBy(xpath = "//h2[text()='All Products']")
	private WebElement landingHeader;
	
	@FindBy(css = "a[href='/product_details/1']")
	private WebElement firstProductViewDetailButton;
	
	@FindBy(id = "search_product")
	private WebElement searchProductTextBox;
	
	@FindBy(id = "submit_search")
	private WebElement searchButton;
	
	@FindBy(xpath = "//p[text()='Blue Top']/ancestor::div[@class='product-image-wrapper']")
	private WebElement productOneHover;
	
	@FindBy(xpath = "//p[text()='Men Tshirt']/ancestor::div[@class='product-image-wrapper']")
	private WebElement productTwoHover;
	
	@FindBy(css = "div.product-overlay a[data-product-id='2']")
	private WebElement secondProductAddToCartOnHover;
	
	@FindBy(css = "div.product-overlay a[data-product-id='1']")
	private WebElement firstProductAddToCartOnHover;
	
	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getProductPageHeader() {
		WaitUtils.waitForElementToBeVisible(driver, landingHeader);
		return this.landingHeader;
	}
	
	public ProductDetail clickViewProduct() {
		try {
			logger.debug("try block");
			firstProductViewDetailButton.click();
		}catch(ElementClickInterceptedException e) {
			e.printStackTrace();
			logger.debug("catch block");
			JavascriptUtils.javascriptScrollToView(driver, firstProductViewDetailButton);
			firstProductViewDetailButton.click();
			//JavascriptUtils.javascriptForceClick(driver, firstProductViewDetailButton);
			logger.debug("js force click");
		}
		return new ProductDetail(driver);
	}
	
	public ProductPage enterSearchTextToSearchTextBox(String searchText) {
		this.searchProductTextBox.sendKeys(searchText);
		return this;
	}
	
	public SearchProductPage clickSearchButton() {
		this.searchButton.click();
		return new SearchProductPage(driver);
	}
	
	public ProductPage hoverOnFirstProduct() {
		JavascriptUtils.javascriptScrollToView(driver, productOneHover);
		Actions action = new Actions(driver);
		action.moveToElement(productOneHover).pause(Duration.ofMillis(500)).perform();
		return this;
	}
	
	public ProductPage hoverOnSecondProduct() {
		JavascriptUtils.javascriptScrollToView(driver, productTwoHover);
		Actions action = new Actions(driver);
		action.moveToElement(productTwoHover).pause(Duration.ofMillis(500)).perform();
		return this;
	}
	
	public DialogBoxPage clickAddToCartSecondProduct() {		
		WaitUtils.waitForElementToBeClickable(driver, secondProductAddToCartOnHover);
		this.secondProductAddToCartOnHover.click();
		return new DialogBoxPage(driver);
	}
	
	public DialogBoxPage clickAddToCartFirstProduct() {		
		WaitUtils.waitForElementToBeClickable(driver, firstProductAddToCartOnHover);
		this.firstProductAddToCartOnHover.click();
		return new DialogBoxPage(driver);
	}
	
	

}
