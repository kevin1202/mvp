package com.lofty.longan.model.net;

import com.lofty.longan.model.bean.BaseResponse;
import com.lofty.longan.model.bean.Login;

import retrofit2.http.GET;
import rx.Observable;

/**
 *
 */
public interface DataSource {

    @GET("login")
    Observable<BaseResponse<Login>> login(String name, String password);
}