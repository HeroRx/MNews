package com.gzucm.mnews.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.gzucm.mnews.di.module.NewsModule;

import com.jess.arms.di.scope.FragmentScope;
import com.gzucm.mnews.mvp.ui.fragment.NewsFragment;

@FragmentScope
@Component(modules = NewsModule.class, dependencies = AppComponent.class)
public interface NewsComponent {
    void inject(NewsFragment fragment);
}