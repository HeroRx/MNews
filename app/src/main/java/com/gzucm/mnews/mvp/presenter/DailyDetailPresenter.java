package com.gzucm.mnews.mvp.presenter;

import android.app.Application;
import android.util.Log;

import com.gzucm.mnews.mvp.contract.DailyDetailContract;
import com.gzucm.mnews.mvp.model.entity.DailyDetailsEntity;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.integration.AppManager;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.utils.RxLifecycleUtils;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import me.jessyan.rxerrorhandler.handler.RetryWithDelay;


@ActivityScope
public class DailyDetailPresenter extends BasePresenter<DailyDetailContract.Model, DailyDetailContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    private DailyDetailsEntity data;
    @Inject
    public DailyDetailPresenter(DailyDetailContract.Model model, DailyDetailContract.View rootView) {
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

    public void getNewsDetails(int id){
        mModel.getNewsDetails(id)
                .subscribeOn(Schedulers.io())
                .retryWhen(new RetryWithDelay(3, 2))
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))//使用Rxlifecycle,使Disposable和Activity一起销毁
                .subscribe(new ErrorHandleSubscriber<DailyDetailsEntity>(mErrorHandler) {
                    @Override
                    public void onNext(@NonNull DailyDetailsEntity dailyDetailsEntity) {
                        data = dailyDetailsEntity;
                        Log.i("MNews-Detail",dailyDetailsEntity.getBody() +"detail"+ dailyDetailsEntity);

                        if (data != null) {
                            mRootView.loadData(data);
                        }

                    }

                    @Override
                    public void onError(Throwable t) {
                        super.onError(t);
                    }
                });
    }


}
