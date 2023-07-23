package com.example.vacash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Homepage extends AppCompatActivity {

    ViewPager carouselContainer;
    int[] carouselImages = {R.drawable.pubgwallpaper, R.drawable.rafaelamoba, R.drawable.genshinwall};
    String[] carouseltext1 = {"LIMITED TIME", "NOW AVAILABLE", "LIMITED TIME"};
    String[] carouseltext2 = {"PUBG: Playerunknown's Battlegrounds", "Mobile Legends: Bang Bang", "Genshing Impact"};
    String[] carouseltext3 = {"Top Battle Royale Mobile Game", "Play With The World!", "Top Battle Royale Mobile Game"};
    CarouselAdapter carouselAdapter;
    //posisi image sekarang dimana
    int currImage = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        carouselContainer = findViewById(R.id.carouselContainer);

        //create adapter
        carouselAdapter = new CarouselAdapter(this, carouselImages, carouseltext1, carouseltext2, carouseltext3);
        carouselContainer.setAdapter(carouselAdapter);

        imageChange();
    }

    void imageChange(){
        carouselContainer.postDelayed(new Runnable() {
            @Override
            public void run() {
                currImage = (carouselContainer.getCurrentItem() +1)%carouselImages.length;
                carouselContainer.setCurrentItem(currImage);
                imageChange();
            }
        }, 5000);
    }

}