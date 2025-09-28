package com.page.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utils.JavascriptUtils;

public class PageBase {
	
	protected WebDriver driver;
	protected JavascriptUtils js;
	
	public PageBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.js = new JavascriptUtils(driver);
	}

}
