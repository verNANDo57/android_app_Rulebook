package com.verNANDo57.rulebook_educational.rules.mainrules.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.verNANDo57.rulebook_educational.rules.mainrules.AppMainRulesOrthographyFragment;
import com.verNANDo57.rulebook_educational.rules.mainrules.AppMainRulesPunctuationFragment;


public class CustomPagerAdapter extends FragmentPagerAdapter {

    Fragment orthography = new AppMainRulesOrthographyFragment();
    Fragment punctuation = new AppMainRulesPunctuationFragment();

    public CustomPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return orthography;
        } else if (position == 1) {
            return punctuation;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
