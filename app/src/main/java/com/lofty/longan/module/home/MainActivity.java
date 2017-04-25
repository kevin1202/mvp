package com.lofty.longan.module.home;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.lofty.longan.R;
import com.lofty.longan.base.BaseActivity;
import com.lofty.longan.model.bean.BookResponse;
import com.lofty.longan.model.net.ExceptionHandle;
import com.lofty.longan.utils.FrescoUtils;
import com.lofty.longan.view.loadview.CommonLoadingView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

public class MainActivity extends BaseActivity implements MainContract.View {

    private MainContract.Presenter presenter;

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView rvBooks;
    private CommonLoadingView mLoadingView;
    private BookAdapter bookAdapter;
    private List<BookResponse.Result.Book> books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new MainPresenter(this);
        initView();
        initData();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    public void initView() {
        mLoadingView = (CommonLoadingView) findViewById(R.id.loadingView);

        mLoadingView.setLoadingHandler(new CommonLoadingView.LoadingHandler() {
            @Override
            public void doRequestData() {
                getBookList();
            }
        });
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.refresh_layout);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getBookList();
            }
        });
        rvBooks = (RecyclerView) findViewById(R.id.recycler_view);

    }

    private void getBookList() {
        mLoadingView.load();
        Observable.timer(3, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {

                    @Override
                    public void accept(Long aLong) throws Exception {
                        presenter.getBookList();
                    }
                });

    }

    protected void initData() {
        books = new ArrayList<>();
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
                getBookList();
            }
        });
        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_red_light);
        // 设置手指在屏幕下拉多少距离会触发下拉刷新
        mSwipeRefreshLayout.setDistanceToTriggerSync(300);
        // 设定下拉圆圈的背景
        mSwipeRefreshLayout.setProgressBackgroundColorSchemeColor(Color.WHITE);
        // 设置圆圈的大小
        mSwipeRefreshLayout.setSize(SwipeRefreshLayout.LARGE);
        rvBooks.setLayoutManager(new LinearLayoutManager(this));
        rvBooks.addItemDecoration(new DividerItemDecoration(MainActivity.this, LinearLayoutManager.VERTICAL));
        bookAdapter = new BookAdapter(this, books);
        rvBooks.setAdapter(bookAdapter);
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showError(ExceptionHandle.ResponeThrowable throwable) {
        mSwipeRefreshLayout.setRefreshing(false);
        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
        mLoadingView.loadError();
    }

    @Override
    public void updateBookList(BookResponse response) {
        mLoadingView.loadSuccess();
        bookAdapter.setData(response.getResult().getBookList());
        bookAdapter.notifyDataSetChanged();
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showLoadEmpey() {
        mSwipeRefreshLayout.setRefreshing(false);
        mLoadingView.loadSuccess(true);
        Toast.makeText(this, "加载数据为空", Toast.LENGTH_SHORT).show();
    }


    public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

        private Context mContext;

        public void setData(List<BookResponse.Result.Book> datas) {
            this.datas = datas;
        }

        private List<BookResponse.Result.Book> datas;//数据

        //适配器初始化
        public BookAdapter(Context context, List<BookResponse.Result.Book> datas) {
            mContext = context;
            this.datas = datas;
        }

        @Override
        public BookAdapter.BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.list_item_book, parent, false);
            return new BookViewHolder(view);
        }

        @Override
        public void onBindViewHolder(BookViewHolder holder, int position) {
            FrescoUtils.loadImage(datas.get(position).getCoverImg(), holder.ivCover);
            holder.tvName.setText("名称：" + datas.get(position).getName());
            holder.tvType.setText("类型：" + datas.get(position).getType());
            holder.tvArea.setText("地区：" + datas.get(position).getArea());
            holder.tvDate.setText("更新日期：" + datas.get(position).getLastUpdate());
        }

        @Override
        public int getItemCount() {
            return datas == null ? 0 : datas.size();//获取数据的个数
        }

        //自定义ViewHolder，用于加载图片
        class BookViewHolder extends RecyclerView.ViewHolder {
            private SimpleDraweeView ivCover;
            private TextView tvName, tvType, tvArea, tvDate;

            public BookViewHolder(View view) {
                super(view);
                ivCover = (SimpleDraweeView) view.findViewById(R.id.iv_book_cover);
                tvName = (TextView) view.findViewById(R.id.tv_book_name);
                tvType = (TextView) view.findViewById(R.id.tv_book_type);
                tvArea = (TextView) view.findViewById(R.id.tv_book_area);
                tvDate = (TextView) view.findViewById(R.id.tv_book_date);
            }
        }

    }
}