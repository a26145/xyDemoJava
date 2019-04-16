package com.example.xydemo.views.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xydemojava.R;

public class XRecyclerViewTest1Fragment extends Fragment {
    public static final String XRECYCLERVIEWFRAGMENT1 = "xrecyclerviewFragment1";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_xrecyclerview_demo_1, null);
        return inflate;
    }


    /**
     * 创建instance
     */
    public static XRecyclerViewTest1Fragment newInstance(@NonNull String type) {
        Bundle bundle = new Bundle();
        XRecyclerViewTest1Fragment gankFragment = new XRecyclerViewTest1Fragment();
        gankFragment.setArguments(bundle);
        return gankFragment;
    }
}
