package com.gzucm.mnews.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.gzucm.mnews.di.module.ResetPsswordModule;

import com.jess.arms.di.scope.ActivityScope;
import com.gzucm.mnews.mvp.ui.activity.ResetPsswordActivity;

@ActivityScope
@Component(modules = ResetPsswordModule.class, dependencies = AppComponent.class)
public interface ResetPsswordComponent {
    void inject(ResetPsswordActivity activity);
}