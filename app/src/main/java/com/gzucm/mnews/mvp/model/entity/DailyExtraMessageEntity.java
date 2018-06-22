package com.gzucm.mnews.mvp.model.entity;

/**
 * Created on 2018/6/22 0022 16:26.
 *
 * @author herozii
 */
public class DailyExtraMessageEntity {

    /**
     * long_comments : 3
     * popularity : 320
     * short_comments : 17
     * comments : 20
     */

    private int long_comments;
    private int popularity;
    private int short_comments;
    private int comments;

    public int getLong_comments() {
        return long_comments;
    }

    public void setLong_comments(int long_comments) {
        this.long_comments = long_comments;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public int getShort_comments() {
        return short_comments;
    }

    public void setShort_comments(int short_comments) {
        this.short_comments = short_comments;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }
}
