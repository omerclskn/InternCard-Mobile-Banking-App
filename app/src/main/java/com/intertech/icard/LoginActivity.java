package com.intertech.icard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    FloatingActionButton _fab;
    ImageView logo, imgTranslate, imgNotification, imgDarkMode;
    TextView tvIndividual, tvCorporate;
    TextInputLayout inputTCNo, inputPassword;
    Button btnLogin;

    Switch switchLoginChange;

    Boolean isTranslate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        isTranslate=getIntent().getBooleanExtra("dil",true);
        if (isTranslate) {
            //imgTranslate.setImageResource(R.drawable.ic_translate_tr);
            LocaleHelper.setLocale(this, "en");
        } else {
            //imgTranslate.setImageResource(R.drawable.ic_translate_tr);
            LocaleHelper.setLocale(this, "");
        }

        setContentView(R.layout.activity_login);


        logo = findViewById(R.id.img_logo);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).setEnabled(false);

        imgTranslate = findViewById(R.id.btn_translate);
        imgTranslate.setOnClickListener(this);

        imgNotification = findViewById(R.id.btn_notification);
        imgNotification.setOnClickListener(this);

        imgDarkMode = findViewById(R.id.btn_darkMode);
        imgDarkMode.setOnClickListener(this);

        _fab = findViewById(R.id.fab);
        _fab.setImageTintList(ColorStateList.valueOf(Color.rgb(255, 255, 255)));

        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        tvIndividual = findViewById(R.id.txt_individual);
        tvCorporate = findViewById(R.id.txt_corporate);
        tvCorporate.setAlpha((float) 0.5);
        switchLoginChange = findViewById(R.id.switch_login);
        switchLoginChange.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tvIndividual.setAlpha((float) 0.5);
                    tvCorporate.setAlpha((float) 1);
                } else {
                    tvCorporate.setAlpha((float) 0.5);
                    tvIndividual.setAlpha((float) 1);
                }
            }
        });

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_translate:
                if (isTranslate) {
                    //imgTranslate.setImageResource(R.drawable.ic_translate_tr);

                    isTranslate=false;
                } else {
                    //imgTranslate.setImageResource(R.drawable.ic_translate_tr);

                    isTranslate=true;
                }
                Intent intent1 = new Intent(LoginActivity.this, LoginActivity.class);
                intent1.putExtra("dil",isTranslate);
                finish();
                startActivity(intent1);

                break;
            case R.id.btn_darkMode:
                Toast.makeText(getApplicationContext(), "Gece modu", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_notification:
                Toast.makeText(getApplicationContext(), "Bildirim", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab:
                Toast.makeText(getApplicationContext(), "Yardım", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_login:
                inputTCNo = (TextInputLayout) findViewById(R.id.input_tc);
                inputPassword = (TextInputLayout) findViewById(R.id.input_pw);
                if (is_Valid_Password(inputPassword.getEditText().getText().toString())
                        && inputTCNo.getEditText().getText().toString().length() == 11) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    //Toast.makeText(getApplicationContext(), "Hatalı giriş yaptınız.Tekrar deneyiniz.", Toast.LENGTH_SHORT).show();

                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.customtoast, (ViewGroup) findViewById(R.id.custom_toast_container));
                    TextView tv = (TextView) layout.findViewById(R.id.txtvw);
                    tv.setText("\nHatalı giriş yaptınız.\nTekrar deneyiniz.\n");
                    Toast toast = new Toast(getApplicationContext());
                    toast.setDuration(Toast.LENGTH_LONG);
                    toast.setView(layout);
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, -250);
                    toast.setView(layout);
                    toast.show();
                }

                System.out.println(inputTCNo.getEditText().getText());

                break;
        }
    }

    public static boolean is_Valid_Password(String password) {
        System.out.println(password);

        if (password.length() < 8) return false;
        boolean isContainsDigit = false;
        boolean isContainsUpperCase = false;
        boolean isContainsLowerCase = false;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isDigit(c)) {
                isContainsDigit = true;
            } else if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    isContainsUpperCase = true;
                } else {
                    isContainsLowerCase = true;
                }
            }
        }
        return (isContainsDigit && isContainsUpperCase && isContainsLowerCase);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch ((item.getItemId())) {
            case R.id.menu_ATM:
                Toast.makeText(getApplicationContext(), "ATM", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_calculator:
                Toast.makeText(getApplicationContext(), "Döviz Hesaplayıcı", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_transaction:
                Toast.makeText(getApplicationContext(), "Hızlı İşlem", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_QR:
                Toast.makeText(getApplicationContext(), "Karekod", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}