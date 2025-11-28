package tests;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import drivers.DriverManager;
import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductsPage;

public class VerifyProductQuantityInCart extends BaseTest{
	
	@Test
	public void testVerifyProductQuantityInCart() throws InterruptedException 
	{
		WebDriver driverRef = DriverManager.getWebDriver();

		logger.info("----------- TESTCASE 13: VERIFY PRODUCT Quantity In Cart  --------------");

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
		
	    // Verify All Products
	    Assert.assertTrue(productPage.isAllProduct(),"Expected product list to be visible but it is not." );
	    logger.info("Product list is displayed successfully");
	    
	    // Navigate to Product Details Page
	    productPage.clickViewProduct(1);
	    logger.info("Clicked on 'View Product' for a product");
	    
	    ProductDetailsPage productDetail = new ProductDetailsPage(driverRef);
	    Assert.assertTrue(productDetail.isProductPageUrl() && productDetail.isProductTitle(),"Expected Product Details Page to be visible but it is not.");
	    logger.info("Product Details Page is visible successfully");
	    
	    
	    //Set product quantity
	    productDetail.setQuantity("4");

	    //Store the set quantity 
	    int cartQuantity = Integer.parseInt(productDetail.getSetQuantity());
	    
	    //Click Add to Cart button
	    productDetail.clickOnAddCartBtn();
	   
	    //Click on View Cart from popup
	    productPage.clickOnViewCart();
	    
	    CartPage cartPage = new CartPage(driverRef);
		
		// Verify that Cart Page is displayed successfully
	    Assert.assertTrue(
	    		cartPage. isCartTitle() && cartPage.isCartUrl(),
		        "Expected Cart Page to be visible but it is not."
	    );
	    logger.info("Cart Page is visible successfully");
	    
	    
	   // Verify that the cart quantity matches the quantity set before adding to cart
	    Assert.assertEquals(
	    		cartPage.inCartQuantity(0), cartQuantity,
	            "Expected total cart quantity to match added to the cart with the quantity that is displayed in the cart, but it does not."
	    		);
	    logger.info("Verified total cart quantity successfully");		
	}

}
