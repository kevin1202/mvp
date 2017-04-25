package com.lofty.longan.model.source.local;

import com.lofty.longan.model.bean.BookResponse;
import com.lofty.longan.model.source.BooksDataSource;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * 本地数据
 */
public class BooksLocalDataSource implements BooksDataSource {
    @Override
    public Observable<BookResponse> getBookList() {
        return Observable.create(new ObservableOnSubscribe<BookResponse>() {
            @Override
            public void subscribe(ObservableEmitter<BookResponse> observableEmitter) throws Exception {

                List<BookResponse.Result.Book> books = new ArrayList<>();
                for (int i = 0; i < 20; i++) {
                    BookResponse.Result.Book book = new BookResponse.Result.Book();
                    book.setCoverImg("http://img05.tooopen.com/images/20160121/tooopen_sy_155168162826.jpg");
                    book.setArea("少年" + i);
                    book.setName("懂你的" + i);
                    book.setType("国漫" + i);
                    book.setLastUpdate("20170425");
                    books.add(book);
                }

                BookResponse.Result result =new BookResponse.Result();
                result.setLimit(2000);
                result.setLimit(0);
                result.setBookList(books);

                BookResponse response = new BookResponse();
                response.setError_code(200);
                response.setReason("成功");
                response.setResult(result);

                observableEmitter.onNext(response);
                observableEmitter.onComplete();
            }
        });
    }
}
