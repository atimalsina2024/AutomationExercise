package com.test.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import utils.PropertyUtil;

public class TestBase {
	protected static WebDriver driver;
	
	@BeforeTest
	public void setup() {
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--private");
		//options.addArguments("--headless");
		driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
		driver.get(PropertyUtil.get("baseUrl"));
	}
	
	@AfterTest
	public void teardown() {
		if(driver != null) {
			//driver.close();
			driver.quit();
		}
	}

}
