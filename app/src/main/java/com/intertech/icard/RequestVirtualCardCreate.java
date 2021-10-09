package com.intertech.icard;

public class RequestVirtualCardCreate {
    private com.intertech.icard.Header Header;
    private com.intertech.icard.ParameterVirtualCardCreate Parameters[]=new com.intertech.icard.ParameterVirtualCardCreate[1];

    public com.intertech.icard.Header getHeader() {
        return Header;
    }

    public void setHeader(com.intertech.icard.Header header) {
        this.Header = header;
    }

    public com.intertech.icard.ParameterVirtualCardCreate getParam() {
        return Parameters[0];
    }

    public void setParam(com.intertech.icard.ParameterVirtualCardCreate parameters) {
        this.Parameters[0] = parameters;
    }

    public RequestVirtualCardCreate(com.intertech.icard.Header header, com.intertech.icard.ParameterVirtualCardCreate parameters) {
        this.Header = header;
        this.Parameters[0] = parameters;
    }
}
