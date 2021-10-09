package com.intertech.icard;

public class ParameterVirtualCardCreate {
    private int  CardLimit;
    private String CreditCardNo;
    private String CustomerNo;

    public int getCardLimit() {
        return CardLimit;
    }

    public ParameterVirtualCardCreate(int cardLimit, String creditCardNo, String customerNo) {
        CardLimit = cardLimit;
        CreditCardNo = creditCardNo;
        CustomerNo = customerNo;
    }

    public void setCardLimit(int cardLimit) {
        CardLimit = cardLimit;
    }

    public String getCreditCardNo() {
        return CreditCardNo;
    }

    public void setCreditCardNo(String creditCardNo) {
        CreditCardNo = creditCardNo;
    }

    public String getCustomerNo() {
        return CustomerNo;
    }

    public void setCustomerNo(String customerNo) {
        CustomerNo = customerNo;
    }
}
