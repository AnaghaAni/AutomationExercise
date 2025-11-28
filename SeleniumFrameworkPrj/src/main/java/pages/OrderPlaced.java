package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


//POM class for Order Placed page
public class OrderPlaced extends BasePage{
	
	//Locators
	By continueButton = By.xpath("//a[text()='Continue']");
    By orderPlacedMessage = By.xpath("//b[text()='Order Placed!']");
	
    
    //Constructors
	public  OrderPlaced(WebDriver driver)
	{
		super(driver);
	}
	
	// Check if Order page title is correct
    public boolean isOrderTitle()
    {
        return pageTitle().contains("Automation Exercise - Order Placed");
    }
    
    //Click on "Continue Button"
    public void clickContinue() 
    {
        click(continueButton);
    }

    
    // Get Order Placed message text
    public String getOrderPlacedText() 
    {
        return pageText(orderPlacedMessage);
    }

}
