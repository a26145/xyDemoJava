package com.example.xydemo.contract;

import com.example.xydemo.entity.LordMoreResponseEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GankUrlService {
    String BASE_URL = "http://gank.io/api/";

    @GET("data/{category}/{pagecount}/{page}")
    Observable<LordMoreResponseEntity> requestData(
            @Path("category") String category,
            @Path("pagecount") int countPerPage,
            @Path("page") int page);
}
