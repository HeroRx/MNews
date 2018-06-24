package com.gzucm.mnews.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import com.gzucm.mnews.mvp.contract.ResetPsswordContract;
import com.gzucm.mnews.mvp.model.ResetPsswordModel;


@Module
public class ResetPsswordModule {
    private ResetPsswordContract.View view;

    /**
     * 构建ResetPsswordModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public ResetPsswordModule(ResetPsswordContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    ResetPsswordContract.View provideResetPsswordView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    ResetPsswordContract.Model provideResetPsswordModel(ResetPsswordModel model) {
        return model;
    }
}