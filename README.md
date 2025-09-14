# AutomationExercise

This project contains **Selenium WebDriver automation test scripts** for [Automation Exercise](https://automationexercise.com) website.  
It is built for practicing automation testing concepts such as **locators, Page Object Model (POM), TestNG, and reporting**.

-----
## Project Structure

AutomationExercise/
│── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── drivers/          # WebDriver setup & management
│   │   │   ├── pages/            # Page Object Model (POM) classes
│   │   │   └── utils/            # Utility classes 
│   │   └── resources/
│   │       ├── config.properties # Project configuration
│   │       └── log4j2.xml        # Logging configuration
│   │
│   ├── test/
│   │   ├── java/
│   │   │   ├── dataProviders/    # Data-driven testing providers
│   │   │   ├── listeners/        # TestNG Listeners (for reports, logging)
│   │   │   └── tests/            # Actual test cases
│   │   └── resources/
│   │       └── testData/         # Test data files 
│
│── logs/
│   └── automation.log            # Runtime execution logs
│
│── target/                       # Build output 
│── test-output/                  # TestNG default reports
│── pom.xml                       # Maven build configuration
│── testng.xml                    # TestNG suite file



---

## Tools & Technologies
- **Java**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **Extent Reports**

