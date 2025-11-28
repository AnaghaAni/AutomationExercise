package tests;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import dataProviders.DataProviders;
import drivers.DriverManager;
import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;

public class AddProductsInCart extends BaseTest
{
	@Test(dataProvider="productId", dataProviderClass=DataProviders.class)
	public void testAddProductsInCart(Integer prdId1, Integer prdId2)
	{
		int addToCartClicks = 0;
		int totalQuantity = 0;

		WebDriver driverRef = DriverManager.getWebDriver();

		logger.info("----------- TESTCASE 12 : ADD PRODUCTS IN CART --------------");

		// Verify Home Page
		HomePage homePage = new HomePage(driverRef);
		Assert.assertTrue(homePage.isHomePage(), "Home Page is NOT visible.");
		logger.info("Home Page is displayed successfully");

		// Navigate to Products Page
		homePage.clickOnProducts();
		logger.info("Clicked on 'Products' menu");

		ProductsPage productPage = new ProductsPage(driverRef);
		Assert.assertTrue(productPage.isProductPageUrl() && productPage.isProductTitle(),
		        "Products Page is NOT visible.");
		logger.info("Products Page is displayed successfully");
		
		
        // Track product details & clicks
        Map<Integer, String> expectedNames = new HashMap<>();
        Map<Integer, String> expectedPrices = new HashMap<>();
        Map<Integer, Integer> productQuantities = new HashMap<>();

       // Capture product details for first product
        expectedNames.put( prdId1, productPage.getProductNameIncart(prdId1));
        expectedPrices.put( prdId1, productPage.getProductPriceIncart(prdId1));  

		// Add first product
		productPage.addProductToCart(prdId1);
		addToCartClicks++;
		totalQuantity++ ;
		productQuantities.put(prdId1, totalQuantity);
		logger.info("Added first product to cart");
		productPage.clickOnContinueShoppingBtn(); // Continue shopping for second product

		//Reset
		totalQuantity = 0;
		
		
		// Capture product details for second product
        expectedNames.put( prdId2, productPage.getProductNameIncart( prdId2));
        expectedPrices.put( prdId2, productPage.getProductPriceIncart( prdId2));  
        
		// Add second product
    	productPage.addProductToCart( prdId2);
		addToCartClicks++;
		totalQuantity++ ;
		productQuantities.put( prdId2, totalQuantity);
		
		logger.info("Added second product to cart");

		// Go to Cart Page
		productPage.clickOnViewCart();
		logger.info("Navigated to Cart Page");

		CartPage cartPage = new CartPage(driverRef);
		
		// Verify that Cart Page is displayed successfully
	    Assert.assertTrue(cartPage. isCartTitle() && cartPage.isCartUrl(),
		        "Expected Cart Page to be visible but it is not."
		    );
		    logger.info("Cart Page is visible successfully");

		// Verify cart size
		int actualCartSize = cartPage.cartSize();
		Assert.assertEquals(actualCartSize, addToCartClicks,
		        "Expected cart to contain " + addToCartClicks + " products, but found " + actualCartSize);
		logger.info("Cart contains " + actualCartSize + " products as expected");


		// Verify product name of first product
		Assert.assertEquals(cartPage.inCartProductName(0).replaceAll("\\s+", " ").trim(), expectedNames.get(prdId1).replaceAll("\\s+", " ").trim(),
		        "Product name mismatch for first product");
	
		logger.info("Verified first product name matches");

		// Verify product price of first product
		Assert.assertEquals(cartPage.inCartPrice(0), expectedPrices.get(prdId1),
		        "Product price mismatch for first product");
		logger.info("Verified product price matches");

		// Verify total calculation of first product
		Assert.assertEquals(cartPage.inCartTotal(0), cartPage.calculateTotalAmount(0),
		        "Total amount mismatch for first product");
		logger.info("Verified total amount matches");
		
		
		// Verify total quantity of first product
		Assert.assertEquals(cartPage.inCartQuantity(0), productQuantities.get(prdId1),
				"Expected total cart quantity to match number of clicks on Add to Cart, but it does not.");
		logger.info("Verified total cart quantity");
		
		
		// Verify product name of second product
		Assert.assertEquals(cartPage.inCartProductName(1).replaceAll("\\s+", " ").trim(), expectedNames.get(prdId2).replaceAll("\\s+", " ").trim(),
		        "Product name mismatch for second product");
		logger.info("Verified second product name matches");
		
		

		// Verify product price of Second product
		Assert.assertEquals(cartPage.inCartPrice(1), expectedPrices.get(prdId2),
		        "Product price mismatch for second product");
		logger.info("Verified product price matches");
		
		

		// Verify total calculation of second product
		Assert.assertEquals(cartPage.inCartTotal(1), cartPage.calculateTotalAmount(1),
		        "Total amount mismatch for second product");
		logger.info("Verified total amount matches");

		
		// Verify total quantity of second product
		Assert.assertEquals(cartPage.inCartQuantity(1),productQuantities.get(prdId1) ,
				"Expected total cart quantity to match number of clicks on Add to Cart, but it does not.");
		logger.info("Verified total cart quantity");

	}

}
