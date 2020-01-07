package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage extends BasePage{

    @FindBy (id = "aa_accountId")
    public WebElement accountDropdown;

    @FindBy(css = "#all_transactions_for_account th")
    public List<WebElement> transactionTableHeaders;


    public String getDefaultDropDownOption(){
        Select select = new Select(accountDropdown);
        return  select.getFirstSelectedOption().getText();
    }

    public void setDropDownOption(String option){
        Select select = new Select(accountDropdown);
        select.selectByVisibleText(option);

    }

    public List<String> getListOfDropDownOptions(){
        Select select = new Select(accountDropdown);
        return BrowserUtils.getListOfString(select.getOptions());
    }

    public List<String> getTransactionTableHeadersList(){
        return BrowserUtils.getListOfString(transactionTableHeaders);
    }
}
