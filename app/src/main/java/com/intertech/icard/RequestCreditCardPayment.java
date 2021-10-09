package com.intertech.icard;

public class RequestCreditCardPayment {
    private com.intertech.icard.Header Header;
    private ParameterCreditCardPayment Parameters[]=new ParameterCreditCardPayment[1];

    public com.intertech.icard.Header getHeader() {
        return Header;
    }

    public void setHeader(com.intertech.icard.Header header) {
        this.Header = header;
    }

    public ParameterCreditCardPayment getParam() {
        return Parameters[0];
    }

    public void setParam(ParameterCreditCardPayment parameters) {
        this.Parameters[0] = parameters;
    }

    public RequestCreditCardPayment(com.intertech.icard.Header header, ParameterCreditCardPayment parameters) {
        this.Header = header;
        this.Parameters[0] = parameters;
    }
}