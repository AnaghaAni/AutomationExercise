package tests;

import java.util.Map;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import dataProviders.DataProviders;
import drivers.DriverManager;
import pages.AccountDeletedPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

public class LoginTest extends BaseTest 
{
	
	
	/**
	 * LoginTest contains test cases related to user login functionality.
	 *
	 * Each test case:
	  *
	 *   1.Extends {@link base.BaseTest} to use setup/teardown
	 *   2.Uses {@link driver.DriverManager} to get thread-safe WebDriver
	 *   3.Interacts with {@link pages.LoginPage} (Page Object Model)
	 * 
	 */

	@Test(dataProvider="loginData",dataProviderClass=DataProviders.class)
	public void testLogin(Map<String,String>data)
	{
		WebDriver driver = DriverManager.getWebDriver();
		
		 logger.info("------- TESTCASE 2 : LOGIN USER WITH  CORRECT EMAIL AND  PASSWORD ----------");
		
		//Verify that the Home Page is displayed correctly.
	    HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.isHomePage(),  "Expected Home Page to be visible but it is not");
		logger.info("Home Page is displayed successfully");
		
		// Navigate to Signup/Login
	    homePage.clickSignUpORLogin();
	    logger.info("Navigated to Signup/Login page");
	    
	    
	    //Verify that the login is displayed correctly.
	    LoginPage loginPage = new LoginPage(driver);
	    Assert.assertTrue(loginPage.isLogin(), "Expected login section to be visible but it is not");
	    logger.info("Login section is visible");
	    
	    
	    //Perform login
		loginPage.enterMail(data.get("username"));
		loginPage.enterPassword(data.get("password"));
		loginPage.clickOnLoginBtn();
		logger.info("fill details and clicked on login button");
		
		
		//Verify User Logged In
		 MyAccountPage myAccPage = new MyAccountPage(driver);
		 Assert.assertTrue(myAccPage.isLoggedInUser(), "Expected user should login, but it is not ");
		 logger.info("User logged in successfully: {}", myAccPage.getLoggedInUserText());
		 
		 //Delete Account
		 myAccPage.clickDeleteAcc();
         logger.info("Clicked on Delete Account button");
         
         //Verify Account Deletion
         AccountDeletedPage accDelPage = new AccountDeletedPage(driver);
         logger.info("Account has been deleted successfully");
         accDelPage.continueClick();
         

	}
	
	
    
}
