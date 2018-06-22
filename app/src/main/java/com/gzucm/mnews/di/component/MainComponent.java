package com.gzucm.mnews.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.gzucm.mnews.di.module.MainModule;

import com.jess.arms.di.scope.ActivityScope;
import com.gzucm.mnews.mvp.ui.activity.MainActivity;

@ActivityScope
@Component(modules = MainModule.class, dependencies = AppComponent.class)
public interface MainComponent {
    void inject(MainActivity activity);
}