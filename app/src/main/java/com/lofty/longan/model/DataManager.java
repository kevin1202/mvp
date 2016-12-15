package com.lofty.longan.model;

import com.lofty.longan.model.bean.BaseResponse;
import com.lofty.longan.model.bean.Login;
import com.lofty.longan.model.net.DataSource;

import rx.Observable;

/**
 * 数据管理者
 */
public class DataManager {

    private DataSource dataSource;

    public DataManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 登录接口
     *
     * @param name
     * @param pwd
     */
    public Observable<BaseResponse<Login>> login(String name, String pwd) {
        return dataSource.login(name, pwd);
    }
}