package com.lofty.longan.view.activity.welcome;

import android.content.Intent;
import android.widget.Toast;

import com.blankj.utilcode.utils.BarUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lofty.longan.R;
import com.lofty.longan.base.BaseActivity;
import com.lofty.longan.base.RxPresenter;
import com.lofty.longan.contract.welcome.WelcomeContract;
import com.lofty.longan.presenter.welcome.WelcomePresenter;
import com.lofty.longan.utils.FrescoUtils;
import com.lofty.longan.view.activity.home.MainActivity;

public class WelcomeActivity extends BaseActivity<WelcomePresenter> implements WelcomeContract.View {

    private SimpleDraweeView ivWelcome;

    @Override
    protected int getLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    protected RxPresenter getPresenter() {
        return new WelcomePresenter();
    }

    @Override
    protected void initView() {
        ivWelcome = (SimpleDraweeView) findViewById(R.id.iv_welcome);
    }

    @Override
    protected void initData() {
        presenter.init();
    }

    @Override
    public void initBar() {
        BarUtils.setTransparentStatusBar(this);
    }

    @Override
    public void loadImage() {
        FrescoUtils.loadImage("http://www.pixelstalk.net/wp-content/uploads/2016/06/Phone-Free-1080-x-1920-HD-Wallpapers.jpg", ivWelcome);
    }

    @Override
    public void jumpToMain() {
        startActivity(new Intent(this, MainActivity.class));
        this.finish();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }
}