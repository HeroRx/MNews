package com.gzucm.mnews.di.component;

import com.gzucm.mnews.di.module.RegisterModule;
import com.gzucm.mnews.mvp.ui.activity.RegisterActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(modules = RegisterModule.class, dependencies = AppComponent.class)
public interface RegisterComponent {
    void inject(RegisterActivity activity);
}