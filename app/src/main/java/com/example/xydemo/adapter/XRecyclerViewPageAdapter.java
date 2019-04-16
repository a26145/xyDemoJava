package com.example.xydemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.xydemo.views.fragment.DelRecyclerFragment;

import java.util.List;

public class XRecyclerViewPageAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;

    public XRecyclerViewPageAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }


    @Override
    public int getCount() {
        return fragments.size();
    }
}
