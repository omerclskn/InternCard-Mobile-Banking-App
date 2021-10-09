package com.intertech.icard.APIGetCreditCardList;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CardLimits {

@SerializedName("$type")
@Expose
private String $type;
@SerializedName("MarjsizKartLimit")
@Expose
private Double marjsizKartLimit;
@SerializedName("KartKullanilabilirKredi")
@Expose
private Double kartKullanilabilirKredi;
@SerializedName("MarjsizKartLimitNA")
@Expose
private Double marjsizKartLimitNA;
@SerializedName("KullanilabilirKrediNA")
@Expose
private Double kullanilabilirKrediNA;
@SerializedName("ExpressLimit")
@Expose
private Double expressLimit;
@SerializedName("Kullan\u0131labilirExpressLimit")
@Expose
private Double kullanLabilirExpressLimit;
@SerializedName("LimitUsed")
@Expose
private Double limitUsed;
@SerializedName("LimitUsedTRY")
@Expose
private Double limitUsedTRY;
@SerializedName("LimitUsedUSD")
@Expose
private Double limitUsedUSD;
@SerializedName("LimitUsedEUR")
@Expose
private Double limitUsedEUR;

public String get$type() {
return $type;
}

public void set$type(String $type) {
this.$type = $type;
}

public Double getMarjsizKartLimit() {
return marjsizKartLimit;
}

public void setMarjsizKartLimit(Double marjsizKartLimit) {
this.marjsizKartLimit = marjsizKartLimit;
}

public Double getKartKullanilabilirKredi() {
return kartKullanilabilirKredi;
}

public void setKartKullanilabilirKredi(Double kartKullanilabilirKredi) {
this.kartKullanilabilirKredi = kartKullanilabilirKredi;
}

public Double getMarjsizKartLimitNA() {
return marjsizKartLimitNA;
}

public void setMarjsizKartLimitNA(Double marjsizKartLimitNA) {
this.marjsizKartLimitNA = marjsizKartLimitNA;
}

public Double getKullanilabilirKrediNA() {
return kullanilabilirKrediNA;
}

public void setKullanilabilirKrediNA(Double kullanilabilirKrediNA) {
this.kullanilabilirKrediNA = kullanilabilirKrediNA;
}

public Double getExpressLimit() {
return expressLimit;
}

public void setExpressLimit(Double expressLimit) {
this.expressLimit = expressLimit;
}

public Double getKullanLabilirExpressLimit() {
return kullanLabilirExpressLimit;
}

public void setKullanLabilirExpressLimit(Double kullanLabilirExpressLimit) {
this.kullanLabilirExpressLimit = kullanLabilirExpressLimit;
}

public Double getLimitUsed() {
return limitUsed;
}

public void setLimitUsed(Double limitUsed) {
this.limitUsed = limitUsed;
}

public Double getLimitUsedTRY() {
return limitUsedTRY;
}

public void setLimitUsedTRY(Double limitUsedTRY) {
this.limitUsedTRY = limitUsedTRY;
}

public Double getLimitUsedUSD() {
return limitUsedUSD;
}

public void setLimitUsedUSD(Double limitUsedUSD) {
this.limitUsedUSD = limitUsedUSD;
}

public Double getLimitUsedEUR() {
return limitUsedEUR;
}

public void setLimitUsedEUR(Double limitUsedEUR) {
this.limitUsedEUR = limitUsedEUR;
}

}


