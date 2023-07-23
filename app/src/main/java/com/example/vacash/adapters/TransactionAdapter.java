package com.example.vacash.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vacash.R;
import com.example.vacash.models.TransactionModel;

import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.MyViewHolder> {

    Context context;
    ArrayList<TransactionModel> transactions;

    public TransactionAdapter(Context context, ArrayList<TransactionModel> transactions) {
        this.context = context;
        this.transactions = transactions;
    }

    @NonNull
    @Override
    public TransactionAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.past_transaction_row, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionAdapter.MyViewHolder holder, int position) {
        holder.itemImage.setImageResource(R.drawable.growtopia);
        holder.gameName.setText(transactions.get(position).getGameName());
        holder.itemName.setText(transactions.get(position).getItemNameQuantity());
        holder.price.setText(transactions.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView gameName, itemName, price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.transactionItemImage);
            gameName = itemView.findViewById(R.id.transactionGameName);
            itemName = itemView.findViewById(R.id.transactionItemName);
            price = itemView.findViewById(R.id.transactionPrice);
        }
    }
}
