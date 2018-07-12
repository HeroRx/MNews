package com.gzucm.mnews.di.module;

import com.gzucm.mnews.mvp.contract.DailyDetailContract;
import com.gzucm.mnews.mvp.model.DailyDetailModel;
import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;


@Module
public class DailyDetailModule {
    private DailyDetailContract.View view;

    /**
     * 构建DailyDetailModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public DailyDetailModule(DailyDetailContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    DailyDetailContract.View provideDailyDetailView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    DailyDetailContract.Model provideDailyDetailModel(DailyDetailModel model) {
        return model;
    }
}