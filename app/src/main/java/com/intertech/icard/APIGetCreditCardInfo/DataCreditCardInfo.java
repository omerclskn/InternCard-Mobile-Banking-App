package com.intertech.icard.APIGetCreditCardInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataCreditCardInfo {

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("CreditCardDetail")
    @Expose
    private List<CreditCardInfoCreditCardDetail> creditCardDetail = null;

    public String get$type() {
        return $type;
    }

    public void set$type(String $type) {
        this.$type = $type;
    }

    public List<CreditCardInfoCreditCardDetail> getCreditCardDetail() {
        return creditCardDetail;
    }

    public void setCreditCardDetail(List<CreditCardInfoCreditCardDetail> creditCardDetail) {
        this.creditCardDetail = creditCardDetail;
    }

}