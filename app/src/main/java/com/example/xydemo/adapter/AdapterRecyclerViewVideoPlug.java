package com.example.xydemo.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bumptech.glide.Glide;
import com.example.xydemo.constant.VideoConstant;
import com.example.xydemojava.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class AdapterRecyclerViewVideoPlug extends RecyclerView.Adapter<AdapterRecyclerViewVideoPlug.MyViewHolder> {

    public static final String TAG = "AdapterRecyclerViewVideo";
    int[] videoIndexs = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    private Context context;
    private View.OnClickListener mListener;

    public AdapterRecyclerViewVideoPlug(Context context, View.OnClickListener listener) {
        this.context = context;
        mListener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.item_videoview, parent,
                false));
        return holder;
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.i(TAG, "onBindViewHolder [" + holder.videoplayer.hashCode() + "] position=" + position);

        holder.videoplayer.setUp(
                VideoConstant.videoUrls[0][position], JZVideoPlayer.SCREEN_WINDOW_LIST,
                VideoConstant.videoTitles[0][position]);
        Glide.with(holder.videoplayer.getContext()).load(VideoConstant.videoThumbs[0][position]).into(holder.videoplayer.thumbImageView);
        holder.btDz.setTag(new TagClass(position,"点赞"));
        holder.btDz.setOnClickListener(mListener);
        holder.btFx.setTag(new TagClass(position,"分享"));
        holder.btFx.setOnClickListener(mListener);
        holder.btSc.setTag(new TagClass(position,"收藏"));
        holder.btSc.setOnClickListener(mListener);
        holder.btXq.setTag(new TagClass(position,"详情"));
        holder.btXq.setOnClickListener(mListener);
    }

    @Override
    public int getItemCount() {
        return videoIndexs.length;
    }

    @OnClick({R.id.bt_xq, R.id.bt_dz, R.id.bt_sc, R.id.bt_fx})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_xq:
                break;
            case R.id.bt_dz:
                break;
            case R.id.bt_sc:
                break;
            case R.id.bt_fx:
                break;
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.videoplayer)
        JZVideoPlayerStandard videoplayer;
        @BindView(R.id.bt_xq)
        Button btXq;
        @BindView(R.id.bt_dz)
        Button btDz;
        @BindView(R.id.bt_sc)
        Button btSc;
        @BindView(R.id.bt_fx)
        Button btFx;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    public class TagClass{

       int index;
       String desc;

        public TagClass(int index, String desc) {
            this.index = index;
            this.desc = desc;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

}
