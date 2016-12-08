package com.lofty.longan.model.net;

import com.lofty.longan.model.bean.BaseResponse;
import com.lofty.longan.model.bean.Login;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by codeest on 16/10/10.
 * https://github.com/codeestX/my-restful-api
 */

public interface ApiService {

    /**
     * 用户登录
     *
     * @return
     */
    @GET("version")
    Observable<BaseResponse<Login>> login();
}