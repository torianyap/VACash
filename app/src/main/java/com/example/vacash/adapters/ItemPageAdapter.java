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
import com.example.vacash.models.ItemModel;
import com.example.vacash.models.RecyclerViewInterface;

import java.util.ArrayList;

public class ItemPageAdapter extends RecyclerView.Adapter<ItemPageAdapter.MyViewHolder> {

    Context context;
    ArrayList<ItemModel> itemModels;
    RecyclerViewInterface recyclerViewInterface;

    public ItemPageAdapter(Context context, ArrayList<ItemModel> itemModels, RecyclerViewInterface rvi){
        this.context = context;
        this.itemModels = itemModels;
        this.recyclerViewInterface = rvi;
    }

    @NonNull
    @Override
    public ItemPageAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_recycler_row, parent, false);
        return new MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemPageAdapter.MyViewHolder holder, int position) {
        holder.itemName.setText(itemModels.get(position).getItemName());
        holder.storeName.setText(itemModels.get(position).getStoreName());
        holder.storeDetail.setText(itemModels.get(position).getStoreDetail());
        holder.itemPrice.setText(GlobalVariable.formatCurrency(itemModels.get(position).getItemPrice()));
        holder.imageView.setImageResource(itemModels.get(position).getItemImg());
    }

    @Override
    public int getItemCount() {
        return itemModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView itemName, storeName, storeDetail, itemPrice;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView7);
            itemName = itemView.findViewById(R.id.textView9);
            storeName = itemView.findViewById(R.id.textView8);
            storeDetail = itemView.findViewById(R.id.textView6);
            itemPrice = itemView.findViewById(R.id.textView10);

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
