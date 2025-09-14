package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import drivers.DriverFactory;
import drivers.DriverManager;
import utils.ConfigReader;

public class BaseTest {
	
	
	public static final Logger logger = LogManager.getLogger(BaseTest.class);
	
	/*
	    * Sets up the WebDriver before running tests.
	    * 
	    * Creates a new browser instance using DriverFactory
	    * - Stores the WebDriver in ThreadLocal via DriverManager
	    * - Opens the application URL
	    */
		
		@Parameters({"os","browser"})
		@BeforeMethod
		public void setUp( String os,String browser)
		{
			
			WebDriver driverRef = DriverFactory.createDriver(browser);
			DriverManager.setWebDriver(driverRef);
			
			 // Navigate to application under test
			DriverManager.getWebDriver().get(ConfigReader.get("base.url"));
		}
		
		
		/*
		 
	     * Cleans up the WebDriver after running tests.
	     * 
	     * - Quits the browser if driver is not null
	     * - Removes WebDriver reference from ThreadLocal
	     *   to avoid memory leaks in parallel execution
	     */
		
		
		@AfterMethod
		public void tearDown()
		{
			if(DriverManager.getWebDriver() !=null)
			{
				DriverManager.getWebDriver().quit();
				DriverManager.removeDriver(); //clear ThreadLocal
			}
		}
	

}
