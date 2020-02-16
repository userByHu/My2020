package com.hu.myknowage.animation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.hu.myknowage.R;

public class AnimationActivity extends AppCompatActivity {

    private Button mTestAnimBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        initView();

    }

    private void initView() {

        mTestAnimBtn = findViewById(R.id.test_anim_btn);
        mTestAnimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initAnim();
            }
        });
    }

    private void initAnim() {
//        // xml实现补间动画
//        Animation animation = AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.simple_view_anim);
//        // java实现补间动画
////        Animation animation = new TranslateAnimation(50f,100f,0f,0f);
////        animation.setDuration(2000);
////        animation.setFillAfter(true);
////        animation.setFillBefore(false);
////        animation.setRepeatCount(4);
////        animation.setRepeatMode(Animation.REVERSE);
//        mTestAnimBtn.startAnimation(animation);


        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 200f,0, 400f, 0, 800f, 0);
        valueAnimator.setDuration(2000);
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float curValueFloat = (Float) animation.getAnimatedValue();
                int curValue = curValueFloat.intValue();
                mTestAnimBtn.layout(curValue, curValue, curValue + mTestAnimBtn.getWidth(), curValue + mTestAnimBtn.getHeight());
            }
        });

//        valueAnimator.start();

        ValueAnimator valueAnimator1 = ValueAnimator.ofArgb(0xff000000, 0xffffffff);
        valueAnimator1.setDuration(10000);
        valueAnimator1.setRepeatCount(-1);
        valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int) animation.getAnimatedValue();
                mTestAnimBtn.setBackgroundColor(curValue);
            }
        });
//        valueAnimator1.start();

        ValueAnimator valueAnimator2 = ValueAnimator.ofObject(new CharEvaluator(),'A','Z');
        valueAnimator2.setDuration(2000);
        valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                char curValue = (char) animation.getAnimatedValue();
                mTestAnimBtn.setText(curValue+"");
            }
        });
//        valueAnimator2.start();

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mTestAnimBtn,"TranslationX",0,100);
        objectAnimator.setDuration(2000);
        objectAnimator.start();

    }


}
