package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import drivers.DriverManager;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductsPage;

public class ProductDetailsTest extends BaseTest{
	
	
	@Test
	public void testProductTest()
	{
		
	    WebDriver driverRef = DriverManager.getWebDriver();
	    
	    logger.info("------- TESTCASE 8 : VERIFY ALL PRODUCTS AND PRODUCT DETAIL PAGE ----------");

	    // Verify Home Page
	    HomePage homePage = new HomePage(driverRef);
	    Assert.assertTrue(homePage.isHomePage(),
	        "Expected Home Page to be visible but it is not."
	    );
	    logger.info("Home Page is displayed successfully");
	    
	    

	    // Navigate to Products Page
	    homePage.clickOnProducts();
	    logger.info("Clicked on 'Products' menu");

	    ProductsPage productPage = new ProductsPage(driverRef);
	    Assert.assertTrue(productPage.isProductPageUrl() && productPage.isProductTitle(),
	        "Expected Products Page to be visible but it is not."
	    );
	    logger.info("Products Page is visible successfully");
	    
	    
	    

	    // Verify All Products
	    Assert.assertTrue(productPage.isAllProduct(),"Expected product list to be visible but it is not." );
	    logger.info("Product list is displayed successfully");

	    // Navigate to Product Details Page
	    productPage.clickViewProduct();
	    logger.info("Clicked on 'View Product' for a product");

	    ProductDetailsPage productDetail = new ProductDetailsPage(driverRef);
	    Assert.assertTrue(productDetail.isProductPageUrl() && productDetail.isProductTitle(),"Expected Product Details Page to be visible but it is not.");
	    logger.info("Product Details Page is visible successfully");

	    // Verify Product Details
	    Assert.assertTrue(productDetail.isProductName(),"Expected product name to be visible but it is not." );
	    logger.info("Product name is visible");

	    Assert.assertTrue(productDetail.isCategory(),"Expected product category to be visible but it is not." );
	    logger.info("Product category is visible");

	    Assert.assertTrue(productDetail.isCost(), "Expected product cost to be visible but it is not.");
	    logger.info("Product cost is visible");

	    Assert.assertTrue(productDetail.isAvailability(),"Expected product availability to be visible but it is not.");
	    logger.info("Product availability is visible");

	    Assert.assertTrue(productDetail.isCondition(),"Expected product condition to be visible but it is not.");
	    logger.info("Product condition is visible");

	    Assert.assertTrue( productDetail.isBrand(),"Expected product brand to be visible but it is not.");
	    logger.info("Product brand is visible");
        
        
	}

}
