package com.example.vacash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.vacash.adapters.ItemPageAdapter;
import com.example.vacash.models.ItemModel;

import java.util.ArrayList;

public class ItemPage extends AppCompatActivity {

    ArrayList<com.example.vacash.models.ItemModel> ItemModel = new ArrayList<>();
    ImageButton homeIcon;
    ImageButton hamburgerIcon;
    AnimatorSet slideDownAnimatorSet;
//    View slidingView;

    ArrayList<ItemModel> items;

    int[] itemImg = {R.drawable.growtopia, R.drawable.growtopia, R.drawable.growtopia};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_page);

        items = this.getIntent().getExtras().getParcelableArrayList("Items");
        String gameName = this.getIntent().getExtras().getString("gameName");
        Integer gameIcon = this.getIntent().getExtras().getInt("gameIcon");

        ImageView gameIconView = findViewById(R.id.imageView5);
        gameIconView.setImageResource(gameIcon);

        TextView gameNameView = findViewById(R.id.textView5);
        gameNameView.setText(gameName);

        RecyclerView recyclerView = findViewById(R.id.mRecycleView);
        setUpItemModel();
        ItemPageAdapter adapter = new ItemPageAdapter(this, items);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        homeIcon = findViewById(R.id.home_icon);
        hamburgerIcon = findViewById(R.id.hamburgerIcon);

        slideDownAnimatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.slide_down);
        slideDownAnimatorSet.setTarget(R.menu.dropdown_menu);

        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToHome();
            }
        });

        hamburgerIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(view);
            }
        });
    }


    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view, Gravity.END);
        popupMenu.getMenuInflater().inflate(R.menu.dropdown_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_profile:
                        navigateToProfile();
                        return true;
                    case R.id.menu_logout:
                        navigateToLogout();
                        return true;
                    default:
                        return false;
                }
            }
        });
        slideDownAnimatorSet.start();
        popupMenu.show();

        // Change background color when the dropdown is shown
//        mainLayout.setBackgroundColor(Color.parseColor("#800080")); // Purple color with 50% opacity
    }

    private void navigateToLogout() {
        Intent intent = new Intent(this, SplashPage.class);
        startActivity(intent);
    }

    private void navigateToProfile() {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

    private void navigateToHome() {
        Intent intent = new Intent(this, Homepage.class);
        startActivity(intent);
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