package com.lofty.longan.module.home;


import com.lofty.longan.base.BasePresenter;
import com.lofty.longan.base.BaseView;
import com.lofty.longan.model.bean.BookResponse;

/**
 * 订单列表获取购物车数量
 */
public interface MainContract {

    interface View extends BaseView<Presenter> {

        void updateBookList(BookResponse response);

        void showLoadEmpey();
    }

    interface Presenter extends BasePresenter {

        void getBookList();

    }
}
