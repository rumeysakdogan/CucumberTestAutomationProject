package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }

    @When("user logs in")
    public void user_logs_in() throws InterruptedException {

        loginPage.login("storemanager");
        Thread.sleep(3000);
    }

    @Then("user should see dashboard page")
    public void user_should_see_dashboard_page() {

        BrowserUtils.wait(3);

        String expected = "Dashboard";
        String actual = loginPage.getPageSubTitleText();

        Assert.assertEquals("Title is not correct!", expected, actual);
        System.out.println("I see the Dashboard page!");
        Driver.closeDriver();
    }

    @Then("user should see {string} page")
    public void user_should_see_page(String expected) {

        BrowserUtils.wait(3);
        String actual = loginPage.getPageSubTitleText().trim();
        Assert.assertEquals("Title is not correct!", expected, actual);
    }

    //  When user logs in as "driver"
    // When user logs in as "salesmanager"
    // When user logs in as "storemanager"
    @When("user logs in as {string}")
    public void user_logs_in_as(String string) {
     loginPage.login(string);
    }

    //String
    //When user logs in with "storemanager85" username and "wrong" password
    @When("user logs in with {string} username and {string} password")
    public void user_logs_in_with_username_and_password(String string, String string2) {
       loginPage.login(string,string2);
    }

    // String expected = "Invalid user name or password."
    //Then user verifies that "Invalid user name or password." message is displayed
    @Then("user verifies that {string} message is displayed")
    public void user_verifies_that_message_is_displayed(String expected) {

        String actualResult = loginPage.getWarningMessageText();
        Assert.assertEquals(expected, actualResult);
    }



}
