package com.automation.core.base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.automation.core.config.ConfigurationManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {
	private static final Logger logger = LogManager.getLogger(WebDriverFactory.class);
	private static final ThreadLocal<WebDriver> threadLocalDriver =  new ThreadLocal<WebDriver>();
	private  static ConfigurationManager config = ConfigurationManager.getInstance();
	
	private WebDriverFactory() {
	}
	
	public static WebDriver createDriver() {
		WebDriver driver;
		String browser = config.getProperty("browser");
		boolean isRemote = Boolean.parseBoolean(config.getProperty("isRemote"));
		
		if(isRemote) {
			driver = initializeRemoveDriver(browser);
			threadLocalDriver.set(driver);
		}
		else {
			driver = initializeLocalDriver(browser);
			threadLocalDriver.set(driver);
		}
				
		return driver;
	}
	
	private static WebDriver initializeLocalDriver(String browser) {
		WebDriver driver ;
		switch(browser.toLowerCase()) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		
		case "safari":
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;
			
		default:
			logger.warn("invalid browser, defaulting to firefox");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		}
		return driver;

	}
	
	private static WebDriver initializeRemoveDriver(String browser) {
		
		try {
			URL gridUrl = new URL(config.getProperty("grid.url"));
			switch(browser.toLowerCase()) {
			case "chrome":
				return new RemoteWebDriver(gridUrl,getChromeOptions());
			case "firefox":
				return new RemoteWebDriver(gridUrl, getFirefoxOptions());
			// implement edge and safari later
			default:
				return new RemoteWebDriver(gridUrl, getFirefoxOptions());
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to create remote driver");
		}
		
	}
	
	private static ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		return options;
		
	}

	public static WebDriver getDriver() {
		return threadLocalDriver.get();
	}
	
	private static FirefoxOptions getFirefoxOptions() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.dir", System.getProperty("user.dir") + File.separator + config.getProperty("download.path"));
		//profile.setPreference("browser.download.dir", System.getProperty("user.dir") + File.separator + config.getProperty("download.path"));
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
		profile.setPreference("pdfjs.disabled", true);
		profile.setPreference("browser.download.manager.showWhenStarting", false);
        FirefoxOptions options = new FirefoxOptions();
		options.setProfile(profile);
        options.addArguments("--private");
        //options.addArguments("--headless");
        return options;
	}
	
	public static void quitWebDriver() {
		WebDriver driver = threadLocalDriver.get();
		try {
			if(driver != null) {
				driver.quit();
				logger.info("driver closed successfully");
			}
		}catch (Exception e) {
			logger.error("Error closing the driver");
		}
		finally {
			threadLocalDriver.remove();
			logger.info("driver removed from threadlocal");
		}
	}

}
