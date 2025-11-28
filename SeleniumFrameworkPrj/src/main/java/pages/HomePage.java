package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;




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
	 By categoryLoc =By.xpath("//div[@class='left-sidebar']//h2[normalize-space()='Category']");
	 By womenCategoryLoc = By.xpath("//a[normalize-space()='Women']");
	 By menCategoryLoc = By.xpath("//a[normalize-space()='Men']");
	 By kidsCategoryLoc = By.xpath("//a[@href='#Kids']");
	 By womenCategoryList = By.cssSelector("div#Women ul li");
	 By menCategoryList = By.cssSelector("div#Men ul li");
	 By kidsCategoryList = By.cssSelector("div#Kids ul li");
	 By categoryHeader = By.cssSelector("h2.title.text-center");
	 By brandLoc = By.xpath("//div[@class='left-sidebar']//h2[normalize-space()='Brands']");
	 By brandList = By.cssSelector(".brands-name ul li");
	 By brandHeader = By.cssSelector(".features_items .title");
	 
	 
	
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
	 public void clickOnProducts() 
	 {
		 scrollIntoView(findElement(productLoc));
	     click(productLoc);
	 }
	
	 // Enter email in the subscription box
	 public void enterSubscribeEmail(String email) 
	 {
	     scrollIntoView(findElement(subscribeEmailLoc));
	     type(subscribeEmailLoc, email);
	 }
	
	 // Click the Subscribe button
	 public void clickSubscribeBtn() 
	 {
	     click(subscribeBtn);
	 }
	
	 // Verify if subscription success message is displayed
	 public boolean isSubscribeMsg() 
	 {
	     return isElementVisible(subscribeSuccessMsgLoc);
	 }
	
	 // Click on Cart link
	 public void clickOnCart() 
	 {
	     click(cartLoc);
	 }
	 
	  // Women-specific wrapper
	 public void selectWomenSubCategory(String subCategory) 
	 {
		 	scrollIntoView(findElement(womenCategoryLoc));
	        click(womenCategoryLoc); 
	        selectSubCategory(womenCategoryList, subCategory);
	 }

	    // Men-specific wrapper
     public void selectMenSubCategory(String subCategory) 
	 {
    	    scrollIntoView(findElement(menCategoryLoc));
	        click(menCategoryLoc); 
	        selectSubCategory(menCategoryList, subCategory);
	 }

	  // Kids-specific wrapper
	 public void selectKidsSubCategory(String subCategory) 
	 {
		 	scrollIntoView(findElement(kidsCategoryLoc));
	        click(kidsCategoryLoc); 
	        selectSubCategory(kidsCategoryList, subCategory);
	  }
	 
	 //get the text of the category header displayed on the page
	 public String getCategoryHeader() 
	 {
		    return pageText(categoryLoc);
	 }
	 
	//get the text of the category header displayed on the page
	 public String getBrandHeader() 
	 {
		 return pageText(brandLoc);
	 }
	 
	 
	 public void selectSubCategory(By categoryListLocator, String subCategoryName) 
	 {
		    List<WebElement> categories = findElements(categoryListLocator);


		    for (WebElement category : categories) {

		        WebElement link = category.findElement(By.tagName("a"));
		        if (subCategoryName.equalsIgnoreCase(link.getText())) 
		        {
		            link.click();
		            break;
		        }
		    }
		}
	 
	 
	 public void selectBrand(By brandList, String brandName) 
	 {
		    List<WebElement> categories = findElements(brandList);


		    for (WebElement category : categories) {

		        WebElement link = category.findElement(By.tagName("a"));
		        if (brandName.equalsIgnoreCase(link.getText())) 
		        {
		            link.click();
		            break;
		        }
		    }
		}

	 

	 
	 
}
