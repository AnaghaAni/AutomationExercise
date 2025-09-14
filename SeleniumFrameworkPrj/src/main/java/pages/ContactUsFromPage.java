package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsFromPage extends BasePage {
	
	
	// Page Object Class for the "Contact Us" form page
	By getInTouchLoc =  By.xpath("//h2[normalize-space()='Get In Touch']");
	By nameLoc = By.cssSelector("input[data-qa='name']");
	By emailLoc = By.cssSelector("input[data-qa='email']");
	By subjectLoc = By.cssSelector("input[data-qa='subject']");
	By inputMsgLoc = By.cssSelector("textarea[data-qa='message']");
	By uploadFileLoc = By.cssSelector("input[name='upload_file']");
	By submitLoc= By.cssSelector("input[data-qa='submit-button']");
	By successMsgLoc = By.cssSelector("div.status.alert.alert-success");
	By homeBtnLoc = By.xpath("//span//parent::a[@href='/']");
	
    // Constructor
    public ContactUsFromPage(WebDriver driver) 
    {
        super(driver); 
    }

	// Verify "Get In Touch" section is visible
    public boolean isContactUs() 
    {
        return isElementVisible(getInTouchLoc);
    }

    // Enter name in the form
    public void enterName(String name) 
    {
        type(nameLoc, name);
    }

    // Enter email in the form
    public void enterEmail(String email) 
    {
        type(emailLoc, email);
    }

    // Enter subject in the form
    public void enterSubject(String subject) 
    {
        type(subjectLoc, subject);
    }

    // Enter message in the form
    public void enterInputMsg(String msg) 
    {
        type(inputMsgLoc, msg);
    }

    // Upload file
    public void upload(String file) 
    {
        type(uploadFileLoc, file);
    }

    // Click on Submit button
    public void clickOnSubmit() 
    {
        click(submitLoc);
    }

    // Handle alert after form submission
    public void contactUsAlert() 
    {
        acceptAlert();
    }

    // Verify if form submission was successful
    public boolean isContactUsFormSubmitted() 
    {
        return isElementVisible(successMsgLoc);
    }

    // Click on Home button to navigate back
    public void clickOnHome() 
    {
        click(homeBtnLoc);
    }
}