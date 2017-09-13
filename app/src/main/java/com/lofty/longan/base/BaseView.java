package com.lofty.longan.base;

import com.lofty.longan.model.net.ExceptionHandle;

/**
 * View基类
 */
public interface BaseView<T> {

    void setPresenter(T presenter);

    void showError(ExceptionHandle.ResponeThrowable throwable);
}