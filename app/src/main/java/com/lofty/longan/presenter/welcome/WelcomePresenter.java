package com.lofty.longan.presenter.welcome;

import com.lofty.longan.base.RxPresenter;
import com.lofty.longan.contract.welcome.WelcomeContract;
import com.lofty.longan.model.net.RxSchedulers;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;


public class WelcomePresenter extends RxPresenter<WelcomeContract.View> implements WelcomeContract.Presenter {

    @Override
    public void init() {
        view.initBar();
        view.loadImage();
        startCountDown();
    }

    private void startCountDown() {
        Disposable disposable = Observable.timer(3000, TimeUnit.MILLISECONDS)
                .compose(new ObservableTransformer<Long, Long>() {
                    @Override
                    public ObservableSource<Long> apply(Observable<Long> observable) {
                        return observable.compose(RxSchedulers.<Long>io_main());
                    }
                })
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        view.jumpToMain();
                    }

                });
        addDisposable(disposable);
    }
}