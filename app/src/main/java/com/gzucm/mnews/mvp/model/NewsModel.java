package com.gzucm.mnews.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.gzucm.mnews.mvp.contract.NewsContract;
import com.gzucm.mnews.mvp.model.api.Api;
import com.gzucm.mnews.mvp.model.api.service.ApiService;
import com.gzucm.mnews.mvp.model.entity.DailyEntity;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import javax.inject.Inject;

import io.reactivex.Observable;
import me.jessyan.retrofiturlmanager.RetrofitUrlManager;


@FragmentScope
public class NewsModel extends BaseModel implements NewsContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public NewsModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);

        RetrofitUrlManager.getInstance().putDomain("zhihu", Api.ZHIHU_DOMAIN);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<DailyEntity> getlatestNews() {
        return mRepositoryManager.obtainRetrofitService(ApiService.class)
                .getlatestNews();
    }
}