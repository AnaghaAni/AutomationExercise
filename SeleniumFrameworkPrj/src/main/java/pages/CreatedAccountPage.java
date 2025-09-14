package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Page Object Class for the "Account Created" page
public class CreatedAccountPage extends BasePage{
	
	//Locators	
	By accountCreatedMsgLoc=By.xpath("//h2//b[text()='Account Created!']");
	By continueBtnLoc=By.xpath("//a[text()='Continue']");
	
	//constructors
	public CreatedAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
    // Verify if "Account Created!" message is visible
	public boolean isAccCretedMsg() 
	{
		return isElementVisible(accountCreatedMsgLoc);
	}
	
	 // Click the Continue button
	public void continueClick()
	{
		click(continueBtnLoc);
	}

}
