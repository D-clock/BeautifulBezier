package com.bezier.indicator;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * 利用贝塞尔曲线实现的提示器
 * <p/>
 * Created by Clock on 2016/9/16.
 */
public class BezierIndicator extends View {

    public BezierIndicator(Context context) {
        super(context);
    }

    public BezierIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BezierIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public BezierIndicator(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

}
