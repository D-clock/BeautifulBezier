package com.clock.beautifulbezier.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.clock.beautifulbezier.R;

/**
 * 购物车页面
 *
 * @author Clock
 */
public class ShoppingActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mTarget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        mTarget = (ImageView) findViewById(R.id.iv_target);
        mTarget.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if (viewId == R.id.iv_target) {
        }
    }
}
