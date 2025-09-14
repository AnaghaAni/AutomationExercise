package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

	//Page Object Class for the Test Cases Page
	public class TestCasesPage extends BasePage 
	{
	
	 // Locator
	 By isTestCaseLoc = By.xpath("//h2[@class='title text-center']/b[text()='Test Cases']");
	
	 // Constructor
	 public TestCasesPage(WebDriver driver)
	 {
	     super(driver); // Initialize BasePage
	 }
	
	 // Verify if Test Cases title is visible on the page
	 public boolean isTestCasePage() 
	 {
	     return isElementVisible(isTestCaseLoc);
	 }
	
	 // Verify if current URL contains "/test_cases"
	 public boolean isTestCaseUrl() 
	 {
	     return getCurrentUrl().contains("/test_cases");
	 }
}
