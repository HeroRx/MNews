package com.gzucm.mnews.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.widget.Toast;

import com.blankj.utilcode.util.FragmentUtils;
import com.gzucm.mnews.R;
import com.gzucm.mnews.di.component.DaggerMainComponent;
import com.gzucm.mnews.di.module.MainModule;
import com.gzucm.mnews.mvp.contract.MainContract;
import com.gzucm.mnews.mvp.presenter.MainPresenter;
import com.gzucm.mnews.mvp.ui.fragment.MyFragment;
import com.gzucm.mnews.mvp.ui.fragment.NewsFragment;
import com.gzucm.mnews.mvp.ui.fragment.SortFragment;
import com.gzucm.mnews.mvp.ui.fragment.ThemeFragment;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.gzucm.mnews.app.EventBusTags.ACTIVITY_FRAGMENT_REPLACE;
import static com.jess.arms.utils.Preconditions.checkNotNull;


public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.bottom_bar)
    BottomBar mBottomBar;

    private int mReplace = 0;

    private List<Integer> mTitles;
    private List<Fragment> mFragments;
    private List<Integer> mNavIds;

    //上次按下返回键的系统时间
    private long lastBackTime = 0;
    //当前按下返回键的系统时间
    private long currentBackTime = 0;

    private OnTabSelectListener mOnTabSelectListener = tabId -> {

        switch (tabId) {
            case R.id.tab_news:
                mReplace = 0;
                break;
            case R.id.tab_sort:
                mReplace = 1;
                break;
            case R.id.tab_theme:
                mReplace = 2;
                break;
            case R.id.tab_my:
                mReplace = 3;
                break;
        }

        FragmentUtils.showHide(mReplace, mFragments);
    };

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerMainComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

        if (mTitles == null) {
            mTitles = new ArrayList<>();
            mTitles.add(R.string.news);
            mTitles.add(R.string.sort);
            mTitles.add(R.string.theme);
            mTitles.add(R.string.my);
        }
        if (mNavIds == null) {
            mNavIds = new ArrayList<>();
            mNavIds.add(R.id.tab_news);
            mNavIds.add(R.id.tab_sort);
            mNavIds.add(R.id.tab_theme);
            mNavIds.add(R.id.tab_my);
        }

        NewsFragment mNewsFragment;
        SortFragment mSortFragment;
        ThemeFragment mThemeFragment;
        MyFragment mMyFragment;

        if (savedInstanceState == null) {
            mNewsFragment = NewsFragment.newInstance();
            mSortFragment = SortFragment.newInstance();
            mThemeFragment = ThemeFragment.newInstance();
            mMyFragment = MyFragment.newInstance();
        } else {
            mReplace = savedInstanceState.getInt(ACTIVITY_FRAGMENT_REPLACE);
            FragmentManager fm = getSupportFragmentManager();
            mNewsFragment = (NewsFragment) FragmentUtils.findFragment(fm, NewsFragment.class);
            mSortFragment = (SortFragment) FragmentUtils.findFragment(fm, SortFragment.class);
            mThemeFragment = (ThemeFragment) FragmentUtils.findFragment(fm, ThemeFragment.class);
            mMyFragment = (MyFragment) FragmentUtils.findFragment(fm, MyFragment.class);
        }
        if (mFragments == null) {
            mFragments = new ArrayList<>();
            mFragments.add(mNewsFragment);
            mFragments.add(mSortFragment);
            mFragments.add(mThemeFragment);
            mFragments.add(mMyFragment);
        }
        FragmentUtils.add(getSupportFragmentManager(), mFragments, R.id.main_frame, 0);
        mBottomBar.setOnTabSelectListener(mOnTabSelectListener);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //保存当前Activity显示的Fragment索引
        outState.putInt(ACTIVITY_FRAGMENT_REPLACE, mReplace);
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
    protected void onDestroy() {
        super.onDestroy();

        this.mTitles = null;
        this.mFragments = null;
        this.mNavIds = null;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //捕获返回键按下的事件
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //获取当前系统时间的毫秒数
            currentBackTime = System.currentTimeMillis();
            //比较上次按下返回键和当前按下返回键的时间差，如果大于2秒，则提示再按一次退出
            if (currentBackTime - lastBackTime > 2 * 1000) {
                Toast.makeText(this, "再按一次返回键退出", Toast.LENGTH_SHORT).show();
                lastBackTime = currentBackTime;
            } else { //如果两次按下的时间差小于2秒，则退出程序
                ArmsUtils.exitApp();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}
