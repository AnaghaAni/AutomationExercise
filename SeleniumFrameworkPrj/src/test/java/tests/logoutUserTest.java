package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import drivers.DriverManager;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

public class logoutUserTest extends BaseTest{
	@Test
	@Parameters({"logoutMail","logoutPassword"})
	public void logoutTest(String logoutMail, String logoutPassword)
	{
		
		//Verify Home Page
		WebDriver driverRef = DriverManager.getWebDriver();
		
		 logger.info("------- TESTCASE 4 : LOGOUT USER  ----------");
		
		HomePage homePage = new HomePage(driverRef);
		Assert.assertTrue(homePage.isHomePage(),"Expected Home Page to be visible but it is not");
		logger.info("Home Page is displayed successfully");
		homePage.clickSignUpORLogin();
		logger.info("Navigated to Signup/Login page");
		
		//Verify Login Page
		LoginPage loginPage = new LoginPage(driverRef);
		Assert.assertTrue(loginPage.isLogin(),"Expected Login Page to be visible but it is not");
		logger.info("Login Page is displayed successfully");
		loginPage.enterMail(logoutMail);
		loginPage.enterPassword(logoutPassword);
		loginPage.clickOnLoginBtn();
        logger.info("Entered credentials and clicked Login button");
		
        
        //Verify User Logged In
		MyAccountPage myAccPage = new MyAccountPage(driverRef);
		Assert.assertTrue(myAccPage.isLoggedInUser()," Expected user to be logged in but validation failed");
		logger.info("User logged in successfully as: {}", myAccPage.getLoggedInUserText());
		myAccPage.clickOnLogout();
		logger.info("User clicked Logout button");
		
		//Verify Logout Success
		Assert.assertTrue(loginPage.isLogin()," Expected to navigate back to Login Page after logout, but it did not");
		logger.info("Successfully navigated back to Login Page after logout");

		
	}

}
