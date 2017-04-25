package com.lofty.longan.model.source.remote;

import com.lofty.longan.model.bean.BookResponse;
import com.lofty.longan.model.net.RetrofitHelper;
import com.lofty.longan.model.source.BooksDataSource;
import com.lofty.longan.model.source.BooksService;

import io.reactivex.Observable;

/**
 * 远程图书数据
 */
public class BooksRemoteDataSource implements BooksDataSource {

    private BooksService service;

    public BooksRemoteDataSource() {
        service = RetrofitHelper.createApi(BooksService.class, "http://japi.juhe.cn");
    }

    @Override
    public Observable<BookResponse> getBookList() {
        return service.getBookList();
    }
}
