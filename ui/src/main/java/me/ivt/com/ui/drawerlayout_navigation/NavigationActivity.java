package me.ivt.com.ui.drawerlayout_navigation;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.KeyEvent;

import me.ivt.com.ui.R;

public class NavigationActivity extends AppCompatActivity {
    DrawerLayout mDrawerLayout;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        mDrawerLayout = findViewById(R.id.drawer_layout);
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (mDrawerLayout.isDrawerOpen(Gravity.START)) {
            mDrawerLayout.closeDrawer(Gravity.START);
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
