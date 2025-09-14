package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import drivers.DriverManager;
import pages.HomePage;
import pages.LoginPage;

public class SignuptestExistingMail  extends BaseTest{
	
	@Test
	@Parameters({"username","mail"})
	public void testWithExistingMail(String username, String mail)
	{
		logger.info("------- TESTCASE 5 : REGISTER USER with Existing mail ----------");

	    WebDriver driver = DriverManager.getWebDriver();

	    // Verify Home Page
	    HomePage homePage = new HomePage(driver);
	    Assert.assertTrue(homePage.isHomePage(), "Expected Home Page to be visible but it is not");
	    logger.info("Home Page is displayed successfully");

	    // Navigate to Signup/Login
	    homePage.clickSignUpORLogin();
	    logger.info("Navigated to Signup/Login page");

	    //  Verify Signup section
	    LoginPage loginPage = new LoginPage(driver);
	    Assert.assertTrue(loginPage.isSignup(), "Expected Signup section to be visible but it is not");
	    logger.info("Signup section is visible");
	    

	    // Perform signup
	    loginPage.enterUsername(username);
	    loginPage.enterEmailAddress(mail);
	    loginPage.clickOnSignUpBtn();
	    logger.info("Performed signup with username: {} and email: {}",username, mail);
	    Assert.assertTrue(loginPage.isSignupErr(), "Expected duplicate email error message not displayed!");
	}

}
