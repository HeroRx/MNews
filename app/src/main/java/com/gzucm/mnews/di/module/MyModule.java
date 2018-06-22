package com.gzucm.mnews.di.module;

import com.jess.arms.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

import com.gzucm.mnews.mvp.contract.MyContract;
import com.gzucm.mnews.mvp.model.MyModel;


@Module
public class MyModule {
    private MyContract.View view;

    /**
     * 构建MyModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public MyModule(MyContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    MyContract.View provideMyView() {
        return this.view;
    }

    @FragmentScope
    @Provides
    MyContract.Model provideMyModel(MyModel model) {
        return model;
    }
}