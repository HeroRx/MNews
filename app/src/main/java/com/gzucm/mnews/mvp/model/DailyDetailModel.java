package com.gzucm.mnews.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.gzucm.mnews.mvp.contract.DailyDetailContract;
import com.gzucm.mnews.mvp.model.api.service.ApiService;
import com.gzucm.mnews.mvp.model.entity.DailyDetailsEntity;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import javax.inject.Inject;

import io.reactivex.Observable;


@ActivityScope
public class DailyDetailModel extends BaseModel implements DailyDetailContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public DailyDetailModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<DailyDetailsEntity> getNewsDetails(int id) {
        return mRepositoryManager.obtainRetrofitService(ApiService.class)
                .getNewsDetails(id);
    }
}