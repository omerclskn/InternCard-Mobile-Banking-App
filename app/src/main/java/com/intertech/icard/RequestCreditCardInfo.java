package com.intertech.icard;

public class RequestCreditCardInfo {
    private com.intertech.icard.Header Header;
    private ParameterCreditCardInfo Parameters[]=new ParameterCreditCardInfo[1];

    public com.intertech.icard.Header getHeader() {
        return Header;
    }

    public void setHeader(com.intertech.icard.Header header) {
        this.Header = header;
    }

    public ParameterCreditCardInfo getParam() {
        return Parameters[0];
    }

    public void setParam(ParameterCreditCardInfo parameters) {
        this.Parameters[0] = parameters;
    }

    public RequestCreditCardInfo(com.intertech.icard.Header header, ParameterCreditCardInfo parameters) {
        this.Header = header;
        this.Parameters[0] = parameters;
    }
}