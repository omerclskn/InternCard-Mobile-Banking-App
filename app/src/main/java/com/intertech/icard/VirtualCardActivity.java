package com.intertech.icard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.intertech.icard.APIGetCreditCardList.CreditCardCreditCardDetail;
import com.intertech.icard.APIGetCreditCardList.GetCreditCardList;
import com.intertech.icard.APIVirtualCardCreate.VirtualCardCreate;
import com.intertech.icard.creditCard.CreditCard;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VirtualCardActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    EditText inputDateVirtualCard;
    private DatePickerDialog datePickerDialog;
    private Calendar calendar;
    private int year, month, dayOfMonth;
    Button btnSend;
    TextView txtDateSelect;
    CheckBox checkBox;

    int customerNo;
    String cardNo;

    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_virtual_card);
        ((BottomNavigationView)findViewById(R.id.bottomNavigationVirtualCard)).setSelectedItemId(R.id.mCreditCard);

        bottomNavigationView = findViewById(R.id.bottomNavigationVirtualCard);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        //bottomNavigationView.setSelectedItemId(R.id.mCreditCard);


        inputDateVirtualCard = findViewById(R.id.input_dateVirtualCard);
        inputDateVirtualCard.setEnabled(false);
        inputDateVirtualCard.setAlpha((float) 0.5);

        txtDateSelect = findViewById(R.id.txt_dateSelect);
        btnSend=findViewById(R.id.btn_sendVirtualCard);
        txtDateSelect.setEnabled(false);
        txtDateSelect.setAlpha((float) 0.5);

        ((TextView)findViewById(R.id.txt_balance1VirtualCard)).setText(getIntent().getStringExtra("FullName"));
        ((TextView)findViewById(R.id.txt_cardNoVirtualCard)).setText(getIntent().getStringExtra("MaskedCardNo"));
        ((TextView)findViewById(R.id.txt_expirationDateVirtualCard)).setText(getIntent().getStringExtra("CardName"));

        customerNo=getIntent().getIntExtra("CustomerNO",0);
        cardNo=getIntent().getStringExtra("CardNumber");

        checkBox = findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    inputDateVirtualCard.setEnabled(true);
                    txtDateSelect.setEnabled(true);
                    txtDateSelect.setAlpha((float) 1);
                    inputDateVirtualCard.setAlpha((float) 1);
                }else{
                    inputDateVirtualCard.setEnabled(false);
                    txtDateSelect.setEnabled(false);
                    txtDateSelect.setAlpha((float) 0.5);
                    inputDateVirtualCard.setAlpha((float) 0.5);
                }
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findViewById(R.id.loadingPanel).setVisibility(View.VISIBLE);

                sendNetworkRequest(Integer.parseInt(((EditText)findViewById(R.id.input_limitVirtualCard)).getText().toString()),cardNo,Integer.toString(customerNo));
            }
        });

        txtDateSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(VirtualCardActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                inputDateVirtualCard.setText(day + "/" + (month+1) + "/" + year);
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.show();
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mHome:
                Intent intent = new Intent(VirtualCardActivity.this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.mCreditCard:
                Intent intent2 = new Intent(VirtualCardActivity.this, CardActivity.class);
                startActivity(intent2);
                return true;
            case R.id.mHelp:
                Toast.makeText(VirtualCardActivity.this, "Yardım Sayfası", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mSettings:
                Toast.makeText(VirtualCardActivity.this, "Ayarlar Sayfası", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }

    private void sendNetworkRequest(int cardLimit,String creditCardNo,String customerNumber)
    {


        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(90, TimeUnit.SECONDS)
                .connectTimeout(90, TimeUnit.SECONDS)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-gateway.intertech.com.tr/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        ParameterVirtualCardCreate param = new ParameterVirtualCardCreate(cardLimit,creditCardNo,customerNumber);
        Header header = new Header("c1c2a508fdf64c14a7b44edc9241c9cd","API",
                "takim2","takim2");

        RequestVirtualCardCreate customerNo =  new RequestVirtualCardCreate(header,param);
        RetrofitClient ourRetrofitClient = retrofit.create(RetrofitClient.class);
        Call<VirtualCardCreate> res = ourRetrofitClient.GetVirtualCardCreateValue(customerNo);


        res.enqueue(new Callback<VirtualCardCreate>() {
            @Override
            public void onResponse(Call<VirtualCardCreate> call, Response<VirtualCardCreate> response) {


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
                        //Toast.makeText(getApplicationContext(),"Sanal Kartınız Başarıyla Oluşturulmuştur.", Toast.LENGTH_LONG).show();
                        tv.setText("\nSanal Kartınız Başarıyla Oluşturulmuştur.\n");
                        toast.show();
                        Intent intent = new Intent(VirtualCardActivity.this, CardActivity.class);
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
            public void onFailure(Call<VirtualCardCreate> call,Throwable t) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });

    }
}