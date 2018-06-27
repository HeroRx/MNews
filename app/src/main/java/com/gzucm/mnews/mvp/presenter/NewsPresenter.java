package com.gzucm.mnews.mvp.presenter;

import android.app.Application;
import android.util.Log;

import com.google.gson.Gson;
import com.gzucm.mnews.mvp.contract.NewsContract;
import com.gzucm.mnews.mvp.model.entity.DailyEntity;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.integration.AppManager;
import com.jess.arms.mvp.BasePresenter;
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


@FragmentScope
public class NewsPresenter extends BasePresenter<NewsContract.Model, NewsContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    @Inject
    public NewsPresenter(NewsContract.Model model, NewsContract.View rootView) {
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

    public void getlatestNews(){
        mModel.getlatestNews()
                .subscribeOn(Schedulers.io())
//                .retryWhen(new RetryWithDelay(3, 2))
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))//使用Rxlifecycle,使Disposable和Activity一起销毁
                .subscribe(new ErrorHandleSubscriber<DailyEntity>(mErrorHandler) {
                    @Override
                    public void onNext(@NonNull DailyEntity dailyEntity) {


                        Log.i("MNews--",""+ dailyEntity.getDate() + dailyEntity.getStories());
//                        ArmsUtils.startActivity(MainActivity.class);
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
                                DailyEntity dailyEntity = gson.fromJson(response,DailyEntity.class);
//                                Log.i("MNews --",""+response);

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
//

                    }
                });
    }

}
