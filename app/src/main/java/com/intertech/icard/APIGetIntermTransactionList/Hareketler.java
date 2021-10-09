package com.intertech.icard.APIGetIntermTransactionList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Hareketler {

@SerializedName("$type")
@Expose
private String $type;
@SerializedName("DonemIciHareketlerCardList")
@Expose
private List<List<DonemIciHareketlerCard>> donemIciHareketlerCardList = null;

public String get$type() {
return $type;
}

public void set$type(String $type) {
this.$type = $type;
}

public List<List<DonemIciHareketlerCard>> getDonemIciHareketlerCardList() {
return donemIciHareketlerCardList;
}

public void setDonemIciHareketlerCardList(List<List<DonemIciHareketlerCard>> donemIciHareketlerCardList) {
this.donemIciHareketlerCardList = donemIciHareketlerCardList;
}

}