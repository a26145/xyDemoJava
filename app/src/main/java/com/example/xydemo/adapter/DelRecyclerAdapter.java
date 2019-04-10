package com.example.xydemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bumptech.glide.Glide;
import com.example.xydemo.callback.RecyclerDelCallBack;
import com.example.xydemo.entity.LordMoreEntity;
import com.example.xydemo.widget.xRecyclerView;
import com.example.xydemojava.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class DelRecyclerAdapter extends xRecyclerView.xAdapter<DelRecyclerAdapter.MyViewHolder> {

    private final List<LordMoreEntity> mListData;

    private RecyclerDelCallBack callBack;

    public DelRecyclerAdapter(List<LordMoreEntity> data, String type, RecyclerDelCallBack callBack) {
        mListData = data;
        this.callBack = callBack;
    }

    public LordMoreEntity delOne(int position){
        LordMoreEntity lordMoreEntity = mListData.get(position);
        mListData.remove(position);
        notifyDataSetChanged();
        return lordMoreEntity;
    }
    public void addOne(LordMoreEntity entity){
        mListData.add(entity);
        notifyDataSetChanged();
    }
    @Override
    protected int getxItemCount() {
        return mListData.size();
    }

    @Override
    protected MyViewHolder onCreatexViewHolder(ViewGroup parent, int itemType) {
        Context context = parent.getContext().getApplicationContext();
        return new MyViewHolder(View.inflate(context, R.layout.item_videoview, null));
    }

    @Override
    protected void onBindxViewHolder(MyViewHolder holder, int position) {
        final LordMoreEntity item = mListData.get(position);
        holder.setTag(position);
        holder.player.setUp(item.getmUrl(), JZVideoPlayer.SCREEN_WINDOW_NORMAL,
                Glide.with(holder.player).load(item.getImages().get(0)).into(holder.player.thumbImageView));
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.videoplayer)
        JZVideoPlayerStandard player;
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

        @OnClick({R.id.bt_xq, R.id.bt_dz, R.id.bt_sc, R.id.bt_fx, R.id.bt_del})
        public void onViewClicked(View view) {
            view.setTag(index);
            switch (view.getId()) {
                case R.id.bt_xq:

                    callBack.onItemXQClick(view);
                    break;
                case R.id.bt_dz:

                    callBack.onItemDZClick(view);
                    break;
                case R.id.bt_sc:
                    callBack.onItemSCClick(view);
                    break;
                case R.id.bt_fx:
                    callBack.onItemFXClick(view);
                    break;
                case R.id.bt_del:
                    JZVideoPlayer.goOnPlayOnPause();
                    callBack.onItemDelClick(view);
                    break;
            }
        }
        MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
        int index = 0;
        public void setTag(int tag) {
            this.index = tag;
        }
    }
}