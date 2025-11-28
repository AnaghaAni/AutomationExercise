package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import drivers.DriverManager;
import pages.CartPage;
import pages.HomePage;

public class SubscriptionInCartPageTest extends BaseTest {
	
	@Test
	public void testSubscriptionInCartPageTest()
	{
		
		WebDriver driverRef = DriverManager.getWebDriver();
		
		 logger.info("------- TESTCASE 11 : VERIFY SUBSCRIPTION IN CART PAGE ----------");

		// Verify Home Page
		HomePage homePage = new HomePage(driverRef);
		Assert.assertTrue(homePage.isHomePage(),"Expected Home Page to be visible, but it is not.");
		logger.info("Home Page is displayed successfully");
		
		
		homePage.clickOnCart();
		logger.info("Clicked on 'Cart' link");
		
		CartPage cartPage = new CartPage(driverRef);
		Assert.assertTrue(cartPage.isCartTitle() && cartPage.isCartUrl(),"Expected Cart Page to be visible, but it is not.");
		logger.info("Cart Page is displayed successfully");
		
		// Enter subscription email
		String email = "usersname3@gmail.com";
		homePage.enterSubscribeEmail(email);
	    logger.info("Entered subscription email: {}", email);

		// Click Subscribe button
		homePage.clickSubscribeBtn();
		logger.info("Clicked on 'Subscribe' button");

		// Verify subscription success message
		Assert.assertTrue(homePage.isSubscribeMsg(),"Expected subscription success message to be visible, but it is not.");
		logger.info("Subscription success message displayed successfully for email: {}", email);

	}

}
