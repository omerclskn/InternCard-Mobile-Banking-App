package com.intertech.icard.APIVirtualCardCreate;




import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class DataVirtualCard {

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("CreditCardNo")
    @Expose
    private String creditCardNo;
    @SerializedName("SanalCardNo")
    @Expose
    private String sanalCardNo;
    @SerializedName("SanalCardExpiryDate")
    @Expose
    private String sanalCardExpiryDate;
    @SerializedName("SanalCardCVC2")
    @Expose
    private String sanalCardCVC2;
    @SerializedName("ShadowCardNumber")
    @Expose
    private String shadowCardNumber;
    @SerializedName("TransactionCode")
    @Expose
    private String transactionCode;
    @SerializedName("ExpenseAmount")
    @Expose
    private Double expenseAmount;
    @SerializedName("SourceAccount")
    @Expose
    private Object sourceAccount;
    @SerializedName("TransactionDate")
    @Expose
    private String transactionDate;
    @SerializedName("AccountingReference")
    @Expose
    private String accountingReference;
    @SerializedName("TransactionID")
    @Expose
    private Integer transactionID;
    @SerializedName("State")
    @Expose
    private Integer state;
    @SerializedName("CreditInfoForConfirmations")
    @Expose
    private Object creditInfoForConfirmations;
    @SerializedName("ConfirmationToken")
    @Expose
    private Object confirmationToken;
    @SerializedName("RequiredConfirmationType")
    @Expose
    private Integer requiredConfirmationType;
    @SerializedName("Otp")
    @Expose
    private Object otp;
    @SerializedName("MobilePhoneNumber")
    @Expose
    private Object mobilePhoneNumber;
    @SerializedName("CanUserCommitTransaction")
    @Expose
    private Boolean canUserCommitTransaction;
    @SerializedName("NpsSurveyGuid")
    @Expose
    private Object npsSurveyGuid;

    public String get$type() {
        return $type;
    }

    public void set$type(String $type) {
        this.$type = $type;
    }

    public String getCreditCardNo() {
        return creditCardNo;
    }

    public void setCreditCardNo(String creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    public String getSanalCardNo() {
        return sanalCardNo;
    }

    public void setSanalCardNo(String sanalCardNo) {
        this.sanalCardNo = sanalCardNo;
    }

    public String getSanalCardExpiryDate() {
        return sanalCardExpiryDate;
    }

    public void setSanalCardExpiryDate(String sanalCardExpiryDate) {
        this.sanalCardExpiryDate = sanalCardExpiryDate;
    }

    public String getSanalCardCVC2() {
        return sanalCardCVC2;
    }

    public void setSanalCardCVC2(String sanalCardCVC2) {
        this.sanalCardCVC2 = sanalCardCVC2;
    }

    public String getShadowCardNumber() {
        return shadowCardNumber;
    }

    public void setShadowCardNumber(String shadowCardNumber) {
        this.shadowCardNumber = shadowCardNumber;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public Double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(Double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public Object getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(Object sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getAccountingReference() {
        return accountingReference;
    }

    public void setAccountingReference(String accountingReference) {
        this.accountingReference = accountingReference;
    }

    public Integer getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Integer transactionID) {
        this.transactionID = transactionID;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Object getCreditInfoForConfirmations() {
        return creditInfoForConfirmations;
    }

    public void setCreditInfoForConfirmations(Object creditInfoForConfirmations) {
        this.creditInfoForConfirmations = creditInfoForConfirmations;
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

    public Object getOtp() {
        return otp;
    }

    public void setOtp(Object otp) {
        this.otp = otp;
    }

    public Object getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(Object mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public Boolean getCanUserCommitTransaction() {
        return canUserCommitTransaction;
    }

    public void setCanUserCommitTransaction(Boolean canUserCommitTransaction) {
        this.canUserCommitTransaction = canUserCommitTransaction;
    }

    public Object getNpsSurveyGuid() {
        return npsSurveyGuid;
    }

    public void setNpsSurveyGuid(Object npsSurveyGuid) {
        this.npsSurveyGuid = npsSurveyGuid;
    }

}