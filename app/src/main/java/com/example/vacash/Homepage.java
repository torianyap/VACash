package com.example.vacash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.example.vacash.adapters.CarouselAdapter;
import com.example.vacash.adapters.HomeTabAdapter;
import com.example.vacash.models.GlobalVariable;
import com.google.android.material.tabs.TabLayout;

public class Homepage extends AppCompatActivity {

    ViewPager carouselContainer;
    int[] carouselImages = {R.drawable.pubgwallpaper, R.drawable.rafaelamoba, R.drawable.genshinwall};
    String[] carouseltext1 = {"LIMITED TIME", "NOW AVAILABLE", "LIMITED TIME"};
    String[] carouseltext2 = {"PUBG: Playerunknown's Battlegrounds", "Mobile Legends: Bang Bang", "Genshing Impact"};
    String[] carouseltext3 = {"Top Battle Royale Mobile Game", "Play With The World!", "Top Battle Royale Mobile Game"};
    CarouselAdapter carouselAdapter;
    //posisi image sekarang dimana
    int currImage = 0;

    TabLayout tabLayout;
    ViewPager2 viewpagertab;
    HomeTabAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        GlobalVariable.init();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        carouselContainer = findViewById(R.id.carouselContainer);

        //create adapter
        carouselAdapter = new CarouselAdapter(this, carouselImages, carouseltext1, carouseltext2, carouseltext3);
        carouselContainer.setAdapter(carouselAdapter);

        imageChange();

        tabLayout = findViewById(R.id.tabLayout);
        viewpagertab = findViewById(R.id.tabViewPagerGame);
        adapter = new HomeTabAdapter(getSupportFragmentManager(), getLifecycle());

        viewpagertab.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Mobile"));
        tabLayout.addTab(tabLayout.newTab().setText("PC"));
        tabLayout.addTab(tabLayout.newTab().setText("Console"));

        // set space between tabs
        ViewGroup slidingTabStrip = (ViewGroup) tabLayout.getChildAt(0);

        for (int i=0; i<slidingTabStrip.getChildCount()-1; i++) {
            View v = slidingTabStrip.getChildAt(i);
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            params.rightMargin = 85;
        }

        //klik tab sinkronin ke viewpager
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpagertab.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewpagertab.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position){
                super.onPageSelected(position);
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
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