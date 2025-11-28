package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryPage extends BasePage 
{
	 //Locators
	 By categoryHeader = By.cssSelector("h2.title.text-center");
	 		
	 // Constructor
	 public CategoryPage(WebDriver driver) 
	 {
	     super(driver); // Initialize BasePage
	 }
	 
	// Get the text of the category header element
	 public boolean isCategory()
	 {
		 return isElementVisible(categoryHeader);
	 }
	 
}
