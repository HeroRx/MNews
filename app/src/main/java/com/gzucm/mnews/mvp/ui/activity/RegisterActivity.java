package com.gzucm.mnews.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.widget.Toast;

import com.blankj.utilcode.util.EncryptUtils;
import com.blankj.utilcode.util.RegexUtils;
import com.gzucm.mnews.R;
import com.gzucm.mnews.app.util.DialogUtil;
import com.gzucm.mnews.di.component.DaggerRegisterComponent;
import com.gzucm.mnews.di.module.RegisterModule;
import com.gzucm.mnews.mvp.contract.RegisterContract;
import com.gzucm.mnews.mvp.model.entity.BmobEntity.User;
import com.gzucm.mnews.mvp.presenter.RegisterPresenter;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import butterknife.BindView;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class RegisterActivity extends BaseActivity<RegisterPresenter> implements RegisterContract.View {

    @BindView(R.id.et_user_register)
    EditText usernameEt;
    @BindView(R.id.et_psw_register)
    EditText passwordEt;
    @BindView(R.id.et_phone_register)
    EditText phoneEt;

    User user = null;
    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerRegisterComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .registerModule(new RegisterModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_register; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
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

    @OnClick(R.id.btn_register)
    void register(){
        String username = usernameEt.getText().toString().trim();
        String password = passwordEt.getText().toString().trim();
        String phone = phoneEt.getText().toString().trim();
        String md5 = EncryptUtils.encryptMD5ToString(password);
        if (RegexUtils.isMobileExact(phone)){
            user = new User(username,md5,phone);
            mPresenter.register(user);
        }else {
            Toast.makeText(RegisterActivity.this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void registerFailedByAccountExist() {
        Toast.makeText(RegisterActivity.this, "用户名已经存在", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void registerSuccess() {
//        Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
        DialogUtil.showProgressDialog("","注册成功,正在登录中...",RegisterActivity.this);
        mPresenter.autoLogin(user.getUsername(),user.getPassword());
    }

    @Override
    public void registerFaildeByPhoneExist() {
        Toast.makeText(RegisterActivity.this, "手机号已经被注册", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void autoLoginFailed() {

    }

    @Override
    public void autoLoginSuccess() {
        DialogUtil.hideProgressDialog();
    }


}
