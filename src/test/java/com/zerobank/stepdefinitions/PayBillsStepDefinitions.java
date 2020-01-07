package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class PayBillsStepDefinitions {
        private PayBillsPage payBillsPage = new PayBillsPage();
    @Then("user enters payment amount of {string}")
    public void user_enters_payment_amount_of(String amount) {
       payBillsPage.sentKeysAmountInputBox(amount);
    }

    @Then("user enters date of {string}")
    public void user_enters_date_of(String date) {
        payBillsPage.sendKeysDateInputBox(date);
    }

    @Then("user verifies that the success message is displayed {string}")
    public void user_verifies_that_the_success_message_is_displayed(String expectedAlertMessage) {
        String actualAlertMessage = payBillsPage.getAlertMessage();
        Assert.assertEquals("Alert message is wrong",expectedAlertMessage,actualAlertMessage);
    }

    @Then("user verifies that the error message {string} is displayed on {string} page")
    public void userVerifiesThatTheErrorMessagePleaseFillOutThisFieldMessageIsDisplayedOnPayBillsPage(String expectedErrorMessage,String page) {
          String actualMessage;
            if(page.equalsIgnoreCase("Pay Bills")){
                actualMessage = payBillsPage.getErrorValidationMessage();
            }else {
                actualMessage = null;
            }
            Assert.assertEquals("Error message is wrong",expectedErrorMessage,actualMessage);

    }

    @Then("user verifies that {string} input box is empty")
    public void userVerifiesThatDateInputBoxIsEmpty(String inputBox) {
            String inputText = payBillsPage.getInputBoxText(inputBox);
            Assert.assertTrue(inputText.isEmpty());

    }
}
