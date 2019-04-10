package com.example.xydemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.xydemo.views.fragment.DelRecyclerFragment;
import com.example.xydemo.views.fragment.GankFragment;

import java.util.List;

public class DelRecyclerViewPagerAdapter extends FragmentPagerAdapter {
    private List<String> mTitleList;

    public DelRecyclerViewPagerAdapter(FragmentManager fm, List<String> titleList) {
        super(fm);
        mTitleList = titleList;
    }

    @Override
    public Fragment getItem(int position) {
        return DelRecyclerFragment.newInstance(mTitleList.get(position));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList.get(position);
    }

    @Override
    public int getCount() {
        return mTitleList.size();
    }
}
