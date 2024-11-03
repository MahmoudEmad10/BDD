package stepDefinitions;

import baseTest.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AddUser;
import pages.AdminPage;
import pages.LoginPage;
import util.ConfigReader;

public class AdminSteps {
    private LoginPage loginPage;
    private AdminPage adminPage;
    private WebDriver driver;
    private ConfigReader configReader;
    private AddUser addUser;
    private int initialCount;

    public AdminSteps() {
        configReader = new ConfigReader();
        driver = BaseTest.getInstance().returnDriver();
        loginPage = new LoginPage(driver);
        adminPage = new AdminPage(driver);
        addUser = new AddUser(driver);
    }

    @Given("user has logged in to OrangeHRM with username and password")
    public void userHasLoggedIn() {
        loginPage.login();
    }

    @When("user navigates to Admin tab")
    public void userNavigatesToAdmin() throws InterruptedException {
        adminPage.clickAdminTab();
    }

    @Then("user retrieves the number of records")
    public void userRetrievesRecordsCount() throws InterruptedException {
        initialCount = adminPage.getRecordsCount();
        System.out.println("initialCount is : " + initialCount);
    }

    @Then("user adds a new record")
    public void user_adds_new_record() throws InterruptedException {
        adminPage.clickAddButton();
        addUser.selectUserRole();
        addUser.selectStatus();
        addUser.enterEmployeeName();
        addUser.enterUsername();
        addUser.enterPassword();
        addUser.enterConfirmPassword();
        addUser.clickOnSaveButton();
    }

    @Then("the records count should increase by one")
    public void records_count_increase_by_one() throws InterruptedException {
        int updatedCount = adminPage.getRecordsCount();
        Assert.assertEquals(initialCount + 1, updatedCount);
        System.out.println("Updated records count: " + updatedCount);
    }

    @When("user search for the recently added record")
    public void user_search_for_the_recently_added_record() throws InterruptedException {
        adminPage.searchWithUserName();
        addUser.clickOnSaveButton();
    }

    @When("user deletes the recently added record")
    public void delete_recently_added_record() throws InterruptedException {
        adminPage.clickDeleteIcon();
        adminPage.AssertThatDeleteConfirmationMsgIsDisplayed();
        adminPage.clickOnConfirmDelete();
        adminPage.AssertThatDeleteToastMsgIsDisplayed();
        adminPage.AssertDeleteToastMsgText();
        Thread.sleep(5000);
    }

    @Then("the records count should decrease by one")
    public void records_count_decrease_by_one() throws InterruptedException {
        int updatedCount = adminPage.getRecordsCount();
        Assert.assertEquals(initialCount - 1, updatedCount);
        System.out.println("Updated records count: " + updatedCount);
    }

    @When("user click on reset button")
    public void user_click_on_reset_button() throws InterruptedException {
        adminPage.clickResetButton();
        Thread.sleep(5000);
    }

}
