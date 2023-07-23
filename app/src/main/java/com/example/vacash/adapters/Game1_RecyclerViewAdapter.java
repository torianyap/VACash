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
import com.example.vacash.models.ItemModel;

import java.util.ArrayList;

public class Game1_RecyclerViewAdapter extends RecyclerView.Adapter<Game1_RecyclerViewAdapter.MyViewHolder> {

    Context context;
    ArrayList<ItemModel> itemModels;

    public Game1_RecyclerViewAdapter(Context context, ArrayList<ItemModel> itemModels){

        this.context = context;
        this.itemModels = itemModels;
    }

    @NonNull
    @Override
    public Game1_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Game1_RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.itemName.setText(itemModels.get(position).getItemName());
        holder.storeName.setText(itemModels.get(position).getStoreName());
        holder.storeDetail.setText(itemModels.get(position).getStoreDetail());
        holder.itemPrice.setText(itemModels.get(position).getItemPrice());
    }

    @Override
    public int getItemCount() {
        return itemModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView itemName, storeName, storeDetail, itemPrice;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView7);
            itemName = itemView.findViewById(R.id.textView9);
            storeName = itemView.findViewById(R.id.textView8);
            storeDetail = itemView.findViewById(R.id.textView6);
            itemPrice = itemView.findViewById(R.id.textView10);
        }
    }

}
