package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import dataProviders.DataProviders;
import drivers.DriverManager;
import pages.ContactUsFromPage;
import pages.HomePage;

public class ContactUsTest extends BaseTest {
	
	@Test(dataProvider="contactusData",dataProviderClass = DataProviders.class)
	public void testContactUs(String name, String email, String subject, String message, String filePath)
	{
        WebDriver driverRef = DriverManager.getWebDriver();
        
        logger.info("------- TESTCASE 6 : CONTACT US FORM ----------");

        // Verify Home Page
        HomePage homePage = new HomePage(driverRef);
        Assert.assertTrue(homePage.isHomePage(), "Expected Home Page to be visible but it is not.");
        logger.info("Home Page is displayed successfully");

        homePage.clickOnContactUs();
        logger.info("Navigated to Contact Us page");

        // Verify Contact Us Page
        ContactUsFromPage contactUs = new ContactUsFromPage(driverRef);
        Assert.assertTrue(contactUs.isContactUs(), "Expected Contact Us Page to be visible but it is not.");
        logger.info("Contact Us Page is displayed successfully");

        //Fill Contact Us Form
        contactUs.enterName(name);
        contactUs.enterEmail(email);
        contactUs.enterSubject(subject);
        contactUs.enterInputMsg(message);
        
        // upload file only if provided
        if (filePath != null && !filePath.trim().isEmpty()) 
        {
            contactUs.upload(filePath);
        }
        logger.info("Entered contact details in the form");

        contactUs.clickOnSubmit();
        contactUs.contactUsAlert(); 
        logger.info("Submitted the form and handled alert");

        //Verify Form Submission
        Assert.assertTrue(contactUs.isContactUsFormSubmitted(),"Expected form to be submitted successfully, but validation failed.");
        logger.info("Contact form submitted successfully");

        // Navigate Back to Home
        contactUs.clickOnHome();
        Assert.assertTrue(homePage.isHomePage(),"Expected Home Page to be visible after navigating back, but it is not.");
        logger.info("Successfully navigated back to Home Page");
	}
	
	



}
