package me.ivt.com.ui.scene_translation_animation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import me.ivt.com.ui.R;

/**
 * 转场动画：共享元素的转换 和 普通的转换
 * 设置转场动画的前提
 */
public class Scene_Translation_AnimtionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene__translation__animtion);
    }
    
    public void go1(View view) {
        startActivity(new Intent(this,SecondActivity.class));        
        overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        
    }
    
    public void go2(View view) {
        
    }
    
    public void go3(View view) {
        
        
    }
    
    public void go4(View view) {
        
        
    }
}
