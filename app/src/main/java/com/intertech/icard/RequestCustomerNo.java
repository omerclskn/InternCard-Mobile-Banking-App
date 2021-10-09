package com.intertech.icard;

public class RequestCustomerNo {
    private com.intertech.icard.Header Header;
    private com.intertech.icard.ParameterCustomerNo Parameters[]=new com.intertech.icard.ParameterCustomerNo[1];

    public com.intertech.icard.Header getHeader() {
        return Header;
    }

    public void setHeader(com.intertech.icard.Header header) {
        this.Header = header;
    }

    public com.intertech.icard.ParameterCustomerNo getParam() {
        return Parameters[0];
    }

    public void setParam(com.intertech.icard.ParameterCustomerNo parameters) {
        this.Parameters[0] = parameters;
    }

    public RequestCustomerNo(com.intertech.icard.Header header, com.intertech.icard.ParameterCustomerNo parameters) {
        this.Header = header;
        this.Parameters[0] = parameters;
    }
}