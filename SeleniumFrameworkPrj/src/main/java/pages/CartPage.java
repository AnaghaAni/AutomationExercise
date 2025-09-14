package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
	
	
	By isSubscriptionTxtLoc = By.xpath("//h2[text()='Subscription']");
	By subscribeEmailLoc = By.id("susbscribe_email");
	By subscribeBtn = By.id("subscribe");
	
	public CartPage(WebDriver driver)
	{
		super(driver);
	}
	
	public boolean isCartTitle()
	{
		return pageTitle().contains("Automation Exercise - Checkout");
	}
	
	public boolean isCartUrl()
	{
		return getCurrentUrl().contains("/view_cart");
	}

	
	public boolean isSubscritpion()
	{
		return isElementVisible(isSubscriptionTxtLoc);
	}
	
	
	public void enterSubscribeEmail(String email)
	{
		scrollIntoView(findElement(subscribeEmailLoc));
		type(subscribeEmailLoc,email);
	}
	
	public void clickSubscribeBtn()
	{
		click(subscribeBtn);
	}
	

}
