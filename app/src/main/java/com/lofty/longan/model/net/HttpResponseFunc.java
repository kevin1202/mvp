package com.lofty.longan.model.net;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class HttpResponseFunc<T> implements Function<Throwable, Observable<T>> {
    @Override
    public Observable<T> apply(Throwable throwable) throws Exception {
        return Observable.error(ExceptionHandle.handleException(throwable));
    }
}