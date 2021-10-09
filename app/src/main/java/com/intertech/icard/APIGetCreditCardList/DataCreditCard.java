package com.intertech.icard.APIGetCreditCardList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class DataCreditCard {

@SerializedName("$type")
@Expose
private String $type;
@SerializedName("CreditCardDetail")
@Expose
private List<CreditCardCreditCardDetail> creditCardCreditCardDetail = null;

public String get$type() {
return $type;
}

public void set$type(String $type) {
this.$type = $type;
}

public List<CreditCardCreditCardDetail> getCreditCardDetail() {
return creditCardCreditCardDetail;
}

public void setCreditCardDetail(List<CreditCardCreditCardDetail> creditCardCreditCardDetail) {
this.creditCardCreditCardDetail = creditCardCreditCardDetail;
}

}