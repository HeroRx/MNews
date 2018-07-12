package com.gzucm.mnews.mvp.contract;

import com.gzucm.mnews.mvp.model.entity.DailyDetailsEntity;
import com.jess.arms.mvp.IModel;
import com.jess.arms.mvp.IView;

import io.reactivex.Observable;


public interface DailyDetailContract {
    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        //获取数据并设置adapter
        void loadData(DailyDetailsEntity dailyDetailsEntity);
    }

    //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,即是否使用缓存
    interface Model extends IModel {
        Observable<DailyDetailsEntity> getNewsDetails(int id);
    }
}
