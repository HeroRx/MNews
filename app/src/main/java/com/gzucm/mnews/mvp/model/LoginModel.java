package com.gzucm.mnews.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.gzucm.mnews.mvp.contract.LoginContract;
import com.gzucm.mnews.mvp.model.api.service.BmobApiService;
import com.gzucm.mnews.mvp.model.entity.UserEntity;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import javax.inject.Inject;

import io.reactivex.Observable;


@ActivityScope
public class LoginModel extends BaseModel implements LoginContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public LoginModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<UserEntity> loginByAccount(String username, String password) {
        return mRepositoryManager.obtainRetrofitService(BmobApiService.class)
                .loginByAccount(username,password);
    }


}