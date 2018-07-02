package com.gzucm.mnews.mvp.model.entity.MultiEntity;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.gzucm.mnews.mvp.model.entity.DailyEntity;

import java.util.List;

/**
 * Created on 2018/6/28 0028 12:31.
 *
 * @author herozii
 */
public class DailyMultiItem implements MultiItemEntity {

    public static final int ITEM_Banner = 1;
    public static final int ITEM_TODAY_HOT = 2;
    public static final int ITEM_BEFORE = 3;

    private int spanSize;
    private int itemType;

    private DailyEntity.StoriesBean storiesBean;
    private DailyEntity.TopStoriesBean topStoriesBean;

    //stories
    private String today_hot;
    private String title;
    private String ga_prefix;
    private boolean multipic;
    private int type;
    private int id;
    private List<String> images;

    //top
    private String image;
//    private int type;
//    private int id;
//    private String ga_prefix;
//    private String title;


    public DailyMultiItem() {
    }

    public DailyMultiItem(int itemType) {
        this.itemType = itemType;
    }

    public DailyMultiItem(int itemType, DailyEntity.StoriesBean storiesBean) {
        this.itemType = itemType;
        this.storiesBean = storiesBean;
    }

    public DailyEntity.StoriesBean getStoriesBean() {
        return storiesBean;
    }

    public void setStoriesBean(DailyEntity.StoriesBean storiesBean) {
        this.storiesBean = storiesBean;
    }


    public DailyEntity.TopStoriesBean getTopStoriesBean() {
        return topStoriesBean;
    }

    public void setTopStoriesBean(DailyEntity.TopStoriesBean topStoriesBean) {
        this.topStoriesBean = topStoriesBean;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public boolean isMultipic() {
        return multipic;
    }

    public void setMultipic(boolean multipic) {
        this.multipic = multipic;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getToday_hot() {
        return today_hot;
    }

    public void setToday_hot(String today_hot) {
        this.today_hot = today_hot;
    }

    // BOTTOM
    //
    private void setSpanSzieWithItemType(int itemType) {
        switch (itemType) {
            case ITEM_Banner:
                spanSize = 2;
                break;
            case ITEM_TODAY_HOT:
                spanSize = 2;
                break;
            case ITEM_BEFORE:
                spanSize = 1;
                break;

        }
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
        setSpanSzieWithItemType(itemType);
    }


    public int getSpanSize() {
        return spanSize;
    }

    public void setSpanSize(int spanSize) {
        this.spanSize = spanSize;
    }
}
