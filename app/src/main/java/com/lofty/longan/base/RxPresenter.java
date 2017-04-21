package com.lofty.longan.base;

import com.lofty.longan.model.net.RxException;
import com.lofty.longan.model.net.RxManage;
import com.lofty.longan.model.net.RxSchedulers;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * 基于Rx的Presenter封装,控制订阅的生命周期
 */
public class RxPresenter<T extends BaseView> implements BasePresenter<T> {

    protected T view;
    protected RxManage rxManage;

    protected void addDisposable(Disposable disposable) {
        rxManage.add(disposable);
    }

    @Override
    public void attachView(T view) {
        this.view = view;
        rxManage = new RxManage();
    }

    @Override
    public void detachView() {
        this.view = null;
        rxManage.clear();
    }

    public boolean isViewAttached() {
        return view != null;
    }

    public T getView() {
        return view;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }

    public <T> void addDisposable(Observable<T> observable, Consumer<T> consumer) {
        Disposable disposable = observable
                .compose(RxSchedulers.<T>io_main())
                .subscribe(consumer, new RxException<>(view));
        rxManage.add(disposable);
    }

}