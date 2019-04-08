package com.example.xydemo.views;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.example.xydemo.base.BaseActivity;
import com.example.xydemojava.R;

import butterknife.BindView;

public class RecyclerMoreActivity extends BaseActivity {
    @BindView(R.id.gank_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.gank_swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void initViews() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });
        RecyclerView.Adapter adapter = new YourOwnAdapter();
        AdapterWrapper adapterWrapper = new AdapterWrapper(adapter);
        // 将RecyclerView和刚创建的adapterWrapper传入
        SwipeToLoadHelper helper = new SwipeToLoadHelper(recyclerView, adapterWrapper);
    }

    public void endRefresh(){
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    protected int initContentView() {
        return R.layout.activity_recycler_more;
    }

}
