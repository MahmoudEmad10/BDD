package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AdminPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "a[href='/web/index.php/admin/viewAdminModule']")
    WebElement adminTab;

    @FindBy(css = "span[class='oxd-text oxd-text--span']")
    WebElement recordsCount;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement addButton;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    WebElement systemUserName;

    @FindBy(xpath = "(//i[@class='oxd-icon bi-trash'])[1]")
    WebElement deleteIcon;

    @FindBy(xpath = "(//p[@class='oxd-text oxd-text--p oxd-text--card-body'])")
    WebElement deleteConfirmationMsg;

    @FindBy(xpath = "(//button[contains(@class, 'oxd-button')])[5]")
    WebElement confirmDeleteButton;

    @FindBy(id = "oxd-toaster_1")
    WebElement successfullyDeleteToast;

    @FindBy(xpath = "(//button[contains(@class, 'oxd-button')])[1]")
    WebElement resetButton;

    public void clickAdminTab() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(adminTab)).click();
    }

    public int getRecordsCount() throws InterruptedException {
        String countText = wait.until(ExpectedConditions.visibilityOf(recordsCount)).getText();
        Thread.sleep(3000);
        String number = countText.replaceAll("[^0-9]", "");
        int recordCount = Integer.parseInt(number);
        return recordCount;
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.visibilityOf(addButton)).click();
        System.out.println("Button add is clicked");
    }

    public void searchWithUserName(String username) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(systemUserName)).sendKeys(username);
    }

    public void clickDeleteIcon() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(deleteIcon)).click();
    }

    public void AssertThatDeleteConfirmationMsgIsDisplayed() {
        String actualMsg = wait.until(ExpectedConditions.visibilityOf(deleteConfirmationMsg)).getText();
        Assert.assertEquals(actualMsg, "The selected record will be permanently deleted. Are you sure you want to continue?");
    }

    public void clickOnConfirmDelete() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(confirmDeleteButton)).click();
    }

    public void AssertThatDeleteToastMsgIsDisplayed() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(successfullyDeleteToast)).isDisplayed());
    }

    public void AssertDeleteToastMsgText() {
        String actualMsg = wait.until(ExpectedConditions.visibilityOf(successfullyDeleteToast)).getText();
        Assert.assertEquals(actualMsg, "Success\n" +
                "Successfully Deleted\n" +
                "×");
    }

    public void clickResetButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(resetButton)).click();
        Thread.sleep(5000);
    }

}
