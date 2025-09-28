package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	//private static final int DEFAULT_TIMEOUT = 10;
	//private WebDriverWait wait;
	
	//public WaitUtils(WebDriver driver) {
		//wait = new WebDriverWait(driver,Duration.ofSeconds(DEFAULT_TIMEOUT));
	//}
	
	public static void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
