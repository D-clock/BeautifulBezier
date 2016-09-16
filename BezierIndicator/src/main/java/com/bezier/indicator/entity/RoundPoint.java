package com.bezier.indicator.entity;

/**
 * 圆点实体类
 * <p/>
 * Created by Clock on 2016/9/16.
 */
public class RoundPoint {

    /**
     * 圆心在x轴上的坐标
     */
    private float x;
    /**
     * 圆心在y轴上的坐标
     */
    private float y;
    /**
     * 圆的半径
     */
    private float radius;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }
}
