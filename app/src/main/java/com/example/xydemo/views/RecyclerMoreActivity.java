package com.example.xydemo.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.xydemo.adapter.GankViewPagerAdapter;
import com.example.xydemo.base.BaseActivity;
import com.example.xydemojava.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerMoreActivity extends AppCompatActivity {

    @BindView(R.id.gank_view_pager)
    ViewPager mViewPager;

    private List<String> mFragmentType = new ArrayList<String>(){
        {
            add("Android");
            add("福利");
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadmore);
        ButterKnife.bind(this);
        mViewPager.setAdapter(new GankViewPagerAdapter(getSupportFragmentManager(), mFragmentType));
    }

}
