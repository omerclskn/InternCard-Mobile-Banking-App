package com.intertech.icard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.intertech.icard.APICreditCardPayment.CreditCardPayment;
import com.intertech.icard.APIGetAccountList.Account;
import com.intertech.icard.APIGetAccountList.GetAccountList;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DebtActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    Button gonder;
    String CardNumber, MaskedCardNo, CardName, FullName;
    int CustomerNO;
    Double ToplamBorc,AsgariTutar,DonemSonuBorcu;
    CheckBox checkBox;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debt);

        ((BottomNavigationView)findViewById(R.id.bottomNavigationDebt)).setSelectedItemId(R.id.mCreditCard);

        FullName = getIntent().getStringExtra("FullName");
        CustomerNO = getIntent().getIntExtra("CustomerNO",0);
        CardNumber = getIntent().getStringExtra("CardNumber");
        MaskedCardNo = getIntent().getStringExtra("MaskedCardNo");
        CardName = getIntent().getStringExtra("CardName");
        DonemSonuBorcu = getIntent().getDoubleExtra("DonemSonuBorcu",0);
        ToplamBorc = getIntent().getDoubleExtra("ToplamBorc",0);
        AsgariTutar = getIntent().getDoubleExtra("AsgariTutar",0);

        bottomNavigationView = findViewById(R.id.bottomNavigationDebt);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        //bottomNavigationView.setSelectedItemId(R.id.mCreditCard);



        TextView customer_name = (TextView) findViewById(R.id.txt_balance1VirtualCard);
        TextView card_num = (TextView) findViewById(R.id.txt_cardNoVirtualCard);
        ((TextView) findViewById(R.id.txt_expirationDateVirtualCard)).setText(CardName);
        Button asgari_tutar = (Button) findViewById(R.id.btn_minimumDebt);
        Button toplam_borc = (Button) findViewById(R.id.btn_totalDebt);
        Button donem_sonu_borcu = (Button) findViewById(R.id.btn_termDebt);

        asgari_tutar.setText(asgari_tutar.getText()+"\n\n"+beautifyTheMoney(Double.parseDouble(String.format("%.2f",AsgariTutar)))+"₺");
        toplam_borc.setText(toplam_borc.getText()+"\n\n"+beautifyTheMoney(Double.parseDouble(String.format("%.2f",ToplamBorc)))+"₺");
        donem_sonu_borcu.setText(donem_sonu_borcu.getText()+"\n\n"+beautifyTheMoney(Double.parseDouble(String.format("%.2f",DonemSonuBorcu)))+"₺");

        EditText tutar = (EditText) findViewById(R.id.input_limitVirtualCard);
        customer_name.setText(FullName);
        card_num.setText(MaskedCardNo);

        gonder=(Button)findViewById(R.id.btn_send);
        gonder.setEnabled(false);
        gonder.setAlpha((float) 0.5);

        checkBox = findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    gonder.setEnabled(true);
                    gonder.setAlpha((float) 1);
                }else{
                    gonder.setEnabled(false);
                    gonder.setAlpha((float) 0.5);
                }
            }
        });


        asgari_tutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tutar.setText( String.format("%.2f",AsgariTutar));
            }
        });

        toplam_borc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tutar.setText(String.format("%.2f",ToplamBorc));
            }
        });

        donem_sonu_borcu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tutar.setText(String.format("%.2f",DonemSonuBorcu));
            }
        });



        Spinner spinner = (Spinner) findViewById(R.id.spinner);



        gonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findViewById(R.id.loadingPanel).setVisibility(View.VISIBLE);
                Spinner spinner = (Spinner) findViewById(R.id.spinner);

                Account id= (Account)spinner.getSelectedItem();

                //Toast.makeText(getApplicationContext(),tutar.getText().toString(), Toast.LENGTH_LONG).show();
                sendNetworkRequest1(id.getBranchCode(),id.getCustomerNo(),id.getAccountSuffix(),id.getCurrencyCode(),Double.parseDouble(tutar.getText().toString()),CardNumber);

            }
        });



        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.accounts_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        sendNetworkRequest();
    }


    private void sendNetworkRequest()
    {


        ArrayList<Account> list = new ArrayList<>();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-gateway.intertech.com.tr/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        ParameterCustomerNo param = new ParameterCustomerNo(Integer.toString(CustomerNO));//13417870
        Header header = new Header("c1c2a508fdf64c14a7b44edc9241c9cd","API",
                "takim2","takim2");

        RequestCustomerNo customerNo =  new RequestCustomerNo(header,param);
        RetrofitClient ourRetrofitClient = retrofit.create(RetrofitClient.class);
        Call<GetAccountList> res = ourRetrofitClient.GetAccountListValue(customerNo);


        res.enqueue(new Callback<GetAccountList>() {
            @Override
            public void onResponse(Call<GetAccountList> call, Response<GetAccountList> response) {

                //Toast.makeText(getApplicationContext(),"oldu", Toast.LENGTH_LONG).show();
                findViewById(R.id.loadingPanel).setVisibility(View.GONE);
                System.out.println("HTTP STATUS"+response.code());
                if (response.isSuccessful())
                {
                    for (Account acc : response.body().getData().getAccountList()) {
                        list.add(acc);
                        System.out.println(acc.getAccountSuffix()+"sadfasfasasd");
                    }

                    Spinner spinner = (Spinner) findViewById(R.id.spinner);

                    ArrayAdapter<Account> adapter =
                            new ArrayAdapter<Account>(getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, list);
                    adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);

                    spinner.setAdapter(adapter);

                }


//                creditCardAdapter.setData(list);
//                rcvCreditCard.setAdapter(creditCardAdapter);
//                cardInformation(0);
//                cardCount = creditCardAdapter.getItemCount();
//                findViewById(R.id.loadingPanel).setVisibility(View.GONE);
//                findViewById(R.id.fab).setVisibility(View.VISIBLE);

            }
            @Override
            public void onFailure(Call<GetAccountList> call,Throwable t) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });

    }


    private void sendNetworkRequest1(int branchcode,int customernumber,int accountsuffix,String currencycode,double amount,String creditcardno)
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

        ParameterCreditCardPayment param = new ParameterCreditCardPayment(new SourceAccountClass(branchcode,customernumber,accountsuffix,currencycode),amount,creditcardno,customernumber);
        Header header = new Header("c1c2a508fdf64c14a7b44edc9241c9cd","API",
                "takim2","takim2");

        RequestCreditCardPayment customerNo =  new RequestCreditCardPayment(header,param);
        RetrofitClient ourRetrofitClient = retrofit.create(RetrofitClient.class);
        Call<CreditCardPayment> res = ourRetrofitClient.GetCreditCardPaymentValue(customerNo);


        res.enqueue(new Callback<CreditCardPayment>() {
            @Override
            public void onResponse(Call<CreditCardPayment> call, Response<CreditCardPayment> response) {

                findViewById(R.id.loadingPanel).setVisibility(View.GONE);

                System.out.println("HTTP STATUS"+response.code());

                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.customtoast, (ViewGroup) findViewById(R.id.custom_toast_container));
                TextView tv = (TextView) layout.findViewById(R.id.txtvw);

                Toast toast = new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, -250);
                toast.setView(layout);


                if (response.isSuccessful())
                {

                    if(response.body().getData()==null)
                    {

                        //Toast.makeText(getApplicationContext(),"Bakiye Yetersiz.", Toast.LENGTH_LONG).show();
                        tv.setText("\nBakiye Yetersiz.\n");
                        toast.show();

                    }
                    else{
                        //Toast.makeText(getApplicationContext(),"Ödemeniz Başarıyla Gerçekleşmiştir.", Toast.LENGTH_LONG).show();
                        tv.setText("\nÖdemeniz Başarıyla\n   Gerçekleşmiştir.\n");
                        toast.show();
                        Intent intent = new Intent(DebtActivity.this, CardActivity.class);
                        //finishActivity(0);
                        startActivity(intent);
                    }

                }else if(response.code()==500)
                {
                    //Toast.makeText(getApplicationContext(),"Hata oluştu. Tekrar deneyiniz.", Toast.LENGTH_LONG).show();
                    tv.setText("\nHata oluştu. Tekrar deneyiniz.\n");
                    toast.show();
                }

            }
            @Override
            public void onFailure(Call<CreditCardPayment> call,Throwable t) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mHome:
                Intent intent = new Intent(DebtActivity.this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.mCreditCard:
                Intent intent2 = new Intent(DebtActivity.this, CardActivity.class);
                startActivity(intent2);
                return true;
            case R.id.mHelp:
                Toast.makeText(DebtActivity.this, "Yardım Sayfası", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mSettings:
                Toast.makeText(DebtActivity.this, "Ayarlar Sayfası", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }
    private static String beautifyTheMoney(double _money) {
        if (_money == 0) {
            return "0,00" ;
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
        return sb + "," + string_kurus.substring(2, 4) ;
    }



}