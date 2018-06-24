package com.gzucm.mnews.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.widget.Toast;

import com.gzucm.mnews.R;
import com.gzucm.mnews.di.component.DaggerResetPsswordComponent;
import com.gzucm.mnews.di.module.ResetPsswordModule;
import com.gzucm.mnews.mvp.contract.ResetPsswordContract;
import com.gzucm.mnews.mvp.model.entity.BmobEntity.User;
import com.gzucm.mnews.mvp.presenter.ResetPsswordPresenter;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Observable;
import rx.functions.Action1;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class ResetPsswordActivity extends BaseActivity<ResetPsswordPresenter> implements ResetPsswordContract.View {

    @BindView(R.id.et_email_reset)
    EditText emailEt;

    User user = new User();
    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerResetPsswordComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .resetPsswordModule(new ResetPsswordModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_reset_pssword; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

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

    @OnClick(R.id.btn_reset)
    void reset(){
        String email = emailEt.getText().toString().trim();
        //TODO 发邮箱的链接输入新密码 所以怎么将这个密码转为MD5存到后台

        user.setEmail(email);
        mPresenter.resetPasswordByEmailed(user);
    }
    @Override
    public void resetFailed() {

        Observable.timer(1, TimeUnit.HOURS).subscribe(new Action1<Long>() {
            @Override
            public void call(Long aLong) {
                Toast.makeText(ResetPsswordActivity.this, "重置密码超时", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void resetSuccess() {
        Toast.makeText(ResetPsswordActivity.this, "请前往邮箱更改密码", Toast.LENGTH_SHORT).show();
    }
}
