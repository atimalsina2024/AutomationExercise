package com.ui.page.pages;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.ui.page.base.PageBase;

import utils.JavascriptUtils;
import utils.WaitUtils;

public class SearchProductPage extends PageBase{

	@FindBy(css = "div.features_items h2.title")
	private WebElement landingPageHeader;
	
	@FindBy(css = "div.productinfo p")
	private List<WebElement> allSearchedItems;
	
	@FindBy(css = "div.single-products")
	private List<WebElement> searchedProductElements;
	
	private String addToCartCss = "div.overlay-content a";
	
	@FindBy(linkText = "Cart")
	private WebElement cartButton;
	
	public SearchProductPage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getLandingPageHeader() {
		WaitUtils.waitForElementToBeVisible(driver, landingPageHeader);
		return this.landingPageHeader;
	}
	
	public List<String> getAllSearchResultProductName(){
		return allSearchedItems
			.stream()
			.map(element -> element.getText())
			.collect(Collectors.toList());
	}
	
	public SearchProductPage hoverOnProduct(WebElement element) {
		JavascriptUtils.javascriptScrollToView(driver, element);
		Actions action = new Actions(driver);
		action.moveToElement(element).pause(Duration.ofMillis(500)).perform();
		return this;
	}
	
	public DialogBoxPage addProductToCart(WebElement div) {
		div.getAttribute("outerHTML");
		WaitUtils.waitForElementToBeClickable(driver,div.findElement(By.cssSelector(addToCartCss)));
		div.findElement(By.cssSelector(addToCartCss)).click();
		return new DialogBoxPage(driver);	
	}
	
	public List<WebElement> getSearchedProductElements(){
		return this.searchedProductElements;
	}
	
	public CartPage clickCartButton() {
		this.cartButton.click();
		return new CartPage(driver);
	}
	
	

}
