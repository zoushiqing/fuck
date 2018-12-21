package me.ivt.com.ui.slidingmenu_drawerlayout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import me.ivt.com.ui.R;

public class DrawerLayoutActivity extends AppCompatActivity {
    Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout);
        mToolbar = findViewById(R.id.too_bar);
        //将以前的Actionbar替换成toolbar
        setSupportActionBar(mToolbar);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close);
        drawerToggle.syncState();
        mDrawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                //滑动过程中不断的调用  范围：slideOffset 0~1
                View content = mDrawerLayout.getChildAt(0);
                View menu = drawerView;
                
                float scale = 1 - slideOffset;//1~0
                
                float leftScale = (float) (1 - 0.3 * scale);//
                float rightScale = (float) (0.7f + 0.3 * scale);//0.7~1
                menu.setScaleX(leftScale);
                menu.setScaleY(leftScale);
                
                content.setScaleX(rightScale);
                content.setScaleY(rightScale);
                content.setTranslationX(menu.getMeasuredWidth() * (1 - scale));
            }
            
            @Override
            public void onDrawerOpened(@NonNull View view) {
                
            }
            
            @Override
            public void onDrawerClosed(@NonNull View view) {
                
            }
            
            @Override
            public void onDrawerStateChanged(int i) {
                
            }
        });
    }
}
