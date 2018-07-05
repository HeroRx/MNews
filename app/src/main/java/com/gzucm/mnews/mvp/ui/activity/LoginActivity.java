package com.gzucm.mnews.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blankj.utilcode.util.EncryptUtils;
import com.gzucm.mnews.R;
import com.gzucm.mnews.di.component.DaggerLoginComponent;
import com.gzucm.mnews.di.module.LoginModule;
import com.gzucm.mnews.mvp.contract.LoginContract;
import com.gzucm.mnews.mvp.presenter.LoginPresenter;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import butterknife.BindView;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.et_user)
    EditText usernameEt;
    @BindView(R.id.et_psw)
    EditText passwordEt;

    @BindView(R.id.btn_login)
    Button login;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerLoginComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_login; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
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

    @OnClick(R.id.tv_register)
    void register(){
//        Toast.makeText(LoginActivity.this, "注册", Toast.LENGTH_SHORT).show();
        ArmsUtils.startActivity(RegisterActivity.class);
        finish();
    }
    @OnClick(R.id.btn_login)
    void login(){
        String username = usernameEt.getText().toString().trim();
        String password = passwordEt.getText().toString().trim();
        //TODO 使用MD5登录
        String md5 = EncryptUtils.encryptMD5ToString(password);
        mPresenter.login(username, password);

    }

    @OnClick(R.id.tv_forget_psw)
    void reset(){
        ArmsUtils.startActivity(ResetPsswordActivity.class);

    }
    @Override
    public void loginFailed() {
        Toast.makeText(LoginActivity.this, "用户名或者密码错误", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void loginSuccess() {

        Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        finish();
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
