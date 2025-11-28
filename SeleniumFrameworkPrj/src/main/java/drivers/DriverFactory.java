package drivers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ConfigReader;



public class DriverFactory {
	 
	/**
	 * Creates and initializes a WebDriver instance for the given browser.
	 * Supported browsers: Chrome, Firefox, Edge.
	 *
	 ** The driver will be:
	 * 
	 *   1.Launched for the given browser
	 *   2.Maximized to full screen
	 *   3. Configured with a default implicit wait of 10 seconds
	 * 
	 *
	 * @param browser The browser name
	 * @return A fully initialized WebDriver
	 * @throws IllegalArgumentException if the browser is not supported
	 * 
	 */
	

	public static WebDriver createDriver(String browser)
	{
		
		WebDriver driver = null;
		
		// Choose driver implementation based on browser name
		switch(browser.toLowerCase())
		{
			case "chrome": driver = new ChromeDriver();
						   break;
						   
			case "firefox" :driver = new FirefoxDriver();
							break;
			
			case "edge" : driver = new  EdgeDriver();
						  break;
						  
			default     : throw new  IllegalArgumentException("Invalid browser name: " + browser
												+ ". Supported browsers are: chrome, firefox, edge");
		}
		
		// Standard setup applied for all drivers
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigReader.get("implicitWait")))); // Apply implicit wait to handle element loading delays
		
		return driver;
	

	}

}