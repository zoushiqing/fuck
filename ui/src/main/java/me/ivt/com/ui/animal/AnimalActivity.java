package me.ivt.com.ui.animal;

import android.animation.Animator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;

import me.ivt.com.ui.R;

public class AnimalActivity extends AppCompatActivity {
    
    private Button mButton1;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
        mButton1 = findViewById(R.id.btn1);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //水波纹 揭露效果 
//                View view, int centerX,  int centerY, float startRadius, float endRadius
//                Animator circularReveal = ViewAnimationUtils.createCircularReveal(v, v.getWidth() / 2, v.getHeight() / 2, 0, (float) Math.hypot(v.getWidth() / 2, v.getHeight() / 2));
                Animator circularReveal = ViewAnimationUtils.createCircularReveal(v,0, 0, 0, (float) Math.hypot(v.getWidth(), v.getHeight()));
                circularReveal.setDuration(500);
                circularReveal.start();
    
            }
        });
    }
}
