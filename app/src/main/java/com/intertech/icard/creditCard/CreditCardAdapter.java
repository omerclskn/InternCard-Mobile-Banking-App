package com.intertech.icard.creditCard;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.intertech.icard.R;

import java.util.List;

public class CreditCardAdapter extends RecyclerView.Adapter<CreditCardAdapter.CreditCardViewHolder> {

    private List<CreditCard> mCreditCards;
    private Context mContext;

    public CreditCardAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public CreditCard getData(int index) {
        return mCreditCards.get(index);
    }

    public void setData(List<CreditCard> list) {
        this.mCreditCards = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CreditCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_credit_card, parent, false);
        return new CreditCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CreditCardViewHolder holder, int position) {
        CreditCard creditCard = mCreditCards.get(position);
        if (creditCard == null) {
            return;
        }

        holder.tvCardNo.setText(creditCard.getNo());
        holder.tvExpirationDate.setText(""+creditCard.getCardType());

        if (creditCard.getCardType().contains("SANAL")) {
            holder.tvExpirationDate.setTypeface(Typeface.DEFAULT_BOLD);
            holder.tvExpirationDate.setTextColor(mContext.getResources().getColor(R.color.vişne));
        }

        holder.tvBalance1.setText(creditCard.getFullName());

        holder.itemView.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {
        if (mCreditCards != null) {
            return mCreditCards.size();
        }
        return 0;
    }

    public class CreditCardViewHolder extends RecyclerView.ViewHolder {
        private TextView tvCardNo, tvBalance1, tvBalance2, tvExpirationDate;


        public CreditCardViewHolder(@NonNull View itemView) {
            super(itemView);

            tvCardNo = itemView.findViewById(R.id.txt_cardNo);
            tvBalance1 = itemView.findViewById(R.id.txt_balance1);
            tvExpirationDate = itemView.findViewById(R.id.txt_expirationDate);

        }
    }
}