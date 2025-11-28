package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitUtils {
	
	public static WebElement  waitForElementToBeClickable(WebDriver driver, By locator)
	{
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));

	}
	
	public static WebElement waitForVisibility(WebDriver driver,By locator) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	   return  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	



}
