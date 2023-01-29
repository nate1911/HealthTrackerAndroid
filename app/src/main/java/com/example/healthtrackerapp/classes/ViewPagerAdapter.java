package com.example.healthtrackerapp.classes;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.healthtrackerapp.fragments.AnalyzesFragment;
import com.example.healthtrackerapp.fragments.HomeFragment;
import com.example.healthtrackerapp.fragments.QuestionsFragment;

public class ViewPagerAdapter extends FragmentStateAdapter
{
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position==0) {
            return new HomeFragment();
        }
        else if (position == 1) {
            return new QuestionsFragment();
        }
        else {
            return new AnalyzesFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }}