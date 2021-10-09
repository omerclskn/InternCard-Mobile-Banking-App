
package com.intertech.icard.APIGetIntermTransactionList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class DataIntermTransaction {

@SerializedName("$type")
@Expose
private String $type;
@SerializedName("CreditCardDetail")
@Expose
private List<IntermTransactionCreditCardDetail> intermTransactionCreditCardDetail = null;

public String get$type() {
return $type;
}

public void set$type(String $type) {
this.$type = $type;
}

public List<IntermTransactionCreditCardDetail> getCreditCardDetail() {
return intermTransactionCreditCardDetail;
}

public void setCreditCardDetail(List<IntermTransactionCreditCardDetail> intermTransactionCreditCardDetail) {
this.intermTransactionCreditCardDetail = intermTransactionCreditCardDetail;
}

}