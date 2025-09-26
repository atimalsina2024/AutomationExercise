package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptUtils {
	
	private JavascriptExecutor js;

	public JavascriptUtils(WebDriver driver) {
		js = (JavascriptExecutor)driver;
	}
	
	public void javascriptScrollToView(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
}
