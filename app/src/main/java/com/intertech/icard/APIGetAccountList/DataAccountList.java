package com.intertech.icard.APIGetAccountList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataAccountList {

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("AccountList")
    @Expose
    private List<Account> accountList = null;

    public String get$type() {
        return $type;
    }

    public void set$type(String $type) {
        this.$type = $type;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

}