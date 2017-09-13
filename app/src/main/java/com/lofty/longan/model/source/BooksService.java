package com.lofty.longan.model.source;

import com.lofty.longan.model.bean.BookResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * 图书请求
 */
public interface BooksService {

    @GET("/comic/book")
    Observable<BookResponse> getBookList();
}
