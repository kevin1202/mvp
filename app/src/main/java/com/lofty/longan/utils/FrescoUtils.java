package com.lofty.longan.utils;

import android.net.Uri;

import com.facebook.drawee.view.SimpleDraweeView;

public class FrescoUtils {
    public static void loadImage(String url, SimpleDraweeView view) {
        view.setImageURI(Uri.parse(url));
    }
}
