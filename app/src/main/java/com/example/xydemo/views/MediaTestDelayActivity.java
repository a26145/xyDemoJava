package com.example.xydemo.views;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.xydemo.adapter.AdapterRecyclerViewVideoDelayPlug;
import com.example.xydemo.adapter.AdapterRecyclerViewVideoPlug;
import com.example.xydemo.base.BaseActivity;
import com.example.xydemo.constant.VideoConstant;
import com.example.xydemo.entity.LordMoreEntity;
import com.example.xydemojava.R;

import java.util.ArrayList;

import butterknife.BindView;
import cn.jzvd.JZVideoPlayer;

public class MediaTestDelayActivity extends BaseActivity {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    AdapterRecyclerViewVideoDelayPlug adapterVideoList;
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };
    @Override
    protected void initViews() {
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        adapterVideoList = new AdapterRecyclerViewVideoDelayPlug(this, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdapterRecyclerViewVideoPlug.TagClass t = (AdapterRecyclerViewVideoPlug.TagClass) v.getTag();
                showToast(t.getIndex() + ":");
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
        doDelayEvent();
    }

    public void doDelayEvent(){
        ArrayList<LordMoreEntity> lordMoreEntities = new ArrayList<>();

        for(int i = 0 ; i < 7 ; i++){
            LordMoreEntity lordMoreEntity = new LordMoreEntity();
            lordMoreEntity.setmUrl(VideoConstant.videoUrls[0][i]);
            ArrayList<String> strings = new ArrayList<>();
            strings.add(VideoConstant.videoThumbs[0][i]);
            lordMoreEntity.setmImages(strings);
            lordMoreEntities.add(lordMoreEntity);
        }

        handler.postDelayed(()->{
            adapterVideoList.update(lordMoreEntities);
            adapterVideoList.notifyDataSetChanged();
        },3000);
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
