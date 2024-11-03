package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class AddUser {
    private WebDriver driver;
    private WebDriverWait wait;

    public AddUser(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[1]")
    WebElement userRoleDropDown;

    @FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[2]")
    WebElement statusDropDown;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeName;

    @FindBy(xpath = "//input[@autocomplete='off'][1]")
    WebElement userName;

    @FindBy(xpath = "(//input[@type='password'])[1]")
    WebElement password;

    @FindBy(xpath = "(//input[@type='password'])[2]")
    WebElement confirmPassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveButton;

    public void selectUserRole() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(userRoleDropDown)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-select-option']/span[text()='Admin']"))).click();
        System.out.println("Admin is selected");
    }

    public void selectStatus() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(statusDropDown)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-select-option']/span[text()='Enabled']"))).click();
        System.out.println("Status is selected");
    }

    public void enterEmployeeName() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(employeeName)).click();
        wait.until(ExpectedConditions.visibilityOf(employeeName)).sendKeys("a ");
        Thread.sleep(10000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-autocomplete-option'][1]"))).click();
        Thread.sleep(1000);
    }

    public void enterUsername() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(userName)).click();
        wait.until(ExpectedConditions.visibilityOf(userName)).sendKeys("Mohamed");
        Thread.sleep(3000);
    }

    public void enterPassword() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(password)).click();
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys("Test@1234");
        Thread.sleep(3000);
    }

    public void enterConfirmPassword() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(confirmPassword)).click();
        wait.until(ExpectedConditions.visibilityOf(confirmPassword)).sendKeys("Test@1234");
        Thread.sleep(3000);
    }

    public void clickOnSaveButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(saveButton)).click();
        Thread.sleep(10000);
    }


}
