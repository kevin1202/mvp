package com.lofty.longan.model.net;

import com.lofty.longan.base.BaseView;

import io.reactivex.functions.Consumer;

/**
 * 处理异常
 */
public class RxException<T extends Throwable> implements Consumer<T> {

    private BaseView view;

    public RxException(BaseView view) {
        this.view = view;
    }

    @Override
    public void accept(T t) throws Exception {
        ExceptionHandle.ResponeThrowable responeThrowable = ExceptionHandle.handleException(t);
        view.showError(responeThrowable.getMessage());
    }
}
