package com.lofty.longan.model.net;

import com.lofty.longan.model.bean.BaseResponse;
import com.lofty.longan.model.bean.LoginResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 *
 */
public interface DataSource {

    @GET("login")
    Observable<BaseResponse<LoginResponse>> login(String name, String password);
}