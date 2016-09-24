package com.clock.beautifulbezier.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Clock on 2016/9/24.
 */

public class ProductInfo {

    /**
     * 海报地址
     */
    private String posterUrl;
    /**
     * 产品名字
     */
    private String name;
    /**
     * 产品介绍
     */
    private String introduction;

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public static List<ProductInfo> fetchProductsInfo() {
        List<ProductInfo> productsInfo = new ArrayList<>();
        for (int count = 1; count <= 5; count++) {
            ProductInfo facebook = new ProductInfo();
            facebook.posterUrl = "http://www.underconsideration.com/brandnew/archives/facebook_2015_logo_detail.png";
            facebook.name = "Facebook";
            facebook.introduction = "一款联系朋友的社交工具,大家可以通过它和朋友、同事、同学以及周围的人保持互动交流，分享无限上传的图片，发布链接和视频的应用。";
            productsInfo.add(facebook);

            ProductInfo snapchat = new ProductInfo();
            snapchat.posterUrl = "https://cdn.fstoppers.com/styles/full/s3/lead/2016/05/photographers_you_should_follow_on_snapchat.jpg";
            snapchat.name = "Snapchat";
            snapchat.introduction = "一款由斯坦福大学两位学生开发的一款“阅后即焚”照片分享应用。";
            productsInfo.add(snapchat);

            ProductInfo twitter = new ProductInfo();
            twitter.posterUrl = "http://www.wpdang.org/wp-content/uploads/2016/06/wpdang_TWITTER-1.jpg";
            twitter.name = "Twitter";
            twitter.introduction = "一家美国社交网络及微博客服务的网站，是全球互联网上访问量最大的十个网站之一。是微博客的典型应用。";
            productsInfo.add(twitter);


            ProductInfo instagram = new ProductInfo();
            instagram.posterUrl = "https://thinkmarketingmagazine.com/wp-content/uploads/2016/05/A-New-Look-for-Instagram-Inspired-by-the-Community-Think-Marketing.png";
            instagram.name = "Instagram";
            instagram.introduction = "一款能让你快速地与亲友分享精彩和有趣的生活点滴的应用。";
            productsInfo.add(instagram);
        }
        return productsInfo;
    }
}
