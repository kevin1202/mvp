package com.lofty.longan.model.net;

import com.lofty.longan.model.bean.BaseResponse;
import com.lofty.longan.model.bean.Login;

import rx.Observable;

/**
 * 数据实现
 */
public class DataSourceImpl implements DataSource {

    /**
     * 用户登录
     * @param name
     * @param pwd
     * @return
     */
    public Observable<BaseResponse<Login>> login(String name, String pwd) {
        return RetrofitHelper.createApi(DataSource.class).login(name, pwd);
    }
}