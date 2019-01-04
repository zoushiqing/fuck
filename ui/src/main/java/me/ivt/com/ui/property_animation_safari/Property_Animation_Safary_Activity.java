package me.ivt.com.ui.property_animation_safari;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import me.ivt.com.ui.R;

public class Property_Animation_Safary_Activity extends AppCompatActivity {
    private LinearLayout mFirst;
    private ImageView mSecond;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property__animation__safary_);
        mFirst = (LinearLayout) findViewById(R.id.first);
        mSecond = (ImageView) findViewById(R.id.second);
    }
    public void startFirstAnimation(View view){
        //第一个view
        //1.翻转动画
        ObjectAnimator first_rotation = ObjectAnimator.ofFloat(mFirst, "rotationX", 0f, 25f);
        first_rotation.setDuration(200);
        //2.透明度
        ObjectAnimator first_alpha = ObjectAnimator.ofFloat(mFirst, "alpha", 1f, 0.5f);
        first_alpha.setDuration(200);
        
        //3.缩放动画
        ObjectAnimator first_scaleX = ObjectAnimator.ofFloat(mFirst, "scaleX", 1f, 0.8f);
        first_scaleX.setDuration(300);
        ObjectAnimator first_scaleY = ObjectAnimator.ofFloat(mFirst, "scaleY", 1f, 0.8f);
        first_scaleY.setDuration(300);
    
        //4.回转动画
        ObjectAnimator first_resume_rotation = ObjectAnimator.ofFloat(mFirst, "rotationX", 25f, 0f);
        first_resume_rotation.setDuration(200);
        first_resume_rotation.setStartDelay(200);
    
        //5.往上移动
        ObjectAnimator first_resume_scaleY = ObjectAnimator.ofFloat(mFirst, "translationY", 0f, -mFirst.getHeight()*0.1f);
        first_resume_scaleY.setDuration(200);
        first_resume_scaleY.setStartDelay(200);
    
        //第二个view
        //6.往上移动
        ObjectAnimator second_resume_scaleY = ObjectAnimator.ofFloat(mSecond, "translationY", mSecond.getHeight(), 0);
        second_resume_scaleY.setDuration(200);
        second_resume_scaleY.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                mSecond.setVisibility(View.VISIBLE);
            }
        });
        
        AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.playTogether(first_rotation,first_alpha,first_scaleX,first_scaleY
                ,first_resume_rotation,first_resume_scaleY,second_resume_scaleY);
    
        animatorSet.start();
                
    }
    public void startSecondAnimation(View view){
        
    }
}
