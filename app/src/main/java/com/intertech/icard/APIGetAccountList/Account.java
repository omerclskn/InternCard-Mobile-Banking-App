package com.intertech.icard.APIGetAccountList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Account {

    @SerializedName("$type")
    @Expose
    private String $type;
    @SerializedName("IsBlockedAccount")
    @Expose
    private Boolean isBlockedAccount;
    @SerializedName("BlockageType")
    @Expose
    private String blockageType;
    @SerializedName("IsPartialBlockedAccount")
    @Expose
    private Boolean isPartialBlockedAccount;
    @SerializedName("IsAggregatedAccount")
    @Expose
    private Boolean isAggregatedAccount;
    @SerializedName("AccountSuffix")
    @Expose
    private Integer accountSuffix;
    @SerializedName("BranchCode")
    @Expose
    private Integer branchCode;
    @SerializedName("BranchName")
    @Expose
    private String branchName;
    @SerializedName("CustomerNo")
    @Expose
    private Integer customerNo;
    @SerializedName("ProductCode")
    @Expose
    private String productCode;
    @SerializedName("OriginalProductCode")
    @Expose
    private String originalProductCode;
    @SerializedName("ProjectCode")
    @Expose
    private String projectCode;
    @SerializedName("ShortName")
    @Expose
    private String shortName;
    @SerializedName("AccountOpenningChannelCode")
    @Expose
    private String accountOpenningChannelCode;
    @SerializedName("IsClosed")
    @Expose
    private Boolean isClosed;
    @SerializedName("IsDisplayedOnInternet")
    @Expose
    private Boolean isDisplayedOnInternet;
    @SerializedName("IsAutoInvested")
    @Expose
    private Boolean isAutoInvested;
    @SerializedName("CurrencyCode")
    @Expose
    private String currencyCode;
    @SerializedName("AnalysisCode")
    @Expose
    private String analysisCode;
    @SerializedName("ReceivableInterestRate")
    @Expose
    private Double receivableInterestRate;
    @SerializedName("DebtInterestRate")
    @Expose
    private Double debtInterestRate;
    @SerializedName("AmountOfBalance")
    @Expose
    private Double amountOfBalance;
    @SerializedName("AmountOfBalanceGross")
    @Expose
    private Double amountOfBalanceGross;
    @SerializedName("AvailableCaptainBalance")
    @Expose
    private Double availableCaptainBalance;
    @SerializedName("AvailableBalance")
    @Expose
    private Double availableBalance;
    @SerializedName("AvailableBalanceGross")
    @Expose
    private Double availableBalanceGross;
    @SerializedName("PreviousDateBalanceGross")
    @Expose
    private Double previousDateBalanceGross;
    @SerializedName("SCCode")
    @Expose
    private List<Object> sCCode = null;
    @SerializedName("IsPersonnelAccount")
    @Expose
    private Boolean isPersonnelAccount;
    @SerializedName("AccountName")
    @Expose
    private String accountName;
    @SerializedName("IBANNo")
    @Expose
    private String iBANNo;
    @SerializedName("CaptainAccountFundBalance")
    @Expose
    private Double captainAccountFundBalance;
    @SerializedName("CaptainAccountBalance")
    @Expose
    private Double captainAccountBalance;
    @SerializedName("AvailableCreditDepositBalance")
    @Expose
    private Double availableCreditDepositBalance;
    @SerializedName("CaptainAccountFlag")
    @Expose
    private Boolean captainAccountFlag;
    @SerializedName("ModernAccountFlag")
    @Expose
    private Boolean modernAccountFlag;
    @SerializedName("ModernAccountMinumumBalance")
    @Expose
    private Double modernAccountMinumumBalance;
    @SerializedName("DormantAccountFlag")
    @Expose
    private Boolean dormantAccountFlag;
    @SerializedName("ValueDate")
    @Expose
    private Object valueDate;
    @SerializedName("MaturityDate")
    @Expose
    private Object maturityDate;
    @SerializedName("AccountClosingDate")
    @Expose
    private Object accountClosingDate;
    @SerializedName("AccountClosingUserCode")
    @Expose
    private Object accountClosingUserCode;
    @SerializedName("AccountOpenningDate")
    @Expose
    private Object accountOpenningDate;
    @SerializedName("AccountOpenningUserCode")
    @Expose
    private String accountOpenningUserCode;
    @SerializedName("ReverseBalancePositionFlag")
    @Expose
    private String reverseBalancePositionFlag;
    @SerializedName("ReverseBalanceAbilityFlag")
    @Expose
    private String reverseBalanceAbilityFlag;
    @SerializedName("CDAFlag")
    @Expose
    private String cDAFlag;
    @SerializedName("BlockageCodeName")
    @Expose
    private String blockageCodeName;
    @SerializedName("BlockageName")
    @Expose
    private String blockageName;
    @SerializedName("BlockageReasonCode")
    @Expose
    private String blockageReasonCode;
    @SerializedName("BlockageReasonCodeName")
    @Expose
    private String blockageReasonCodeName;
    @SerializedName("BlockageExplanation")
    @Expose
    private String blockageExplanation;
    @SerializedName("BlockageUserCode")
    @Expose
    private String blockageUserCode;
    @SerializedName("BlockageAmount")
    @Expose
    private Double blockageAmount;
    @SerializedName("BlockageMaturityDate")
    @Expose
    private Object blockageMaturityDate;
    @SerializedName("BlockageValueDate")
    @Expose
    private Object blockageValueDate;
    @SerializedName("PreviousDateBalance")
    @Expose
    private Double previousDateBalance;
    @SerializedName("TotalPartialBlockageAmount")
    @Expose
    private Double totalPartialBlockageAmount;
    @SerializedName("DebitAccuredInterestAmountForKMH")
    @Expose
    private Double debitAccuredInterestAmountForKMH;
    @SerializedName("CaptainAvailableBalance")
    @Expose
    private Double captainAvailableBalance;
    @SerializedName("HasSchoolPayment")
    @Expose
    private String hasSchoolPayment;
    @SerializedName("AvailableCreditDeposit")
    @Expose
    private Double availableCreditDeposit;
    @SerializedName("BatchDate")
    @Expose
    private Object batchDate;
    @SerializedName("DelayCount")
    @Expose
    private Integer delayCount;
    @SerializedName("MinPaymentAmount")
    @Expose
    private Double minPaymentAmount;
    @SerializedName("LastPaymentDate")
    @Expose
    private Object lastPaymentDate;
    @SerializedName("CDALimit")
    @Expose
    private Double cDALimit;
    @SerializedName("DebitAccruedInterestAmount")
    @Expose
    private Double debitAccruedInterestAmount;
    @SerializedName("DayToMaturity")
    @Expose
    private Integer dayToMaturity;
    @SerializedName("CreditInterestRate")
    @Expose
    private Double creditInterestRate;
    @SerializedName("NetInterestAmount")
    @Expose
    private Double netInterestAmount;
    @SerializedName("CreditAccruedInterestAmount")
    @Expose
    private Double creditAccruedInterestAmount;
    @SerializedName("RollType")
    @Expose
    private String rollType;
    @SerializedName("IsSuitableForIncomeAndOut")
    @Expose
    private Boolean isSuitableForIncomeAndOut;
    @SerializedName("IsPos")
    @Expose
    private Boolean isPos;
    @SerializedName("CdaCashSuffix")
    @Expose
    private Integer cdaCashSuffix;
    @SerializedName("CdaAvailableLimit")
    @Expose
    private Double cdaAvailableLimit;
    @SerializedName("IsDormantAccount")
    @Expose
    private Boolean isDormantAccount;
    @SerializedName("RateType")
    @Expose
    private String rateType;
    @SerializedName("CdaChangeReasonCode")
    @Expose
    private Object cdaChangeReasonCode;
    @SerializedName("CdaReasonDescription")
    @Expose
    private Object cdaReasonDescription;
    @SerializedName("TransactionCodeList")
    @Expose
    private Object transactionCodeList;
    @SerializedName("AdditionalTufeRate")
    @Expose
    private Double additionalTufeRate;
    @SerializedName("TransferrableBlockageAmount")
    @Expose
    private Double transferrableBlockageAmount;
    @SerializedName("IsFreeZoneAccount")
    @Expose
    private Boolean isFreeZoneAccount;

    public String get$type() {
        return $type;
    }

    public void set$type(String $type) {
        this.$type = $type;
    }

    public Boolean getIsBlockedAccount() {
        return isBlockedAccount;
    }

    public void setIsBlockedAccount(Boolean isBlockedAccount) {
        this.isBlockedAccount = isBlockedAccount;
    }

    public String getBlockageType() {
        return blockageType;
    }

    public void setBlockageType(String blockageType) {
        this.blockageType = blockageType;
    }

    public Boolean getIsPartialBlockedAccount() {
        return isPartialBlockedAccount;
    }

    public void setIsPartialBlockedAccount(Boolean isPartialBlockedAccount) {
        this.isPartialBlockedAccount = isPartialBlockedAccount;
    }

    public Boolean getIsAggregatedAccount() {
        return isAggregatedAccount;
    }

    public void setIsAggregatedAccount(Boolean isAggregatedAccount) {
        this.isAggregatedAccount = isAggregatedAccount;
    }

    public Integer getAccountSuffix() {
        return accountSuffix;
    }

    public void setAccountSuffix(Integer accountSuffix) {
        this.accountSuffix = accountSuffix;
    }

    public Integer getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(Integer branchCode) {
        this.branchCode = branchCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Integer getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(Integer customerNo) {
        this.customerNo = customerNo;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getOriginalProductCode() {
        return originalProductCode;
    }

    public void setOriginalProductCode(String originalProductCode) {
        this.originalProductCode = originalProductCode;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getAccountOpenningChannelCode() {
        return accountOpenningChannelCode;
    }

    public void setAccountOpenningChannelCode(String accountOpenningChannelCode) {
        this.accountOpenningChannelCode = accountOpenningChannelCode;
    }

    public Boolean getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
    }

    public Boolean getIsDisplayedOnInternet() {
        return isDisplayedOnInternet;
    }

    public void setIsDisplayedOnInternet(Boolean isDisplayedOnInternet) {
        this.isDisplayedOnInternet = isDisplayedOnInternet;
    }

    public Boolean getIsAutoInvested() {
        return isAutoInvested;
    }

    public void setIsAutoInvested(Boolean isAutoInvested) {
        this.isAutoInvested = isAutoInvested;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getAnalysisCode() {
        return analysisCode;
    }

    public void setAnalysisCode(String analysisCode) {
        this.analysisCode = analysisCode;
    }

    public Double getReceivableInterestRate() {
        return receivableInterestRate;
    }

    public void setReceivableInterestRate(Double receivableInterestRate) {
        this.receivableInterestRate = receivableInterestRate;
    }

    public Double getDebtInterestRate() {
        return debtInterestRate;
    }

    public void setDebtInterestRate(Double debtInterestRate) {
        this.debtInterestRate = debtInterestRate;
    }

    public Double getAmountOfBalance() {
        return amountOfBalance;
    }

    public void setAmountOfBalance(Double amountOfBalance) {
        this.amountOfBalance = amountOfBalance;
    }

    public Double getAmountOfBalanceGross() {
        return amountOfBalanceGross;
    }

    public void setAmountOfBalanceGross(Double amountOfBalanceGross) {
        this.amountOfBalanceGross = amountOfBalanceGross;
    }

    public Double getAvailableCaptainBalance() {
        return availableCaptainBalance;
    }

    public void setAvailableCaptainBalance(Double availableCaptainBalance) {
        this.availableCaptainBalance = availableCaptainBalance;
    }

    public Double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Double getAvailableBalanceGross() {
        return availableBalanceGross;
    }

    public void setAvailableBalanceGross(Double availableBalanceGross) {
        this.availableBalanceGross = availableBalanceGross;
    }

    public Double getPreviousDateBalanceGross() {
        return previousDateBalanceGross;
    }

    public void setPreviousDateBalanceGross(Double previousDateBalanceGross) {
        this.previousDateBalanceGross = previousDateBalanceGross;
    }

    public List<Object> getSCCode() {
        return sCCode;
    }

    public void setSCCode(List<Object> sCCode) {
        this.sCCode = sCCode;
    }

    public Boolean getIsPersonnelAccount() {
        return isPersonnelAccount;
    }

    public void setIsPersonnelAccount(Boolean isPersonnelAccount) {
        this.isPersonnelAccount = isPersonnelAccount;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getIBANNo() {
        return iBANNo;
    }

    public void setIBANNo(String iBANNo) {
        this.iBANNo = iBANNo;
    }

    public Double getCaptainAccountFundBalance() {
        return captainAccountFundBalance;
    }

    public void setCaptainAccountFundBalance(Double captainAccountFundBalance) {
        this.captainAccountFundBalance = captainAccountFundBalance;
    }

    public Double getCaptainAccountBalance() {
        return captainAccountBalance;
    }

    public void setCaptainAccountBalance(Double captainAccountBalance) {
        this.captainAccountBalance = captainAccountBalance;
    }

    public Double getAvailableCreditDepositBalance() {
        return availableCreditDepositBalance;
    }

    public void setAvailableCreditDepositBalance(Double availableCreditDepositBalance) {
        this.availableCreditDepositBalance = availableCreditDepositBalance;
    }

    public Boolean getCaptainAccountFlag() {
        return captainAccountFlag;
    }

    public void setCaptainAccountFlag(Boolean captainAccountFlag) {
        this.captainAccountFlag = captainAccountFlag;
    }

    public Boolean getModernAccountFlag() {
        return modernAccountFlag;
    }

    public void setModernAccountFlag(Boolean modernAccountFlag) {
        this.modernAccountFlag = modernAccountFlag;
    }

    public Double getModernAccountMinumumBalance() {
        return modernAccountMinumumBalance;
    }

    public void setModernAccountMinumumBalance(Double modernAccountMinumumBalance) {
        this.modernAccountMinumumBalance = modernAccountMinumumBalance;
    }

    public Boolean getDormantAccountFlag() {
        return dormantAccountFlag;
    }

    public void setDormantAccountFlag(Boolean dormantAccountFlag) {
        this.dormantAccountFlag = dormantAccountFlag;
    }

    public Object getValueDate() {
        return valueDate;
    }

    public void setValueDate(Object valueDate) {
        this.valueDate = valueDate;
    }

    public Object getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Object maturityDate) {
        this.maturityDate = maturityDate;
    }

    public Object getAccountClosingDate() {
        return accountClosingDate;
    }

    public void setAccountClosingDate(Object accountClosingDate) {
        this.accountClosingDate = accountClosingDate;
    }

    public Object getAccountClosingUserCode() {
        return accountClosingUserCode;
    }

    public void setAccountClosingUserCode(Object accountClosingUserCode) {
        this.accountClosingUserCode = accountClosingUserCode;
    }

    public Object getAccountOpenningDate() {
        return accountOpenningDate;
    }

    public void setAccountOpenningDate(Object accountOpenningDate) {
        this.accountOpenningDate = accountOpenningDate;
    }

    public String getAccountOpenningUserCode() {
        return accountOpenningUserCode;
    }

    public void setAccountOpenningUserCode(String accountOpenningUserCode) {
        this.accountOpenningUserCode = accountOpenningUserCode;
    }

    public String getReverseBalancePositionFlag() {
        return reverseBalancePositionFlag;
    }

    public void setReverseBalancePositionFlag(String reverseBalancePositionFlag) {
        this.reverseBalancePositionFlag = reverseBalancePositionFlag;
    }

    public String getReverseBalanceAbilityFlag() {
        return reverseBalanceAbilityFlag;
    }

    public void setReverseBalanceAbilityFlag(String reverseBalanceAbilityFlag) {
        this.reverseBalanceAbilityFlag = reverseBalanceAbilityFlag;
    }

    public String getCDAFlag() {
        return cDAFlag;
    }

    public void setCDAFlag(String cDAFlag) {
        this.cDAFlag = cDAFlag;
    }

    public String getBlockageCodeName() {
        return blockageCodeName;
    }

    public void setBlockageCodeName(String blockageCodeName) {
        this.blockageCodeName = blockageCodeName;
    }

    public String getBlockageName() {
        return blockageName;
    }

    public void setBlockageName(String blockageName) {
        this.blockageName = blockageName;
    }

    public String getBlockageReasonCode() {
        return blockageReasonCode;
    }

    public void setBlockageReasonCode(String blockageReasonCode) {
        this.blockageReasonCode = blockageReasonCode;
    }

    public String getBlockageReasonCodeName() {
        return blockageReasonCodeName;
    }

    public void setBlockageReasonCodeName(String blockageReasonCodeName) {
        this.blockageReasonCodeName = blockageReasonCodeName;
    }

    public String getBlockageExplanation() {
        return blockageExplanation;
    }

    public void setBlockageExplanation(String blockageExplanation) {
        this.blockageExplanation = blockageExplanation;
    }

    public String getBlockageUserCode() {
        return blockageUserCode;
    }

    public void setBlockageUserCode(String blockageUserCode) {
        this.blockageUserCode = blockageUserCode;
    }

    public Double getBlockageAmount() {
        return blockageAmount;
    }

    public void setBlockageAmount(Double blockageAmount) {
        this.blockageAmount = blockageAmount;
    }

    public Object getBlockageMaturityDate() {
        return blockageMaturityDate;
    }

    public void setBlockageMaturityDate(Object blockageMaturityDate) {
        this.blockageMaturityDate = blockageMaturityDate;
    }

    public Object getBlockageValueDate() {
        return blockageValueDate;
    }

    public void setBlockageValueDate(Object blockageValueDate) {
        this.blockageValueDate = blockageValueDate;
    }

    public Double getPreviousDateBalance() {
        return previousDateBalance;
    }

    public void setPreviousDateBalance(Double previousDateBalance) {
        this.previousDateBalance = previousDateBalance;
    }

    public Double getTotalPartialBlockageAmount() {
        return totalPartialBlockageAmount;
    }

    public void setTotalPartialBlockageAmount(Double totalPartialBlockageAmount) {
        this.totalPartialBlockageAmount = totalPartialBlockageAmount;
    }

    public Double getDebitAccuredInterestAmountForKMH() {
        return debitAccuredInterestAmountForKMH;
    }

    public void setDebitAccuredInterestAmountForKMH(Double debitAccuredInterestAmountForKMH) {
        this.debitAccuredInterestAmountForKMH = debitAccuredInterestAmountForKMH;
    }

    public Double getCaptainAvailableBalance() {
        return captainAvailableBalance;
    }

    public void setCaptainAvailableBalance(Double captainAvailableBalance) {
        this.captainAvailableBalance = captainAvailableBalance;
    }

    public String getHasSchoolPayment() {
        return hasSchoolPayment;
    }

    public void setHasSchoolPayment(String hasSchoolPayment) {
        this.hasSchoolPayment = hasSchoolPayment;
    }

    public Double getAvailableCreditDeposit() {
        return availableCreditDeposit;
    }

    public void setAvailableCreditDeposit(Double availableCreditDeposit) {
        this.availableCreditDeposit = availableCreditDeposit;
    }

    public Object getBatchDate() {
        return batchDate;
    }

    public void setBatchDate(Object batchDate) {
        this.batchDate = batchDate;
    }

    public Integer getDelayCount() {
        return delayCount;
    }

    public void setDelayCount(Integer delayCount) {
        this.delayCount = delayCount;
    }

    public Double getMinPaymentAmount() {
        return minPaymentAmount;
    }

    public void setMinPaymentAmount(Double minPaymentAmount) {
        this.minPaymentAmount = minPaymentAmount;
    }

    public Object getLastPaymentDate() {
        return lastPaymentDate;
    }

    public void setLastPaymentDate(Object lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }

    public Double getCDALimit() {
        return cDALimit;
    }

    public void setCDALimit(Double cDALimit) {
        this.cDALimit = cDALimit;
    }

    public Double getDebitAccruedInterestAmount() {
        return debitAccruedInterestAmount;
    }

    public void setDebitAccruedInterestAmount(Double debitAccruedInterestAmount) {
        this.debitAccruedInterestAmount = debitAccruedInterestAmount;
    }

    public Integer getDayToMaturity() {
        return dayToMaturity;
    }

    public void setDayToMaturity(Integer dayToMaturity) {
        this.dayToMaturity = dayToMaturity;
    }

    public Double getCreditInterestRate() {
        return creditInterestRate;
    }

    public void setCreditInterestRate(Double creditInterestRate) {
        this.creditInterestRate = creditInterestRate;
    }

    public Double getNetInterestAmount() {
        return netInterestAmount;
    }

    public void setNetInterestAmount(Double netInterestAmount) {
        this.netInterestAmount = netInterestAmount;
    }

    public Double getCreditAccruedInterestAmount() {
        return creditAccruedInterestAmount;
    }

    public void setCreditAccruedInterestAmount(Double creditAccruedInterestAmount) {
        this.creditAccruedInterestAmount = creditAccruedInterestAmount;
    }

    public String getRollType() {
        return rollType;
    }

    public void setRollType(String rollType) {
        this.rollType = rollType;
    }

    public Boolean getIsSuitableForIncomeAndOut() {
        return isSuitableForIncomeAndOut;
    }

    public void setIsSuitableForIncomeAndOut(Boolean isSuitableForIncomeAndOut) {
        this.isSuitableForIncomeAndOut = isSuitableForIncomeAndOut;
    }

    public Boolean getIsPos() {
        return isPos;
    }

    public void setIsPos(Boolean isPos) {
        this.isPos = isPos;
    }

    public Integer getCdaCashSuffix() {
        return cdaCashSuffix;
    }

    public void setCdaCashSuffix(Integer cdaCashSuffix) {
        this.cdaCashSuffix = cdaCashSuffix;
    }

    public Double getCdaAvailableLimit() {
        return cdaAvailableLimit;
    }

    public void setCdaAvailableLimit(Double cdaAvailableLimit) {
        this.cdaAvailableLimit = cdaAvailableLimit;
    }

    public Boolean getIsDormantAccount() {
        return isDormantAccount;
    }

    public void setIsDormantAccount(Boolean isDormantAccount) {
        this.isDormantAccount = isDormantAccount;
    }

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public Object getCdaChangeReasonCode() {
        return cdaChangeReasonCode;
    }

    public void setCdaChangeReasonCode(Object cdaChangeReasonCode) {
        this.cdaChangeReasonCode = cdaChangeReasonCode;
    }

    public Object getCdaReasonDescription() {
        return cdaReasonDescription;
    }

    public void setCdaReasonDescription(Object cdaReasonDescription) {
        this.cdaReasonDescription = cdaReasonDescription;
    }

    public Object getTransactionCodeList() {
        return transactionCodeList;
    }

    public void setTransactionCodeList(Object transactionCodeList) {
        this.transactionCodeList = transactionCodeList;
    }

    public Double getAdditionalTufeRate() {
        return additionalTufeRate;
    }

    public void setAdditionalTufeRate(Double additionalTufeRate) {
        this.additionalTufeRate = additionalTufeRate;
    }

    public Double getTransferrableBlockageAmount() {
        return transferrableBlockageAmount;
    }

    public void setTransferrableBlockageAmount(Double transferrableBlockageAmount) {
        this.transferrableBlockageAmount = transferrableBlockageAmount;
    }

    public Boolean getIsFreeZoneAccount() {
        return isFreeZoneAccount;
    }

    public void setIsFreeZoneAccount(Boolean isFreeZoneAccount) {
        this.isFreeZoneAccount = isFreeZoneAccount;
    }

    private static String beautifyTheMoney(double _money) {
        if (_money == 0) {
            return "0,00";
        } else if (_money < 0) {
            return Double.toString(_money);
        }

        double kurus = _money - (int) _money;
        String string_kurus = Double.toString(kurus);
        string_kurus += "0"; //tek ondalikli gelirse, çift ondalıklı sayiya çevirmek icin

        String money = Integer.toString((int) _money);
        StringBuffer sb = new StringBuffer(Integer.toString((int) _money));

        for (int i = 1; money.length() > 3 * i; i++) {
            sb.insert(money.length() - 3 * i, ".");
        }
        return sb + "," + string_kurus.substring(2, 4);
    }

    /**
     * Pay attention here, you have to override the toString method as the
     * ArrayAdapter will reads the toString of the given object for the name
     *
     * @return contact_name
     */
    @Override
    public String toString() {
        return beautifyTheMoney(amountOfBalance) +" ₺ "+accountName;
    }

}