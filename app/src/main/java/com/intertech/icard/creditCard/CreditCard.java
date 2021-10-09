package com.intertech.icard.creditCard;

public class CreditCard {

    private String cardNo, expirationDate;
    private int totalBalance;

    private String no;
    private String fullName;
    private String cardType;

    private Double Bakiye;
    private Double ToplamBorc;
    private Double AsgariTutar;
    private Double MusteriLimiti;
    private Double KalanLimit;
    private String HesapKesimTarihi;
    private String SonOdemeTarihi;

    private int CustomerNo;
    private String CreditCardNo;


    public CreditCard(int customerNo, String creditCardNo, String no, String fullName, String cardType, Double bakiye, Double toplamBorc, Double asgariTutar, Double musteriLimiti, Double kalanLimit, String hesapKesimTarihi, String sonOdemeTarihi) {
        CustomerNo = customerNo;
        CreditCardNo = creditCardNo;
        this.no = no;
        this.fullName = fullName;
        this.cardType = cardType;
        Bakiye = bakiye;
        ToplamBorc = toplamBorc;
        AsgariTutar = asgariTutar;
        MusteriLimiti = musteriLimiti;
        KalanLimit = kalanLimit;
        HesapKesimTarihi = hesapKesimTarihi;
        SonOdemeTarihi = sonOdemeTarihi;
    }

    public int getCustomerNo() {
        return CustomerNo;
    }

    public void setCustomerNo(int customerNo) {
        CustomerNo = customerNo;
    }

    public String getCreditCardNo() {
        return CreditCardNo;
    }

    public void setCreditCardNo(String creditCardNo) {
        CreditCardNo = creditCardNo;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Double getBakiye() {
        return Bakiye;
    }

    public void setBakiye(Double bakiye) {
        Bakiye = bakiye;
    }

    public Double getToplamBorc() {
        return ToplamBorc;
    }

    public void setToplamBorc(Double toplamBorc) {
        ToplamBorc = toplamBorc;
    }

    public Double getAsgariTutar() {
        return AsgariTutar;
    }

    public void setAsgariTutar(Double asgariTutar) {
        AsgariTutar = asgariTutar;
    }

    public Double getMusteriLimiti() {
        return MusteriLimiti;
    }

    public void setMusteriLimiti(Double musteriLimiti) {
        MusteriLimiti = musteriLimiti;
    }

    public Double getKalanLimit() {
        return KalanLimit;
    }

    public void setKalanLimit(Double kalanLimit) {
        KalanLimit = kalanLimit;
    }

    public String getHesapKesimTarihi() {
        return HesapKesimTarihi;
    }

    public void setHesapKesimTarihi(String hesapKesimTarihi) {
        HesapKesimTarihi = hesapKesimTarihi;
    }

    public String getSonOdemeTarihi() {
        return SonOdemeTarihi;
    }

    public void setSonOdemeTarihi(String sonOdemeTarihi) {
        SonOdemeTarihi = sonOdemeTarihi;
    }
}
