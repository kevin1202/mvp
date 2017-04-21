package com.lofty.longan.model.net;

import com.lofty.longan.model.bean.BaseResponse;
import com.lofty.longan.model.bean.LoginResponse;

import io.reactivex.Observable;


/**
 * 数据实现
 */
public class DataSourceImpl implements DataSource {

    public Observable<BaseResponse<LoginResponse>> login(String name, String pwd) {
        return RetrofitHelper.createApi(DataSource.class).login(name, pwd);
    }
}