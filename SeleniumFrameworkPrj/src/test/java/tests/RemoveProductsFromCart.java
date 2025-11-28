package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import drivers.DriverManager;
import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;

public class RemoveProductsFromCart extends BaseTest 
{
	@Test
	@Parameters({"prdId"})
	public void testRemoveProductsFromCart(String prdId)
	{
		
		
		WebDriver driverRef = DriverManager.getWebDriver();
		
		
		logger.info("----------- TESTCASE 17 :   Remove Products From Cart --------------");
		
		
		// Verify Home Page
		HomePage homePage = new HomePage(driverRef);
		Assert.assertTrue(homePage.isHomePage(), "Home Page is NOT visible.");
		logger.info("Home Page is displayed successfully");
		

		// Navigate to Products Page
		homePage.clickOnProducts();
		logger.info("Clicked on 'Products' menu");

		ProductsPage productPage = new ProductsPage(driverRef);
		Assert.assertTrue(productPage.isProductPageUrl() && productPage.isProductTitle(),
		        "Products Page is NOT visible.");
		logger.info("Products Page is displayed successfully");
		
		// Add  product
    	productPage.addProductToCart(Integer.parseInt(prdId));
    	logger.info("Add product to cart");
    	
		// Go to Cart Page
		productPage.clickOnViewCart();
		logger.info("Navigated to Cart Page");
    	
    	CartPage cartPage = new CartPage(driverRef);
		
		// Verify that Cart Page is displayed successfully
	    Assert.assertTrue(
	    		cartPage. isCartTitle() && cartPage.isCartUrl(),
		        "Expected Cart Page to be visible but it is not."
		    );
	   logger.info("Cart Page is visible successfully");
	   
	   cartPage.deleteProductFromCart(Integer.parseInt(prdId));
	   
	   //Verify that cart is empty
	   Assert.assertTrue(cartPage.isCartEmpty(), "Expected to have cart empty, but it is not");
	   logger.info("Cart is empty as expected.");
	}
}
