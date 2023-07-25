package com.example.vacash.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.vacash.fragments.ConsoleFragment;
import com.example.vacash.fragments.MobileFragment;
import com.example.vacash.fragments.PCFragment;

public class HomeTabAdapter extends FragmentStateAdapter {
    public HomeTabAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new MobileFragment();
            case 1: return new PCFragment();
            case 2: return new ConsoleFragment();
        }
        return new MobileFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
