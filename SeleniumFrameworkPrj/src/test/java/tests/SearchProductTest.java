package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import dataProviders.DataProviders;
import drivers.DriverManager;
import pages.HomePage;
import pages.ProductsPage;

public class SearchProductTest extends BaseTest {
	@Test(dataProvider="searchProducts", dataProviderClass = DataProviders.class)
	public void testSearchProduct(String keyword)
	{
		 WebDriver driverRef = DriverManager.getWebDriver();
		 
		 logger.info("------- TESTCASE 9 : SEARCH PRODUCT PAGE ----------");

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
		    
		    
		    productPage.searchProduct(keyword);
		    
		 
		   SoftAssert soft = new SoftAssert(); 
		    
		    Assert.assertTrue(productPage.isSearchTitle(), "Expected 'SEARCHED PRODUCTS' section to be visible,but it is not");
		    logger.info("Search results are visible");
		    
		    Assert.assertTrue(productPage.isSearchedResultDisplayed(),"Expected products after search but found none");
		    logger.info("Products are visible after search");
		    
		   
		    for(String product:productPage.productList())
		    {
		    	soft.assertTrue(product.toLowerCase().contains(keyword.toLowerCase()),
		    			 "Product does not match search keyword");
		    }
		    
		    logger.info("Product related to search are visible");
		  
		    soft.assertAll();
	
	}

}
