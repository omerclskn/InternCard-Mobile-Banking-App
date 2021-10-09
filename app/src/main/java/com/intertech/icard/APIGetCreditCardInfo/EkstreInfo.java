package com.intertech.icard.APIGetCreditCardInfo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class EkstreInfo {

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("CreditCardNo")
    @Expose
    private String creditCardNo;
    @SerializedName("Currency")
    @Expose
    private String currency;
    @SerializedName("EkstreTarihi")
    @Expose
    private String ekstreTarihi;
    @SerializedName("EkstreSonOdemeTarihi")
    @Expose
    private String ekstreSonOdemeTarihi;
    @SerializedName("StatementDate")
    @Expose
    private String statementDate;
    @SerializedName("StatementLastPaymentDate")
    @Expose
    private String statementLastPaymentDate;
    @SerializedName("EkstreTutari")
    @Expose
    private Double ekstreTutari;
    @SerializedName("AsgariOdeme")
    @Expose
    private Double asgariOdeme;
    @SerializedName("OdenenTutar")
    @Expose
    private Double odenenTutar;
    @SerializedName("KalanTutar")
    @Expose
    private Double kalanTutar;
    @SerializedName("DocumentId")
    @Expose
    private Integer documentId;
    @SerializedName("IsOfflineFlag")
    @Expose
    private Boolean isOfflineFlag;
    @SerializedName("DiscountAmount")
    @Expose
    private Double discountAmount;
    @SerializedName("PaymentTotalDueDate")
    @Expose
    private Double paymentTotalDueDate;
    @SerializedName("StatementPaymentStatus")
    @Expose
    private Integer statementPaymentStatus;

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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getEkstreTarihi() {
        return ekstreTarihi;
    }

    public void setEkstreTarihi(String ekstreTarihi) {
        this.ekstreTarihi = ekstreTarihi;
    }

    public String getEkstreSonOdemeTarihi() {
        return ekstreSonOdemeTarihi;
    }

    public void setEkstreSonOdemeTarihi(String ekstreSonOdemeTarihi) {
        this.ekstreSonOdemeTarihi = ekstreSonOdemeTarihi;
    }

    public String getStatementDate() {
        return statementDate;
    }

    public void setStatementDate(String statementDate) {
        this.statementDate = statementDate;
    }

    public String getStatementLastPaymentDate() {
        return statementLastPaymentDate;
    }

    public void setStatementLastPaymentDate(String statementLastPaymentDate) {
        this.statementLastPaymentDate = statementLastPaymentDate;
    }

    public Double getEkstreTutari() {
        return ekstreTutari;
    }

    public void setEkstreTutari(Double ekstreTutari) {
        this.ekstreTutari = ekstreTutari;
    }

    public Double getAsgariOdeme() {
        return asgariOdeme;
    }

    public void setAsgariOdeme(Double asgariOdeme) {
        this.asgariOdeme = asgariOdeme;
    }

    public Double getOdenenTutar() {
        return odenenTutar;
    }

    public void setOdenenTutar(Double odenenTutar) {
        this.odenenTutar = odenenTutar;
    }

    public Double getKalanTutar() {
        return kalanTutar;
    }

    public void setKalanTutar(Double kalanTutar) {
        this.kalanTutar = kalanTutar;
    }

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    public Boolean getIsOfflineFlag() {
        return isOfflineFlag;
    }

    public void setIsOfflineFlag(Boolean isOfflineFlag) {
        this.isOfflineFlag = isOfflineFlag;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Double getPaymentTotalDueDate() {
        return paymentTotalDueDate;
    }

    public void setPaymentTotalDueDate(Double paymentTotalDueDate) {
        this.paymentTotalDueDate = paymentTotalDueDate;
    }

    public Integer getStatementPaymentStatus() {
        return statementPaymentStatus;
    }

    public void setStatementPaymentStatus(Integer statementPaymentStatus) {
        this.statementPaymentStatus = statementPaymentStatus;
    }

    public EkstreInfo(String creditCardNo, String ekstreTarihi, String ekstreSonOdemeTarihi, Double asgariOdeme, Double odenenTutar, Double kalanTutar) {
        this.creditCardNo = creditCardNo;
        this.ekstreTarihi = ekstreTarihi;
        this.ekstreSonOdemeTarihi = ekstreSonOdemeTarihi;
        this.asgariOdeme = asgariOdeme;
        this.odenenTutar = odenenTutar;
        this.kalanTutar = kalanTutar;
    }

    @Override
    public String toString() {
        return ekstreTarihi;
    }
}