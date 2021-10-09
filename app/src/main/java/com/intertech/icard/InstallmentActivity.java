

package com.intertech.icard;

import android.content.Intent;
import android.os.Bundle;


import java.util.ArrayList;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.intertech.icard.APIGetIntermTransactionList.DonemIciHareketlerCard;
import com.intertech.icard.APIGetIntermTransactionList.GetIntermTransactionList;
import com.intertech.icard.cardStatement.CardStatement;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InstallmentActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    List<String> groupList;
    List<String> childList;
    Map<String, List<String>> laptopCollection;
    ExpandableListView expListView;

    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_installment);

        ((BottomNavigationView)findViewById(R.id.bottomNavigationInstallment)).setSelectedItemId(R.id.mCreditCard);
        bottomNavigationView = findViewById(R.id.bottomNavigationInstallment);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        //bottomNavigationView.setSelectedItemId(R.id.mCreditCard);

        ((TextView)findViewById(R.id.txt_balance1VirtualCard)).setText(getIntent().getStringExtra("FullName"));
        ((TextView)findViewById(R.id.txt_cardNoVirtualCard)).setText(getIntent().getStringExtra("MaskedCardNo"));
        ((TextView)findViewById(R.id.txt_expirationDateVirtualCard)).setText(getIntent().getStringExtra("CardName"));

        ((TextView)findViewById(R.id.textView9)).setText("806,13 ₺");

        sendNetworkRequest(getIntent().getIntExtra("CustomerNO", 0), getIntent().getStringExtra("CardNumber"));

        createGroupList();

        createCollection();

        expListView = (ExpandableListView) findViewById(R.id.laptop_list);
        final ExpandableListAdapters expListAdapter = new ExpandableListAdapters(
                this, groupList, laptopCollection);
        expListView.setAdapter(expListAdapter);

        //setGroupIndicatorToRight();

        expListView.setOnChildClickListener(new OnChildClickListener() {

            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {


                final String selected = (String) expListAdapter.getChild(
                        groupPosition, childPosition);
                //Toast.makeText(getBaseContext(), selected, Toast.LENGTH_LONG).show();

                return true;
            }
        });
    }

    private void createGroupList() {
        groupList = new ArrayList<String>();

        groupList.add("Eylül/268,71 ₺");
        groupList.add("Ekim/268,71 ₺");
        groupList.add("Kasım/268,71 ₺");
        groupList.add("Aralık/268,71 ₺");
        groupList.add("Ocak/268,71 ₺");
        groupList.add("Şubat/268,71 ₺");
        groupList.add("Mart/134,77 ₺");
        groupList.add("Nisan/85,75 ₺");
        groupList.add("Mayıs/61,14 ₺");
        groupList.add("Haziran/38,97 ₺");
    }

    private void createCollection() {
        // preparing laptops collection(child)
        String[] Eylul = { "Taksit. Nakit ZINCIRLIKUY ATM 3.Taksit Anapara,3,27.56,9,2020-02-24T15:38:58",
        "Taksit. Nakit ZINCIRLIKUY ATM 3.Taksit Anapara,3,24.61,10,2020-02-24T15:56:35",
        "Taksit. Nakit ZINCIRLIKUY ATM 3.Taksit Anapara,3,22.17,11,2020-02-24T16:04:56",
        "Taksit. Nakit OZGEG ATM 3.Taksit Anapara,3,24.36,8,2020-04-15T10:25:15",
        "Taksit. Nakit OZGEG ATM 3.Taksit Anapara,3,30.43,8,2020-04-15T10:41:45",
        "Taksit. Nakit OZGEG ATM 3.Taksit Anapara,3,30.43,8,2020-04-15T10:44:31",
        "Taksit. Nakit OZGEG ATM 3.Taksit Anapara,3,24.36,8,2020-04-15T10:50:01",
        "Taksit. Nakit OZGEG ATM 3.Taksit Anapara,3,24.36,8,2020-04-15T10:58:13",
        "Taksit. Nakit OZGEG ATM 3.Taksit Anapara,3,21.46,9,2020-04-15T11:02:58",
        "Öteleme-Taksit. Nakit ISTA CC 3.Taksit Anapara,3,38.97,12,2020-07-11T16:03:02"};

        String[] Ekim = { "Taksit. Nakit ZINCIRLIKUY ATM 4.Taksit Anapara,4,27.56,9,2020-02-24T15:38:58",
        "Taksit. Nakit ZINCIRLIKUY ATM 4.Taksit Anapara,4,24.61,10,2020-02-24T15:56:35",
        "Taksit. Nakit ZINCIRLIKUY ATM 4.Taksit Anapara,4,22.17,11,2020-02-24T16:04:56",
        "Taksit. Nakit OZGEG ATM 4.Taksit Anapara,4,24.36,8,2020-04-15T10:25:15",
        "Taksit. Nakit OZGEG ATM 4.Taksit Anapara,4,30.43,8,2020-04-15T10:41:45",
        "Taksit. Nakit OZGEG ATM 4.Taksit Anapara,4,30.43,8,2020-04-15T10:44:31",
        "Taksit. Nakit OZGEG ATM 4.Taksit Anapara,4,24.36,8,2020-04-15T10:50:01",
        "Taksit. Nakit OZGEG ATM 4.Taksit Anapara,4,24.36,8,2020-04-15T10:58:13",
        "Taksit. Nakit OZGEG ATM 4.Taksit Anapara,4,21.46,9,2020-04-15T11:02:58",
        "Öteleme-Taksit. Nakit ISTA CC 4.Taksit Anapara,4,38.97,12,2020-07-11T16:03:02"};

        String[] Kasim = { "Taksit. Nakit ZINCIRLIKUY ATM 5.Taksit Anapara,5,27.56,9,2020-02-24T15:38:58",
        "Taksit. Nakit ZINCIRLIKUY ATM 5.Taksit Anapara,5,24.61,10,2020-02-24T15:56:35",
        "Taksit. Nakit ZINCIRLIKUY ATM 5.Taksit Anapara,5,22.17,11,2020-02-24T16:04:56",
        "Taksit. Nakit OZGEG ATM 5.Taksit Anapara,5,24.36,8,2020-04-15T10:25:15",
        "Taksit. Nakit OZGEG ATM 5.Taksit Anapara,5,30.43,8,2020-04-15T10:41:45",
        "Taksit. Nakit OZGEG ATM 5.Taksit Anapara,5,30.43,8,2020-04-15T10:44:31",
        "Taksit. Nakit OZGEG ATM 5.Taksit Anapara,5,24.36,8,2020-04-15T10:50:01",
        "Taksit. Nakit OZGEG ATM 5.Taksit Anapara,5,24.36,8,2020-04-15T10:58:13",
        "Taksit. Nakit OZGEG ATM 5.Taksit Anapara,5,21.46,9,2020-04-15T11:02:58",
        "Öteleme-Taksit. Nakit ISTA CC 5.Taksit Anapara,5,38.97,12,2020-07-11T16:03:02" };

        String[] Aralik = { "Taksit. Nakit ZINCIRLIKUY ATM 6.Taksit Anapara,6,27.56,9,2020-02-24T15:38:58",
        "Taksit. Nakit ZINCIRLIKUY ATM 6.Taksit Anapara,6,24.61,10,2020-02-24T15:56:35",
        "Taksit. Nakit ZINCIRLIKUY ATM 6.Taksit Anapara,6,22.17,11,2020-02-24T16:04:56",
        "Taksit. Nakit OZGEG ATM 6.Taksit Anapara,6,24.36,8,2020-04-15T10:25:15",
        "Taksit. Nakit OZGEG ATM 6.Taksit Anapara,6,30.43,8,2020-04-15T10:41:45",
        "Taksit. Nakit OZGEG ATM 6.Taksit Anapara,6,30.43,8,2020-04-15T10:44:31",
        "Taksit. Nakit OZGEG ATM 6.Taksit Anapara,6,24.36,8,2020-04-15T10:50:01",
        "Taksit. Nakit OZGEG ATM 6.Taksit Anapara,6,24.36,8,2020-04-15T10:58:13",
        "Taksit. Nakit OZGEG ATM 6.Taksit Anapara,6,21.46,9,2020-04-15T11:02:58",
        "Öteleme-Taksit. Nakit ISTA CC 6.Taksit Anapara,6,38.97,12,2020-07-11T16:03:02"};

        String[] Ocak = { "Taksit. Nakit ZINCIRLIKUY ATM 7.Taksit Anapara,7,27.56,9,2020-02-24T15:38:58",
        "Taksit. Nakit ZINCIRLIKUY ATM 7.Taksit Anapara,7,24.61,10,2020-02-24T15:56:35",
        "Taksit. Nakit ZINCIRLIKUY ATM 7.Taksit Anapara,7,22.17,11,2020-02-24T16:04:56",
        "Taksit. Nakit OZGEG ATM 7.Taksit Anapara,7,24.36,8,2020-04-15T10:25:15",
        "Taksit. Nakit OZGEG ATM 7.Taksit Anapara,7,30.43,8,2020-04-15T10:41:45",
        "Taksit. Nakit OZGEG ATM 7.Taksit Anapara,7,30.43,8,2020-04-15T10:44:31",
        "Taksit. Nakit OZGEG ATM 7.Taksit Anapara,7,24.36,8,2020-04-15T10:50:01",
        "Taksit. Nakit OZGEG ATM 7.Taksit Anapara,7,24.36,8,2020-04-15T10:58:13",
        "Taksit. Nakit OZGEG ATM 7.Taksit Anapara,7,21.46,9,2020-04-15T11:02:58",
        "Öteleme-Taksit. Nakit ISTA CC 7.Taksit Anapara,7,38.97,12,2020-07-11T16:03:02"};

        String[] Subat = { "Taksit. Nakit ZINCIRLIKUY ATM 8.Taksit Anapara,8,27.56,9,2020-02-24T15:38:58",
        "Taksit. Nakit ZINCIRLIKUY ATM 8.Taksit Anapara,8,24.61,10,2020-02-24T15:56:35",
        "Taksit. Nakit ZINCIRLIKUY ATM 8.Taksit Anapara,8,22.17,11,2020-02-24T16:04:56",
        "Taksit. Nakit OZGEG ATM 8.Taksit Anapara,8,24.36,8,2020-04-15T10:25:15",
        "Taksit. Nakit OZGEG ATM 8.Taksit Anapara,8,30.43,8,2020-04-15T10:41:45",
        "Taksit. Nakit OZGEG ATM 8.Taksit Anapara,8,30.43,8,2020-04-15T10:44:31",
        "Taksit. Nakit OZGEG ATM 8.Taksit Anapara,8,24.36,8,2020-04-15T10:50:01",
        "Taksit. Nakit OZGEG ATM 8.Taksit Anapara,8,24.36,8,2020-04-15T10:58:13",
        "Taksit. Nakit OZGEG ATM 8.Taksit Anapara,8,21.46,9,2020-04-15T11:02:58",
        "Öteleme-Taksit. Nakit ISTA CC 8.Taksit Anapara,8,38.97,12,2020-07-11T16:03:02"};

        String[] Mart = {"Taksit. Nakit ZINCIRLIKUY ATM 9.Taksit Anapara,9,27.56,9,2020-02-24T15:38:58",
        "Taksit. Nakit ZINCIRLIKUY ATM 9.Taksit Anapara,9,24.61,10,2020-02-24T15:56:35",
        "Taksit. Nakit ZINCIRLIKUY ATM 9.Taksit Anapara,9,22.17,11,2020-02-24T16:04:56",
        "Taksit. Nakit OZGEG ATM 9.Taksit Anapara,9,21.46,9,2020-04-15T11:02:58",
        "Öteleme-Taksit. Nakit ISTA CC 9.Taksit Anapara,9,38.97,12,2020-07-11T16:03:02"};

        String[] Nisan = {"Taksit. Nakit ZINCIRLIKUY ATM 10.Taksit Anapara,10,24.61,10,2020-02-24T15:56:35",
        "Taksit. Nakit ZINCIRLIKUY ATM 10.Taksit Anapara,10,22.17,11,2020-02-24T16:04:56",
        "Öteleme-Taksit. Nakit ISTA CC 10.Taksit Anapara,10,38.97,12,2020-07-11T16:03:02"};

        String[] Mayis = {"Taksit. Nakit ZINCIRLIKUY ATM 11.Taksit Anapara,11,22.17,11,2020-02-24T16:04:56",
        "Öteleme-Taksit. Nakit ISTA CC 11.Taksit Anapara,11,38.97,12,2020-07-11T16:03:02"};

        String[] Haziran = {"Öteleme-Taksit. Nakit ISTA CC 12.Taksit Anapara,12,38.97,12,2020-07-11T16:03:02"};

        laptopCollection = new LinkedHashMap<String, List<String>>();



        for (String laptop : groupList) {
            if (laptop.equals("Eylül/268,71 ₺"))
                loadChild(Eylul);
             else if (laptop.equals("Ekim/268,71 ₺"))
                loadChild(Ekim);
            else if (laptop.equals("Kasım/268,71 ₺"))
                loadChild(Kasim);
            else if (laptop.equals("Aralık/268,71 ₺"))
                loadChild(Aralik);
            else if (laptop.equals("Ocak/268,71 ₺"))
                loadChild(Ocak);
            else if (laptop.equals("Şubat/268,71 ₺"))
                loadChild(Subat);
            else if (laptop.equals("Mart/134,77 ₺"))
                loadChild(Mart);
            else if (laptop.equals("Nisan/85,75 ₺"))
                loadChild(Nisan);
            else if (laptop.equals("Mayıs/61,14 ₺"))
                loadChild(Mayis);
            else if (laptop.equals("Haziran/38,97 ₺"))
                loadChild(Haziran);

            laptopCollection.put(laptop, childList);
        }
    }

    private void loadChild(String[] laptopModels) {
        childList = new ArrayList<String>();
        for (String model : laptopModels)
            childList.add(model);
    }

    private void setGroupIndicatorToRight() {
        /* Get the screen width */
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;

        expListView.setIndicatorBounds(width - getDipsFromPixel(35), width
                - getDipsFromPixel(5));
    }

    // Convert pixel to dip
    public int getDipsFromPixel(float pixels) {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
    }

    private void sendNetworkRequest(int CustomerNumber,String CreditCardNo)
    {


        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-gateway.intertech.com.tr/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        ParameterIntermTransactionList param = new ParameterIntermTransactionList(Integer.toString(CustomerNumber),CreditCardNo,new CreditCardDetailClass("H"));
        Header header = new Header("c1c2a508fdf64c14a7b44edc9241c9cd","API",
                "takim2","takim2");

        RequestIntermTransactionList customerNo =  new RequestIntermTransactionList(header,param);
        RetrofitClient ourRetrofitClient = retrofit.create(RetrofitClient.class);
        Call<GetIntermTransactionList> res = ourRetrofitClient.GetPostIntermTransactionListValue(customerNo);


        res.enqueue(new Callback<GetIntermTransactionList>() {
            @Override
            public void onResponse(Call<GetIntermTransactionList> call, Response<GetIntermTransactionList> response) {

                //Toast.makeText(getApplicationContext(),"oldu", Toast.LENGTH_LONG).show();
                List<AylarClass> taksitler=new ArrayList<>();
                taksitler.add(new AylarClass("Eylül", new ArrayList<>()));
                taksitler.add(new AylarClass("Ekim", new ArrayList<>()));
                taksitler.add(new AylarClass("Kasım", new ArrayList<>()));
                taksitler.add(new AylarClass("Aralık", new ArrayList<>()));
                taksitler.add(new AylarClass("Ocak", new ArrayList<>()));
                taksitler.add(new AylarClass("Şubat", new ArrayList<>()));
                taksitler.add(new AylarClass("Mart", new ArrayList<>()));
                taksitler.add(new AylarClass("Nisan", new ArrayList<>()));
                taksitler.add(new AylarClass("Mayıs", new ArrayList<>()));
                taksitler.add(new AylarClass("Haziran", new ArrayList<>()));
                taksitler.add(new AylarClass("Temmuz", new ArrayList<>()));
                taksitler.add(new AylarClass("Ağustos", new ArrayList<>()));


                System.out.println("HTTP STATUS"+response.code());
                if (response.isSuccessful())
                {
                    for (DonemIciHareketlerCard card : response.body().getData().getCreditCardDetail().get(0).getHareketler().get(0).getDonemIciHareketlerCardList().get(0)) {



                        for (int i=0;i<card.getKalanTaksitSayi();i++)
                        {
                            taksitler.get(i).harcamalar.add(new AylarClass.HarcamalarClass(card.getIslemAciklamasi().replace("2.Tk",(Integer.toString(card.getTaksitSayi()+i+1)) + ".Taksit"),card.getTaksitSayi()+i+1,card.getIslemTutari(),card.getToplamTaksitSayi(),card.getIslemTarihi()));
                        }
                    }
                    for ( AylarClass taksit : taksitler
                    ) {
                        System.out.println(taksit.ay);
                        double toplam=0;
                        for ( AylarClass.HarcamalarClass ha: taksit.harcamalar
                        ) {
                            System.out.println(ha.toString());
                            toplam+=ha.IslemTutari;
                        }
                        System.out.println(toplam);
                    }

                }




                findViewById(R.id.loadingPanel).setVisibility(View.GONE);


            }
            @Override
            public void onFailure(Call<GetIntermTransactionList> call,Throwable t) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);}
        });

    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu., menu);
        return true;
    }*/

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mHome:
                Intent intent = new Intent(InstallmentActivity.this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.mCreditCard:
                Intent intent2 = new Intent(InstallmentActivity.this, CardActivity.class);
                startActivity(intent2);
                return true;
            case R.id.mHelp:
                Toast.makeText(InstallmentActivity.this, "Yardım Sayfası", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mSettings:
                Toast.makeText(InstallmentActivity.this, "Ayarlar Sayfası", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }


}


class AylarClass {
    String ay;
    List<HarcamalarClass> harcamalar;

    public AylarClass(String ay, List<HarcamalarClass> harcamalar) {
        this.ay = ay;
        this.harcamalar = harcamalar;
    }



    public static class HarcamalarClass {
        String sirket;
        int taksit;
        double IslemTutari;
        int ToplamTaksitSayi ;
        String IslemTarihi;

        public HarcamalarClass(String sirket, int taksit, double islemTutari, int toplamTaksitSayi, String islemTarihi) {
            this.sirket = sirket;
            this.taksit = taksit;
            IslemTutari = islemTutari;
            ToplamTaksitSayi = toplamTaksitSayi;
            IslemTarihi = islemTarihi;
        }

        @Override
        public String toString() {
            return  sirket +
                    "," + IslemTutari +
                    "," + IslemTarihi +
                    "," + ToplamTaksitSayi +
                    "/" + taksit ;
        }
    }



}