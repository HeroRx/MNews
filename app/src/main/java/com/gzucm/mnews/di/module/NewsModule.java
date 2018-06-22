package com.gzucm.mnews.di.module;

import com.jess.arms.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

import com.gzucm.mnews.mvp.contract.NewsContract;
import com.gzucm.mnews.mvp.model.NewsModel;


@Module
public class NewsModule {
    private NewsContract.View view;

    /**
     * 构建NewsModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public NewsModule(NewsContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    NewsContract.View provideNewsView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    NewsContract.Model provideNewsModel(NewsModel model) {
        return model;
    }
}