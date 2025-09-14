package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Represents the "Account Deleted" page
public class AccountDeletedPage extends BasePage {
	
	// Locators
	By isAccDeletedLoc =By.xpath("//h2//b[text()='Account Deleted!']");
	By continueBtnLoc=By.xpath("//a[text()='Continue']");
	
	//constructor
	public AccountDeletedPage(WebDriver driver)
	{
		super(driver);
	}


	// Check if "Account Deleted!" message is visible
	public boolean isAccDeleted()
	{
		return isElementVisible(isAccDeletedLoc);
		
	}
	
	public void continueClick()
	{
		click(continueBtnLoc);
	}

	
	
}
