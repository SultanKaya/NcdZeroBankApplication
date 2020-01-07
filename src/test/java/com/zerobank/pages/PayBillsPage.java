package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayBillsPage extends  BasePage{

    @FindBy(css = "[id ='sp_amount']")
    private WebElement amountInputBox;

    @FindBy(id = "sp_date")
    private WebElement dateInputBox;

    @FindBy(id = "sp_description")
    private WebElement descriptionInputBox;

    @FindBy(id="pay_saved_payees")
    private WebElement payButton;

    @FindBy(css = "[id=alert_content] span")
    private WebElement alertMessage;

    public void makePayment(Double amount, String date, String description){
        if(amount != null){
            amountInputBox.sendKeys(""+amount);
        }
        if(date != null) {
            dateInputBox.sendKeys(date);
        }
        descriptionInputBox.sendKeys(description);
    }
    public void makePayment(Double amount, String date) {
        if(amount != null){
            amountInputBox.sendKeys(""+amount);
        }
        if(date != null) {
            dateInputBox.sendKeys(date);
        }
    }

    public void clickPayButton(){
        payButton.click();
    }

    public void sentKeysAmountInputBox(String amount) {
        BrowserUtils.waitForVisibility(this.amountInputBox,5);
        if( !amount.equals("null")) { this.amountInputBox.sendKeys(amount); }
    }

    public void sendKeysDateInputBox(String date) {
        BrowserUtils.waitForVisibility(this.dateInputBox,5);
       if(date != null){ this.dateInputBox.sendKeys(date); }
    }

    public void sendKeysDescriptionInputBox(String description) {
       if(description != null){ this.descriptionInputBox.sendKeys();}
    }

    public String getAlertMessage(){
        return alertMessage.getText();
    }

    public String getErrorValidationMessage(){
        if(!this.amountInputBox.getAttribute("validationMessage").isEmpty()){
       return this.amountInputBox.getAttribute("validationMessage"); }
        else { return this.dateInputBox.getAttribute("validationMessage"); }
    }

    public String getInputBoxText(String inputBox){
        if(inputBox.equalsIgnoreCase("Amount")){
            System.out.println(amountInputBox.getAttribute("value"));
            return amountInputBox.getAttribute("value");
        }else if(inputBox .equalsIgnoreCase("Date")){
            System.out.println(dateInputBox.getAttribute("value"));
            return dateInputBox.getAttribute("value");
        }else if (inputBox.equalsIgnoreCase("description")){
            System.out.println(amountInputBox.getText());
            return descriptionInputBox.getText();
        }else{
            return null;
        }
    }
}
