package com.lofty.longan.model.source;

import com.lofty.longan.model.bean.BookResponse;

import io.reactivex.Observable;

/**
 * 图书数据仓库
 */
public class BooksRepository implements BooksDataSource{

    private static BooksDataSource source;
    private static BooksRepository instance;

    public static BooksRepository getInstance(BooksDataSource source) {
        if (instance == null) {
            synchronized (BooksRepository.class) {
                if (instance == null) {
                    instance = new BooksRepository();
                }
            }
        }
        BooksRepository.source = source;
        return instance;
    }


    @Override
    public Observable<BookResponse> getBookList() {
        return source.getBookList();
    }
}
