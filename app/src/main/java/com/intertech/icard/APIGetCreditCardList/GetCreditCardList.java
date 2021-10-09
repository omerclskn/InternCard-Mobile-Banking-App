package com.intertech.icard.APIGetCreditCardList;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class GetCreditCardList {

@SerializedName("$type")
@Expose
private String $type;
@SerializedName("Data")
@Expose
private DataCreditCard data;

public String get$type() {
return $type;
}

public void set$type(String $type) {
this.$type = $type;
}

public DataCreditCard getData() {
return data;
}

public void setData(DataCreditCard data) {
this.data = data;
}

}