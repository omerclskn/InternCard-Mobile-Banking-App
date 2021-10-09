package com.intertech.icard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;


public class ChartActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        ((BottomNavigationView)findViewById(R.id.bottomNavigationChart)).setSelectedItemId(R.id.mCreditCard);

        bottomNavigationView = findViewById(R.id.bottomNavigationChart);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        //bottomNavigationView.setSelectedItemId(R.id.mCreditCard);


        ((TextView)findViewById(R.id.txt_balance1VirtualCard)).setText(getIntent().getStringExtra("FullName"));
        ((TextView)findViewById(R.id.txt_cardNoVirtualCard)).setText(getIntent().getStringExtra("MaskedCardNo"));
        ((TextView)findViewById(R.id.txt_expirationDateVirtualCard)).setText(getIntent().getStringExtra("CardName"));

        PieChart pieChart = findViewById(R.id.pieChart);

        ArrayList<PieEntry> arrayList = new ArrayList<>();
        arrayList.add(new PieEntry(2000,"Elektronik"));
        arrayList.add(new PieEntry(750,"Giyim"));
        arrayList.add(new PieEntry(1100,"Market"));
        arrayList.add(new PieEntry(1200,"Fatura"));
        arrayList.add(new PieEntry(3300,"Diğer"));

        PieDataSet pieDataSet = new PieDataSet(arrayList,"");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(16f);

        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("Harcamalar");
        pieChart.animate();
        pieChart.setDrawEntryLabels(false);
pieChart.setHoleRadius(45);




        pieChart.setDrawHoleEnabled(true);

        pieChart.setEntryLabelTextSize(12);
        pieChart.setEntryLabelColor(Color.BLACK);

        pieChart.getDescription().setEnabled(false);

        Legend l = pieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setFormSize(15f);
        l.setTextSize(15);
        l.setYEntrySpace(5);

        l.setDrawInside(false);
        l.setEnabled(true);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mHome:
                Intent intent = new Intent(ChartActivity.this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.mCreditCard:
                Intent intent2 = new Intent(ChartActivity.this, CardActivity.class);
                startActivity(intent2);
                return true;
            case R.id.mHelp:
                Toast.makeText(ChartActivity.this, "Yardım Sayfası", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mSettings:
                Toast.makeText(ChartActivity.this, "Ayarlar Sayfası", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }

}