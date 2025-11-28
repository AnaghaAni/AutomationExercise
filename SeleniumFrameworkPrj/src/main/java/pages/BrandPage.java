package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrandPage extends BasePage
{
	
	
	 By brandHeader = By.cssSelector(".features_items .title");
	
	 // Constructor
	 public BrandPage(WebDriver driver) 
	 {
	     super(driver); // Initialize BasePage
	 }
	 
	 public boolean isBrandProduct()
	 {
		 return isElementVisible(brandHeader);
	 }
	 
	 

}
