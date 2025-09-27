package com.page.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utils.JavascriptUtils;
import utils.WaitUtils;

public class PageBase {
	
	protected WebDriver driver;
	protected static WaitUtils waitUtil;
	protected JavascriptUtils js;
	
	public PageBase(WebDriver driver) {
		PageFactory.initElements(driver, this);
		PageBase.waitUtil = new WaitUtils(driver);
		this.js = new JavascriptUtils(driver);
	}

}
