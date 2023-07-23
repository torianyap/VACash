package com.example.vacash.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.vacash.console;
import com.example.vacash.mobile;
import com.example.vacash.pc;

public class homeAdapter extends FragmentStateAdapter {
    public homeAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new mobile();
            case 1: return new pc();
            case 2: return new console();
        }
        return new mobile();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
