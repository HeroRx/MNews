package com.gzucm.mnews.mvp.model.api.service;

import com.gzucm.mnews.mvp.model.entity.DailyCommentEntity;
import com.gzucm.mnews.mvp.model.entity.DailyDetailsEntity;
import com.gzucm.mnews.mvp.model.entity.DailyEntity;
import com.gzucm.mnews.mvp.model.entity.DailyExtraMessageEntity;
import com.gzucm.mnews.mvp.model.entity.HotEntity;
import com.gzucm.mnews.mvp.model.entity.SectionsDetailsEntity;
import com.gzucm.mnews.mvp.model.entity.SectionsEntity;
import com.gzucm.mnews.mvp.model.entity.ThemeDailyEntity;
import com.gzucm.mnews.mvp.model.entity.ThemeDetailEntity;
import com.gzucm.mnews.mvp.model.entity.VersionEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created on 2018/6/22 0022 16:08.
 * 知乎日报api链接
 * https://github.com/izzyleung/ZhihuDailyPurify/wiki/%E7%9F%A5%E4%B9%8E%E6%97%A5%E6%8A%A5-API-%E5%88%86%E6%9E%90
 * @author herozii
 */
public interface ApiService {

    /**
     * 获取最新的日报数据
     */
    @GET("news/latest")
    Observable<DailyEntity> getlatestNews();
    /**
     * 根据时间获取对应的日报数据
     */
    @GET("news/before/{date}")
    Observable<DailyEntity> getBeforeNews(@Path("date") String date);
    /**
     * 获取日报详情数据
     */
    @GET("news/{id}")
    Observable<DailyDetailsEntity> getNewsDetails(@Path("id") int id);
    /**
     * 获取专题日报
     */
    @GET("themes")
    Observable<ThemeDailyEntity> getDailyType();
    /**
     * 根据id查询主题日报内容
     */
    @GET("theme/{id}")
    Observable<ThemeDetailEntity> getThemesDetailsById(@Path("id") int id);
    /**
     * 根据id查询日报的额外信息
     */
    @GET("story-extra/{id}")
    Observable<DailyExtraMessageEntity> getDailyExtraMessageById(@Path("id") int id);
    /**
     * 根据id查询日报的长评论
     */
    @GET("story/{id}/long-comments")
    Observable<DailyCommentEntity> getDailyLongComment(@Path("id") int id);
    /**
     * 根据id查询日报的短评论
     */
    @GET("story/{id}/short-comments")
    Observable<DailyCommentEntity> getDailyShortComment(@Path("id") int id);
    /**
     * 获取知乎专栏数据
     */
    @GET("sections")
    Observable<SectionsEntity> getZhiHuSections();
    /**
     * 获取专栏详情数据
     */
    @GET("section/{id}")
    Observable<SectionsDetailsEntity> getSectionsDetails(@Path("id") int id);
    /**
     * 获取专栏的之前消息
     * https://news-at.zhihu.com/api/4/section/2/before/1527980398
     */
    @GET("section/{id}/before/{timestamp}")
    Observable<SectionsDetailsEntity> getBeforeSectionsDetails(
            @Path("id") int id, @Path("timestamp") long timestamp);


    /**
     *  软件版本查询
     *  https://news-at.zhihu.com/api/4/version/android/2.3.0
     */
    @GET("version/android/{curVersion}")
    Observable<VersionEntity> getLatestVersion(@Path("curVersion") String curVersion);

    /**
     *  热门消息
     */
    @GET("news/hot")
    Observable<HotEntity> getHotMessage();


}
