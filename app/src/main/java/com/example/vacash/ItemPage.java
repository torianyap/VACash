package com.example.vacash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.vacash.adapters.Game1_RecyclerViewAdapter;
import com.example.vacash.models.ItemModel;

import java.util.ArrayList;

public class ItemPage extends AppCompatActivity {

    ArrayList<com.example.vacash.models.ItemModel> ItemModel = new ArrayList<>();

    int[] itemImg = {R.drawable.growtopia, R.drawable.growtopia, R.drawable.growtopia};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_page);

        RecyclerView recyclerView = findViewById(R.id.mRecycleView);
        setUpItemModel();
        Game1_RecyclerViewAdapter adapter = new Game1_RecyclerViewAdapter(this, ItemModel);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpItemModel(){
        String[] itemName = getResources().getStringArray(R.array.ItemName);
        String[] storeName = getResources().getStringArray(R.array.StoreName);
        String[] storeDetail = getResources().getStringArray(R.array.StoreDetail);
        String[] itemPrice = getResources().getStringArray(R.array.Price);


        for (int i=0; i< itemName.length; i++){
            ItemModel.add(new ItemModel(itemName[i],
                    storeName[i],
                    storeDetail[i],
                    itemPrice[i],
                    itemImg[i]));
        }
    }
}