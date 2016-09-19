package com.clock.beautifulbezier.entity;

import com.clock.beautifulbezier.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 货物信息
 * <p/>
 * Created by Clock on 2016/9/19.
 */
public class GoodsInfo {

    private int icon;
    private String name;
    private int price;

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * 随便创建的一组测试数据
     *
     * @return
     */
    public static List<GoodsInfo> createGoodsList() {
        List<GoodsInfo> goodsInfoList = new ArrayList<>();
        for (int count = 1; count <= 4; count++) {
            GoodsInfo one = new GoodsInfo();
            one.icon = R.mipmap.qq_icon;
            one.name = "Just a QQ";
            one.price = 100;
            goodsInfoList.add(one);

            GoodsInfo two = new GoodsInfo();
            two.icon = R.mipmap.qzone_icon;
            two.name = "Just a Qzone";
            two.price = 200;
            goodsInfoList.add(two);

            GoodsInfo three = new GoodsInfo();
            three.icon = R.mipmap.wechat_icon;
            three.name = "Just a WeChat";
            three.price = 900;
            goodsInfoList.add(three);

            GoodsInfo four = new GoodsInfo();
            four.icon = R.mipmap.wechat_moment_icon;
            four.name = "WeChat Moment";
            four.price = 998;
            goodsInfoList.add(four);
        }
        return goodsInfoList;
    }
}
