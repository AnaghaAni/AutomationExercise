package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import drivers.DriverManager;
import pages.HomePage;
import pages.LoginPage;

public class LoginwithInvalidCredantials extends BaseTest{
	
	@Test
	@Parameters({"loginmail","loginpassword"})
	public void testLoginWithInvalidData(String loginmail, String loginpassword )
	{
		
		WebDriver driver = DriverManager.getWebDriver();
		
		
		 logger.info("------- TESTCASE 3 : LOGIN USER WITH  INCORRECT EMAIL AND  PASSWORD ----------");
		
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
		loginPage.enterMail(loginmail);
		loginPage.enterPassword(loginpassword);
		loginPage.clickOnLoginBtn();
		logger.info("fill details and clicked on login button");
		
		Assert.assertTrue(loginPage.isLoginErr(),"Expectd to show 'email or password is incorrect',but it is not");
		
	}

}
