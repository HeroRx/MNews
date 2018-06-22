package com.gzucm.mnews.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.gzucm.mnews.di.module.MyModule;

import com.jess.arms.di.scope.FragmentScope;
import com.gzucm.mnews.mvp.ui.fragment.MyFragment;

@FragmentScope
@Component(modules = MyModule.class, dependencies = AppComponent.class)
public interface MyComponent {
    void inject(MyFragment fragment);
}