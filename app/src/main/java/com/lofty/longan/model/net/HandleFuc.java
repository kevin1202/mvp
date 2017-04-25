package com.lofty.longan.model.net;

import com.lofty.longan.model.bean.BaseResponse;

import io.reactivex.functions.Function;

public class HandleFuc<T> implements Function<BaseResponse<T>, T> {
    @Override
    public T apply(BaseResponse<T> response) throws Exception {
        if (!response.isOk())
            throw new ExceptionHandle.ServerException(response.getCode(), response.getMsg() != null ? response.getMsg() : "");
        return response.getData();
    }
}
