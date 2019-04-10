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

import com.example.xydemo.adapter.GankNewsAdapter;
import com.example.xydemo.contract.GankContract;
import com.example.xydemo.contract.GankPresenter;
import com.example.xydemo.entity.LordMoreEntity;
import com.example.xydemo.widget.xRecyclerView;
import com.example.xydemojava.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GankFragment extends Fragment implements GankContract.View {

    private static final String GANK_DATA_KEY = "gank_fragment_data_key";

    /**
     * 创建instance
     */
    public static GankFragment newInstance(@NonNull String type) {
        Bundle bundle = new Bundle();
        bundle.putString(GANK_DATA_KEY, type);
        GankFragment gankFragment = new GankFragment();
        gankFragment.setArguments(bundle);
        return gankFragment;
    }
    private GankNewsAdapter mAdapter;
    private GankPresenter mPresenter;

    @BindView(R.id.gank_recycler_view)
    xRecyclerView mRecyclerView;

    @BindView(R.id.gank_load_failed_tv)
    TextView mTvLoadFailed;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new GankPresenter(this, getArguments().getString(GANK_DATA_KEY));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_loadmore, null);
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
                mPresenter.startLoadMore();
            }
        });
        mRecyclerView.startRefreshing();
        mPresenter.onViewCreate();
    }


    @Override
    public void setListData(List<LordMoreEntity> listData, String type) {
        if (mAdapter == null) {
            mAdapter = new GankNewsAdapter(listData, type);
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