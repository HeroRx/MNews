package com.gzucm.mnews.di.component;

import com.gzucm.mnews.di.module.LoginModule;
import com.gzucm.mnews.mvp.ui.activity.LoginActivity;
import com.gzucm.mnews.mvp.ui.fragment.LoginFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(modules = LoginModule.class, dependencies = AppComponent.class)
public interface LoginComponent {
    void inject(LoginActivity activity);

    void inject(LoginFragment fragment);
}
