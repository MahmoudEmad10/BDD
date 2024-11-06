package baseTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.ConfigReader;

public class BaseTest {
    private static BaseTest instance;
    protected WebDriver driver;
    protected ConfigReader configReader;

    public BaseTest() {
    }

    public static synchronized BaseTest getInstance() {
        if (instance == null) {
            instance = new BaseTest();
        }
        return instance;
    }

    @Before
    public void setUp() {
        configReader = new ConfigReader();
        driver = getInstance().getDriver(configReader.getBrowserName());
        driver.manage().window().maximize();
        driver.get(configReader.getBaseUrl());
    }

    @After
    public void tearDown() throws InterruptedException {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


    public WebDriver getDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        return driver;
    }

    public WebDriver returnDriver() {
        return driver;
    }
}
