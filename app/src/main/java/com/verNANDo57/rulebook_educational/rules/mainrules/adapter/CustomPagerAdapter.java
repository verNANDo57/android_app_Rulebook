package com.verNANDo57.rulebook_educational.rules.mainrules.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.verNANDo57.rulebook_educational.rules.mainrules.AppMainRulesOrthographyFragment;
import com.verNANDo57.rulebook_educational.rules.mainrules.AppMainRulesPunctuationFragment;

public class CustomPagerAdapter extends FragmentStateAdapter {

    Fragment orthography = new AppMainRulesOrthographyFragment();
    Fragment punctuation = new AppMainRulesPunctuationFragment();

    public CustomPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return orthography;
        } else if (position == 1) {
            return punctuation;
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return PagerConstants.MAINRULES_PAGER_ITEM_COUNT;
    }
}
