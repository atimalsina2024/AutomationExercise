package com.page.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.page.base.PageBase;

import utils.WaitUtils;

public class SearchProductPage extends PageBase{

	@FindBy(css = "div.features_items h2.title")
	private WebElement landingPageHeader;
	
	@FindBy(css = "div.productinfo p")
	private List<WebElement> allSearchedItems;
	
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
	
	

}
