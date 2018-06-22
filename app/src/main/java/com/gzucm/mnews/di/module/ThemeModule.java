package com.gzucm.mnews.di.module;

import com.jess.arms.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

import com.gzucm.mnews.mvp.contract.ThemeContract;
import com.gzucm.mnews.mvp.model.ThemeModel;


@Module
public class ThemeModule {
    private ThemeContract.View view;

    /**
     * 构建ThemeModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public ThemeModule(ThemeContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    ThemeContract.View provideThemeView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    ThemeContract.Model provideThemeModel(ThemeModel model) {
        return model;
    }
}