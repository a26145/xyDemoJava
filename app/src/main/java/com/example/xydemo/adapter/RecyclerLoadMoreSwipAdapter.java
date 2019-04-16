package com.example.xydemo.adapter;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.xydemojava.R;
import com.marshalchen.ultimaterecyclerview.SwipeableUltimateViewAdapter;
import com.marshalchen.ultimaterecyclerview.URLogs;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;
import com.marshalchen.ultimaterecyclerview.swipe.SwipeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayerStandard;

public class RecyclerLoadMoreSwipAdapter extends SwipeableUltimateViewAdapter<String> {

    List<String> mList;
    private OnItemClickCallback clickListener;
    public RecyclerLoadMoreSwipAdapter(List<String> list, OnItemClickCallback callback) {
        super(list);
        mList = list;
        clickListener = callback;
    }

    @Override
    protected int getNormalLayoutResId() {
        return R.layout.item_swipeable;
    }

    @Override
    protected void withBindHolder(UltimateRecyclerviewViewHolder holder, String data, int position) {
        super.withBindHolder(holder, data, position);
//        ((SVHolder) holder).textView.setText(data);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public long generateHeaderId(int position) {
        return 0;
    }

    @Override
    public SVHolder newHeaderHolder(View view) {
        return new SVHolder(view, false);
    }


    @Override
    public SVHolder newFooterHolder(View view) {
        return new SVHolder(view, false);
    }

    @Override
    protected void removeNotifyExternal(int pos) {
        closeItem(pos);
    }

    @Override
    protected UltimateRecyclerviewViewHolder newViewHolder(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URLogs.d("click");
            }
        });
        final SVHolder viewHolder = new SVHolder(view, true);
        viewHolder.swipeLayout.setOnDoubleClickListener(new SwipeLayout.DoubleClickListener() {
            @Override
            public void onDoubleClick(SwipeLayout layout, boolean surface) {
                Toast.makeText(view.getContext(), "DoubleClick", Toast.LENGTH_SHORT).show();
            }
        });

        viewHolder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mList.remove(viewHolder.getLayoutPosition());
                removeAt(viewHolder.getLayoutPosition());
                Toast.makeText(view.getContext(), "Deleted " + viewHolder.getLayoutPosition(), Toast.LENGTH_SHORT).show();
                clickListener.onDeleteClick(v,viewHolder.getLayoutPosition());
            }
        });

        return viewHolder;
    }

    public void addData(ArrayList<String> data) {
        mList.addAll(data);
    }

    class SVHolder extends UltimateRecyclerviewViewHolder {
        //        public TextView textView;
        public Button deleteButton;
        public SwipeLayout swipeLayout;
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


        public SVHolder(View itemView, boolean bind) {
            super(itemView);
            if (bind) {
                ButterKnife.bind(this,itemView);
//                textView = (TextView) itemView.findViewById(R.id.position);
                deleteButton = (Button) itemView.findViewById(R.id.delete);
                swipeLayout = (SwipeLayout) itemView.findViewById(R.id.recyclerview_swipe);
                swipeLayout.setDragEdge(SwipeLayout.DragEdge.Right);
                swipeLayout.setShowMode(SwipeLayout.ShowMode.PullOut);
                player = itemView.findViewById(R.id.videoplayer);

            }
        }
    }
    public interface OnItemClickCallback{
        void onDeleteClick(View v,int position);
    }
}
