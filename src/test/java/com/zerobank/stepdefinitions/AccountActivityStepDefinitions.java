package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class AccountActivityStepDefinitions {
    private AccountActivityPage  accountActivityPage = new AccountActivityPage();
    private AccountSummaryPage accountSummaryPage = new AccountSummaryPage();

    @Then("user verifies that the following {string} dropdown options are available")
    public void user_verifies_that_the_following_account_dropdown_options_are_available(String dropdown, List<String> expectedOptions) {
        if(dropdown.equalsIgnoreCase("account")){
            List <String> actualOptions = accountActivityPage.getListOfDropDownOptions();
            Assert.assertEquals("Options do not match", expectedOptions,actualOptions);
        }

    }

    @Then("user verifies that the default drop down option is {string}")
    public void userVerifiesThatTheDefaultDropDownOptionIsSavings(String expectedOption) {
        String actualOption = accountActivityPage.getDefaultDropDownOption();
        Assert.assertEquals("Default options do not match",expectedOption,actualOption);
    }

    @When("user clicks on {string} link on the Account Summary Page")
    public void userClicksOnLinkLinkOnTheAccountSummaryPage(String link) {
        accountSummaryPage.clickAccountTypeLink(link);
    }

    @And("Account drop drown should have {string} selected")
    public void accountDropDrownShouldHaveOptionSelected(String expectedOption) {
       String actualOption= accountActivityPage.getDefaultDropDownOption();
       Assert.assertEquals("Wrong default option is displayed",expectedOption,actualOption);
    }
}
