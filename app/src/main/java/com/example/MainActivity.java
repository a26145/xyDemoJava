package com.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.xydemo.adapter.RecyclerViewCommonAdapter;
import com.example.xydemo.base.BaseActivity;
import com.example.xydemo.constant.Constants;
import com.example.xydemo.recyclerlayoutmanagers.LayoutManager;
import com.example.xydemojava.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.recy)
    RecyclerView recy;
    private RecyclerViewCommonAdapter recyclerViewCommonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recyclerViewCommonAdapter = new RecyclerViewCommonAdapter(this);
        recy.setLayoutManager(LayoutManager.buildLinearManager(this));
        recy.setAdapter(recyclerViewCommonAdapter);
        recyclerViewCommonAdapter.update(new Constants.MainMenuModel());
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected int initContentView() {
        return R.layout.activity_main;
    }
}
