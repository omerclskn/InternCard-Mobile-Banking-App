
package com.intertech.icard.APIGetIntermTransactionList;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class GetIntermTransactionList {

@SerializedName("$type")
@Expose
private String $type;
@SerializedName("Data")
@Expose
private DataIntermTransaction dataIntermTransaction;

public String get$type() {
return $type;
}

public void set$type(String $type) {
this.$type = $type;
}

public DataIntermTransaction getData() {
return dataIntermTransaction;
}

public void setData(DataIntermTransaction dataIntermTransaction) {
this.dataIntermTransaction = dataIntermTransaction;
}

}