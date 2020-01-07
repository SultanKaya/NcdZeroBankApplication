package com.zerobank.utilities;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.PayBillsPage;

public class Pages {
    private AccountActivityPage accountActivityPage;
    private AccountSummaryPage accountSummaryPage;
    private LoginPage loginPage;
    private PayBillsPage payBillsPage;

    public AccountActivityPage accountActivityPage() {
        if(accountActivityPage == null){
            accountActivityPage = new AccountActivityPage();
        }
        return accountActivityPage;
    }

    public AccountSummaryPage accountSummaryPage() {
        if(accountSummaryPage == null){
            accountSummaryPage = new AccountSummaryPage();
        }
        return accountSummaryPage;
    }

    public LoginPage loginPage() {
        if(loginPage == null){
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public PayBillsPage payBillsPage() {
        if(payBillsPage==null){
            payBillsPage = new PayBillsPage();
        }
        return payBillsPage;
    }
}
