package com.gzucm.mnews.mvp.model.entity;

import java.util.List;

/**
 * Created on 2018/6/22 0022 16:28.
 *
 * @author herozii
 */
public class DailyCommentEntity {

    private List<CommentsBean> comments;

    public List<CommentsBean> getComments() {
        return comments;
    }

    public void setComments(List<CommentsBean> comments) {
        this.comments = comments;
    }

    public static class CommentsBean {
        /**
         * author : 戴燕
         * content : 社会对特殊儿童群体的关注微乎其微，很少人在意这个群体真正存在于这个社会，没有人在意这些孩子的家长怎样挣扎着生活，没有接触就没有了解，社会留给这个群体的空间太狭窄，让更多人忽略他们的存在，可他们就是真实的存在于我们的身边，我们不是想把他们变成热点新闻，而是社会能够提供给他们足够充足的软硬件设施，能够保障他们以后的生活，普通孩子所拥有的教育条件凭什么特殊孩子就要被忽视，他们的成长需要我们这个社会的关注呀！
         * avatar : http://pic1.zhimg.com/da8e974dc_im.jpg
         * time : 1485096239
         * id : 27900061
         * likes : 3
         */

        private String author;
        private String content;
        private String avatar;
        private int time;
        private int id;
        private int likes;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getLikes() {
            return likes;
        }

        public void setLikes(int likes) {
            this.likes = likes;
        }
    }
}
