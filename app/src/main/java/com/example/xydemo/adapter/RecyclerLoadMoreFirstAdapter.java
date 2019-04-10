package com.example.xydemo.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.xydemo.callback.RecyclerDelCallBack;
import com.example.xydemo.entity.LordMoreEntity;
import com.example.xydemojava.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class RecyclerLoadMoreFirstAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /**
     * 第一种ViewType，正常的item
     */
    private int normalType = 0;
    /**
     * 第二种ViewType，底部的提示View
     */
    private int footType = 1;
    /**
     * 变量，是否有更多数据
     */
    private boolean hasMore;
    /**
     * 变量，是否隐藏了底部的提示
     */
    private boolean fadeTips = false;
    /**
     * 获取主线程的Handler
     */
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Context mContext;
    private RecyclerDelCallBack callBack;
    public RecyclerLoadMoreFirstAdapter(Context context, boolean hasMore, RecyclerDelCallBack callBack) {
        this.mContext = context;
        this.hasMore = hasMore;
        this.callBack = callBack;
    }

    private List<LordMoreEntity> data = new ArrayList<>();

    /**
     * 暴露接口，更新数据源，并修改hasMore的值，如果有增加数据，hasMore为true，否则为false
     */
    public void updateList(List<LordMoreEntity> newDatas, boolean hasMore) {
        // 在原有的数据之上增加新数据
        if (newDatas != null) {
            data.addAll(newDatas);
        }
        this.hasMore = hasMore;
        notifyDataSetChanged();
    }

    public void setData(List<LordMoreEntity> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int type) {
        if (type == normalType) {
            return new MyViewHolder(LayoutInflater.from(mContext)
                    .inflate(R.layout.item_videoview, parent, false));
        } else {
            //这个是上拉加载更多的view
            return new FootHolder(LayoutInflater.from(mContext)
                    .inflate(R.layout.item_loadmore_footer, parent, false));
        }
    }

    /**
     * 根据条目位置返回ViewType，以供onCreateViewHolder方法内获取不同的Holder
     */
    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1) {
            return footType;
        } else {
            return normalType;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            LordMoreEntity person = data.get(position);
            setBindViewHolder((MyViewHolder) holder, person, position);
        } else {
            setFootBindViewHolder((FootHolder) holder, position);
        }
    }



    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size() + 1;
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
        @BindView(R.id.bt_del)
        Button btDel;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
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
                    callBack.onItemDelClick(view);
                    break;
            }
        }
        int index;
        public void setTag(int index){
            this.index = index;
        }
    }

    class FootHolder extends RecyclerView.ViewHolder {

        private TextView tv_more;

        FootHolder(View itemView) {
            super(itemView);
            tv_more = itemView.findViewById(R.id.tv_more);
        }
    }

    private void setFootBindViewHolder(FootHolder holder, int position) {

    }

    private void setBindViewHolder(MyViewHolder holder, LordMoreEntity person, int position) {
        holder.setTag(position);
        holder.videoplayer.setUp(person.getUrl(), JZVideoPlayer.SCREEN_WINDOW_NORMAL,"");
    }
}
