package com.example.vacash.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.vacash.R;

public class CarouselAdapter extends PagerAdapter {

    //penampung semua image dan text di carousel
    int[] images;
    String[] texts1;
    String[] texts2;
    String[] texts3;
    Context context;

    //constructor
    public CarouselAdapter(Context context, int[] images, String[] texts1, String[] texts2, String[] texts3){
        this.images = images;
        this.texts1 = texts1;
        this.texts2 = texts2;
        this.texts3 = texts3;
        this.context = context;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.carousel_item, container, false);

        //SET IMAGE
        ImageView carouselImage = view.findViewById(R.id.imageCarousels);

        TextView limitedtime = view.findViewById(R.id.limitedtime);
        TextView namagame = view.findViewById(R.id.namagame);
        TextView description = view.findViewById(R.id.description);

        carouselImage.setImageResource(images[position]);
        limitedtime.setText(texts1[position]);
        namagame.setText(texts2[position]);
        description.setText(texts3[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    //berapa banyak image dan text dalam image carousel
    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
