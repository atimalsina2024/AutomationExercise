package com.page.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utils.JavascriptUtils;
import utils.WaitUtils;

public class PageBase {
	
	protected WebDriver driver;
	protected WaitUtils waitUtil;
	protected JavascriptUtils js;
	
	public PageBase(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.waitUtil = new WaitUtils(driver);
		this.js = new JavascriptUtils(driver);
	}

}
