package com.gzucm.mnews.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.gzucm.mnews.mvp.contract.ResetPsswordContract;
import com.gzucm.mnews.mvp.model.api.Api;
import com.gzucm.mnews.mvp.model.api.service.BmobApiService;
import com.gzucm.mnews.mvp.model.entity.BmobEntity.User;
import com.gzucm.mnews.mvp.model.entity.UserEntity;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import javax.inject.Inject;

import io.reactivex.Observable;
import me.jessyan.retrofiturlmanager.RetrofitUrlManager;


@ActivityScope
public class ResetPsswordModel extends BaseModel implements ResetPsswordContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public ResetPsswordModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
        RetrofitUrlManager.getInstance().putDomain("bmob", Api.Bmob_DOMAIN);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<UserEntity> resetPasswordByEmailed(User user) {
        return mRepositoryManager.obtainRetrofitService(BmobApiService.class)
                .resetPasswordByEmailed(user);
    }
}