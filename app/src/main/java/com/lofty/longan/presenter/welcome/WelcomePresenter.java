package com.lofty.longan.presenter.welcome;

import com.lofty.longan.base.RxPresenter;
import com.lofty.longan.contract.welcome.WelcomeContract;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class WelcomePresenter extends RxPresenter<WelcomeContract.View> implements WelcomeContract.Presenter {

    @Override
    public void init() {
        view.initBar();
        view.loadImage();
        startCountDown();
    }

    private void startCountDown() {
        Subscription rxSubscription = Observable.timer(3000, TimeUnit.MILLISECONDS)
                .compose(new Observable.Transformer<Long, Long>() {
                    @Override
                    public Observable<Long> call(Observable<Long> observable) {
                        return observable.subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread());
                    }
                })
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        view.jumpToMain();
                    }
                });
        addSubscrebe(rxSubscription);
    }
}