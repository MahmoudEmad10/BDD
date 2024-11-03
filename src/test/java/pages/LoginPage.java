package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ConfigReader;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private ConfigReader configReader;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.configReader = new ConfigReader();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    WebElement usernameField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(css = "[type='submit']")
    WebElement loginButton;


    public void login() {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.sendKeys(configReader.getUserName());
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(configReader.getPassword());
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        System.out.println("Login action performed.");
    }
}
