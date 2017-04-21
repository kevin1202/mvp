package com.lofty.longan.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lofty.longan.app.AppManager;

/**
 * MVP activity基类
 */
public abstract class BaseActivity<T extends RxPresenter> extends AppCompatActivity implements BaseView {

    protected T presenter;
    protected Activity activity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        activity = this;
        presenter = (T) getPresenter();
        if (presenter != null)
            presenter.attachView(this);
        presenter.checkViewAttached();
        initView();
        initData();
        AppManager.getAppManager().addActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null)
            presenter.detachView();
        AppManager.getAppManager().finishActivity(this);
    }

    protected abstract int getLayout();

    protected abstract BasePresenter getPresenter();

    protected abstract void initView();

    protected abstract void initData();
}