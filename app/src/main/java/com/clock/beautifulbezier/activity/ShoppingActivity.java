package com.clock.beautifulbezier.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import com.bezier.evaluator.ParabolaEvaluator;
import com.clock.beautifulbezier.R;
import com.clock.beautifulbezier.adapter.GoodsAdapter;
import com.clock.beautifulbezier.entity.GoodsInfo;

/**
 * 购物车页面
 *
 * @author Clock
 */
public class ShoppingActivity extends AppCompatActivity {

    private final static String TAG = ShoppingActivity.class.getSimpleName();

    private ImageView mShoppingCart;
    private RecyclerView mSellList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        mShoppingCart = (ImageView) findViewById(R.id.iv_shopping_cart);
        mSellList = (RecyclerView) findViewById(R.id.rv_sell_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mSellList.setLayoutManager(layoutManager);
        GoodsAdapter goodsAdapter = new GoodsAdapter(this, GoodsInfo.createGoodsList(), new GoodsAdapter.OnAddListener() {
            @Override
            public void onAdd(View view) {
                int width = view.getWidth();
                int height = view.getHeight();
                final ImageView ballView = new ImageView(ShoppingActivity.this);
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(width, height);
                ballView.setLayoutParams(layoutParams);
                ballView.setImageResource(R.mipmap.red_point);
                final ViewGroup decorView = (ViewGroup) getWindow().getDecorView();
                decorView.addView(ballView);
                int[] location = new int[2];
                view.getLocationInWindow(location);
                PointF srcPoint = new PointF(location[0], location[1]);
                mShoppingCart.getLocationInWindow(location);
                PointF destPoint = new PointF(location[0], location[1]);
                PointF midPoint = new PointF(destPoint.x, srcPoint.y);
                ParabolaEvaluator evaluator = new ParabolaEvaluator(srcPoint, destPoint, midPoint);
                ValueAnimator animator = ValueAnimator.ofObject(evaluator, srcPoint, destPoint);
                animator.setDuration(400);
                animator.setInterpolator(new AccelerateDecelerateInterpolator());
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        PointF pointF = (PointF) animation.getAnimatedValue();
                        ballView.setX(pointF.x);
                        ballView.setY(pointF.y);
                    }
                });
                animator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        decorView.removeView(ballView);
                    }
                });
                animator.start();
            }
        });
        mSellList.setAdapter(goodsAdapter);

    }

}
