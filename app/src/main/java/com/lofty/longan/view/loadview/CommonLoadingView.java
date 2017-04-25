package com.lofty.longan.view.loadview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.lofty.longan.R;

/**
 * 通用处理view
 */

public class CommonLoadingView extends FrameLayout {

    public Context mContext;
    //加载错误视图
    protected LinearLayout mLoadErrorLl;
    //加载错误点击事件处理
    private LoadingHandler mLoadingHandler;
    //加载view
    private View loadingView;
    //加载失败view
    private View loadingErrorView;
    //数据为空
    private View emptyView;

    public CommonLoadingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CommonLoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }

    public void setLoadingHandler(LoadingHandler loadingHandler) {
        mLoadingHandler = loadingHandler;
    }

    public void setLoadingErrorView(View loadingErrorView) {
        this.removeViewAt(1);
        this.loadingErrorView = loadingErrorView;
        this.loadingErrorView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLoadingHandler != null) {
                    mLoadingHandler.doRequestData();
                    CommonLoadingView.this.load();
                }
            }
        });
        this.addView(loadingErrorView,1);
    }

    public void setLoadingView(View loadingView) {
        this.removeViewAt(0);
        this.loadingView = loadingView;
        this.addView(loadingView,0);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        loadingView = inflate(mContext, R.layout.common_loading_view, null);
        loadingErrorView = inflate(mContext, R.layout.common_not_network_view, null);
        emptyView = inflate(mContext, R.layout.common_empty_view, null);
        this.addView(loadingView);
        this.addView(loadingErrorView);
        this.addView(emptyView);
        loadingErrorView.setVisibility(GONE);
        emptyView.setVisibility(GONE);
        initView(this);
    }

    private void initView(View rootView) {
        mLoadErrorLl = (LinearLayout) rootView.findViewById(R.id.load_error_ll);
        mLoadErrorLl.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLoadingHandler != null) {
                    CommonLoadingView.this.load();
                    mLoadingHandler.doRequestData();
                }
            }
        });
    }

    public void load(){
        loadingView.setVisibility(VISIBLE);
        loadingErrorView.setVisibility(GONE);
        emptyView.setVisibility(GONE);
    }

    public void loadSuccess(){
        this.loadSuccess(false);
    }

    public void loadSuccess(boolean isEmpty){
        loadingView.setVisibility(GONE);
        loadingErrorView.setVisibility(GONE);
        if (isEmpty) {
            emptyView.setVisibility(VISIBLE);
        }else{
            emptyView.setVisibility(GONE);
        }
    }


    public void loadError(){
        loadingView.setVisibility(GONE);
        loadingErrorView.setVisibility(VISIBLE);
    }


    public interface LoadingHandler{
        void doRequestData();
    }
}
