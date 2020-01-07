package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountSummaryStepDefinitions {
    private AccountSummaryPage accountSummaryPage = new AccountSummaryPage();


    @Then("user navigates to {string} tab")
    public void user_navigates_to_tab(String tab) {
       accountSummaryPage.navigateTo(tab);
    }

    @Then("user verifies that the following account types are displayed")
    public void user_verifies_that_the_following_account_types_are_displayed(List<String> expectedAccountTypes) {
        Assert.assertEquals("List dont match",expectedAccountTypes,accountSummaryPage.accountTypes());
    }

    @Then("user verifies that {string} following table columns are displayed")
    public void userVerifiesThatCreditAccountsFollowingTableColumnsAreDisplayed(String table, List<String> expectedTableColumns) {
        List<String> actualTableColumns=accountSummaryPage.tableColumns(table);
        Assert.assertEquals("Table columns dont match",expectedTableColumns,actualTableColumns);
    }
}
