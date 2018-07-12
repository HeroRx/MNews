package com.gzucm.mnews.di.component;

import com.gzucm.mnews.di.module.DailyDetailModule;
import com.gzucm.mnews.mvp.ui.activity.DailyDetailActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(modules = DailyDetailModule.class, dependencies = AppComponent.class)
public interface DailyDetailComponent {
    void inject(DailyDetailActivity activity);
}