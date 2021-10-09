package com.intertech.icard;

public class RequestIntermTransactionList {
    private com.intertech.icard.Header Header;
    private ParameterIntermTransactionList Parameters[]=new ParameterIntermTransactionList[1];

    public com.intertech.icard.Header getHeader() {
        return Header;
    }

    public void setHeader(com.intertech.icard.Header header) {
        Header = header;
    }

    public ParameterIntermTransactionList getParameters() {
        return Parameters[0];
    }

    public void setParameters(ParameterIntermTransactionList parameters) {
        Parameters[0] = parameters;
    }

    public RequestIntermTransactionList(com.intertech.icard.Header header, ParameterIntermTransactionList parameters) {
        Header = header;
        Parameters[0] = parameters;
    }
}
