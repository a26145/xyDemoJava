package com.example.xydemo.views.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xydemo.adapter.DelRecyclerAdapter;
import com.example.xydemo.adapter.GankNewsAdapter;
import com.example.xydemo.callback.RecyclerDelCallBack;
import com.example.xydemo.contract.DelRecyclerPresenter;
import com.example.xydemo.contract.GankContract;
import com.example.xydemo.contract.GankPresenter;
import com.example.xydemo.entity.LordMoreEntity;
import com.example.xydemo.widget.xRecyclerView;
import com.example.xydemojava.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DelRecyclerFragment extends Fragment implements GankContract.View {

    private static final String GANK_DATA_KEY = "gank_fragment_data_key";

    /**
     * 创建instance
     */
    public static DelRecyclerFragment newInstance(@NonNull String type) {
        Bundle bundle = new Bundle();
        bundle.putString(GANK_DATA_KEY, type);
        DelRecyclerFragment gankFragment = new DelRecyclerFragment();
        gankFragment.setArguments(bundle);
        return gankFragment;
    }
    private DelRecyclerAdapter mAdapter;
    private DelRecyclerPresenter mPresenter;

    @BindView(R.id.gank_recycler_view)
    xRecyclerView mRecyclerView;

    @BindView(R.id.gank_load_failed_tv)
    TextView mTvLoadFailed;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new DelRecyclerPresenter(this, getArguments().getString(GANK_DATA_KEY));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(this.getActivity()).inflate(R.layout.fragment_loadmore, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        mRecyclerView.setListener(new xRecyclerView.xAdapterListener() {
            @Override
            public void startRefresh() {
                Log.e("fragment", "start refresh");
                mPresenter.startRefresh();
            }

            @Override
            public void startLoadMore() {
                Log.e("fragment", "start load more");
//                mPresenter.startLoadMore();
            }
        });
        mRecyclerView.startRefreshing();
        mPresenter.onViewCreate();
    }

    ArrayList<LordMoreEntity> entities = new ArrayList<>();
    @Override
    public void setListData(List<LordMoreEntity> listData, String type) {
        if (mAdapter == null) {
            mAdapter = new DelRecyclerAdapter(listData, type, new RecyclerDelCallBack() {
                @Override
                public void onItemXQClick(View v) {
                    if(entities.size()>0){
                        mAdapter.addOne(entities.get(0));
                    }
                }
                @Override
                public void onItemDZClick(View v) {

                }

                @Override
                public void onItemFXClick(View v) {

                }

                @Override
                public void onItemSCClick(View v) {

                }

                @Override
                public void onItemDelClick(View v) {
                    LordMoreEntity lordMoreEntity = mAdapter.delOne((Integer) v.getTag());
                    entities.add(lordMoreEntity);
                }
            });
            mRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onInitLoadFailed() {
        mRecyclerView.setVisibility(View.GONE);
        mTvLoadFailed.setVisibility(View.VISIBLE);
    }

    @Override
    public void stopRefresh() {
        mRecyclerView.stopRefreshing();
    }

    @Override
    public void stopLoadMore() {
        mRecyclerView.stopLoadingMore();
    }
}