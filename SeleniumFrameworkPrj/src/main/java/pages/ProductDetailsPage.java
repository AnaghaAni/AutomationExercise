package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


//Page Object Class for the Product Details page
public class ProductDetailsPage extends BasePage {

 // Locators
 By productNameLoc = By.cssSelector(".product-information h2");
 By categoryLoc = By.cssSelector(".product-information p");
 By costLoc = By.cssSelector(".product-information span span");
 By quantityLoc = By.id("quantity");
 By availabilityLoc = By.xpath("//b[contains(text(),'Availability:')]");
 By conditionLoc = By.xpath("//b[contains(text(),'Condition:')]");
 By brandLoc = By.xpath("//b[contains(text(),'Brand:')]");
 By addCartBtn = By.xpath("//button[@class='btn btn-default cart']");


   // Constructor
	 public ProductDetailsPage(WebDriver driver) 
	 {
	     super(driver); // Initialize BasePage
	 }
	
	 // Verify the page title contains expected text
	 public boolean isProductTitle() 
	 {
	     return pageTitle().contains("Automation Exercise - Product Details");
	 }
	
	 // Verify if URL contains product details path
	 public boolean isProductPageUrl() 
	 {
	     return getCurrentUrl().contains("/product_details/1");
	 }
	 
	
	
	 // Verify product name is visible
	 public boolean isProductName()
	 {
	     return isElementVisible(productNameLoc);
	 }
	
	 // Verify product category is visible
	 public boolean isCategory()
	 {
	     return isElementVisible(categoryLoc);
	 }
	
	 // Verify product cost is visible
	 public boolean isCost() 
	 {
	     return isElementVisible(costLoc);
	 }
	
	 // Verify quantity input is visible
	 public boolean isQuantity() 
	 {
	     return isElementVisible(quantityLoc);
	 }
	
	 // Verify product availability info is visible
	 public boolean isAvailability() 
	 {
	     return isElementVisible(availabilityLoc);
	 }
	
	 // Verify product condition info is visible
	 public boolean isCondition() 
	 {
	     return isElementVisible(conditionLoc);
	 }
	
	 // Verify product brand info is visible
	 public boolean isBrand() 
	 {
	     return isElementVisible(brandLoc);
	 }
	 
	 
	// Clicks on the "Add to Cart" button
	 public void clickOnAddCartBtn() 
	 {
		 click(addCartBtn);	
	 }
	
	 // Set the quantity for the product
	 public void setQuantity(String quantity) 
	 {
		 
	     type(quantityLoc, quantity);
	 }
	 
	 public String getSetQuantity()
	 {
		 return getAttribute(quantityLoc);
	 }
}
