package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

//Page Object Class for the Payment page

public class PaymentPage extends BasePage 
{
	
		//Locators
		By cardNameLoc = By.cssSelector("input[data-qa='name-on-card']");
		By cardNoLoc = By.cssSelector("input[data-qa='card-number']");
		By cvcLoc = By.cssSelector("input[data-qa='cvc']");
		By monthLoc = By.cssSelector("input[placeholder='MM']");
		By yearLoc = By.cssSelector("input[placeholder='YYYY']");
		By payBtnLoc = By.xpath("//button[text()='Pay and Confirm Order']");
		By paymentSuccessMsg = By.xpath("//div[@id='success_message']//div[normalize-space()='Your order has been placed successfully!']");
		
		//Constructor
		public PaymentPage(WebDriver driver)
		{
			super(driver);
		}
	

		
		// Verify page title
	    public boolean isPaymentTitle() 
	    {
	        return pageTitle().contains("Automation Exercise - Payment");
	    }

	    // Verify page URL
	    public boolean isPaymentUrl() 
	    {
	        return getCurrentUrl().contains("/payment");
	    }
	    
	    // Enter cardholder name
	    public void entercardName(String cardName) 
	    {
	    	type(cardNameLoc, cardName);
	    }
	    
	    // Enter card number
	    public void entercardNo(String cardNo) 
	    {
	    	scrollIntoView(findElement(cardNoLoc));
	    	type(cardNoLoc, cardNo);
	    }

	    // Enter CVC
	    public void enterCvc(String cvc) 
	    {
	    	type(cvcLoc, cvc);
	    }
	    
	    // Enter expiry month
	    public void enterMonth(String month) 
	    {
	    	type(monthLoc, month);
	    }
	    
	    // Enter expiry year
	    public void enterYear(String year) {
	    	type(yearLoc, year);
	    }
	    
	    // Click "Pay and Confirm Order"
	    public void clickOnPayBtn() 
	    {
	    	click(payBtnLoc);
	    }
	    
	    // Get success message after payment
	    public String getSuccessMsg() 
	    {
	    	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	    	// return wait.until(ExpectedConditions.presenceOfElementLocated(paymentSuccessMsg)).getText();
	    	return pageText(paymentSuccessMsg);
	    }


}
