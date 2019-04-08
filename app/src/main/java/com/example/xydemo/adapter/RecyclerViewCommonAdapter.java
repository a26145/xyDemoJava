package com.example.xydemo.adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xydemo.base.BaseActivity;
import com.example.xydemo.constant.Constants;
import com.example.xydemo.interfaces.UpDateInterface;
import com.example.xydemojava.R;

public class RecyclerViewCommonAdapter extends RecyclerView.Adapter<RecyclerViewCommonAdapter.RecyclerViewCommonHolder> implements UpDateInterface {

    private BaseActivity activity;
    private int size;
    private Constants.MainMenuModel model;

    public RecyclerViewCommonAdapter(BaseActivity mainActivity) {
        activity = mainActivity;
    }


    @NonNull
    @Override
    public RecyclerViewCommonHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerViewCommonHolder recyclerViewCommonHolder = new RecyclerViewCommonHolder(activity.getLayoutInflater().inflate(R.layout.item_mainmenu, null));
        return recyclerViewCommonHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewCommonHolder recyclerViewCommonHolder, int i) {
        if(model==null)
            return;
        final Constants.ItemModel itemModel = model.get(i);
        recyclerViewCommonHolder.tvText.setText(itemModel.getName());
        recyclerViewCommonHolder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, itemModel.getClz());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return size;
    }

    @Override
    public void update(Object o) {
        model = (Constants.MainMenuModel) o;
        this.size = model.size;
        notifyDataSetChanged();
    }

    class RecyclerViewCommonHolder extends RecyclerView.ViewHolder {

        TextView tvText;
        View rootView;

        public RecyclerViewCommonHolder(@NonNull View itemView) {
            super(itemView);
            tvText = itemView.findViewById(R.id.tv_text);
            rootView = itemView.findViewById(R.id.rl_root);
        }
    }
}
