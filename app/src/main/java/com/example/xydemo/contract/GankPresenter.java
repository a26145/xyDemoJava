package com.example.xydemo.contract;

import android.util.Log;

import com.example.xydemo.entity.LordMoreEntity;
import com.example.xydemo.entity.LordMoreResponseEntity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class GankPresenter implements GankContract.Presenter{

    private final GankUrlService mUrlService;
    private final GankContract.View mView;
    private List<LordMoreEntity> mListData = new ArrayList<>();
    private String mType;
    private int mCurrentPage;

    public GankPresenter(GankContract.View view, String fragmentType) {
        // retrofit 创建API Service实例
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GankUrlService.BASE_URL)
                .addConverterFactory(new NullOnEmptyConverterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        mUrlService = retrofit.create(GankUrlService.class);
        mListData.clear();
        mView = view;
        mType = fragmentType;
    }

    @Override
    public void onViewCreate() {
        mCurrentPage = 1;
        loadData();
    }

    @Override
    public void startRefresh() {
        mCurrentPage = 1;
        loadData();
    }

    @Override
    public void startLoadMore() {
        mCurrentPage++;
        loadData();
    }

    private void loadData() {
        mUrlService.requestData(mType, 20, mCurrentPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LordMoreResponseEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(LordMoreResponseEntity value) {
                        // 首次或刷新
                        if (mCurrentPage == 1)
                            mListData.clear();

                        // 刷新数据
                        mListData.addAll(value.getResults());
                        mView.setListData(mListData, mType);

                        Log.e("adapter", "page:" + mCurrentPage + ", size:" + mListData.size());
                        // 更新视图
                        if (mCurrentPage == 1) {
                            mView.stopRefresh();
                        } else {
                            mView.stopLoadMore();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mView.onInitLoadFailed();
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }
}
