package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


	

//Page Object Class for the Products Page
public class ProductsPage extends BasePage {

	 // Locators
	 By searchLoc = By.id("search_product");
	 By searchBtn = By.id("submit_search");
	 By searchTitleLoc = By.cssSelector(".features_items>.title.text-center");
	 By allProductLoc = By.xpath("//h2[text()='All Products']");
	 By viewProductLoc = By.xpath("//a[@href='/product_details/1']");
	 By searchProductList = By.cssSelector(".productinfo.text-center p");
	
	 // Constructor
	 public ProductsPage(WebDriver driver) 
	 {
	     super(driver); // Initialize BasePage
	 }
	
	 // Verify the page title contains expected text
	 public boolean isProductTitle() 
	 {
	     return pageTitle().contains("Automation Exercise - All Products");
	 }
	
	 // Verify if URL contains products path
	 public boolean isProductPageUrl() 
	 {
	     return getCurrentUrl().contains("/products");
	 }
	
	 // Click on "View Product" link for first product
	 public void clickViewProduct() 
	 {
	     click(viewProductLoc);
	 }
	
	 // Verify if All Products section is visible
	 public boolean isAllProduct() 
	 {
	     return isElementVisible(allProductLoc);
	 }
	
	 // Search a product by name
	 public void searchProduct(String productName)
	 {
	     type(searchLoc, productName);
	     click(searchBtn);
	 }
	
	 // Verify if search title is visible
	 public boolean isSearchTitle() 
	 {
	     return isElementVisible(searchTitleLoc);
	 }
	
	 // Get list of searched product names
	 public ArrayList<String> productList() 
	 {
	     List<WebElement> searchedProductList = findElements(searchProductList);
	     ArrayList<String> productList = new ArrayList<>();
	     for (WebElement search : searchedProductList) {
	         productList.add(search.getText());
	     }
	     return productList;
	 }
	
	 // Check if search results are displayed
	 public boolean isSearchedResultDisplayed() 
	 {
	     return productList().size() > 0;
	 }
}

