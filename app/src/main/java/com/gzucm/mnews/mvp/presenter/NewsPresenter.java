package com.gzucm.mnews.mvp.presenter;

import android.app.Application;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gzucm.mnews.app.configuration.AppConstant;
import com.gzucm.mnews.mvp.contract.NewsContract;
import com.gzucm.mnews.mvp.model.entity.DailyEntity;
import com.gzucm.mnews.mvp.model.entity.MultiEntity.DailyMultiItem;
import com.gzucm.mnews.mvp.ui.activity.DailyDetailActivity;
import com.gzucm.mnews.mvp.ui.adapter.DailyListAdapter;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.integration.AppManager;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.utils.ArmsUtils;
import com.jess.arms.utils.RxLifecycleUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import me.jessyan.rxerrorhandler.handler.RetryWithDelay;


@FragmentScope
public class NewsPresenter extends BasePresenter<NewsContract.Model, NewsContract.View> implements BaseQuickAdapter.OnItemClickListener {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;


    private DailyListAdapter mAdapter;
    private List<DailyMultiItem> data = new ArrayList<>();
    private DailyEntity mTodayDaily;
    private String mCurrentDate;
    private int mNewId;

    //通过接口也可以拿到这个ID,但是通过DailyDetaileActivity实现NewsPresenter里面的接口就很奇怪
//    public interface FragmentInteraction{
//        void process(int id);
//    }
//    FragmentInteraction listener = new FragmentInteraction() {
//        @Override
//        public void process(int id) {
//            id = mNewId;
//        }
//    };

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

    public void getLatestData() {
        mModel.getlatestNews()
                .subscribeOn(Schedulers.io())
                .retryWhen(new RetryWithDelay(3, 2))
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
                .flatMap(new Function<DailyEntity, ObservableSource<DailyEntity>>() {
                    @Override
                    public ObservableSource<DailyEntity> apply(DailyEntity dailyEntity) throws Exception {
                        mTodayDaily = dailyEntity;
                        mCurrentDate = dailyEntity.getDate();
                        getBeforeNews(mCurrentDate);
                        return  mModel.getBeforeNews(mCurrentDate);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))//使用Rxlifecycle,使Disposable和Activity一起销毁
                .subscribe(new ErrorHandleSubscriber<DailyEntity>(mErrorHandler) {
                    @Override
                    public void onNext(@NonNull DailyEntity dailyEntity) {

                        if (dailyEntity != null) {
                            data.addAll(mModel.parseBannerDailyEntityData(mTodayDaily));
                            data.addAll(mModel.parseTodayDailyEntityData(mTodayDaily));
                            data.addAll(mModel.parseBeforeDailyEntityData(dailyEntity));
                        }

                        setAdapter(data);

                        Log.i("MNews--getBanner", "" + dailyEntity.getDate() + dailyEntity.getTop_stories());
//                        ArmsUtils.startActivity(MainActivity.class);
                    }

                });
    }


    public void cleanData(){
        data.clear();
    }

    public void getBeforeNews(String date) {
        mModel.getBeforeNews(date)
                .subscribeOn(Schedulers.io())
                .retryWhen(new RetryWithDelay(3, 2))
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))//使用Rxlifecycle,使Disposable和Activity一起销毁
                .subscribe(new ErrorHandleSubscriber<DailyEntity>(mErrorHandler) {
                    @Override
                    public void onNext(@NonNull DailyEntity dailyEntity) {


//                        setAdapter(bdata);
                        mCurrentDate = dailyEntity.getDate();
                        Log.i("MNews--", "" + dailyEntity.getDate() + dailyEntity.getStories() + dailyEntity.getTop_stories());
//                        ArmsUtils.startActivity(MainActivity.class);
                    }

                    @Override
                    public void onError(Throwable t) {
                        super.onError(t);
                    }
                });
    }

    public void getBeforeLoadMoreNews() {
        mModel.getBeforeLoadMoreNews(mCurrentDate)
                .subscribeOn(Schedulers.io())
                .retryWhen(new RetryWithDelay(3, 2))
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))//使用Rxlifecycle,使Disposable和Activity一起销毁
                .subscribe(new ErrorHandleSubscriber<DailyEntity>(mErrorHandler) {
                    @Override
                    public void onNext(@NonNull DailyEntity dailyEntity) {


//                        setAdapter(bdata);
                        mCurrentDate = dailyEntity.getDate();
                        Log.i("MNews--", "" + dailyEntity.getDate() + dailyEntity.getStories() + dailyEntity.getTop_stories());
//                        ArmsUtils.startActivity(MainActivity.class);
                        if (dailyEntity != null) {
                            data.addAll(mModel.parseBeforeDailyEntityData(dailyEntity));
                        }
                        Log.i("MNews--当前的日期",mCurrentDate);
                        setAdapter(data);
                    }

                    @Override
                    public void onError(Throwable t) {
                        super.onError(t);
                    }
                });
    }



    public void setAdapter(List<DailyMultiItem> data) {
        if (mAdapter == null) {
            mAdapter = new DailyListAdapter(data);
            mAdapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
                @Override
                public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {

                    return data.get(position).getSpanSize();

                }
            });
            mRootView.setRecyclerAdapter(mAdapter);
            mAdapter.setOnItemClickListener(this);
        } else {
            mAdapter.setNewData(data);
        }
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Toast.makeText(mApplication, "" + position, Toast.LENGTH_SHORT).show();
        DailyMultiItem dailyMultiItem = data.get(position);
        mNewId = dailyMultiItem.getId();
        Intent intent = new Intent(mApplication,DailyDetailActivity.class);
        Toast.makeText(mApplication,""+mNewId,Toast.LENGTH_SHORT).show();
        intent.putExtra(AppConstant.NEW_ID,mNewId);
        ArmsUtils.startActivity(intent);
    }

}
