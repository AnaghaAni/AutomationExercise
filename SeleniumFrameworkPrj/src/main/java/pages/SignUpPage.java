package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Page Object Class for the Sign Up Page
public class SignUpPage extends BasePage {

	 // Locators
	 By enterAccInfoLoc = By.xpath("//h2//b[text()='Enter Account Information']");
	 By passwordLoc = By.xpath("//input[@data-qa='password']");
	 By selectDayLoc = By.id("days");
	 By selectMonthLoc = By.id("months");
	 By yearLoc = By.id("years");
	 By newsletterLoc = By.id("newsletter");
	 By receiveSpecialOfferLoc = By.id("optin");
	 By firstNameLoc = By.cssSelector("input[name='first_name']");
	 By lastNameLoc = By.cssSelector("input[name='last_name']");
	 By companyLoc = By.id("company");
	 By address1Loc = By.id("address1");
	 By selectCountryLoc = By.id("country");
	 By stateLoc = By.id("state");
	 By cityLoc = By.id("city");
	 By zipcodeLoc = By.id("zipcode");
	 By mobileNoLoc = By.id("mobile_number");
	 By createAccBtnLoc = By.xpath("//button[@data-qa='create-account']");
	 By accountCreatedMsgLoc = By.xpath("//h2//b[text()='Account Created!']");
	 By continueBtnLoc = By.xpath("//a[text()='Continue']");
	
	 // Constructor
	 public SignUpPage(WebDriver driver) {
	     super(driver); // Initialize BasePage
	 }
	
	 // Verify if "Enter Account Information" section is visible
	 public boolean isEnterAccInfo() 
	 {
	     try {
	         return findElement(enterAccInfoLoc).isDisplayed();
	     } catch (Exception e) {
	         return false;
	     }
	 }
	
	 // Select title (Mr./Mrs.)
	 public void selectTitle(String title) 
	 {
	     By titleLoc = By.xpath("//input[@name='title' and @value='" + title + "']");
	     click(titleLoc);
	 }
	
	 // Enter password
	 public void enterPassword(String password)
	 {
	     type(passwordLoc, password);
	 }
	
	 // Select day, month, year from dropdowns
	 public void selectDay(String day)
	 {
	     selectDropDown(selectDayLoc, day);
	 }
	
	 public void selectMonth(String month) {
	     selectDropDown(selectMonthLoc, month);
	 }
	
	 public void selectYear(String year) 
	 {
	     selectDropDown(yearLoc, year);
	 }
	
	 // Enable newsletter signup
	 public void enableNewsletterSignup() 
	 {
	     click(newsletterLoc);
	 }
	
	 // Enable special offers checkbox
	 public void clickSpecialOffersCheckbox() 
	 {
	     click(receiveSpecialOfferLoc);
	 }
	
	 
	 
	 // Enter personal details
	 public void enterFirstName(String firstName) 
	 {
	     type(firstNameLoc, firstName);
	 }
	
	 public void enterLastName(String lastName)
	 {
	     type(lastNameLoc, lastName);
	 }
	
	 public void enterCompany(String company) 
	 {
	     type(companyLoc, company);
	 }
	
	 public void enterAddress1(String address) 
	 {
	     type(address1Loc, address);
	 }
	
	 public void selectCountry(String country) 
	 {
	     selectDropDown(selectCountryLoc, country);
	 }
	
	 public void enterState(String state) 
	 {
	     type(stateLoc, state);
	 }
	
	 public void enterCity(String city) 
	 {
	     type(cityLoc, city);
	 }
	
	 public void enterZipCode(String zipcode) 
	 {
	     type(zipcodeLoc, zipcode);
	 }
	
	 public void enterMobileNo(String mobileNo) 
	 {
	     type(mobileNoLoc, mobileNo);
	 }
	
	 // Click Create Account button
	 public void clickCreateAccBtn() 
	 {
	     click(createAccBtnLoc);
	 }
}
