package pages;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//Page Object Class for the Checkout Page
public class CheckoutPage extends BasePage{
	
	// Locators
	By deliveryAddrLoc = By.xpath("//h3[text()='Your delivery address']");
	By bilingAddrLoc   = By.xpath("//h3[text()='Your billing address']");
	By nameLoc     = By.cssSelector(".address_firstname.address_lastname");
	By addressLoc  = By.cssSelector("#address_delivery .address_address1.address_address2");
	By cityStateLoc= By.cssSelector("#address_delivery .address_city.address_state_name.address_postcode");
	By countryLoc  = By.cssSelector("#address_delivery .address_country_name");
	By phoneLoc    = By.cssSelector("#address_delivery .address_phone"); // fixed selector
	
	By addressList  = By.xpath("//ul[@id='address_delivery']//li");
	By addressList2 = By.xpath("//ul[@id='address_invoice']//li");
	By commentLoc   = By.xpath("//textarea[@name='message']");
	By placeOrderLoc= By.xpath("//a[@href='/payment']");
	
	
	//Constructor
	public CheckoutPage(WebDriver driver) 
	{
		super(driver);
	}
	
	// Check if delivery address section is visible
	public boolean isDeliveryAddrDisplayed() 
	{
		return isElementVisible(deliveryAddrLoc);
	}
	
	// Check if billing address section is visible
	public boolean isBillingAddrDisplayed() 
	{
		return isElementVisible(bilingAddrLoc);
	}
	
	// Enter comment in textarea
	public void setComment(String message) 
	{
		scrollIntoView(findElement(commentLoc));
		type(commentLoc, message);
	}
	
	// Click "Place Order"
	public void clickOnPlaceOrder() 
	{
		click(placeOrderLoc);
	}
	
	// Get delivery address details as Map
	public Map<String, String> getDeliveryAddress() 
	{
	    Map<String, String> details = new LinkedHashMap<>();
	    List<WebElement> addressBlock = findElements(addressList);

	    details.put("Name",     addressBlock.get(1).getText().trim());
	    details.put("Company",  addressBlock.get(2).getText().trim());
	    details.put("Address1", addressBlock.get(3).getText().trim());
	    details.put("StateZip", addressBlock.get(5).getText().trim());
	    details.put("Country",  addressBlock.get(6).getText().trim());
	    details.put("MobileNo", addressBlock.get(7).getText().trim());

	    return details;
	}
	
	// Get billing address details as Map
	public Map<String, String> getBillingAddress() 
	{
	    Map<String, String> details = new LinkedHashMap<>();
	    List<WebElement> addressBlock = findElements(addressList2);

	    details.put("Name",     addressBlock.get(1).getText().trim());
	    details.put("Company",  addressBlock.get(2).getText().trim());
	    details.put("Address1", addressBlock.get(3).getText().trim());
	    details.put("StateZip", addressBlock.get(5).getText().trim());
	    details.put("Country",  addressBlock.get(6).getText().trim());
	    details.put("MobileNo", addressBlock.get(7).getText().trim());

	    return details;
	}
}
