package com.gzucm.mnews.di.component;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.gzucm.mnews.di.module.SortModule;

import com.jess.arms.di.scope.FragmentScope;
import com.gzucm.mnews.mvp.ui.fragment.SortFragment;

@FragmentScope
@Component(modules = SortModule.class, dependencies = AppComponent.class)
public interface SortComponent {
    void inject(SortFragment fragment);
}