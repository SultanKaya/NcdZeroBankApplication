package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginStepDefinitions {
    private LoginPage loginPage = new LoginPage();
    private PayBillsPage payBillsPage = new PayBillsPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.getProperty("url"));
    }

    @Then("user clicks on {string} button")
    public void user_clicks_on_button(String button) {
        if(button.equalsIgnoreCase("Sign in")){
            loginPage.signInButtonClick();
        }else if(button.equalsIgnoreCase("Pay")){
            payBillsPage.clickPayButton();
        }else{
            System.out.println("Invalid Button");
        }
    }

    @Then("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
       loginPage.login(username,password);
    }

    @Then("user verifies that the page title is {string}")
    public void user_verifies_that_the_page_title_is(String expectedTitle) {
       String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Wrong page title", expectedTitle,actualTitle);
    }

    @Then("user verifies that the error message {string} is displayed")
    public void user_verifies_that_the_error_message_is_displayed(String expectedErrorMessage) {
        String actualErrorMessage = loginPage.getErrorMessage();
       Assert.assertEquals("Error message is not displayed",expectedErrorMessage,actualErrorMessage);
    }

    @And("user logs in as {string}")
    public void userLogsInAsUsername(String username) {
        System.out.println("Logging in as " + username);
         loginPage.login();
    }
}
