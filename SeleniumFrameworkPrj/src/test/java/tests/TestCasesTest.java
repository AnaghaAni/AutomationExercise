package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import drivers.DriverManager;
import pages.HomePage;
import pages.TestCasesPage;

public class TestCasesTest extends BaseTest{
	
	@Test
	public void testTestCases()
	{
		
        WebDriver driverRef = DriverManager.getWebDriver();
        
        logger.info("------- TESTCASE 7 : VERIFY TESTCASE PAGE ----------");
        
        // Verify Home Page
        HomePage homePage = new HomePage(driverRef);
        Assert.assertTrue(homePage.isHomePage(), "Expected Home Page to be visible but it is not.");
        logger.info("Home Page is displayed successfully");
        
        homePage.clickOnTestCase();
        logger.info("Navigated to Test Case page");
        
        TestCasesPage testCase = new TestCasesPage(driverRef);
        Assert.assertTrue(testCase.isTestCasePage() && testCase.isTestCaseUrl(),
        				"Expected Test case page should be visible, but it is not");
        logger.info("Test Case Page is displayed successfully");

	}

}
