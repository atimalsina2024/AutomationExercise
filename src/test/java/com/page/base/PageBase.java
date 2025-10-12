package com.page.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
	
	protected WebDriver driver;
	private static final Logger logger = LogManager.getLogger(PageBase.class);
	
	public PageBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logger.debug("PageFactory initialized in PageBase");
	}

}
