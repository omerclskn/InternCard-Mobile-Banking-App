package com.intertech.icard;

import com.intertech.icard.APICreditCardPayment.CreditCardPayment;
import com.intertech.icard.APIGetAccountList.GetAccountList;
import com.intertech.icard.APIGetCreditCardInfo.GetCreditCardInfo;
import com.intertech.icard.APIGetCreditCardList.GetCreditCardList;
import com.intertech.icard.APIGetIntermTransactionList.GetIntermTransactionList;
import com.intertech.icard.APIVirtualCardCreate.VirtualCardCreate;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface RetrofitClient {

    @Headers({"Content-Type: application/json","Ocp-Apim-Subscription-Key: 9a08001407a04215acf918e4c51c21dd"})
    @POST("BankingApiV01/GetCreditCardList")
    Call<GetCreditCardList> GetPostGetCreditCardListValue(@Body com.intertech.icard.RequestCustomerNo customerNo);

    @Headers({"Content-Type: application/json","Ocp-Apim-Subscription-Key: 9a08001407a04215acf918e4c51c21dd"})
    @POST("BankingApiV01/cards/GetIntermTransactionList")
    Call<GetIntermTransactionList> GetPostIntermTransactionListValue(@Body com.intertech.icard.RequestIntermTransactionList value);

    @Headers({"Content-Type: application/json","Ocp-Apim-Subscription-Key: 9a08001407a04215acf918e4c51c21dd"})
    @POST("BankingApiV01/cards/GetCreditCardInfo")
    Call<GetCreditCardInfo> GetPostCreditCardInfoValue(@Body com.intertech.icard.RequestCreditCardInfo value);

    @Headers({"Content-Type: application/json","Ocp-Apim-Subscription-Key: 9a08001407a04215acf918e4c51c21dd"})
    @POST("BankingApiV01/GetAccountList")
    Call<GetAccountList> GetAccountListValue(@Body com.intertech.icard.RequestCustomerNo value);

    @Headers({"Content-Type: application/json","Ocp-Apim-Subscription-Key: 9a08001407a04215acf918e4c51c21dd"})
    @POST("BankingApiV01/cards/CreditCardPayment")
    Call<CreditCardPayment> GetCreditCardPaymentValue(@Body com.intertech.icard.RequestCreditCardPayment value);

    @Headers({"Content-Type: application/json","Ocp-Apim-Subscription-Key: 9a08001407a04215acf918e4c51c21dd"})
    @POST("BankingApiV01/cards/VirtualCardCreate")
    Call<VirtualCardCreate> GetVirtualCardCreateValue(@Body com.intertech.icard.RequestVirtualCardCreate value);
}