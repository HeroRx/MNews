package com.gzucm.mnews.mvp.model;

import android.app.Application;

import com.google.gson.Gson;
import com.gzucm.mnews.mvp.contract.NewsContract;
import com.gzucm.mnews.mvp.model.api.Api;
import com.gzucm.mnews.mvp.model.api.service.ApiService;
import com.gzucm.mnews.mvp.model.entity.DailyEntity;
import com.gzucm.mnews.mvp.model.entity.MultiEntity.DailyMultiItem;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import me.jessyan.retrofiturlmanager.RetrofitUrlManager;


@FragmentScope
public class NewsModel extends BaseModel implements NewsContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public NewsModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);

        RetrofitUrlManager.getInstance().putDomain("zhihu", Api.ZHIHU_DOMAIN);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }

    @Override
    public Observable<DailyEntity> getlatestNews() {
        return mRepositoryManager.obtainRetrofitService(ApiService.class)
                .getlatestNews();
    }

    @Override
    public Observable<DailyEntity> getBeforeNews(String date) {
        return mRepositoryManager.obtainRetrofitService(ApiService.class)
                .getBeforeNews(date);
    }

    @Override
    public Observable<DailyEntity> getBeforeLoadMoreNews(String date) {
        return mRepositoryManager.obtainRetrofitService(ApiService.class)
                .getBeforeNews(date);
    }


    @Override
    public List<DailyMultiItem> parseTodayDailyEntityData(DailyEntity getAllListData) {
        List<DailyMultiItem> data = new ArrayList<>();
        List<DailyEntity.StoriesBean> storiesBeans = ( List<DailyEntity.StoriesBean>) getAllListData.getStories();

        if (getAllListData != null) {
            // 今日推荐
            if (storiesBeans != null) {
                //stories
                DailyEntity.StoriesBean storiesBean;
                for (int i = 0; i < storiesBeans.size(); i++) {

                    DailyMultiItem item = new DailyMultiItem();
                    storiesBean = storiesBeans.get(i);
                    item.setItemType(DailyMultiItem.ITEM_TODAY_HOT);
                    item.setTitle(storiesBean.getTitle());
                    item.setGa_prefix(storiesBean.getGa_prefix());
                    item.setMultipic(storiesBean.isMultipic());
                    item.setType(storiesBean.getType());
                    item.setImages(storiesBean.getImages());
                    data.add(item);
                }
            }
        }
        return data;
    }

    @Override
    public List<DailyMultiItem> parseBannerDailyEntityData(DailyEntity getAllListData) {
        List<DailyMultiItem> data = new ArrayList<>();
        List<DailyEntity.TopStoriesBean> topStoriesBeans = ( List<DailyEntity.TopStoriesBean>) getAllListData.getTop_stories();
        // Banner
        if (topStoriesBeans != null) {
            //TopStories
            DailyEntity.TopStoriesBean topStoriesBean;
            for (int i = 0; i < topStoriesBeans.size(); i++) {
                DailyMultiItem item = new DailyMultiItem();
                topStoriesBean = topStoriesBeans.get(i);
                item.setItemType(DailyMultiItem.ITEM_Banner);

                item.setTitle(topStoriesBean.getTitle());
                item.setGa_prefix(topStoriesBean.getGa_prefix());
                item.setType(topStoriesBean.getType());
                item.setImage(topStoriesBean.getImage());
                data.add(item);
            }
        }
        return data;
    }

    @Override
    public List<DailyMultiItem> parseBeforeDailyEntityData(DailyEntity getAllListData) {
        List<DailyMultiItem> data = new ArrayList<>();
        List<DailyEntity.StoriesBean> storiesBeans = ( List<DailyEntity.StoriesBean>) getAllListData.getStories();


        if (getAllListData != null) {
            // 往日新闻
            if (storiesBeans != null) {
                //stories
                DailyEntity.StoriesBean storiesBean;
                for (int i = 0; i < storiesBeans.size(); i++) {

                    DailyMultiItem item = new DailyMultiItem();
                    storiesBean = storiesBeans.get(i);
                    item.setItemType(DailyMultiItem.ITEM_BEFORE);

                    item.setTitle(storiesBean.getTitle());
                    item.setGa_prefix(storiesBean.getGa_prefix());
                    item.setMultipic(storiesBean.isMultipic());
                    item.setType(storiesBean.getType());
                    item.setImages(storiesBean.getImages());
                    data.add(item);
                }
            }
        }
        return data;
    }


}