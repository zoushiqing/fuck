package me.ivt.com.ui.propertyanimation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;

import me.ivt.com.ui.R;

public class PropertyAnimationActivity extends AppCompatActivity {
    
    private ImageView mImageView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);
        mImageView = findViewById(R.id.imgv);
        
    }
    
    public void startAnimation(final View view) {
//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate);
//        mImageView.startAnimation(animation);
        
        //1.------------------------------------------
//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view, "translationX", 0f, 180f);
//        objectAnimator.setDuration(500);
//        objectAnimator.start();
        
        
        //2.同时执行多个动画
//        @SuppressLint("ObjectAnimatorBinding") ObjectAnimator animator=ObjectAnimator.ofFloat(view,"hahhahh",0f,100f);
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                animation.getAnimatedFraction();//百分比
//                float animatedValue = (float) animation.getAnimatedValue();//得到duration时间内，values当中的某一个值
//                mImageView.setScaleX((float) (0.5+animatedValue/100));//0.5~1
//                mImageView.setScaleY((float) (0.5+animatedValue/100));//0.5~1
//            }
//        });
//        animator.start();
        
        //3.使用ValueAnimator
//        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 100);
//        valueAnimator.setDuration(500);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                float value = (float) animation.getAnimatedValue();
//                mImageView.setScaleX(0.5f+value/100);
//                mImageView.setScaleY(0.5f+value/100);
//            }
//        });
//        valueAnimator.start();
        
        //4.PropertyValuesHolder
//        PropertyValuesHolder propertyValuesHolder=PropertyValuesHolder.ofFloat("alpha",1f,0.7f,1f);
//        PropertyValuesHolder propertyValuesHolder2=PropertyValuesHolder.ofFloat("scaleX",1f,0.7f,1f);
//        PropertyValuesHolder propertyValuesHolder3=PropertyValuesHolder.ofFloat("scaleY",1f,0.7f,1f);
//        PropertyValuesHolder propertyValuesHolder4=PropertyValuesHolder.ofFloat("translationX",0,360f);
//    
//        ObjectAnimator objectAnimator=ObjectAnimator.ofPropertyValuesHolder(view,propertyValuesHolder,propertyValuesHolder2,propertyValuesHolder3,propertyValuesHolder4);
//        objectAnimator.setDuration(500);
//        objectAnimator.start();
        
        //5.动画集
//        ObjectAnimator animator1=ObjectAnimator.ofFloat(view,"scaleX",1f,0.7f,1f);
//        ObjectAnimator animator2=ObjectAnimator.ofFloat(view,"scaleY",1f,0.7f,1f);
//        ObjectAnimator animator3=ObjectAnimator.ofFloat(view,"rotation",0,180);
//        AnimatorSet animatorSet=new AnimatorSet();
//        animatorSet.playTogether(animator1,animator2,animator3);//同时执行
////        animatorSet.playSequentially(animator1,animator2,animator3);//依次执行
//        animatorSet.setDuration(500);
//        animatorSet.start();
        
        //6.抛物线
        /**
         * x:匀速
         * y:加速度   y=1/2*g*t*t
         * 使用估值器最好实现。
         */
//        final ValueAnimator valueAnimator = new ValueAnimator();
//        valueAnimator.setDuration(4000);
//        valueAnimator.setObjectValues(new PointF(0f, 0f));
//        valueAnimator.setEvaluator(new TypeEvaluator<PointF>() {
//            @Override
//            public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
//                PointF pointF = new PointF();
//                
//                pointF.x = 100f * (fraction * 4);
//                pointF.y = 0.5f * 150f * (fraction * 4) * (fraction * 4);
//                return pointF;
//            }
//        });
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                PointF pointF = (PointF) animation.getAnimatedValue();
//                float x = pointF.x;
//                float y = pointF.y;
//                view.setX(x);
//                view.setY(y);
//            }
//        });
//        valueAnimator.start();
        ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(view,"translationY",0f,700f);
        objectAnimator.setDuration(1500);
        objectAnimator.setRepeatCount(-1);
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator.setInterpolator(new BounceInterpolator());
        objectAnimator.start();
    }
}
