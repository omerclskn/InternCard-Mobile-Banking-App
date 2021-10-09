package com.intertech.icard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.intertech.icard.APIGetCreditCardList.CreditCardCreditCardDetail;
import com.intertech.icard.APIGetCreditCardList.GetCreditCardList;
import com.intertech.icard.creditCard.CreditCard;
import com.intertech.icard.creditCard.CreditCardAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CardActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private RecyclerView rcvCreditCard;
    private CreditCardAdapter creditCardAdapter;

    ImageView rightArrow, leftArrow;
    FloatingActionButton fab, fab1, fab2, fab3, fab4, fab5;
    Animation fabOpen, fabClose, rotateForward, rotateBackward;
    ViewPager2 _vp;
    TextView tvBalance1, tvBalance2, tvDebt1, tvDebt2, tvMinDebt1, tvMinDebt2, tvCustomerLimit, tvRemainLimit, tvAccountDate, tvPayDate;
    TextView txtLinkCardDebt, txtLinkCardLimit, txtLinkAccountActivities;

    int cardPosition, cardCount;
    boolean isOpen = false, isOpacity = true;

    AlertDialog.Builder dialogBuilder;
    AlertDialog dialog;

    TextView txtFab1, txtFab2, txtFab3, txtFab4;
    ViewPager2 viewPager2;

    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sendNetworkRequest();
        setContentView(R.layout.activity_card);
        ((BottomNavigationView)findViewById(R.id.bottomNavigationViewDebt)).setSelectedItemId(R.id.mCreditCard);

        tvDebt1 = findViewById(R.id.txt_totalDebt1);
        tvMinDebt1 = findViewById(R.id.txt_minDebt1);
        tvCustomerLimit = findViewById(R.id.txt_totalCardLimit);
        tvRemainLimit = findViewById(R.id.txt_remainingCardLimit);
        tvAccountDate = findViewById(R.id.txt_cutoffDate);
        tvPayDate = findViewById(R.id.txt_dueDate);

        txtFab1 = findViewById(R.id.txt_fab1);
        txtFab2 = findViewById(R.id.txt_fab2);
        txtFab3 = findViewById(R.id.txt_fab3);
        txtFab4 = findViewById(R.id.txt_fab4);

        viewPager2 = findViewById(R.id.viewpager);
        viewPager2.setVisibility(View.INVISIBLE);


        bottomNavigationView = findViewById(R.id.bottomNavigationViewDebt);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.mCreditCard);

          /*
            Kartlar
         */

        rcvCreditCard = findViewById(R.id.rcv_creditCard);
        creditCardAdapter = new CreditCardAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rcvCreditCard.setLayoutManager(linearLayoutManager);

        creditCardAdapter.setData(getListCreditCard());
        rcvCreditCard.setAdapter(creditCardAdapter);

        leftArrow = findViewById(R.id.btn_left);
        leftArrow.setVisibility(View.INVISIBLE);
        leftArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (linearLayoutManager.findFirstVisibleItemPosition() > 0) {
                    rcvCreditCard.smoothScrollToPosition(linearLayoutManager.findFirstVisibleItemPosition() - 1);
                    if (cardPosition > 0) {
                        cardPosition--;
                    }
                } else {
                    rcvCreditCard.smoothScrollToPosition(0);
                }
                cardInformation(cardPosition);
            }
        });

        rightArrow = findViewById(R.id.btn_right);
        rightArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rcvCreditCard.smoothScrollToPosition(linearLayoutManager.findLastVisibleItemPosition() + 1);
                if (cardPosition < cardCount) {
                    cardPosition++;
                }
                cardInformation(cardPosition);
            }
        });

        rcvCreditCard.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0) {
                    leftArrow.setVisibility(View.INVISIBLE);
                } else {
                    leftArrow.setVisibility(View.VISIBLE);
                }

                if (linearLayoutManager.findLastCompletelyVisibleItemPosition() == (recyclerView.getAdapter().getItemCount() - 1)) {
                    rightArrow.setVisibility(View.INVISIBLE);
                } else
                    rightArrow.setVisibility(View.VISIBLE);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        /*
            -------------------------------------
         */

        txtLinkCardDebt = findViewById(R.id.txt_linkCardDebt);
        txtLinkCardDebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardActivity.this, DebtActivity.class);
                intent.putExtra("CustomerNO", creditCardAdapter.getData(cardPosition).getCustomerNo());
                intent.putExtra("CardNumber", creditCardAdapter.getData(cardPosition).getCreditCardNo());
//
                intent.putExtra("MaskedCardNo", creditCardAdapter.getData(cardPosition).getNo());
                intent.putExtra("FullName",creditCardAdapter.getData(cardPosition).getFullName());
                intent.putExtra("CardName", creditCardAdapter.getData(cardPosition).getCardType());
                intent.putExtra("ToplamBorc", creditCardAdapter.getData(cardPosition).getToplamBorc());
                intent.putExtra("AsgariTutar", creditCardAdapter.getData(cardPosition).getAsgariTutar());
                intent.putExtra("DonemSonuBorcu", 55.0);
//                intent.putExtra("Borc",beautifyTheMoney(creditCardAdapter.getData(cardPosition).getToplamBorc()));


//                if (creditCardAdapter.getData(cardPosition).getHesapKesimTarihi().length()==8)
//                    intent.putExtra("HesapKesim",creditCardAdapter.getData(cardPosition).getHesapKesimTarihi().substring(6,8)+"/"+creditCardAdapter.getData(cardPosition).getHesapKesimTarihi().substring(4,6)+"/" +creditCardAdapter.getData(cardPosition).getHesapKesimTarihi().substring(0,4));
//                else
//                    intent.putExtra("HesapKesim",creditCardAdapter.getData(cardPosition).getHesapKesimTarihi());
//
//                if (creditCardAdapter.getData(cardPosition).getSonOdemeTarihi().length()==8)
//                    intent.putExtra("SonOdeme",creditCardAdapter.getData(cardPosition).getSonOdemeTarihi().substring(6,8)+"/"+creditCardAdapter.getData(cardPosition).getSonOdemeTarihi().substring(4,6)+"/" +creditCardAdapter.getData(cardPosition).getSonOdemeTarihi().substring(0,4));
//                else
//                    intent.putExtra("SonOdeme",creditCardAdapter.getData(cardPosition).getSonOdemeTarihi());


                startActivity(intent);
            }
        });
        txtLinkCardLimit = findViewById(R.id.txt_linkCardLimit);
        txtLinkCardLimit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CardActivity.this, "Limit Arttır", Toast.LENGTH_SHORT).show();
            }
        });
        txtLinkAccountActivities = findViewById(R.id.txt_linkAccountActivities);
        txtLinkAccountActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CardActivity.this, CardStatementActivity.class);
                intent.putExtra("CustomerNO", creditCardAdapter.getData(cardPosition).getCustomerNo());
                intent.putExtra("CardNumber", creditCardAdapter.getData(cardPosition).getCreditCardNo());

                intent.putExtra("MaskedCardNo", creditCardAdapter.getData(cardPosition).getNo());
                intent.putExtra("FullName", creditCardAdapter.getData(cardPosition).getFullName());
                intent.putExtra("CardName", creditCardAdapter.getData(cardPosition).getCardType());

                intent.putExtra("Borc", beautifyTheMoney(creditCardAdapter.getData(cardPosition).getToplamBorc()));


                if (creditCardAdapter.getData(cardPosition).getHesapKesimTarihi().length() == 8)
                    intent.putExtra("HesapKesim", creditCardAdapter.getData(cardPosition).getHesapKesimTarihi().substring(6, 8) + "/" + creditCardAdapter.getData(cardPosition).getHesapKesimTarihi().substring(4, 6) + "/" + creditCardAdapter.getData(cardPosition).getHesapKesimTarihi().substring(0, 4));
                else
                    intent.putExtra("HesapKesim", creditCardAdapter.getData(cardPosition).getHesapKesimTarihi());

                if (creditCardAdapter.getData(cardPosition).getSonOdemeTarihi().length() == 8)
                    intent.putExtra("SonOdeme", creditCardAdapter.getData(cardPosition).getSonOdemeTarihi().substring(6, 8) + "/" + creditCardAdapter.getData(cardPosition).getSonOdemeTarihi().substring(4, 6) + "/" + creditCardAdapter.getData(cardPosition).getSonOdemeTarihi().substring(0, 4));
                else
                    intent.putExtra("SonOdeme", creditCardAdapter.getData(cardPosition).getSonOdemeTarihi());

                startActivity(intent);
            }
        });

        fab = (FloatingActionButton) findViewById(R.id.fabCard);
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab3 = (FloatingActionButton) findViewById(R.id.fab3);
        fab4 = (FloatingActionButton) findViewById(R.id.fab4);

        fabOpen = AnimationUtils.loadAnimation(this, R.anim.fab_open);
        fabClose = AnimationUtils.loadAnimation(this, R.anim.fab_close);

        rotateForward = AnimationUtils.loadAnimation(this, R.anim.rotate_forward);
        rotateBackward = AnimationUtils.loadAnimation(this, R.anim.rotate_backward);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
                if (isOpacity) {
                    viewPager2.setVisibility(View.VISIBLE);

                } else {
                    viewPager2.setVisibility(View.INVISIBLE);
                }
                isOpacity = !isOpacity;

            }
        });

        // Sanal Kart Başvuru
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
                if (isOpacity) {
                    viewPager2.setVisibility(View.VISIBLE);

                } else {
                    viewPager2.setVisibility(View.INVISIBLE);
                }
                isOpacity = !isOpacity;

                Intent intent = new Intent(CardActivity.this, VirtualCardActivity.class);
                intent.putExtra("FullName", creditCardAdapter.getData(cardPosition).getFullName());
                intent.putExtra("MaskedCardNo", creditCardAdapter.getData(cardPosition).getNo());
                intent.putExtra("CardName", creditCardAdapter.getData(cardPosition).getCardType());
                intent.putExtra("CardNumber", creditCardAdapter.getData(cardPosition).getCreditCardNo());
                intent.putExtra("CustomerNO", creditCardAdapter.getData(cardPosition).getCustomerNo());


                startActivity(intent);
            }
        });
        // Kart Başvuru
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
                if (isOpacity) {
                    viewPager2.setVisibility(View.VISIBLE);

                } else {
                    viewPager2.setVisibility(View.INVISIBLE);
                }
                isOpacity = !isOpacity;

                Toast.makeText(CardActivity.this, "Kart Başvuru", Toast.LENGTH_SHORT).show();
            }
        });
        // Grafikler
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
                if (isOpacity) {
                    viewPager2.setVisibility(View.VISIBLE);

                } else {
                    viewPager2.setVisibility(View.INVISIBLE);
                }
                isOpacity = !isOpacity;
                Intent intent = new Intent(CardActivity.this, ChartActivity.class);
                intent.putExtra("FullName", creditCardAdapter.getData(cardPosition).getFullName());
                intent.putExtra("MaskedCardNo", creditCardAdapter.getData(cardPosition).getNo());
                intent.putExtra("CardName", creditCardAdapter.getData(cardPosition).getCardType());
                startActivity(intent);
            }
        });
        // Bekleyen taksitler
        fab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
                if (isOpacity) {
                    viewPager2.setVisibility(View.VISIBLE);

                } else {
                    viewPager2.setVisibility(View.INVISIBLE);
                }
                isOpacity = !isOpacity;
                Intent intent = new Intent(CardActivity.this, InstallmentActivity.class);
                intent.putExtra("CustomerNO", creditCardAdapter.getData(cardPosition).getCustomerNo());
                intent.putExtra("CardNumber", creditCardAdapter.getData(cardPosition).getCreditCardNo());
                intent.putExtra("FullName", creditCardAdapter.getData(cardPosition).getFullName());
                intent.putExtra("MaskedCardNo", creditCardAdapter.getData(cardPosition).getNo());
                intent.putExtra("CardName", creditCardAdapter.getData(cardPosition).getCardType());
                intent.putExtra("AsgariTutar", creditCardAdapter.getData(cardPosition).getAsgariTutar());
                startActivity(intent);

                Toast.makeText(CardActivity.this, "Bekleyen taksitler", Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mHome:
                Intent intent = new Intent(CardActivity.this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.mHelp:
                Toast.makeText(CardActivity.this, "Yardım Sayfası", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mSettings:
                Toast.makeText(CardActivity.this, "Ayarlar Sayfası", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }

    private List<CreditCard> getListCreditCard() {
        List<CreditCard> list = new ArrayList<>();

        //list.add(new CreditCard("404 201 408 12", 550, 10, "10/20"));
        //list.add(new CreditCard("404 201 408 12", 550, 10, "10/20"));
        //list.add(new CreditCard("404 201 408 12", 550, 10, "10/20"));
        list.add(new CreditCard(0, "", getString(R.string.loading), getString(R.string.loading), getString(R.string.loading), 0.0, 0.0, 0.0, 0.0, 0.0, "", ""));
        list.add(new CreditCard(0, "", getString(R.string.loading), getString(R.string.loading), getString(R.string.loading), 0.0, 0.0, 0.0, 0.0, 0.0, "", ""));
        list.add(new CreditCard(0, "", getString(R.string.loading), getString(R.string.loading), getString(R.string.loading), 0.0, 0.0, 0.0, 0.0, 0.0, "", ""));

        return list;
    }

    private void cardInformation(int position) {

        //int arr[1] = parseToArray(creditCardAdapter.getData(position).getBakiye());
        tvDebt1.setText(beautifyTheMoney(creditCardAdapter.getData(position).getToplamBorc()));
        tvMinDebt1.setText(beautifyTheMoney(creditCardAdapter.getData(position).getAsgariTutar()));
        tvCustomerLimit.setText(beautifyTheMoney(creditCardAdapter.getData(position).getMusteriLimiti()));
        tvRemainLimit.setText(beautifyTheMoney(creditCardAdapter.getData(position).getKalanLimit()));

        if (creditCardAdapter.getData(position).getHesapKesimTarihi().length() == 8)
            tvAccountDate.setText(creditCardAdapter.getData(position).getHesapKesimTarihi().substring(6, 8) + "/" + creditCardAdapter.getData(position).getHesapKesimTarihi().substring(4, 6) + "/" + creditCardAdapter.getData(position).getHesapKesimTarihi().substring(0, 4));
        else
            tvAccountDate.setText(creditCardAdapter.getData(position).getHesapKesimTarihi());

        if (creditCardAdapter.getData(position).getSonOdemeTarihi().length() == 8)
            tvPayDate.setText(creditCardAdapter.getData(position).getSonOdemeTarihi().substring(6, 8) + "/" + creditCardAdapter.getData(position).getSonOdemeTarihi().substring(4, 6) + "/" + creditCardAdapter.getData(position).getSonOdemeTarihi().substring(0, 4));
        else
            tvPayDate.setText(creditCardAdapter.getData(position).getSonOdemeTarihi());
    }

    private void animateFab() {
        if (isOpen) {
            fab.startAnimation(rotateBackward);
            fab1.startAnimation(fabClose);
            fab2.startAnimation(fabClose);
            fab3.startAnimation(fabClose);
            fab4.startAnimation(fabClose);

            txtFab1.startAnimation(fabClose);
            txtFab2.startAnimation(fabClose);
            txtFab3.startAnimation(fabClose);
            txtFab4.startAnimation(fabClose);

            fab1.setClickable(false);
            fab2.setClickable(false);
            fab3.setClickable(false);
            fab4.setClickable(false);


            isOpen = false;
        } else {
            fab.startAnimation(rotateForward);
            fab1.startAnimation(fabOpen);
            fab2.startAnimation(fabOpen);
            fab3.startAnimation(fabOpen);
            fab4.startAnimation(fabOpen);

            txtFab1.startAnimation(fabOpen);
            txtFab2.startAnimation(fabOpen);
            txtFab3.startAnimation(fabOpen);
            txtFab4.startAnimation(fabOpen);

            fab1.setClickable(true);
            fab2.setClickable(true);
            fab3.setClickable(true);
            fab4.setClickable(true);

            isOpen = true;
        }
    }

    private static String beautifyTheMoney(double _money) {
        if (_money == 0) {
            return "0,00" + " ₺";
        } else if (_money < 0) {
            return Double.toString(_money) + " ₺";
        }

        double kurus = _money - (int) _money;
        String string_kurus = Double.toString(kurus);
        string_kurus += "0"; //tek ondalikli gelirse, çift ondalıklı sayiya çevirmek icin

        String money = Integer.toString((int) _money);
        StringBuffer sb = new StringBuffer(Integer.toString((int) _money));

        for (int i = 1; money.length() > 3 * i; i++) {
            sb.insert(money.length() - 3 * i, ".");
        }
        return sb + "," + string_kurus.substring(2, 4) + " ₺";
    }

    private void sendNetworkRequest()
    {
        int customerNumber=13188998;//13707091;

        List<CreditCard> list = new ArrayList<>();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(90, TimeUnit.SECONDS)
                .connectTimeout(90, TimeUnit.SECONDS)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-gateway.intertech.com.tr/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        ParameterCustomerNo param = new ParameterCustomerNo( Integer.toString(customerNumber) );//13707091
        Header header = new Header("c1c2a508fdf64c14a7b44edc9241c9cd","API",
                "takim2","takim2");

        RequestCustomerNo customerNo =  new RequestCustomerNo(header,param);
        RetrofitClient ourRetrofitClient = retrofit.create(RetrofitClient.class);
        Call<GetCreditCardList> res = ourRetrofitClient.GetPostGetCreditCardListValue(customerNo);


        res.enqueue(new Callback<GetCreditCardList>() {
            @Override
            public void onResponse(Call<GetCreditCardList> call, Response<GetCreditCardList> response) {

                //Toast.makeText(getApplicationContext(),"oldu", Toast.LENGTH_LONG).show();

                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.customtoast, (ViewGroup) findViewById(R.id.custom_toast_container));
                TextView tv = (TextView) layout.findViewById(R.id.txtvw);
                tv.setText("\nHesap kesim tarihiniz gelmiştir. Son ödeme tarihine kadar ödemenizi gerekmektedir.\n");
                Toast toast = new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, -50);
                toast.setView(layout);
                toast.show();

                System.out.println("HTTP STATUS"+response.code());
                if (response.isSuccessful())
                {
                    for (CreditCardCreditCardDetail card : response.body().getData().getCreditCardDetail()) {


                        if(!(card.getSanalKart())){
                            list.add(new CreditCard(customerNumber,card.getCreditCardNo(),card.getMaskedCardNumber().substring(0,4)+" "+card.getMaskedCardNumber().substring(4,8)+" "+card.getMaskedCardNumber().substring(8,12)+" "+card.getMaskedCardNumber().substring(12,16),card.getCardOwnerName()+ " " + card.getCardOwnerSurname(),card.getProductAdi(),card.getCardLimits().getKartKullanilabilirKredi(),card.getCardLimits().getMarjsizKartLimit()-card.getCardLimits().getKartKullanilabilirKredi(),
                                    card.getAsgaridenKalanOdemeTutariYI(),card.getCardLimits().getMarjsizKartLimit(),card.getCardLimits().getKartKullanilabilirKredi(),card.getSonEksTarih(),card.getSonOdemeTarih()));
                        }
                        else if(card.getSanalKart() && card.getKartStatusu().equals("N")){
                            // sanalları ekleme
                            list.add(new CreditCard(customerNumber,card.getCreditCardNo(),card.getMaskedCardNumber().substring(0,4)+" "+card.getMaskedCardNumber().substring(4,8)+" "+card.getMaskedCardNumber().substring(8,12)+" "+card.getMaskedCardNumber().substring(12,16),card.getCardOwnerFullName(),card.getProductAdi(),card.getCardLimits().getKartKullanilabilirKredi(),card.getCardLimits().getMarjsizKartLimit()-card.getCardLimits().getKartKullanilabilirKredi(),
                                    card.getAsgaridenKalanOdemeTutariYI(),card.getCardLimits().getMarjsizKartLimit(),card.getCardLimits().getKartKullanilabilirKredi(),card.getSonEksTarih(),card.getSonOdemeTarih()));

                        }
                    }

                    creditCardAdapter.setData(list);
                    rcvCreditCard.setAdapter(creditCardAdapter);
                    cardInformation(0);
                    cardCount = creditCardAdapter.getItemCount();

                    findViewById(R.id.loadingPanel).setVisibility(View.GONE);
                    findViewById(R.id.fabCard).setVisibility(View.VISIBLE);
                } else if(response.code()==500)
                {


                    LayoutInflater inflater1 = getLayoutInflater();
                    View layout1 = inflater1.inflate(R.layout.customtoast, (ViewGroup) findViewById(R.id.custom_toast_container));
                    TextView tv1 = (TextView) layout1.findViewById(R.id.txtvw);
                    tv1.setText("\nHata oluştu. Tekrar deneyiniz.\n");
                    Toast toast1 = new Toast(getApplicationContext());
                    toast1.setDuration(Toast.LENGTH_LONG);
                    toast1.setView(layout1);
                    toast1.setGravity(Gravity.CENTER_VERTICAL, 0, -250);
                    toast1.setView(layout1);
                    toast1.show();

                }

            }
            @Override
            public void onFailure(Call<GetCreditCardList> call,Throwable t) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });

    }

    public int[] parseToArray(double money) {
        int y = (int) Math.floor(money);

        int x = (int) Math.round((money - y) * 100);

        int[] myNum = {0, 0};
        myNum[0] = x;
        myNum[1] = y;

        return myNum;
    }

    public void createNewContactDialog(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.card_limit_popup, null);
    }

}