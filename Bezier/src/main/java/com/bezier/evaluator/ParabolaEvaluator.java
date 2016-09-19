package com.bezier.evaluator;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

/**
 * 抛物线效果，利用二阶贝塞尔曲线实现
 * <p/>
 * Created by Clock on 2016/9/18.
 */
public class ParabolaEvaluator implements TypeEvaluator<PointF> {

    /**
     * 抛物线起点
     */
    private PointF mSrcPointF;
    /**
     * 抛物线终点
     */
    private PointF mDestPoint;
    /**
     * 媒介点
     */
    private PointF mMidPointF;

    /**
     * @param srcPoint  抛物线起点
     * @param destPoint 抛物线终点
     * @param midPoint  媒介点
     */
    public ParabolaEvaluator(PointF srcPoint, PointF destPoint, PointF midPoint) {
        this.mSrcPointF = srcPoint;
        this.mDestPoint = destPoint;
        this.mMidPointF = midPoint;
    }

    @Override
    public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
        //实现公式：B(t) = (1 - t)^2 * P0 + 2t * (1 - t) * P1 + t^2 * P2, t ∈ [0,1]
        //P0: mSrcPointF ，P1 ：mMidPointF ，P2 ：mDestPoint ， fraction：t

        float diff = 1 - fraction;
        float x = (float) (Math.pow(diff, 2) * mSrcPointF.x + 2 * fraction * diff * mMidPointF.x + Math.pow(fraction, 2) * mDestPoint.x);
        float y = (float) (Math.pow(diff, 2) * mSrcPointF.y + 2 * fraction * diff * mMidPointF.y + Math.pow(fraction, 2) * mDestPoint.y);

        PointF result = new PointF(x, y);
        return result;
    }
}
