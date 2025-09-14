package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Page Object Class for the "My Account" page
public class MyAccountPage extends BasePage {

	 // Locators
	 By loggedInUserLoc = By.xpath("//i[@class='fa fa-user']/parent::a");
	 By deleteAccLoc = By.xpath("//i[@class='fa fa-trash-o']/parent::a");
	 By logoutLoc = By.xpath("//i[@class='fa fa-lock']//parent::a");
	
	 // Constructor
	 public MyAccountPage(WebDriver driver) 
	 {
	     super(driver); // Initialize BasePage
	 }
	
	 // Verify if logged-in user element is visible
	 public boolean isLoggedInUser() 
	 {
	     return isElementVisible(loggedInUserLoc);
	 }
	
	 // Get the text of the logged-in user
	 public String getLoggedInUserText() 
	 {
	     return driver.findElement(loggedInUserLoc).getText();
	 }
	
	 // Click on Delete Account link
	 public void clickDeleteAcc() 
	 {
	     click(deleteAccLoc);
	 }
	
	 // Click on "Logout" link
	 public void clickOnLogout() 
	 {
	     click(logoutLoc);
	 }
}


