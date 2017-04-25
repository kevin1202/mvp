package com.lofty.longan.module.home;

import com.lofty.longan.model.bean.BookResponse;
import com.lofty.longan.model.net.BaseObserver;
import com.lofty.longan.model.net.RxManage;
import com.lofty.longan.model.net.RxSchedulers;
import com.lofty.longan.model.source.BooksRepository;
import com.lofty.longan.model.source.remote.BooksRemoteDataSource;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;

/**
 * 图书列表控制器
 */
class MainPresenter implements MainContract.Presenter {

    private BooksRepository repository;

    private MainContract.View view;
    private RxManage rxManage;

    public MainPresenter(MainContract.View view) {
        if (view == null) {
            throw new NullPointerException("tasksView cannot be null!");
        }
        this.view = view;
        rxManage = new RxManage();
        repository = BooksRepository.getInstance(new BooksRemoteDataSource());
        view.setPresenter(this);
    }

    @Override
    public void getBookList() {
        repository.getBookList()
                .compose(RxSchedulers.<BookResponse>io_main())
                .subscribe(new BaseObserver<BookResponse>(view) {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        rxManage.add(disposable);
                    }

                    @Override
                    public void onNext(BookResponse response) {
                        if (response.getResult().getBookList() == null || response.getResult().getBookList().isEmpty()) {
                            view.showLoadEmpey();
                        } else {
                            view.updateBookList(response);
                        }
                    }
                });
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        rxManage.clear();
    }
}
