package com.example.xydemo.contract;

import com.example.xydemo.entity.LordMoreEntity;

import java.util.List;

public interface GankContract {
    interface View {
        //        void setPageState(boolean isLoading);
        void setListData(List<LordMoreEntity> listData, String type);

        //        void onRefreshComplete();
//        void onLoadMoreComplete();
        void onInitLoadFailed();

        void stopRefresh();

        void stopLoadMore();
    }

    interface Presenter {
        void onViewCreate();

        void startRefresh();

        void startLoadMore();
    }
}
