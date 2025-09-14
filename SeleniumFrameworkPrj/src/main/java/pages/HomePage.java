package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//Page Object Class for the Home Page
public class HomePage extends BasePage {
	
	 // Locators
	 By homeTitleLoc = By.xpath("//span[text()='Automation']");
	 By homeSubTitleLoc = By.xpath("//h2[text()='Full-Fledged practice website for Automation Engineers']");
	 By signUpORLoginLoc = By.xpath("//a[normalize-space(text())='Signup / Login']");
	 By contactUsLoc = By.cssSelector("a[href='/contact_us']");
	 By testCaseLoc = By.cssSelector("a[href='/test_cases']");
	 By productLoc = By.cssSelector("a[href='/products']");
	 By subscribeEmailLoc = By.id("susbscribe_email");
	 By subscribeBtn = By.id("subscribe");
	 By subscribeSuccessMsgLoc = By.cssSelector("#success-subscribe .alert-success.alert");
	 By cartLoc = By.cssSelector("a[href='/view_cart']");
	
	 // Constructor
	 public HomePage(WebDriver driver) 
	 {
	     super(driver); // Initialize BasePage
	 }
	
	 // Verify if Home Page is displayed
	 public boolean isHomePage() 
	 {
	     return isElementVisible(homeSubTitleLoc);
	 }
	
	 // Click on Signup / Login link
	 public void clickSignUpORLogin() 
	 {
	     click(signUpORLoginLoc);
	 }
	
	 // Click on Contact Us link
	 public void clickOnContactUs() 
	 {
	     click(contactUsLoc);
	 }
	
	 // Click on Test Cases link
	 public void clickOnTestCase() 
	 {
	     click(testCaseLoc);
	 }
	
	 // Click on "Products" link
	 public void clickOnProducts() {
	     click(productLoc);
	 }
	
	 // Enter email in the subscription box
	 public void enterSubscribeEmail(String email) {
	     scrollIntoView(findElement(subscribeEmailLoc));
	     type(subscribeEmailLoc, email);
	 }
	
	 // Click the Subscribe button
	 public void clickSubscribeBtn() {
	     click(subscribeBtn);
	 }
	
	 // Verify if subscription success message is displayed
	 public boolean isSubscribeMsg() {
	     return isElementVisible(subscribeSuccessMsgLoc);
	 }
	
	 // Click on Cart link
	 public void clickOnCart() {
	     click(cartLoc);
	 }
}
