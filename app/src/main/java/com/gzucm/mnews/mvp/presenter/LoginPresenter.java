package com.gzucm.mnews.mvp.presenter;

import android.app.Application;
import android.util.Log;

import com.google.gson.Gson;
import com.gzucm.mnews.mvp.contract.LoginContract;
import com.gzucm.mnews.mvp.model.entity.UserEntity;
import com.gzucm.mnews.mvp.ui.activity.MainActivity;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.integration.AppManager;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.utils.ArmsUtils;
import com.jess.arms.utils.RxLifecycleUtils;

import java.io.IOException;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import okhttp3.ResponseBody;
import retrofit2.HttpException;


@ActivityScope
public class LoginPresenter extends BasePresenter<LoginContract.Model, LoginContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    static UserEntity mUserEntity = new UserEntity();
    @Inject
    public LoginPresenter(LoginContract.Model model, LoginContract.View rootView) {
        super(model, rootView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mAppManager = null;
        this.mImageLoader = null;
        this.mApplication = null;
    }

    public void login(String username,String password){
        mModel.loginByAccount(username,password)
                .subscribeOn(Schedulers.io())
//                .retryWhen(new RetryWithDelay(3, 2))
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))//使用Rxlifecycle,使Disposable和Activity一起销毁
                .subscribe(new ErrorHandleSubscriber<UserEntity>(mErrorHandler) {
                    @Override
                    public void onNext(@NonNull UserEntity userEntity) {
                        mUserEntity = userEntity;
                        if (userEntity != null){
                            mRootView.loginSuccess();
                        }
                        Log.i("MNews",""+userEntity.getSessionToken() + "ma" + userEntity.getStatus());
                        ArmsUtils.startActivity(MainActivity.class);
                    }

                    @Override
                    public void onError(Throwable t) {
                        super.onError(t);
                        //t里面携带异常的响应体
                        if(t instanceof HttpException){
                            ResponseBody body = ((HttpException) t).response().errorBody();
                            try {
                                String response = body.string();
                                Gson gson = new Gson();
                                UserEntity userEntity = gson.fromJson(response,UserEntity.class);
                                Log.i("MNews",""+response);
                                if (userEntity.getCode() == 101){
                                    mRootView.loginFailed();
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
//                        HttpException exception = (HttpException)t;
//                        String message = exception.response().message();
//                        UserEntity userEntity = (UserEntity) ((HttpException) t).response().body();
//                        int code = exception.response().code();
//                        if (code == 400){
//                            mRootView.loginFailed();
//                        }

                    }
                });
    }
}
