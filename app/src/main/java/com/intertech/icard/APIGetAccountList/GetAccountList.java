package com.intertech.icard.APIGetAccountList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetAccountList {

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("Data")
    @Expose
    private DataAccountList data;

    public String get$type() {
        return $type;
    }

    public void set$type(String $type) {
        this.$type = $type;
    }

    public DataAccountList getData() {
        return data;
    }

    public void setData(DataAccountList data) {
        this.data = data;
    }

}