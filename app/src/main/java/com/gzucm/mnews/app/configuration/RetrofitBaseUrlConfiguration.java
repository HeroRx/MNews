package com.gzucm.mnews.app.configuration;

import android.content.Context;

import com.jess.arms.di.module.ClientModule;

import me.jessyan.retrofiturlmanager.RetrofitUrlManager;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created on 2018/6/27 0027 11:37.
 *
 * @author herozii
 */
public class RetrofitBaseUrlConfiguration implements ClientModule.RetrofitConfiguration {
    @Override
    public void configRetrofit(Context context, Retrofit.Builder builder) {
        // 配置多BaseUrl支持
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        builder.client(RetrofitUrlManager.getInstance().with(clientBuilder)
                .build());
    }
}