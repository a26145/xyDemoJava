package com.example.xydemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xydemo.constant.VideoConstant;
import com.example.xydemojava.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by jianghejie on 15/11/26.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    public void setClickCallBack(ItemClickCallBack clickCallBack) {
        this.clickCallBack = clickCallBack;
    }

    public interface ItemClickCallBack {
        void onItemClick(int pos);
    }

    public ArrayList<String> datas = null;
    private ItemClickCallBack clickCallBack;
    private View.OnClickListener mListener;
    public MyAdapter(ArrayList<String> datas, View.OnClickListener mListener) {
        this.datas = datas;
        this.mListener = mListener;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_videoview, viewGroup, false);
        return new ViewHolder(view);
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.videoplayer.setUp(
                VideoConstant.videoUrls[0][position], JZVideoPlayer.SCREEN_WINDOW_LIST,
                VideoConstant.videoTitles[0][position]);
        Glide.with(holder.videoplayer.getContext()).load(VideoConstant.videoThumbs[0][position]).into(holder.videoplayer.thumbImageView);
        holder.btDz.setTag(new MyAdapter.TagClass(position,"点赞"));
        holder.btDz.setOnClickListener(mListener);
        holder.btFx.setTag(new MyAdapter.TagClass(position,"分享"));
        holder.btFx.setOnClickListener(mListener);
        holder.btSc.setTag(new MyAdapter.TagClass(position,"收藏"));
        holder.btSc.setOnClickListener(mListener);
        holder.btXq.setTag(new MyAdapter.TagClass(position,"详情"));
        holder.btXq.setOnClickListener(mListener);
        holder.videoplayer.setUp(
                VideoConstant.videoUrls[0][position], JZVideoPlayer.SCREEN_WINDOW_NORMAL,
                VideoConstant.videoTitles[0][position]);
        Glide.with(holder.videoplayer.getContext()).load(VideoConstant.videoThumbs[0][position]).into(holder.videoplayer.thumbImageView);

    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.size();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {

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
        @BindView(R.id.bt_del)
        Button btDel;



        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
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





















