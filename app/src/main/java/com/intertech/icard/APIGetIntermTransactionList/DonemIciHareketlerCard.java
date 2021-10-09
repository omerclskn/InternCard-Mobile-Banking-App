
package com.intertech.icard.APIGetIntermTransactionList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class DonemIciHareketlerCard {

@SerializedName("$type")
@Expose
private String $type;
@SerializedName("TrnCodeDetail")
@Expose
private Object trnCodeDetail;
@SerializedName("CardNo")
@Expose
private String cardNo;
@SerializedName("IslemTarihi")
@Expose
private String islemTarihi;
@SerializedName("IslemAciklamasi")
@Expose
private String islemAciklamasi;
@SerializedName("HareketTipi")
@Expose
private String hareketTipi;
@SerializedName("CardBehaviourType")
@Expose
private String cardBehaviourType;
@SerializedName("TrnProcessType")
@Expose
private String trnProcessType;
@SerializedName("IslemTipi")
@Expose
private String islemTipi;
@SerializedName("IslemTutari")
@Expose
private Double islemTutari;
@SerializedName("OrjinalTutar")
@Expose
private Double orjinalTutar;
@SerializedName("TakasTutari")
@Expose
private Double takasTutari;
@SerializedName("MilPoint")
@Expose
private Double milPoint;
@SerializedName("BonusPuan")
@Expose
private Double bonusPuan;
@SerializedName("KalanTaksitSayi")
@Expose
private Integer kalanTaksitSayi;
@SerializedName("ToplamTaksitSayi")
@Expose
private Integer toplamTaksitSayi;
@SerializedName("TaksitSayi")
@Expose
private Integer taksitSayi;
@SerializedName("KalanTaksitTutar")
@Expose
private Double kalanTaksitTutar;
@SerializedName("HareketAdi")
@Expose
private String hareketAdi;
@SerializedName("UyeIsyeriKategorisi")
@Expose
private String uyeIsyeriKategorisi;
@SerializedName("UyeIsyeriKategoriAciklamasi")
@Expose
private String uyeIsyeriKategoriAciklamasi;
@SerializedName("UyeIsyeriAdi")
@Expose
private String uyeIsyeriAdi;
@SerializedName("UyeIsyeriSehri")
@Expose
private String uyeIsyeriSehri;
@SerializedName("UyeIsyeriBolgesi")
@Expose
private Object uyeIsyeriBolgesi;
@SerializedName("UyeIsyeriUlkesi")
@Expose
private String uyeIsyeriUlkesi;
@SerializedName("ProvizyonNo")
@Expose
private String provizyonNo;
@SerializedName("MRCCode")
@Expose
private String mRCCode;
@SerializedName("IslemKaynagi")
@Expose
private String islemKaynagi;
@SerializedName("OtelemeFlag")
@Expose
private Boolean otelemeFlag;
@SerializedName("Currency")
@Expose
private String currency;
@SerializedName("IslemParaBirimi")
@Expose
private String islemParaBirimi;
@SerializedName("IsSuitableForExtraInstallment")
@Expose
private Boolean isSuitableForExtraInstallment;
@SerializedName("DebitCredit")
@Expose
private String debitCredit;
@SerializedName("ShadowCardNumber")
@Expose
private Object shadowCardNumber;
@SerializedName("TrnCode")
@Expose
private Object trnCode;
@SerializedName("TrnAmount")
@Expose
private Double trnAmount;
@SerializedName("IsOfflineFlag")
@Expose
private Boolean isOfflineFlag;
@SerializedName("MainTransactionId")
@Expose
private Integer mainTransactionId;
@SerializedName("BankRefId")
@Expose
private Object bankRefId;
@SerializedName("CreditCartTransferFlag")
@Expose
private Boolean creditCartTransferFlag;
@SerializedName("CardTransactionGroupId")
@Expose
private Integer cardTransactionGroupId;
@SerializedName("ParaBirimi")
@Expose
private String paraBirimi;

public String get$type() {
return $type;
}

public void set$type(String $type) {
this.$type = $type;
}

public Object getTrnCodeDetail() {
return trnCodeDetail;
}

public void setTrnCodeDetail(Object trnCodeDetail) {
this.trnCodeDetail = trnCodeDetail;
}

public String getCardNo() {
return cardNo;
}

public void setCardNo(String cardNo) {
this.cardNo = cardNo;
}

public String getIslemTarihi() {
return islemTarihi;
}

public void setIslemTarihi(String islemTarihi) {
this.islemTarihi = islemTarihi;
}

public String getIslemAciklamasi() {
return islemAciklamasi;
}

public void setIslemAciklamasi(String islemAciklamasi) {
this.islemAciklamasi = islemAciklamasi;
}

public String getHareketTipi() {
return hareketTipi;
}

public void setHareketTipi(String hareketTipi) {
this.hareketTipi = hareketTipi;
}

public String getCardBehaviourType() {
return cardBehaviourType;
}

public void setCardBehaviourType(String cardBehaviourType) {
this.cardBehaviourType = cardBehaviourType;
}

public String getTrnProcessType() {
return trnProcessType;
}

public void setTrnProcessType(String trnProcessType) {
this.trnProcessType = trnProcessType;
}

public String getIslemTipi() {
return islemTipi;
}

public void setIslemTipi(String islemTipi) {
this.islemTipi = islemTipi;
}

public Double getIslemTutari() {
return islemTutari;
}

public void setIslemTutari(Double islemTutari) {
this.islemTutari = islemTutari;
}

public Double getOrjinalTutar() {
return orjinalTutar;
}

public void setOrjinalTutar(Double orjinalTutar) {
this.orjinalTutar = orjinalTutar;
}

public Double getTakasTutari() {
return takasTutari;
}

public void setTakasTutari(Double takasTutari) {
this.takasTutari = takasTutari;
}

public Double getMilPoint() {
return milPoint;
}

public void setMilPoint(Double milPoint) {
this.milPoint = milPoint;
}

public Double getBonusPuan() {
return bonusPuan;
}

public void setBonusPuan(Double bonusPuan) {
this.bonusPuan = bonusPuan;
}

public Integer getKalanTaksitSayi() {
return kalanTaksitSayi;
}

public void setKalanTaksitSayi(Integer kalanTaksitSayi) {
this.kalanTaksitSayi = kalanTaksitSayi;
}

public Integer getToplamTaksitSayi() {
return toplamTaksitSayi;
}

public void setToplamTaksitSayi(Integer toplamTaksitSayi) {
this.toplamTaksitSayi = toplamTaksitSayi;
}

public Integer getTaksitSayi() {
return taksitSayi;
}

public void setTaksitSayi(Integer taksitSayi) {
this.taksitSayi = taksitSayi;
}

public Double getKalanTaksitTutar() {
return kalanTaksitTutar;
}

public void setKalanTaksitTutar(Double kalanTaksitTutar) {
this.kalanTaksitTutar = kalanTaksitTutar;
}

public String getHareketAdi() {
return hareketAdi;
}

public void setHareketAdi(String hareketAdi) {
this.hareketAdi = hareketAdi;
}

public String getUyeIsyeriKategorisi() {
return uyeIsyeriKategorisi;
}

public void setUyeIsyeriKategorisi(String uyeIsyeriKategorisi) {
this.uyeIsyeriKategorisi = uyeIsyeriKategorisi;
}

public String getUyeIsyeriKategoriAciklamasi() {
return uyeIsyeriKategoriAciklamasi;
}

public void setUyeIsyeriKategoriAciklamasi(String uyeIsyeriKategoriAciklamasi) {
this.uyeIsyeriKategoriAciklamasi = uyeIsyeriKategoriAciklamasi;
}

public String getUyeIsyeriAdi() {
return uyeIsyeriAdi;
}

public void setUyeIsyeriAdi(String uyeIsyeriAdi) {
this.uyeIsyeriAdi = uyeIsyeriAdi;
}

public String getUyeIsyeriSehri() {
return uyeIsyeriSehri;
}

public void setUyeIsyeriSehri(String uyeIsyeriSehri) {
this.uyeIsyeriSehri = uyeIsyeriSehri;
}

public Object getUyeIsyeriBolgesi() {
return uyeIsyeriBolgesi;
}

public void setUyeIsyeriBolgesi(Object uyeIsyeriBolgesi) {
this.uyeIsyeriBolgesi = uyeIsyeriBolgesi;
}

public String getUyeIsyeriUlkesi() {
return uyeIsyeriUlkesi;
}

public void setUyeIsyeriUlkesi(String uyeIsyeriUlkesi) {
this.uyeIsyeriUlkesi = uyeIsyeriUlkesi;
}

public String getProvizyonNo() {
return provizyonNo;
}

public void setProvizyonNo(String provizyonNo) {
this.provizyonNo = provizyonNo;
}

public String getMRCCode() {
return mRCCode;
}

public void setMRCCode(String mRCCode) {
this.mRCCode = mRCCode;
}

public String getIslemKaynagi() {
return islemKaynagi;
}

public void setIslemKaynagi(String islemKaynagi) {
this.islemKaynagi = islemKaynagi;
}

public Boolean getOtelemeFlag() {
return otelemeFlag;
}

public void setOtelemeFlag(Boolean otelemeFlag) {
this.otelemeFlag = otelemeFlag;
}

public String getCurrency() {
return currency;
}

public void setCurrency(String currency) {
this.currency = currency;
}

public String getIslemParaBirimi() {
return islemParaBirimi;
}

public void setIslemParaBirimi(String islemParaBirimi) {
this.islemParaBirimi = islemParaBirimi;
}

public Boolean getIsSuitableForExtraInstallment() {
return isSuitableForExtraInstallment;
}

public void setIsSuitableForExtraInstallment(Boolean isSuitableForExtraInstallment) {
this.isSuitableForExtraInstallment = isSuitableForExtraInstallment;
}

public String getDebitCredit() {
return debitCredit;
}

public void setDebitCredit(String debitCredit) {
this.debitCredit = debitCredit;
}

public Object getShadowCardNumber() {
return shadowCardNumber;
}

public void setShadowCardNumber(Object shadowCardNumber) {
this.shadowCardNumber = shadowCardNumber;
}

public Object getTrnCode() {
return trnCode;
}

public void setTrnCode(Object trnCode) {
this.trnCode = trnCode;
}

public Double getTrnAmount() {
return trnAmount;
}

public void setTrnAmount(Double trnAmount) {
this.trnAmount = trnAmount;
}

public Boolean getIsOfflineFlag() {
return isOfflineFlag;
}

public void setIsOfflineFlag(Boolean isOfflineFlag) {
this.isOfflineFlag = isOfflineFlag;
}

public Integer getMainTransactionId() {
return mainTransactionId;
}

public void setMainTransactionId(Integer mainTransactionId) {
this.mainTransactionId = mainTransactionId;
}

public Object getBankRefId() {
return bankRefId;
}

public void setBankRefId(Object bankRefId) {
this.bankRefId = bankRefId;
}

public Boolean getCreditCartTransferFlag() {
return creditCartTransferFlag;
}

public void setCreditCartTransferFlag(Boolean creditCartTransferFlag) {
this.creditCartTransferFlag = creditCartTransferFlag;
}

public Integer getCardTransactionGroupId() {
return cardTransactionGroupId;
}

public void setCardTransactionGroupId(Integer cardTransactionGroupId) {
this.cardTransactionGroupId = cardTransactionGroupId;
}

public String getParaBirimi() {
return paraBirimi;
}

public void setParaBirimi(String paraBirimi) {
this.paraBirimi = paraBirimi;
}

}