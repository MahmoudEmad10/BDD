package driverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManagerSingleton {
    private static WebDriverManagerSingleton instance;
    private WebDriver driver;

    // Private constructor to prevent instantiation
    private WebDriverManagerSingleton() {
        // Initialize the WebDriver here if needed
    }

    // Method to get the singleton instance
    public static synchronized WebDriverManagerSingleton getInstance() {
        if (instance == null) {
            instance = new WebDriverManagerSingleton();
        }
        return instance;
    }

    // Method to initialize the WebDriver
    public WebDriver getDriver(String browser) {
        if (driver == null) {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            // You can add more browsers here (e.g., Firefox, Edge)
            else {
                throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
        }
        return driver;
    }

    // Method to quit the driver
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Set to null to allow re-initialization if needed
        }
    }
}
