package tests;

import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import dataProviders.DataProviders;
import drivers.DriverManager;
import pages.AccountDeletedPage;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.OrderPlaced;
import pages.PaymentPage;
import pages.ProductsPage;

public class PlaceOrderLoginBeforeCheckout extends BaseTest
{
	@Test(dataProvider="placeOrderWithLoginData",dataProviderClass=DataProviders.class)
	public void testPlaceOrderLoginBeforeCheckout(Map<String,String>data)
	{
		WebDriver driver = DriverManager.getWebDriver();
		
		logger.info("----------- TESTCASE 15: Place Order: Register before Checkout  --------------");
	
		// Verify Home Page
		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isHomePage(), "Home Page is NOT visible.");
		logger.info("Home Page is displayed successfully");
		
		
		// Navigate to Signup/Login
	    homePage.clickSignUpORLogin();
	    logger.info("Navigated to Signup/Login page");
	    
	    
	    //Verify that the login is displayed correctly.
	    LoginPage loginPage = new LoginPage(driver);
	    Assert.assertTrue(loginPage.isLogin(), "Expected login section to be visible but it is not");
	    logger.info("Login section is visible");
	    
	    
	    //Perform login
		loginPage.enterMail(data.get("email"));
		loginPage.enterPassword(data.get("password"));
		loginPage.clickOnLoginBtn();
		logger.info("fill details and clicked on login button");
		
		
		//Verify User Logged In
		MyAccountPage myAccPage = new MyAccountPage(driver);
		Assert.assertTrue(myAccPage.isLoggedInUser(), "Expected user should login, but it is not ");
		logger.info("User logged in successfully: {}", myAccPage.getLoggedInUserText());
		
		// Navigate to Products Page
		homePage.clickOnProducts();
		logger.info("Clicked on 'Products' menu");

		ProductsPage productPage = new ProductsPage(driver);
		Assert.assertTrue(productPage.isProductPageUrl() && productPage.isProductTitle(),
			        "Products Page is NOT visible.");
		logger.info("Products Page is displayed successfully");
			
		// Add  product
	    productPage.addProductToCart(Integer.parseInt(data.get("productId")));
	    logger.info("Add product to cart");
	    	
		// Go to Cart Page
		productPage.clickOnViewCart();
		logger.info("Navigated to Cart Page");
	    	
	    CartPage cartPage = new CartPage(driver);
			
		// Verify that Cart Page is displayed successfully
		Assert.assertTrue(
		    		cartPage. isCartTitle() && cartPage.isCartUrl(),
			        "Expected Cart Page to be visible but it is not."
			    );
		logger.info("Cart Page is visible successfully");
	   
	   

	   
	
	    //Click on "Proceed Checkout"Button
		cartPage.clickOnCheckoutBtn();
		logger.info("Clicked on Checkout Button");
		
		
		// Prepare expected delivery address
		Map<String, String> expectedAddr = new LinkedHashMap<>();
		expectedAddr.put("Name", data.get("title") + ". " + data.get("firstName") + " " + data.get("lastName"));
		expectedAddr.put("Company", data.get("company"));
		expectedAddr.put("Address1", data.get("address1"));
		expectedAddr.put("StateZip", data.get("city") + " " + data.get("state") + " " + data.get("zipcode"));
		expectedAddr.put("Country", data.get("country"));
		expectedAddr.put("MobileNo", data.get("mobileNo"));

		CheckoutPage checkoutPage = new CheckoutPage(driver);

		// Verify delivery address
		Assert.assertTrue(checkoutPage.isDeliveryAddrDisplayed(), "Delivery address is NOT displayed.");
		logger.info("Delivery address section is visible");

		for (String key : expectedAddr.keySet()) 
		{
		    String exp = expectedAddr.get(key);
		    String act = checkoutPage.getDeliveryAddress().get(key);
		    Assert.assertEquals(act, exp, "{} mismatch! Expected: {} but found: {}".formatted(key, exp, act));
		    logger.info("{} verified: {}", key, act);
		}

		// Verify billing address
		Assert.assertTrue(checkoutPage.isBillingAddrDisplayed(), "Billing address is NOT displayed.");
		logger.info("Billing address section is visible");

		for (String key : expectedAddr.keySet()) 
		{
		    String exp = expectedAddr.get(key);
		    String act = checkoutPage.getBillingAddress().get(key);
		    Assert.assertEquals(act, exp, "{} mismatch! Expected: {} but found: {}".formatted(key, exp, act));
		    logger.info("Billing {} verified: {}", key, act);
		}

		// Enter comment and place order
		checkoutPage.setComment("Good style of dresses");
		checkoutPage.clickOnPlaceOrder();
		logger.info("Placed the order with comment: Good style of dresses");

		// Payment Page
		PaymentPage paymentPage = new PaymentPage(driver);
		Assert.assertTrue(paymentPage.isPaymentTitle() && paymentPage.isPaymentUrl(),
		        "Payment Page is NOT visible.");
		logger.info("Payment Page is displayed successfully");

		paymentPage.entercardName(data.get("cardName"));
		paymentPage.entercardNo(data.get("cardNo"));
		paymentPage.enterCvc(data.get("cvc"));
		paymentPage.enterMonth(data.get("expmonth"));
		paymentPage.enterYear(data.get("expyear"));
		paymentPage.clickOnPayBtn();
		logger.info("Entered card details and clicked Pay");

		// Verify payment success
//		Assert.assertEquals(paymentPage.getSuccessMsg(), "Your order has been placed successfully!",
//		        "Payment success message NOT displayed.");
//		logger.info("Payment completed successfully");

		// Order Placed Page
		OrderPlaced order = new OrderPlaced(driver);
		Assert.assertTrue(order.isOrderTitle(), "Order Page is NOT visible.");
		logger.info("Order Page is displayed successfully");

		
		Assert.assertEquals(order.getOrderPlacedText(), "ORDER PLACED!",
		        "Order Placed message NOT displayed.");
		logger.info("Order placed message verified: {}", order.getOrderPlacedText());

		// Click Continue on Order Placed page
		order.clickContinue();
		logger.info("Clicked on 'Continue' button on Order Placed page");

		// Verify that user is still logged in
		Assert.assertTrue(myAccPage.isLoggedInUser(), 
		        "User is NOT logged in after placing the order.");
		logger.info("User is logged in successfully: {}", myAccPage.getLoggedInUserText());

		// Delete the account
		myAccPage.clickDeleteAcc();
		logger.info("Clicked on 'Delete Account' button");

		// Verify account deletion success
		AccountDeletedPage accDelPage = new AccountDeletedPage(driver);
		Assert.assertTrue(accDelPage.isAccDeleted(), 
		        "Account deletion message NOT displayed; account may not have been deleted.");
		logger.info("Account deleted successfully");

		// Click Continue on Account Deleted page
		accDelPage.continueClick();
		logger.info("Clicked on 'Continue' button after account deletion");

		//  Verify that user is redirected to Home Page after account deletion	
		Assert.assertTrue(homePage.isHomePage(), 
		        "User is NOT redirected to Home Page after account deletion.");
		logger.info("User redirected to Home Page successfully after account deletion");
	}
}
