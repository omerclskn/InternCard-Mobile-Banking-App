package com.intertech.icard.APICreditCardPayment;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CreditCardPayment {

@SerializedName("$type")
@Expose
private String $type;

@SerializedName("Data")
@Expose
private CreditCardPaymentData data;

public String get$type() {
return $type;
}

public void set$type(String $type) {
this.$type = $type;
}

public CreditCardPaymentData getData() {
return data;
}

public void setData(CreditCardPaymentData data) {
this.data = data;
}

}