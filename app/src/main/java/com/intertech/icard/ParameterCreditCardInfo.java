package com.intertech.icard;

public class ParameterCreditCardInfo {
    private String  CustomerNo;
    private String CreditCardNo;
    private boolean LoadStatements;
    private int StatementCount;

    public String getCustomerNo() {
        return CustomerNo;
    }

    public void setCustomerNo(String customerNo) {
        CustomerNo = customerNo;
    }

    public String getCreditCardNo() {
        return CreditCardNo;
    }

    public void setCreditCardNo(String creditCardNo) {
        CreditCardNo = creditCardNo;
    }

    public boolean isLoadStatements() {
        return LoadStatements;
    }

    public void setLoadStatements(boolean loadStatements) {
        LoadStatements = loadStatements;
    }

    public int getStatementCount() {
        return StatementCount;
    }

    public void setStatementCount(int statementCount) {
        StatementCount = statementCount;
    }

    public ParameterCreditCardInfo(String customerNo, String creditCardNo, boolean loadStatements, int statementCount) {
        CustomerNo = customerNo;
        CreditCardNo = creditCardNo;
        LoadStatements = loadStatements;
        StatementCount = statementCount;
    }
}
