package com.lofty.longan.model.net;


import android.util.Log;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

class SecurityInterceptor implements Interceptor {
    private final static String KEY = "key";
    private final static String METHOD_GET = "GET";
    private final static String METHOD_POST = "POST";
    public static final String BOOK_KEY = "67ebba9b530d1f0ef17ac5cb8bef0c8a";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (request.method().equals(METHOD_GET)) {
            HttpUrl url = request.url();
            url = url.newBuilder().addQueryParameter(KEY, BOOK_KEY).build();
            request = request.newBuilder()
                    .url(url)
                    .method(request.method(), request.body())
                    .build();
            Log.d("OkHttp", url.toString());
        }

        return chain.proceed(request);
    }

}
