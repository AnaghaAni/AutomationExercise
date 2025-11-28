package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import drivers.DriverManager;
import pages.HomePage;
import pages.ProductsPage;

public class ViewAndCartBrandProducts extends BaseTest 
{
	
	public void testViewAndCartBrandProducts()
	{
		WebDriver driverRef = DriverManager.getWebDriver();
	
		logger.info("----------- TESTCASE 18 : View Category Products --------------");
	
		// Verify Home Page
		HomePage homePage = new HomePage(driverRef);
		Assert.assertTrue(homePage.isHomePage(), "Home Page is NOT visible.");
		logger.info("Home Page is displayed successfully.");
		
		

		// Navigate to Products Page
		homePage.clickOnProducts();
		logger.info("Clicked on 'Products' menu");

		ProductsPage productPage = new ProductsPage(driverRef);
		Assert.assertTrue(productPage.isProductPageUrl() && productPage.isProductTitle(),
		        "Products Page is NOT visible.");
		logger.info("Products Page is displayed successfully");
		
	}
	

}
