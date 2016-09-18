package com.clock.beautifulbezier.activity;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import com.bezier.evaluator.ParabolaEvaluator;
import com.clock.beautifulbezier.R;

/**
 * 购物车页面
 *
 * @author Clock
 */
public class ShoppingActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String TAG = ShoppingActivity.class.getSimpleName();

    private ImageView mTarget;
    private ImageView mDest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        mTarget = (ImageView) findViewById(R.id.iv_target);
        mTarget.setOnClickListener(this);

        mDest = (ImageView) findViewById(R.id.iv_dest);

    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if (viewId == R.id.iv_target) {

            float srcX = mTarget.getX();
            float srcY = mTarget.getY();

            float destX = mDest.getX();
            float destY = mDest.getY();

            PointF srcPoint = new PointF(srcX, srcY);
            PointF destPoint = new PointF(destX, destY);
            PointF midPoint = new PointF(destX, srcY - 300);
            ParabolaEvaluator parabolaEvaluator = new ParabolaEvaluator(srcPoint, destPoint, midPoint);
            ValueAnimator valueAnimator = ValueAnimator.ofObject(parabolaEvaluator, srcPoint, destPoint);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    PointF pointF = (PointF) animation.getAnimatedValue();
                    mTarget.setX(pointF.x);
                    mTarget.setY(pointF.y);
                }
            });
            valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
            valueAnimator.setDuration(400);
            valueAnimator.start();

            Log.i(TAG, "mTarget X: " + srcX);
            Log.i(TAG, "mTarget Y: " + srcY);
            Log.i(TAG, "mDest X: " + destX);
            Log.i(TAG, "mDest Y: " + destY);

        }
    }
}
