package com.gzucm.mnews.mvp.contract;

import com.gzucm.mnews.mvp.model.entity.DailyEntity;
import com.gzucm.mnews.mvp.model.entity.MultiEntity.DailyMultiItem;
import com.gzucm.mnews.mvp.ui.adapter.DailyListAdapter;
import com.jess.arms.mvp.IModel;
import com.jess.arms.mvp.IView;

import java.util.List;

import io.reactivex.Observable;


public interface NewsContract {
    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        //获取数据并设置adapter
        void setRecyclerAdapter(DailyListAdapter adapter);

    }

    //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,即是否使用缓存
    interface Model extends IModel {
        Observable<DailyEntity> getlatestNews();
        Observable<DailyEntity> getBeforeNews(String date);
        Observable<DailyEntity> getBeforeLoadMoreNews(String date);
        List<DailyMultiItem> parseTodayDailyEntityData(DailyEntity getAllListData);
        List<DailyMultiItem> parseBannerDailyEntityData(DailyEntity getAllListData);
        List<DailyMultiItem> parseBeforeDailyEntityData(DailyEntity getAllListData);
    }
}
