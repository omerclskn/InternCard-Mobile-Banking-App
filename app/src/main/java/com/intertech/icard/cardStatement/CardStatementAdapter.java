package com.intertech.icard.cardStatement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.intertech.icard.R;

import java.util.List;

public class CardStatementAdapter extends RecyclerView.Adapter<CardStatementAdapter.CardStatementViewHolder> {

    private List<CardStatement> mCardStatements;
    private Context mContext;

    public CardStatementAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<CardStatement> list) {
        this.mCardStatements = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CardStatementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_statements, parent, false);
        return new CardStatementViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardStatementViewHolder holder, int position) {
        CardStatement cardStatement = mCardStatements.get(position);
        if (cardStatement == null) {
            return;
        }

        holder.txtSpendingDate.setText(""+cardStatement.getDay() + " " + cardStatement.getMonth() );
        holder.txtSpendingTitle.setText("" + cardStatement.getDescription().replace("Taksit. Nakit ", ""));
        holder.txtSpendingMoney.setText("" + cardStatement.getPay()+" ₺");

    }

    @Override
    public int getItemCount() {
        if (mCardStatements != null) {
            return mCardStatements.size();
        }
        return 0;
    }


    public class CardStatementViewHolder extends RecyclerView.ViewHolder {

        private TextView txtSpendingTitle, txtSpendingMoney, txtSpendingDate;
        private ImageView imgSpendingIcon;


        public CardStatementViewHolder(@NonNull View itemView) {
            super(itemView);

            txtSpendingTitle = itemView.findViewById(R.id.txt_spendingTitle);
            txtSpendingMoney = itemView.findViewById(R.id.txt_spendingMoney);
            txtSpendingDate = itemView.findViewById(R.id.txt_spendingDate);

            imgSpendingIcon = itemView.findViewById(R.id.img_spendingIcon);

        }
    }

}
