package com.gzucm.mnews.mvp.model.entity;

import java.util.List;

/**
 * Created on 2018/6/22 0022 16:10.
 *
 * @author herozii
 */
public class DailyEntity {


    /**
     * date : 20180622
     * stories : [{"title":"换个角度看这些熟悉的中国地标，你还认得出吗？","ga_prefix":"062213","images":["https://pic2.zhimg.com/v2-99dcad1ec410160093a2941d732cfa05.jpg"],"multipic":true,"type":0,"id":9687039},{"images":["https://pic4.zhimg.com/v2-59b15a940cf241b7d48fb5e5e9da876f.jpg"],"type":0,"id":9687326,"ga_prefix":"062212","title":"大误 · 用 xx 在踢球的人"},{"images":["https://pic3.zhimg.com/v2-59f662ffcd634e7161017e603a3fa36e.jpg"],"type":0,"id":9687344,"ga_prefix":"062211","title":"哪家互联网公司的员工最能给公司赚钱？不是腾讯，也不是阿里"},{"images":["https://pic2.zhimg.com/v2-45bd95d5646ad420f66a0674ea9647cd.jpg"],"type":0,"id":9687262,"ga_prefix":"062209","title":"中国的国家电网到底有多强大？"},{"title":"我死了，我的游戏账户怎么办？","ga_prefix":"062208","images":["https://pic3.zhimg.com/v2-f6ef19b07b88f1eea7216ea09817d72a.jpg"],"multipic":true,"type":0,"id":9687038},{"images":["https://pic4.zhimg.com/v2-0152987737b3e0fdab53c70de707166f.jpg"],"type":0,"id":9686651,"ga_prefix":"062207","title":"这可能是我见过的最好的编程指南"},{"images":["https://pic2.zhimg.com/v2-1ecd82ab6b3050cb34531af3dffe2ca1.jpg"],"type":0,"id":9687241,"ga_prefix":"062207","title":"为什么身边的大龄「剩女」如此多，「剩男」却寥寥无几？"},{"images":["https://pic4.zhimg.com/v2-361c3c3a7677b0eeeaf6a94816efc53b.jpg"],"type":0,"id":9687108,"ga_prefix":"062206","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic1.zhimg.com/v2-9edf8aadaa7e793817a0de23b7d3eabc.jpg","type":0,"id":9687344,"ga_prefix":"062211","title":"哪家互联网公司的员工最能给公司赚钱？不是腾讯，也不是阿里"},{"image":"https://pic3.zhimg.com/v2-d4342db0140607ef9301a8348d58d28a.jpg","type":0,"id":9687262,"ga_prefix":"062209","title":"中国的国家电网到底有多强大？"},{"image":"https://pic3.zhimg.com/v2-4a60f6f6016e7a4f2443f070e6d3d3f6.jpg","type":0,"id":9687241,"ga_prefix":"062207","title":"为什么身边的大龄「剩女」如此多，「剩男」却寥寥无几？"},{"image":"https://pic1.zhimg.com/v2-5ecdbcfffb8611ac6599dba6bb0988fc.jpg","type":0,"id":9687039,"ga_prefix":"062213","title":"换个角度看这些熟悉的中国地标，你还认得出吗？"},{"image":"https://pic1.zhimg.com/v2-937fad1d3328bdafec9c73babfa5e2ec.jpg","type":0,"id":9687038,"ga_prefix":"062208","title":"我死了，我的游戏账户怎么办？"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * title : 换个角度看这些熟悉的中国地标，你还认得出吗？
         * ga_prefix : 062213
         * images : ["https://pic2.zhimg.com/v2-99dcad1ec410160093a2941d732cfa05.jpg"]
         * multipic : true
         * type : 0
         * id : 9687039
         */

        private String title;
        private String ga_prefix;
        private boolean multipic;
        private int type;
        private int id;
        private List<String> images;

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
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic1.zhimg.com/v2-9edf8aadaa7e793817a0de23b7d3eabc.jpg
         * type : 0
         * id : 9687344
         * ga_prefix : 062211
         * title : 哪家互联网公司的员工最能给公司赚钱？不是腾讯，也不是阿里
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
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

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
