package com.lofty.longan.model.source;

import com.lofty.longan.model.bean.BookResponse;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * 图书接口
 */
public interface BooksDataSource {

    Observable<BookResponse> getBookList();
}
