package drivers;

import org.openqa.selenium.WebDriver;

//DriverManager is a utility class that manages WebDriver instances
//in a thread-safe way using ThreadLocal. 
//This is mainly used when running tests in parallel execution.

public class DriverManager {
	
	
	/**
	 * 
	 * ThreadLocal variable to hold WebDriver instance separately
   * for each thread. This ensures thread safety when running
   * multiple tests in parallel.
   
	 */
	
	public static ThreadLocal<WebDriver>driver = new ThreadLocal<>();
	
	/**
	 * Assigns a WebDriver instance to the current thread.
	 * @param driverReference The WebDriver instance (e.g., ChromeDriver, FirefoxDriver)
	 */
	
	public static void setWebDriver(WebDriver driverRef)
	{
		driver.set(driverRef);
	}
	
	
	/**
	 *  Retrieves the WebDriver instance associated with the current thread.
	 * @return WebDriver instance for the current thread 
	 */
	
	
	public static WebDriver getWebDriver()
	{
		return driver.get();
	}
	
	
	
	/**
	 *  Quits the WebDriver for the current thread and removes it from ThreadLocal storage.
   * <p>
   * This is important for avoiding memory leaks and ensuring
   * that browser sessions are closed after test execution.
	 */
	
	
	public static void removeDriver()
	{
		driver.remove();
		
	}
	
}
