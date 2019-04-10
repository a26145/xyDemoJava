package com.example.xydemo.views;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.xydemo.adapter.RecyclerLoadMoreSwipAdapter;
import com.example.xydemojava.R;
import com.marshalchen.ultimaterecyclerview.RecyclerItemClickListener;
import com.marshalchen.ultimaterecyclerview.URLogs;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;
import com.marshalchen.ultimaterecyclerview.layoutmanagers.ScrollSmoothLineaerLayoutManager;
import com.marshalchen.ultimaterecyclerview.swipe.SwipeItemManagerInterface;

import java.util.ArrayList;

public class RecyclerLoadMoreSwipActivity extends AppCompatActivity {
    protected Toolbar toolbar;
    protected UltimateRecyclerView ultimateRecyclerView;
    protected boolean isDrag = true, isEnableAutoLoadMore = true, status_progress = false;
    private ArrayList<String> data;
    private ScrollSmoothLineaerLayoutManager mLayoutManager;
    private RecyclerLoadMoreSwipAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadmore_swip);
//        toolbar = (Toolbar) findViewById(R.id.tool_bar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ultimateRecyclerView = (UltimateRecyclerView) findViewById(R.id.ultimate_recycler_view);
        doURV(ultimateRecyclerView);
    }

    /**
     * 初始化时
     * @param ultimateRecyclerView
     */
    private void doURV(UltimateRecyclerView ultimateRecyclerView) {
        data = new ArrayList();
        data.add("aa");
        data.add("bb");
        data.add("cc");
        data.add("dd");
        data.add("aa");
        data.add("bb");
        data.add("cc");
        data.add("dd");
        data.add("aa");
        data.add("bb");
        data.add("cc");
        data.add("dd");
//        enableEmptyViewPolicy();
        enableLoadMore();
//        enableRefresh();
        adapter = new RecyclerLoadMoreSwipAdapter(data);
        adapter.setMode(SwipeItemManagerInterface.Mode.Single);
        mLayoutManager = new ScrollSmoothLineaerLayoutManager(this, LinearLayoutManager.VERTICAL, false, 500);
        ultimateRecyclerView.setHasFixedSize(false);
        ultimateRecyclerView.setLayoutManager(mLayoutManager);
//        swipeListView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                URLogs.d("click");
//            }
//        }));


        ultimateRecyclerView.setAdapter(adapter);
    }

    protected void enableLoadMore() {
        // StickyRecyclerHeadersDecoration headersDecor = new StickyRecyclerHeadersDecoration(simpleRecyclerViewAdapter);
        // ultimateRecyclerView.addItemDecoration(headersDecor);
        ultimateRecyclerView.setLoadMoreView(R.layout.custom_bottom_progressbar);

        ultimateRecyclerView.setOnLoadMoreListener(new UltimateRecyclerView.OnLoadMoreListener() {
            @Override
            public void loadMore(int itemsCount, final int maxLastVisiblePosition) {
                status_progress = true;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        onLoadmore();
                        status_progress = false;
                    }
                }, 500);
            }
        });

    }
    //加载更多时的 操作
    private void onLoadmore() {

    }
    //加载失败
    protected void onFireRefresh() {
        ultimateRecyclerView.setRefreshing(false);
        //   ultimateRecyclerView.scrollBy(0, -50);
        mLayoutManager.scrollToPosition(0);
        //ultimateRecyclerView.setAdapter(simpleRecyclerViewAdapter);
        //simpleRecyclerViewAdapter.notifyDataSetChanged();
        adapter.removeAll();
        ultimateRecyclerView.disableLoadmore();
        ultimateRecyclerView.showEmptyView();
    }

    /**
     * 允许空数据的出现
     */
    protected void enableEmptyViewPolicy() {
        //  ultimateRecyclerView.setEmptyView(R.layout.empty_view, UltimateRecyclerView.EMPTY_KEEP_HEADER_AND_LOARMORE);
        //    ultimateRecyclerView.setEmptyView(R.layout.empty_view, UltimateRecyclerView.EMPTY_KEEP_HEADER);
        ultimateRecyclerView.setEmptyView(R.layout.empty_view, UltimateRecyclerView.EMPTY_KEEP_HEADER_AND_LOARMORE);
    }

    protected void enableRefresh() {
//        ultimateRecyclerView.setDefaultOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        onFireRefresh();
//                    }
//                }, 1000);
//            }
//        });
        //        ultimateRecyclerView.setDefaultSwipeToRefreshColorScheme(getResources().getColor(android.R.color.holo_blue_bright),
//                getResources().getColor(android.R.color.holo_green_light),
//                getResources().getColor(android.R.color.holo_orange_light),
//                getResources().getColor(android.R.color.holo_red_light));

    }


}
