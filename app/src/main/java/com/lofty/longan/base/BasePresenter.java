package com.lofty.longan.base;


/**
 * Every presenter in the app must either implement this interface or extend BasePresenter
 * indicating the MvpView type that wants to be attached with.
 */
public interface BasePresenter<V extends BaseView> {

    void attachView(V view);

    void detachView();
}
