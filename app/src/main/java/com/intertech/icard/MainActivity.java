package com.intertech.icard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationMain);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        //bottomNavigationView.setSelectedItemId(R.id.person);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mCreditCard:
                Intent intent = new Intent(MainActivity.this, CardActivity.class);
                startActivity(intent);
                return true;
            case R.id.mHelp:
                Toast.makeText(MainActivity.this, "Yardım Sayfası", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mSettings:
                Toast.makeText(MainActivity.this, "Ayarlar Sayfası", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }
}