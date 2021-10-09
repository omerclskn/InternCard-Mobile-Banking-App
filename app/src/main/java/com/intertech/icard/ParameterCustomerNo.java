package com.intertech.icard;

public class ParameterCustomerNo {
    private String  CustomerNo;

    public ParameterCustomerNo(String customerNo) {
        CustomerNo = customerNo;
    }

    public String getCustomerNo() {
        return CustomerNo;
    }

    public void setCustomerNo(String customerNo) {
        CustomerNo = customerNo;
    }
}
