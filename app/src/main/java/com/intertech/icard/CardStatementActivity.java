package com.intertech.icard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.intertech.icard.APIGetCreditCardInfo.EkstreInfo;
import com.intertech.icard.APIGetCreditCardInfo.GetCreditCardInfo;
import com.intertech.icard.APIGetIntermTransactionList.DonemIciHareketlerCard;
import com.intertech.icard.APIGetIntermTransactionList.GetIntermTransactionList;
import com.intertech.icard.cardStatement.CardStatement;
import com.intertech.icard.cardStatement.CardStatementAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CardStatementActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private RecyclerView rcvCardStatement;
    private CardStatementAdapter cardStatementAdapter;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_statement);


        ((BottomNavigationView)findViewById(R.id.bottomNavigationCardStatement)).setSelectedItemId(R.id.mCreditCard);

        bottomNavigationView = findViewById(R.id.bottomNavigationCardStatement);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        //bottomNavigationView.setSelectedItemId(R.id.mCreditCard);

        ((TextView) findViewById(R.id.txt_cardNoVirtualCard)).setText(getIntent().getStringExtra("MaskedCardNo"));
        ((TextView) findViewById(R.id.txt_balance1VirtualCard)).setText(getIntent().getStringExtra("FullName"));
        ((TextView) findViewById(R.id.txt_expirationDateVirtualCard)).setText(getIntent().getStringExtra("CardName"));
        //((TextView)findViewById(R.id.tv_cardType)).setText(getIntent().getStringExtra("CardName"));
        //((TextView)findViewById(R.id.tv_fullName)).setText(getIntent().getStringExtra("FullName"));

        ((TextView) findViewById(R.id.textView444)).setText(getIntent().getStringExtra("SonOdeme"));
        ((TextView) findViewById(R.id.textView44)).setText(getIntent().getStringExtra("Borc"));
        ((TextView) findViewById(R.id.textView4)).setText(getIntent().getStringExtra("HesapKesim"));

        sendNetworkRequest(getIntent().getIntExtra("CustomerNO", 0), getIntent().getStringExtra("CardNumber"));
        sendNetworkRequest1(getIntent().getIntExtra("CustomerNO", 0), getIntent().getStringExtra("CardNumber"));


        ArrayList<EkstreInfo> list = new ArrayList<>();
        list.add(new EkstreInfo("", "", "", 0.0, 0.0, 0.0));

        ArrayAdapter<EkstreInfo> adapter;
        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        Spinner donemlerclick = (Spinner) findViewById(R.id.spinner2);


        donemlerclick.setAdapter(adapter);

        donemlerclick.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                ((TextView) findViewById(R.id.textView444)).setText(((EkstreInfo) (donemlerclick.getAdapter().getItem(position))).getEkstreSonOdemeTarihi());
                ((TextView) findViewById(R.id.textView44)).setText(((EkstreInfo) (donemlerclick.getAdapter().getItem(position))).getKalanTutar().toString());
                ((TextView) findViewById(R.id.textView4)).setText(((EkstreInfo) (donemlerclick.getAdapter().getItem(position))).getEkstreTarihi());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

                Toast.makeText(getApplicationContext(), "Seçilmedi", Toast.LENGTH_LONG).show();
            }

        });


        rcvCardStatement = findViewById(R.id.rcv_spending);
        cardStatementAdapter = new CardStatementAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvCardStatement.setLayoutManager(linearLayoutManager);

        cardStatementAdapter.setData(getListCardStatement());
        rcvCardStatement.setAdapter(cardStatementAdapter);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mHome:
                Intent intent = new Intent(CardStatementActivity.this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.mCreditCard:
                Intent intent2 = new Intent(CardStatementActivity.this, CardActivity.class);
                startActivity(intent2);
                return true;
            case R.id.mHelp:
                Toast.makeText(CardStatementActivity.this, "Yardım Sayfası", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mSettings:
                Toast.makeText(CardStatementActivity.this, "Ayarlar Sayfası", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }

    private List<CardStatement> getListCardStatement() {
        List<CardStatement> list = new ArrayList<>();

        list.add(new CardStatement(2020, "Ağustos", 3, "12:00", "2500.0", "INTERTECH BİLGİ İŞLEM VE", "INTERTECH BİLGİ İŞLEM VE", "istanbul", "TL"));
        list.add(new CardStatement(2020, "Haziran", 3, "12:00", "2500.0", "INTERTECH BİLGİ İŞLEM VE", "trend", "istanbul", "TL"));

        return list;
    }

    private String intToDateString(int ay) {
        switch (ay) {
            case 1:
                return "Ocak";

            case 2:
                return "Şubat";

            case 3:
                return "Mart";

            case 4:
                return "Nisan";

            case 5:
                return "Mayıs";

            case 6:
                return "Haziran";

            case 7:
                return "Temmuz";

            case 8:
                return "Ağustos";

            case 9:
                return "Eylül";

            case 10:
                return "Ekim";

            case 11:
                return "Kasım";

            case 12:
                return "Aralık";

            default:
                return "Öyle Ay Yok";

        }
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

    private void sendNetworkRequest(int CustomerNumber, String CreditCardNo) {
        List<CardStatement> list = new ArrayList<>();

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-gateway.intertech.com.tr/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        ParameterIntermTransactionList param = new ParameterIntermTransactionList(Integer.toString(CustomerNumber), CreditCardNo, new CreditCardDetailClass("H"));
        Header header = new Header("c1c2a508fdf64c14a7b44edc9241c9cd", "API",
                "takim2", "takim2");

        RequestIntermTransactionList customerNo = new RequestIntermTransactionList(header, param);
        RetrofitClient ourRetrofitClient = retrofit.create(RetrofitClient.class);
        Call<GetIntermTransactionList> res = ourRetrofitClient.GetPostIntermTransactionListValue(customerNo);


        res.enqueue(new Callback<GetIntermTransactionList>() {
            @Override
            public void onResponse(Call<GetIntermTransactionList> call, Response<GetIntermTransactionList> response) {

                //Toast.makeText(getApplicationContext(), "oldu", Toast.LENGTH_LONG).show();


                System.out.println("HTTP STATUS" + response.code());
                if (response.isSuccessful()) {

                     for (DonemIciHareketlerCard card : response.body().getData().getCreditCardDetail().get(0).getHareketler().get(0).getDonemIciHareketlerCardList().get(0)) {

                        list.add(new CardStatement(Integer.parseInt(card.getIslemTarihi().substring(0, 4)),
                                intToDateString(Integer.parseInt(card.getIslemTarihi().substring(5, 7))),
                                Integer.parseInt(card.getIslemTarihi().substring(8, 10)), card.getIslemTarihi().substring(11, 16),
                                beautifyTheMoney(card.getIslemTutari()),
                                card.getUyeIsyeriAdi(), card.getIslemAciklamasi(), card.getUyeIsyeriSehri(), card.getIslemParaBirimi()));


                    }


                }


                cardStatementAdapter.setData(list);
                rcvCardStatement.setAdapter(cardStatementAdapter);


                findViewById(R.id.loadingPanel).setVisibility(View.GONE);


            }

            @Override
            public void onFailure(Call<GetIntermTransactionList> call, Throwable t) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });

    }

    private void sendNetworkRequest1(int CustomerNumber, String CreditCardNo) {


        ArrayList<EkstreInfo> list = new ArrayList<>();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-gateway.intertech.com.tr/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        ParameterCreditCardInfo param = new ParameterCreditCardInfo(Integer.toString(CustomerNumber), "2021090700000015", true, 3);//13417870
        Header header = new Header("c1c2a508fdf64c14a7b44edc9241c9cd", "API",
                "takim2", "takim2");

        RequestCreditCardInfo customerNo = new RequestCreditCardInfo(header, param);
        RetrofitClient ourRetrofitClient = retrofit.create(RetrofitClient.class);
        Call<GetCreditCardInfo> res = ourRetrofitClient.GetPostCreditCardInfoValue(customerNo);


        res.enqueue(new Callback<GetCreditCardInfo>() {
            @Override
            public void onResponse(Call<GetCreditCardInfo> call, Response<GetCreditCardInfo> response) {

                //Toast.makeText(getApplicationContext(), "oldu", Toast.LENGTH_LONG).show();

                System.out.println("HTTP STATUS" + response.code());
                if (response.isSuccessful()) {
                    for (EkstreInfo esktreınf : response.body().getData().getCreditCardDetail().get(0).getEkstreInfo()) {
                        list.add(esktreınf);

                    }

                    Spinner donemler = (Spinner) findViewById(R.id.spinner2);
                    ArrayAdapter<EkstreInfo> adapter;
                    adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, list);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                    donemler.setAdapter(adapter);
                }


            }

            @Override
            public void onFailure(Call<GetCreditCardInfo> call, Throwable t) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });

    }
}


