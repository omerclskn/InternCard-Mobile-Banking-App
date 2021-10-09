package com.intertech.icard.APIVirtualCardCreate;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class VirtualCardCreate {

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("Data")
    @Expose
    private DataVirtualCard data;

    public String get$type() {
        return $type;
    }

    public void set$type(String $type) {
        this.$type = $type;
    }

    public DataVirtualCard getData() {
        return data;
    }

    public void setData(DataVirtualCard data) {
        this.data = data;
    }

}