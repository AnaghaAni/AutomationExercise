package tests;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import dataProviders.DataProviders;
import drivers.DriverManager;
import pages.AccountDeletedPage;
import pages.CreatedAccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.SignUpPage;

public class SignUpTest extends BaseTest
{
	
   
	
	@Test(dataProvider="signupData",dataProviderClass=DataProviders.class)
  
    public void testUserRegistrationFlow(Map<String,String>data) {


		  logger.info("------- TESTCASE 1 : REGISTER USER ----------");

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
		    loginPage.enterUsername(data.get("username"));
		    loginPage.enterEmailAddress(data.get("email"));
		    loginPage.clickOnSignUpBtn();
		    logger.info("Performed signup with username: {} and email: {}",data.get("username"), data.get("email"));

		    //Verify Account Information section
		    SignUpPage signupPage = new SignUpPage(driver);
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
		    CreatedAccountPage createAccPage = new CreatedAccountPage(driver);
		    Assert.assertTrue(createAccPage.isAccCretedMsg(), "Expected Account Created message but not found");
		    logger.info("Account has been created successfully");
		    createAccPage.continueClick();

		    // Verify user is logged in
		    MyAccountPage myAccPage = new MyAccountPage(driver);
		    Assert.assertTrue(myAccPage.isLoggedInUser(), "Expected user to be logged in but it is not");
		    logger.info("User logged in successfully:" +myAccPage.getLoggedInUserText());

		    //Delete account
		    myAccPage.clickDeleteAcc();
		    logger.info("Clicked on Delete Account button");

		    // Verify account deletion success
		    AccountDeletedPage accDelPage = new AccountDeletedPage(driver);
		    Assert.assertTrue(accDelPage.isAccDeleted(), "Expected Account Deleted message but not found");
		    logger.info("Account has been deleted successfully");
		    accDelPage.continueClick();
		    
		    
		    
		
      
    }
	

}
	
	
	//Verify that the Home Page is displayed correctly.
//    public void checkHomePageVisible(WebDriver driver) {
//        HomePage homePage = new HomePage(driver);
//        if (homePage.isHomePage()) 
//        {
//            logger.info("Home Page is displayed successfully");
//            homePage.clicksignUpORLogin();
//            logger.info("Navigated to Signup/Login page");
//        } 
//        else 
//        {
//            logger.error("Home Page is not displayed");
//            Assert.fail("Home Page should be visible but it is not");
//        }
//    }
//
//    
//    //Verify that the Signup/Login link is visible on the Home Page.
//
//    public void checkSignupLinkVisible(WebDriver driver) 
//    {
//        LoginPage loginPage = new LoginPage(driver);
//        if (loginPage.isSignup()) 
//        {
//            logger.info("Signup/Login link is visible on Home Page");
//        } 
//        else 
//        {
//            logger.error("Signup/Login link is not visible");
//            Assert.fail("Signup/Login link should be visible but it is not");
//        }
//    }
//
//    
//   // Perform the signup action with given username and email.
//   public  void performSignup(WebDriver driver, String userName, String mail) 
//   {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.enterUsername(userName);
//        loginPage.enterEmailAddress(mail);
//        loginPage.clickOnSignUpBtn();
//        logger.info("Performed signup with username: {} and email: {}", userName, mail);
//    }
//
//   
//   //Verify that the Account Information section is visible on the Signup page.
//
//    public void checkAccountInfoSectionVisible(WebDriver driver) 
//    {
//        SignUpPage signupPage = new SignUpPage(driver);
//        if (signupPage.isEnterAccInfo()) 
//        {
//            logger.info("Account Information section is displayed");
//        } 
//        else 
//        {
//            logger.error("Account Information section is not visible");
//            Assert.fail("Account Information section should be visible but it is not");
//        }
//    }
//    
//    
//    
//    //Fill all required account information fields and submit the form.
//
//    public void  fillAccountDetails(WebDriver driver) 
//    {
//        SignUpPage signupPage = new SignUpPage(driver);
//        signupPage.selectTile("Mr");
//        signupPage.eneterPassword("users2@123");
//        signupPage.selectDay("3");
//        signupPage.selectMonth("July");
//        signupPage.selectYear("2003");
//        signupPage.enableNewsletterSignup();
//        signupPage.clickSpecialOffersCheckbox();
//        signupPage.enterFirstName("usersname2");
//        signupPage.enterLastName("test2");
//        signupPage.enterCompany("testcompany1");
//        signupPage.enterAddress1("u");
//        signupPage.selectCountry("India");
//        signupPage.enterState("Kerala");
//        signupPage.enterCity("Ettumanoor");
//        signupPage.enterZipCode("686004");
//        signupPage.enterMobileNo("9999944444");
//        signupPage.clickCreateAccBtn();
//        logger.info("Filled all account details and submitted the form");
//    }
//
//    
//   // Verify that the account has been successfully created.
//
//    public  void checkAccountCreationSuccess(WebDriver driver) 
//    {
//        CreatedAccountPage createAccPage = new CreatedAccountPage(driver);
//        if (createAccPage.isAccCretedMsg()) 
//        {
//            logger.info("Account has been successfully created");
//            createAccPage.continueClick();
//        } 
//        else 
//        {
//            logger.error("Account creation failed");
//            Assert.fail("Account should be created but it is not visible");
//        }
//    }
//
//    //Verify that the user is logged in successfully
//    public void checkUserLoginStatus(WebDriver driver) 
//    {
//        MyAccountPage myAccPage = new MyAccountPage(driver);
//        if (myAccPage.isLoggedInUser()) 
//        {
//            logger.info("User logged in successfully: {}", myAccPage.getLoggedInUserText());
//            myAccPage.clickDeleteAcc();
//            logger.info("Clicked on Delete Account button");
//        } 
//        else
//        {
//            logger.error("User login failed");
//            Assert.fail("User should be logged in but is not");
//        }
//    }
//
//    
//    //Verify that the account deletion process was successful.
//
//    public void checkAccountDeletion(WebDriver driver) 
//    {
//        AccountDeletedPage accDelPage = new AccountDeletedPage(driver);
//        if (accDelPage.isAccDeleted()) 
//        {
//            logger.info("Account has been deleted successfully");
//            accDelPage.continueClick();
//        } 
//        else 
//        {
//            logger.error("Account deletion failed");
//            Assert.fail("Account should be deleted but it is not");
//        }
//    }
//
//}
