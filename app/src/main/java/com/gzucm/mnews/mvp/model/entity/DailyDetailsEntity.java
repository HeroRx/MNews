package com.gzucm.mnews.mvp.model.entity;

import java.util.List;

/**
 * Created on 2018/6/22 0022 16:17.
 *
 * @author herozii
 */
public class DailyDetailsEntity {

    /**
     * body : <div class="main-wrap content-wrap">
     <div class="headline">

     <div class="img-place-holder"></div>



     </div>

     <div class="content-inner">



     <div class="question">
     <h2 class="question-title"></h2>
     <div class="answer">

     <div class="meta">
     <img class="avatar" src="http://pic1.zhimg.com/da8e974dc_is.jpg">
     <span class="author">水金，</span><span class="bio">投资小兵</span>
     </div>

     <div class="content">
     <p>互联网公司一向以员工收入高，工作强度大著称。那么哪一家公司的员工最能挣钱，哪家公司的员工创造的收入最高呢？</p>
     <p>我们统计了中美两地一共上市的 31 家互联网公司的员工数和其收入、EBITDA（没听说过这个词？如果是做投资的那确实要去补补课）、 净利润、2017 年平均员工数（2016 和 2017 年底员工数的平均值），相应的计算了每个员工创造的收入、EBITDA、净利润。得出了几个吃惊的结论。</p>
     <p>我们统计的公司包括（一些规模太小的公司研究意义有限，不在统计之列）：</p>
     <p><strong>中国：BATJ、小米、陌陌、欢聚时代、爱奇艺、虎牙直播、唯品会、搜房、58 同城、前程无忧、汽车之家、易车、搜狗、网易、美图、微博、携程、爱奇艺</strong></p>
     <p><strong>美国：GOOGLE、FACEBOOK、APPLE、SNAPCHAT、Twitter、expedia、ebay、cars、zillow、Netflix、AMAZON</strong></p>
     <p><strong>国内哪家互联网公司员工人均创造的收入最高？</strong></p>
     <p>听到这个问题，我想很多人可能的回答都是：BAT？ 或者是京东？或者是小米？</p>
     <p>以上回答都不对，正确答案是：</p>
     <figure><img class="content-image" src="https://pic3.zhimg.com/v2-e4a796d0f76f97cc168848e63a1aa399_b.jpg" alt=""></figure><p>我们统计的中国上市互联网公司中人均创收最高的公司是：陌陌</p>
     <p>吃惊吧，直播的指数效应该说是没谁了。这个结果出来的时候我也吃了一惊。但是正如直播的盈利能力让二级市场投资人吃惊，陌陌如此高的人均收入确实，令人吃惊。它不仅击败了 BAT，也击败了小米等企业。直播真的是吸金多又不需要太多人力资本投入的企业。</p>
     <p><strong>国内互联网公司员工人均创造的收入前五名？</strong></p>
     <p>答案：陌陌、小米、腾讯、阿里巴巴、YY。如果不算小米，爱奇艺会跻身前五。没有京东，也没有百度呦。</p>
     <figure><img class="content-image" src="https://pic3.zhimg.com/v2-cb8262469700b1d7a732aa64fc4343f9_b.jpg" alt=""></figure><p><strong>美国哪家互联网公司员工人均创造的收入最高？</strong></p>
     <p>GOOGLE、FACEBOOK、APPLE、SNAPCHAT、Twitter、expedia、ebay、cars、zillow、Netflix、AMAZON；这些公司中你觉得哪家公司有可能是人均创收最高的公司呢？搜索之王？社交之王？乔帮主？电商之王？</p>
     <p>都不对</p>
     <p>答案是：Netflix</p>
     <figure><img class="content-image" src="https://pic2.zhimg.com/v2-c91dcb39e6c4a91ae13a0f96e8b11f01_b.jpg" alt=""></figure><p><strong>美国互联网公司员工人均创造的收入前五名？</strong></p>
     <p>答案：Netflix、苹果、Facebook、谷歌、亚马逊。</p>
     <figure><img class="content-image" src="https://pic2.zhimg.com/v2-a990759eddcd4a564c77f9430f0d4b1e_b.jpg" alt=""></figure><p><strong>国内哪家公司人均创造的 EBITDA 最高？</strong>（选用 EBITDA 这个指标，因为互联网公司往往股权激励摊销比较多，用净利润指标不一定完全反映实际情况。）</p>
     <p>答案：腾讯，确实企鹅太能挣钱了。</p>
     <p>第二名是哪家公司？阿里巴巴？</p>
     <p>错。</p>
     <p>答案：陌陌；阿里巴巴只拍到第三名</p>
     <p>国内前六家人均创造的 EBITDA 最高的公司是：腾讯、陌陌、阿里巴巴、爱奇艺、微博、YY。</p>
     <figure><img class="content-image" src="https://pic2.zhimg.com/v2-5a3d8c221b2fb7059992b23bbf267a1a_b.jpg" alt=""></figure><p>而美国前六家人均创造的 EBITDA 最高的公司是：</p>
     <figure><img class="content-image" src="https://pic2.zhimg.com/v2-853395c9b7288aa3030f39db529eb818_b.jpg" alt=""></figure><p><strong>国内哪家公司人均净利润最高？</strong></p>
     <p>答案：陌陌，</p>
     <p>第二名？</p>
     <p>腾讯。 社交确实挣钱。</p>
     <p><strong>国外哪家公司人均净利润最高？</strong></p>
     <p>答案：Facebook。 社交无论在中美都很挣钱。</p>
     <p>第二名：苹果。 苹果确实是一个独特的存在。</p>
     <figure><img class="content-image" src="https://pic4.zhimg.com/v2-ec3692c700f5ff003261a3b2cd41d966_b.jpg" alt=""></figure><p><strong>我们统计的按人均净利润计算中美排名前十的公司</strong></p>
     <p>Facebook、苹果、陌陌、腾讯、cars、谷歌、阿里巴巴、YY（欢聚时代）、Netflix、微博</p>
     <p>这个统计另外赶到有意思的是，从人均净利的角度看，腾讯、陌陌的人均净利能力甚至超过了谷歌。而阿里巴巴的人均净利能力则没有我预想的那么搞。另外我们可以看到美国的 cars(美国版汽车之家)，居然比谷歌的人均净利还高。可见垂直类网站的盈利能力，在中美都是不错。</p>
     <p><strong>细分领域观察</strong></p>
     <p><strong>社交</strong></p>
     <p>Facebook 无论从收入还是利润看，确实是全球佼佼者，无论人均收入、EBITDA、净利润，都远远超过腾讯。而再看细分的话，twitter 的收入几乎是微博的两倍，但是 EBITDA 角度，Twitter 只比微博高一点，而净利润微博则远远高于 Twitter。另外 snapchat 确实还有很长的路要走。</p>
     <figure><img class="content-image" src="https://pic4.zhimg.com/v2-5ad0cbbad07fa1e3fef0c3dcfddf17fe_b.jpg" alt=""></figure><p><strong>搜索</strong></p>
     <p>谷歌的收入是百度的 9 倍，人均净利润只有百度的 2.5 倍。说明百度在控制成本方面还是不错的。但是百度的人均创造营收的能力还低于搜狗，这确实让人费解，也许是百度在其它短期不带来收入或收入比较低的创新业务（无人驾驶、云计算、人工智能等）投入了比较多的人力，另一种可能就是百度确实应该控制一下人员规模了。（插一句：百度的人均收入和利润在我们统计的公司中只位列中游，BAT 之名确实难负）</p>
     <figure><img class="content-image" src="https://pic2.zhimg.com/v2-aa3d2ec028b29fc18f0d4bc571434f08_b.jpg" alt=""></figure><p><strong>电商</strong></p>
     <p>阿里巴巴确实不愧是全球电商里的赚钱机器，人均净利润和 EBITDA 都高于竞争美国对标公司比如 ebay、亚马逊。</p>
     <p>Ebay 的人均收入和 EBITDA 都和阿里巴巴巴相差不大，人均收入甚至还高于阿里巴巴，这反映了 C2C 商业模式本身的平台性特征。平台建起来不易，一旦成功确实赚钱。</p>
     <p>京东的人均收入只有亚马逊的 1/3，人均 EBITDA 只有唯品会的 40%。京东能做的还有很多。</p>
     <figure><img class="content-image" src="https://pic3.zhimg.com/v2-76a307eea0c4866c1674a1815513c357_b.jpg" alt=""></figure><p><strong>视频</strong></p>
     <p>Netflix 和爱奇艺作为中美两国视频业务的领先者，两家公司的人员数量差不多（爱奇艺还多些），但是无论是总体收入、EBITDA、净利润还是人均收入、EBITDA、净利润，Netflix 都是爱奇艺的数倍。这确实反映了两点：</p>
     <figure><img class="content-image" src="https://pic4.zhimg.com/v2-6dc3a2217826949419aa1c7a5c3bf02a_b.jpg" alt=""></figure><p>1. 英语为主的文化内容产品全球传播力确实强。</p>
     <p>2. 美国等海外地区的文化产品付费能力确实要远远强于国内。（一部纸牌屋创造的收入不知道要做多少部网大才能追的上）</p>
     <p><strong>旅游</strong></p>
     <p>和视频的情况类似，旅游领域，中美领军者也是差异巨大，从人均收入、利润看携程还是有很大提升的空间。</p>
     <figure><img class="content-image" src="https://pic1.zhimg.com/v2-f901edd3d3192fbabd613538a366857e_b.jpg" alt=""></figure><p><strong>垂直领域</strong></p>
     <p>这里指的垂直领域，主要指传统的分类信息领域，比如车、房、招聘等。美国的 zillow、cars 无论从人均收入、EBITDA 指标都超过国内，不过国内的汽车之家、易车在收入规模上要胜过 cars 许多。 为了扩展收入，确实需要牺牲一下人效。</p>
     <figure><img class="content-image" src="https://pic1.zhimg.com/v2-c00a8c0121cf5e723a8344a054b91d11_b.jpg" alt=""></figure><p>另外 Zillow 的收入要超过搜房、58（应该比 58 的房产收入多），人均收入、利润更是数倍于国内公司。但中国的房地产市场要比美国活跃，这点确实令人好奇，其中原因还真是值得仔细研究。</p>
     <p><strong>总榜</strong></p>
     <p>说了这么多，我们看看这次统计的总榜吧（按人均收入排序）。</p>
     <figure><img class="content-image" src="https://pic2.zhimg.com/v2-64656f511a7605fb334251d15db7d6b7_b.jpg" alt=""></figure><p>是不是有很多值得研究的东西呢？</p>
     <hr><p>欢迎关注公众号：水金聊投资</p>

     <div class="view-more"><a href="http://zhuanlan.zhihu.com/p/38198658">查看知乎讨论</a></div>

     </div>
     </div>
     </div>


     </div>
     </div><script type=“text/javascript”>window.daily=true</script>
     * image_source : 《硅谷》
     * title : 哪家互联网公司的员工最能给公司赚钱？不是腾讯，也不是阿里
     * image : https://pic1.zhimg.com/v2-9edf8aadaa7e793817a0de23b7d3eabc.jpg
     * share_url : http://daily.zhihu.com/story/9687344
     * js : []
     * ga_prefix : 062211
     * images : ["https://pic3.zhimg.com/v2-59f662ffcd634e7161017e603a3fa36e.jpg"]
     * type : 0
     * id : 9687344
     * css : ["http://news-at.zhihu.com/css/news_qa.auto.css?v=4b3e3"]
     */

    private String body;
    private String image_source;
    private String title;
    private String image;
    private String share_url;
    private String ga_prefix;
    private int type;
    private int id;
    private List<?> js;
    private List<String> images;
    private List<String> css;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImage_source() {
        return image_source;
    }

    public void setImage_source(String image_source) {
        this.image_source = image_source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
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

    public List<?> getJs() {
        return js;
    }

    public void setJs(List<?> js) {
        this.js = js;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getCss() {
        return css;
    }

    public void setCss(List<String> css) {
        this.css = css;
    }
}
