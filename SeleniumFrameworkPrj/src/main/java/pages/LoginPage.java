package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//Page Object Class for the Login Page
public class LoginPage extends BasePage {
	
	 // Locators
	 By loginUserLoc = By.xpath("//h2[text()='Login to your account']");
	 By emailAddressLoc = By.xpath("//input[@data-qa='login-email']");
	 By passwordLoc = By.xpath("//input[@data-qa='login-password']");
	 By loginBtnLoc = By.xpath("//button[@data-qa='login-button']");
	 By usernameLoc = By.xpath("//input[@data-qa='signup-name']");
	 By emailAddressNewLoc = By.xpath("//input[@data-qa='signup-email']");
	 By signUpBtnLoc = By.xpath("//button[@data-qa='signup-button']");
	 By newSignUpLoc = By.xpath("//h2[text()='New User Signup!']");
	 By signupErrLoc = By.xpath("//form[@action='/signup']//p[text()='Email Address already exist!']");
	 By loginErrLoc = By.xpath("//form[@action='/login']//p[text()='Your email or password is incorrect!']");
	
	 // Constructor
	 public LoginPage(WebDriver driver) 
	 {
	     super(driver); // Initialize BasePage
	 }
	
	 // Verify if Login section is visible
	 public boolean isLogin() 
	 {
	     return isElementVisible(loginUserLoc);
	 }
	
	 // Enter email for login
	 public void enterMail(String username) 
	 {
	     type(emailAddressLoc, username);
	 }
	
	 // Enter password for login
	 public void enterPassword(String password) 
	 {
	     type(passwordLoc, password);
	 }
	
	 // Click on Login button
	 public void clickOnLoginBtn() 
	 {
	     click(loginBtnLoc);
	 }
	
	 // Get the page title
	 public String getLoginTitle() 
	 {
	     return driver.getTitle();
	 }
	
	 // Verify if login error message is displayed
	 public boolean isLoginErr() 
	 {
	     return isElementVisible(loginErrLoc);
	 }
	
	 // Verify if Signup section is visible
	 public boolean isSignup() 
	 {
	     return isElementVisible(newSignUpLoc);
	 }
	
	 // Enter username for signup
	 public void enterUsername(String username) 
	 {
	     type(usernameLoc, username);
	 }
	
	 // Enter email for signup
	 public void enterEmailAddress(String email) 
	 {
	     type(emailAddressNewLoc, email);
	 }
	
	 // Click on Signup button
	 public void clickOnSignUpBtn() 
	 {
	     click(signUpBtnLoc);
	 }
	
	 // Verify if signup error message is displayed
	 public boolean isSignupErr() 
	 {
	     return isElementVisible(signupErrLoc);
	 }
}

