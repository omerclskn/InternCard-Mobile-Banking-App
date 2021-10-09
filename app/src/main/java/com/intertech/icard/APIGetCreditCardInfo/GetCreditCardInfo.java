package com.intertech.icard.APIGetCreditCardInfo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class GetCreditCardInfo {

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("Data")
    @Expose
    private DataCreditCardInfo data;

    public String get$type() {
        return $type;
    }

    public void set$type(String $type) {
        this.$type = $type;
    }

    public DataCreditCardInfo getData() {
        return data;
    }

    public void setData(DataCreditCardInfo data) {
        this.data = data;
    }

}