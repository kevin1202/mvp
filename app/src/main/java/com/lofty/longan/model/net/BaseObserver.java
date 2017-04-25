package com.lofty.longan.model.net;

import com.lofty.longan.base.BaseView;

import io.reactivex.Observer;


public abstract class BaseObserver<T> implements Observer<T> {
    private BaseView view;

    public BaseObserver(BaseView view) {
        this.view = view;
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof ExceptionHandle.ResponeThrowable) {
            view.showError((ExceptionHandle.ResponeThrowable) e);
        } else {
            view.showError(new ExceptionHandle.ResponeThrowable(e, ExceptionHandle.ERROR.UNKNOWN));
        }
    }

    @Override
    public void onComplete() {}

}
