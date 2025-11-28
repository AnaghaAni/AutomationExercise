package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.waitUtils;
public class CartPage extends BasePage {

    // Locators
    By isSubscriptionTxtLoc = By.xpath("//h2[text()='Subscription']");
    By cartSizeLoc = By.cssSelector("tbody tr");                  
    By cartProductNameLoc = By.cssSelector(".cart_description a"); 
    By cartPriceLoc = By.cssSelector(".cart_price>p");           
    By quantityLoc = By.cssSelector(".cart_quantity > button");  
    By cartTotalPrice = By.cssSelector(".cart_total > p");
    By proceedCheckoutBtnLoc = By.xpath("//a[text()='Proceed To Checkout']");
    By loginOrRegister = By.xpath("//u//parent::a[@href='/login']");
    By cartEmptyTxtLoc = By.xpath("//b[text()='Cart is empty!']");


    // Constructor
    public CartPage(WebDriver driver) 
    {
        super(driver);
    }

    // Check if Cart page title is correct
    public boolean isCartTitle()
    {
        return pageTitle().contains("Automation Exercise - Checkout");
    }

    // Check if current URL is the cart URL
    public boolean isCartUrl() 
    {
        return getCurrentUrl().contains("/view_cart");
    }

    public boolean isCartEmpty()
    {
    	waitUtils.waitForVisibility(driver, cartEmptyTxtLoc);
    	return isElementVisible(cartEmptyTxtLoc);
    }
    
    
    // Return number of products in the cart
    public int cartSize() 
    {
        return findElements(cartSizeLoc).size();
    }

    // Get product name in cart by productId/index
    public String inCartProductName(int productId) 
    {
        return pageTexts(cartProductNameLoc, productId);
    }

    // Get product price in cart by productId/index
    public String inCartPrice(int productId) 
    {
        return pageTexts(cartPriceLoc, productId);
    }

    // Get product quantity in cart as integer
    public int inCartQuantity(int productId) 
    {
        return extractNumeric(pageTexts(quantityLoc, productId));
    }

    // Check if quantity element is displayed
    public boolean isCartQuantity(int productId) 
    {
        return findElements(quantityLoc).get(productId).isDisplayed();
    }

    // Get total price of product as integer
    public int inCartTotal(int productId) 
    {
        return extractNumeric(pageTexts(cartTotalPrice, productId));
    }

    // Utility: extract numeric value from a string
    public int extractNumeric(String text) 
    {
        String numericPrice = text.replaceAll("[^0-9]", "");
        return Integer.parseInt(numericPrice);
    }

    // Calculate total amount = price * quantity
    public int calculateTotalAmount(int productId) 
    {    
        return extractNumeric(inCartPrice(productId)) * inCartQuantity(productId);
    }
    
    //Click on "Proceed To Checkout"button    
    public void clickOnCheckoutBtn()
    {
    	click(proceedCheckoutBtnLoc);
    }
    
    //Click on "Register/Login" link
    public void clickOnRegisterOrLogin()
    {
    	click(loginOrRegister);
    }
    
    // Remove product from cart
    public void  deleteProductFromCart(int prdId)
    {
    	 By removeProductLoc = By.xpath("//a[@data-product-id='"+prdId+"']");
    	 click(removeProductLoc);
    }
}

