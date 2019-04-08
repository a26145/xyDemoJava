package com.example.xydemo.views;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.example.xydemo.adapter.AdapterRecyclerViewVideo;
import com.example.xydemo.adapter.AdapterRecyclerViewVideoPlug;
import com.example.xydemo.base.BaseActivity;
import com.example.xydemojava.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZMediaManager;
import cn.jzvd.JZUtils;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerManager;

public class MediaTestActivity extends BaseActivity {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    AdapterRecyclerViewVideoPlug adapterVideoList;

    @Override
    protected void initViews() {
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        adapterVideoList = new AdapterRecyclerViewVideoPlug(this, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdapterRecyclerViewVideoPlug.TagClass t = (AdapterRecyclerViewVideoPlug.TagClass) v.getTag();
                showToast(t.getIndex() + ":" + t.getDesc());
            }
        });
        recyclerview.setAdapter(adapterVideoList);
        recyclerview.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(View view) {
                //Tiny
                JZVideoPlayer.onChildViewAttachedToWindow(view, R.id.videoplayer);
            }

            @Override
            public void onChildViewDetachedFromWindow(View view) {
                //普通
//                JZVideoPlayer jzvd = view.findViewById(R.id.videoplayer);
//                if (jzvd != null && JZUtils.dataSourceObjectsContainsUri(jzvd.dataSourceObjects, JZMediaManager.getCurrentDataSource())) {
//                    JZVideoPlayer currentJzvd = JZVideoPlayerManager.getCurrentJzvd();
//                    if (currentJzvd != null && currentJzvd.currentScreen != JZVideoPlayer.SCREEN_WINDOW_FULLSCREEN) {
//                        JZVideoPlayer.releaseAllVideos();
//                    }
//                }
                //Tiny
                JZVideoPlayer.onChildViewDetachedFromWindow(view);
            }
        });
    }


    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void settingDefaultWindow() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayUseLogoEnabled(false);
        getSupportActionBar().setTitle("RecyclerView");
    }

    @Override
    protected int initContentView() {
        return R.layout.activity_recyclerview_content;
    }

}
