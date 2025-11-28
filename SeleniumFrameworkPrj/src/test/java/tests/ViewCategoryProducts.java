package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import drivers.DriverManager;
import pages.CategoryPage;
import pages.HomePage;

public class ViewCategoryProducts extends BaseTest
{
	@Test
	public void testViewCategoryProducts()
	{
		WebDriver driverRef = DriverManager.getWebDriver();

		logger.info("----------- TESTCASE 18 : View Category Products --------------");

		// Verify Home Page
		HomePage homePage = new HomePage(driverRef);
		Assert.assertTrue(homePage.isHomePage(), "Home Page is NOT visible.");
		logger.info("Home Page is displayed successfully.");
		
		

		// Verify Category header in the left sidebar
		Assert.assertEquals(homePage.getCategoryHeader(), "CATEGORY",
		        "Expected 'Category' header at the left-side bar is NOT visible.");
		logger.info("Category header is visible at the left-side bar.");

		//Women Category 
		logger.info("Clicking on 'Women' category -> Dress");
		homePage.selectWomenSubCategory("Dress");

		CategoryPage categoryPage = new CategoryPage(driverRef);
		Assert.assertTrue(categoryPage. isCategory(), 
		        "Category page for Women - Dress is NOT displayed.");
		logger.info("'Women - Dress Products' page is displayed successfully.");

		// Navigate back to Home
		driverRef.navigate().back();
		logger.info("Navigated back to Home Page.");

		// Men Category 
		logger.info("Clicking on 'Men' category -> Tshirts");
		homePage.selectMenSubCategory("Tshirts");

		//categoryPage = new CategoryPage(driverRef); // Re-instantiate after navigation
		Assert.assertTrue(categoryPage. isCategory(), 
		        "Category page for Men - Tshirts is NOT displayed.");
		logger.info("'Men - Tshirts Products' page is displayed successfully.");

		// Navigate back to Home
		driverRef.navigate().back();
		logger.info("Navigated back to Home Page.");

		//  Kids Category 
		logger.info("Clicking on 'Kids' category -> Dress");
		homePage.selectKidsSubCategory("Dress");

		//categoryPage = new CategoryPage(driverRef); // Re-instantiate after navigation
		Assert.assertTrue(categoryPage.isCategory(), 
		        "Category page for Kids - Dress is NOT displayed.");
		logger.info("'Kids - Dress Products' page is displayed successfully.");
		
	}
}
