package com.gzucm.mnews.mvp.ui.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gzucm.mnews.R;
import com.gzucm.mnews.mvp.model.entity.MultiEntity.DailyMultiItem;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;

import java.util.List;

/**
 * Created on 2018/6/27 0027 12:28.
 *
 * @author herozii
 */
public class DailyListAdapter extends BaseMultiItemQuickAdapter<DailyMultiItem, BaseViewHolder> {


    private AppComponent mAppComponent;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public DailyListAdapter(List<DailyMultiItem> data) {
        super(data);
        addItemType(DailyMultiItem.ITEM_Banner, R.layout.cv_banner_list);
        addItemType(DailyMultiItem.ITEM_TODAY_HOT, R.layout.cv_today_daily_list);
        addItemType(DailyMultiItem.ITEM_BEFORE, R.layout.cv_before_daily_list);
    }


    @Override
    protected void convert(BaseViewHolder helper, DailyMultiItem item) {

        if (mAppComponent == null) {
            mAppComponent = ArmsUtils.obtainAppComponentFromContext(mContext);
        }

        switch (item.getItemType()) {
            case DailyMultiItem.ITEM_Banner:

                String image = item.getImage();
                String title = item.getTitle();
                String ga_prefix = item.getGa_prefix();
                mAppComponent
                        .imageLoader()
                        .loadImage(mContext, ImageConfigImpl
                                .builder()
                                .placeholder(R.drawable.account_avatar)
                                .imageView(helper.getView(R.id.banner_image))
                                .url(image)
                                .build());
                helper.setText(R.id.banner_title, item.getTitle());

                break;
            case DailyMultiItem.ITEM_TODAY_HOT:

                List<String> images = item.getImages();
                if (images != null && images.size() > 0) {
                    mAppComponent
                            .imageLoader()
                            .loadImage(mContext, ImageConfigImpl
                                    .builder()
                                    .placeholder(R.drawable.account_avatar)
                                    .imageView(helper.getView(R.id.today_image))
                                    .url(images.get(0))
                                    .build());
                }
                //如果item为多图设置显示多图
                boolean multipic = item.isMultipic();
                if (multipic) {
                    helper.setVisible(R.id.today_more_pic, true);
                } else {
                    helper.setVisible(R.id.today_more_pic, false);
                }
                helper.setText(R.id.today_title, item.getTitle());

                break;
            case DailyMultiItem.ITEM_BEFORE:
                List<String> bimages = item.getImages();
                boolean bmultipic = item.isMultipic();

                mAppComponent
                        .imageLoader()
                        .loadImage(mContext, ImageConfigImpl
                                .builder()
                                .placeholder(R.drawable.account_avatar)
                                .imageView(helper.getView(R.id.c_image))
                                .url(bimages.get(0))
                                .build());
                helper.setText(R.id.c_title, item.getTitle());
                break;
        }
    }


}
