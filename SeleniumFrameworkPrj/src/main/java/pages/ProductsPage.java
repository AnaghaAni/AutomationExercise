package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.waitUtils;


	

//Page Object Class for the Products Page
public class ProductsPage extends BasePage {

	 // Locators
	 By searchLoc = By.id("search_product");
	 By searchBtn = By.id("submit_search");
	 By allProductListLoc = By.cssSelector(".single-products");
	
	 By searchTitleLoc = By.cssSelector(".features_items>.title.text-center");
	 By allProductLoc = By.xpath("//h2[text()='All Products']");
	 By viewProductLoc = By.xpath("//a[@href='/product_details/1']");
	 By searchProductList = By.cssSelector(".productinfo.text-center p");
	 By viewCartLoc = By.cssSelector("li>a[href='/view_cart']");
	 By productCostLoc = By.cssSelector(".productinfo > h2");
	 By continueShoppingBtnLoc = By.xpath("//button[text()='Continue Shopping']");
	 By popUploc = By.cssSelector(".modal-content");
	 
	 
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
	
	
	
	 // Verify if All Products section is visible
	 public boolean isAllProduct() 
	 {
	     return isElementVisible(allProductLoc);
	 }
	
	 // Verify if search title is visible
	 public boolean isSearchTitle() 
	 {
	     return isElementVisible(searchTitleLoc);
	 }
	 
	 
	 // Check if search results are displayed
	 public boolean isSearchedResultDisplayed() 
	 {
	     return productList().size() > 0;
	 }
	   
	 
	 // Search a product by name
	 public void searchProduct(String productName)
	 {
	     type(searchLoc, productName);
	     click(searchBtn);
	 }
	
	 
	 // Click on "View Product" link for first product
	 public void clickViewProduct(int productId) 
	 {
		 By viewProductLoc = By.xpath("//a[@href='/product_details/"+productId+"']");
		 scrollIntoView(findElement(viewProductLoc));
		 click(viewProductLoc);
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
	

	 
	// Adds a product to the cart based on its productId	
	  public void addProductToCart(int productId) 
	  {
		   By addToCartBtn = By.xpath("//a[@data-product-id='"+productId+"']");
		   moveToElement(findElements(allProductListLoc).get(productId));
		   scrollIntoView(findElement(addToCartBtn));
		   click(addToCartBtn);
	  }
	  
	 // Get product name in cart by productId
	  public String getProductNameIncart(int productId)
	  {
		  By productName = By.xpath("//a[@data-product-id='"+productId+"']//ancestor::div[@class='productinfo text-center']//p");
		  return pageText(productName);
	  }
	  

	  // Get product price in cart by productId
	  public String getProductPriceIncart(int productId)
	  {
		  By productPrice = By.xpath("//a[@data-product-id='"+productId+"']/ancestor::div[@class='productinfo text-center']/h2");
		  return pageText( productPrice );
	  }
	  
	  // Click "View Cart" button in popup
	  public void clickOnViewCart()
	  {
		 waitUtils.waitForVisibility(driver,popUploc);
		 jsClick(waitUtils.waitForElementToBeClickable(driver,viewCartLoc));	
	
	  }
	 
	 // Click "Continue Shopping" button
	  public void clickOnContinueShoppingBtn()
	  {
		  click(continueShoppingBtnLoc);
	  }
}

