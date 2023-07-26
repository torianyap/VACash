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
import com.example.vacash.models.GlobalVariable;
import com.example.vacash.models.RecyclerViewInterface;
import com.example.vacash.models.TransactionModel;

import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.MyViewHolder> {

    Context context;
    ArrayList<TransactionModel> transactions;
    RecyclerViewInterface recyclerViewInterface;

    public TransactionAdapter(Context context, ArrayList<TransactionModel> transactions, RecyclerViewInterface rvi) {
        this.context = context;
        this.transactions = transactions;
        this.recyclerViewInterface = rvi;
    }

    @NonNull
    @Override
    public TransactionAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.past_transaction_row, parent, false);
        return new MyViewHolder(v, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionAdapter.MyViewHolder holder, int position) {
        holder.itemImage.setImageResource(transactions.get(position).getItemIcon());
        holder.gameName.setText(transactions.get(position).getGameName());
        holder.itemName.setText(transactions.get(position).getItemNameQuantity());
        holder.price.setText(GlobalVariable.formatCurrency(transactions.get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView gameName, itemName, price;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.transactionItemImage);
            gameName = itemView.findViewById(R.id.transactionGameName);
            itemName = itemView.findViewById(R.id.transactionItemName);
            price = itemView.findViewById(R.id.transactionPrice);

            itemView.setOnClickListener(view -> {
                if (recyclerViewInterface != null) {
                    int pos = getAdapterPosition();

                    if (pos != RecyclerView.NO_POSITION) {
                        recyclerViewInterface.onItemClick(pos);
                    }
                }
            });
        }
    }
}
