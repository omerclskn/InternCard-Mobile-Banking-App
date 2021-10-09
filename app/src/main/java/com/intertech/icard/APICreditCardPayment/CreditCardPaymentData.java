package com.intertech.icard.APICreditCardPayment;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CreditCardPaymentData {

@SerializedName("$type")
@Expose
private String $type;
@SerializedName("ExpenseAmount")
@Expose
private Double expenseAmount;
@SerializedName("AccountingReference")
@Expose
private String accountingReference;
@SerializedName("State")
@Expose
private Integer state;
@SerializedName("ConfirmationToken")
@Expose
private Object confirmationToken;
@SerializedName("RequiredConfirmationType")
@Expose
private Integer requiredConfirmationType;
@SerializedName("MobilePhoneNumber")
@Expose
private Object mobilePhoneNumber;
@SerializedName("NpsSurveyGuid")
@Expose
private Object npsSurveyGuid;

public String get$type() {
return $type;
}

public void set$type(String $type) {
this.$type = $type;
}

public Double getExpenseAmount() {
return expenseAmount;
}

public void setExpenseAmount(Double expenseAmount) {
this.expenseAmount = expenseAmount;
}

public String getAccountingReference() {
return accountingReference;
}

public void setAccountingReference(String accountingReference) {
this.accountingReference = accountingReference;
}

public Integer getState() {
return state;
}

public void setState(Integer state) {
this.state = state;
}

public Object getConfirmationToken() {
return confirmationToken;
}

public void setConfirmationToken(Object confirmationToken) {
this.confirmationToken = confirmationToken;
}

public Integer getRequiredConfirmationType() {
return requiredConfirmationType;
}

public void setRequiredConfirmationType(Integer requiredConfirmationType) {
this.requiredConfirmationType = requiredConfirmationType;
}

public Object getMobilePhoneNumber() {
return mobilePhoneNumber;
}

public void setMobilePhoneNumber(Object mobilePhoneNumber) {
this.mobilePhoneNumber = mobilePhoneNumber;
}

public Object getNpsSurveyGuid() {
return npsSurveyGuid;
}

public void setNpsSurveyGuid(Object npsSurveyGuid) {
this.npsSurveyGuid = npsSurveyGuid;
}

}