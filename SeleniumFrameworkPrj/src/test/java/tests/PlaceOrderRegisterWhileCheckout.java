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
import pages.CreatedAccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.OrderPlaced;
import pages.PaymentPage;
import pages.ProductsPage;
import pages.SignUpPage;

public class PlaceOrderRegisterWhileCheckout extends BaseTest
{
	@Test(dataProvider="placeOrder",dataProviderClass=DataProviders.class)
	public void testPlaceOrderRegisterWhileCheckout (Map<String,String>data)
	{
		WebDriver driverRef = DriverManager.getWebDriver();

		logger.info("----------- TESTCASE 14 :  Place Order Register While Checkout --------------");

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
    	productPage.addProductToCart(Integer.parseInt(data.get("productId")));
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
	   
	   
	   cartPage.clickOnCheckoutBtn();
	   logger.info("Clicked on Checkout Button");
	   
	   cartPage.clickOnRegisterOrLogin();
	   logger.info("Navigated to Login/Signup Page");
	   
	   
	   //  Verify Signup section
	   LoginPage loginPage = new LoginPage(driverRef);
	   Assert.assertTrue(loginPage.isSignup(), "Expected Signup section to be visible but it is not");
	   logger.info("Signup section is visible");

	   // Perform signup
	   loginPage.enterUsername(data.get("username"));
	   loginPage.enterEmailAddress(data.get("email"));
	   loginPage.clickOnSignUpBtn();
	   logger.info("Performed signup with username: {} and email: {}",data.get("username"), data.get("email"));

	   //Verify Account Information section
	   SignUpPage signupPage = new SignUpPage(driverRef);
	   Assert.assertTrue(signupPage.isEnterAccInfo(), "Expected Account Information section but it is not visible");
	   logger.info("Account Information section is visible");

	   	//Fill account details
	    signupPage.selectTitle(data.get("title"));
	    signupPage.enterPassword(data.get("password"));
	    signupPage.selectDay(data.get("day"));
	    signupPage.selectMonth(data.get("month"));
	    signupPage.selectYear(data.get("year"));
	    signupPage.enableNewsletterSignup();
	    signupPage.clickSpecialOffersCheckbox();
	    signupPage.enterFirstName(data.get("firstName"));
	    signupPage.enterLastName(data.get("lastName"));
	    signupPage.enterCompany(data.get("company"));
	    signupPage.enterAddress1(data.get("address1"));
	    signupPage.selectCountry(data.get("country"));
	    signupPage.enterState(data.get("state"));
	    signupPage.enterCity(data.get("city"));
	    signupPage.enterZipCode(data.get("zipcode"));
	    signupPage.enterMobileNo(data.get("mobileNo"));
	    signupPage.clickCreateAccBtn();
	    logger.info("Filled all account details and submitted the form");

	    //Verify account creation success
	    CreatedAccountPage createAccPage = new CreatedAccountPage(driverRef);
	    Assert.assertTrue(createAccPage.isAccCretedMsg(), "Expected Account Created message but not found");
	    logger.info("Account has been created successfully");
	    createAccPage.continueClick();

	    // Verify user is logged in
	    MyAccountPage myAccPage = new MyAccountPage(driverRef);
	    Assert.assertTrue(myAccPage.isLoggedInUser(), "Expected user to be logged in but it is not");
	    logger.info("User logged in successfully:" +myAccPage.getLoggedInUserText());
	    
	    //Click on cart
	    homePage.clickOnCart();
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

		CheckoutPage checkoutPage = new CheckoutPage(driverRef);

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
		PaymentPage paymentPage = new PaymentPage(driverRef);
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
		OrderPlaced order = new OrderPlaced(driverRef);
		Assert.assertTrue(order.isOrderTitle(), "Order Page is NOT visible.");
		logger.info("Order Page is displayed successfully");

		
		Assert.assertEquals(order.getOrderPlacedText(), "ORDER PLACED!"
,
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
		AccountDeletedPage accDelPage = new AccountDeletedPage(driverRef);
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
