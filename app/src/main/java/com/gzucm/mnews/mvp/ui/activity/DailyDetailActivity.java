package com.gzucm.mnews.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.gzucm.mnews.R;
import com.gzucm.mnews.app.configuration.AppConstant;
import com.gzucm.mnews.di.component.DaggerDailyDetailComponent;
import com.gzucm.mnews.di.module.DailyDetailModule;
import com.gzucm.mnews.mvp.contract.DailyDetailContract;
import com.gzucm.mnews.mvp.model.entity.DailyDetailsEntity;
import com.gzucm.mnews.mvp.presenter.DailyDetailPresenter;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;

import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class DailyDetailActivity extends BaseActivity<DailyDetailPresenter> implements DailyDetailContract.View{

    @BindView(R.id.ctl_daily_detail)
    CollapsingToolbarLayout mCollapsingToolbarLayout;

    @BindView(R.id.iv_daily_detail)
    ImageView mDetailImage;

    @BindView(R.id.tv_title_daily_detail)
    TextView mDetailTitle;

    @BindView(R.id.tv_source_daily_detail)
    TextView mDetailSource;

    @BindView(R.id.wv_daily_detail)
    WebView mWebView;


    @BindView(R.id.tv_love_daily_detail)
    TextView mBottomLoveTv;

    @BindView(R.id.tv_comment_daily_detail)
    TextView mBottomCommentTv;

//    private int mId;

    private AppComponent mAppComponent;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerDailyDetailComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .dailyDetailModule(new DailyDetailModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_daily_detail; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        Intent intent = getIntent();
        if (intent != null) {
//            Toast.makeText(this,"idid"+mId,Toast.LENGTH_SHORT).show();
            mPresenter.getNewsDetails(intent.getIntExtra(AppConstant.NEW_ID,-1));
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }

    @Override
    public void loadData(DailyDetailsEntity dailyDetailsEntity) {
        if (mAppComponent == null) {
            mAppComponent = ArmsUtils.obtainAppComponentFromContext(this);
        }
        mAppComponent
                .imageLoader()
                .loadImage(this, ImageConfigImpl
                        .builder()
                        .placeholder(R.drawable.account_avatar)
                        .imageView(mDetailImage)
                        .url(dailyDetailsEntity.getImage())
                        .build());
        mDetailTitle.setText(dailyDetailsEntity.getTitle());
        mDetailSource.setText(dailyDetailsEntity.getImage_source());
    }



//    @Override
//    public void process(int id) {
//        mId = id;
//    }
}
