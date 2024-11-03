package DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverFactory {

    public WebDriver driver;
    public static ThreadLocal<WebDriver> tlDriver= new ThreadLocal<>();

    public WebDriver init_Driver (String browser){
        System.out.println("Browser value is: "+ browser);
        if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
        }
        else {
            System.out.println("Wrong Browser Value");
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    public static WebDriver getDriver(){
        return tlDriver.get();
    }


}
