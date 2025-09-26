package com.test.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class TestBase {
	protected WebDriver driver;
	
	public void setup() {
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--private");
		//options.addArguments("--headless");
		driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
		
	}
	
	public void teardown() {
		if(driver != null) {
			//driver.close();
			driver.quit();
		}
	}

}
