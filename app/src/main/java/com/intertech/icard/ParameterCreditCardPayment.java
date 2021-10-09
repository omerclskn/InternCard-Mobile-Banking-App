package com.intertech.icard;

public class ParameterCreditCardPayment {
    SourceAccountClass SourceAccount;
    double Amount;
    String CreditCardNo;
    int CustomerNo;

    public ParameterCreditCardPayment(SourceAccountClass sourceAccount, double amount, String creditCardNo, int customerNo) {
        SourceAccount = sourceAccount;
        Amount = amount;
        CreditCardNo = creditCardNo;
        CustomerNo = customerNo;
    }

    public SourceAccountClass getSourceAccount() {
        return SourceAccount;
    }

    public void setSourceAccount(SourceAccountClass sourceAccount) {
        SourceAccount = sourceAccount;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public String getCreditCardNo() {
        return CreditCardNo;
    }

    public void setCreditCardNo(String creditCardNo) {
        CreditCardNo = creditCardNo;
    }

    public int getCustomerNo() {
        return CustomerNo;
    }

    public void setCustomerNo(int customerNo) {
        CustomerNo = customerNo;
    }
}

class SourceAccountClass{
    int BranchCode;
    int CustomerNo;

    public SourceAccountClass(int branchCode, int customerNo, int accountSuffix, String currencyCode) {
        BranchCode = branchCode;
        CustomerNo = customerNo;
        AccountSuffix = accountSuffix;
        CurrencyCode = currencyCode;
    }

    public int getBranchCode() {
        return BranchCode;
    }

    public void setBranchCode(int branchCode) {
        BranchCode = branchCode;
    }

    public int getCustomerNo() {
        return CustomerNo;
    }

    public void setCustomerNo(int customerNo) {
        CustomerNo = customerNo;
    }

    public int getAccountSuffix() {
        return AccountSuffix;
    }

    public void setAccountSuffix(int accountSuffix) {
        AccountSuffix = accountSuffix;
    }

    public String getCurrencyCode() {
        return CurrencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        CurrencyCode = currencyCode;
    }

    int AccountSuffix;
    String CurrencyCode;
}