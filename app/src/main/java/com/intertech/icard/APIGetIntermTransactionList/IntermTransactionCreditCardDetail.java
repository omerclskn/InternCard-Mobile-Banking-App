
package com.intertech.icard.APIGetIntermTransactionList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class IntermTransactionCreditCardDetail {

@SerializedName("$type")
@Expose
private String $type;
@SerializedName("Hareketler")
@Expose
private List<Hareketler> hareketler = null;

public String get$type() {
return $type;
}

public void set$type(String $type) {
this.$type = $type;
}

public List<Hareketler> getHareketler() {
return hareketler;
}

public void setHareketler(List<Hareketler> hareketler) {
this.hareketler = hareketler;
}

}



