package com.gzucm.mnews.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.gzucm.mnews.di.module.ThemeModule;

import com.jess.arms.di.scope.FragmentScope;
import com.gzucm.mnews.mvp.ui.fragment.ThemeFragment;

@FragmentScope
@Component(modules = ThemeModule.class, dependencies = AppComponent.class)
public interface ThemeComponent {
    void inject(ThemeFragment fragment);
}