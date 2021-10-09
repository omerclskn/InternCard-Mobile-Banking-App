package com.intertech.icard;

public class ParameterIntermTransactionList {
    private String  CustomerNo;
    private String  CreditCardNo;
    private CreditCardDetailClass  CreditCardDetail;

    public String getCustomerNo() {
        return CustomerNo;
    }

    public void setCustomerNo(String customerNo) {
        CustomerNo = customerNo;
    }

    public ParameterIntermTransactionList(String customerNo, String creditCardNo, CreditCardDetailClass creditCardDetail) {
        CustomerNo = customerNo;
        CreditCardNo = creditCardNo;
        CreditCardDetail = creditCardDetail;
    }

    public String getCreditCardNo() {
        return CreditCardNo;
    }

    public void setCreditCardNo(String creditCardNo) {
        CreditCardNo = creditCardNo;
    }

    public CreditCardDetailClass getCreditCardDetail() {
        return CreditCardDetail;
    }

    public void setCreditCardDetail(CreditCardDetailClass creditCardDetail) {
        CreditCardDetail = creditCardDetail;
    }
}

class CreditCardDetailClass {
    private String OperationCode;

    public String getOperationCode() {
        return OperationCode;
    }

    public CreditCardDetailClass(String operationCode) {
        OperationCode = operationCode;
    }

    public void setOperationCode(String operationCode) {
        OperationCode = operationCode;
    }
}

