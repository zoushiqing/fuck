package me.ivt.com.ui.immerse;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import me.ivt.com.ui.R;

public class ImmerseActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private TextView mTv;
    private boolean change;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //5.0+可以直接用API来修改状态栏的颜色。
//        getWindow().setStatusBarColor(getResources().getColor(R.color.material_blue_grey_800));
        
        
        //去掉状态栏阴影
         setStatusBar();
    
        setContentView(R.layout.activity_immerse);
        mTv = (TextView) findViewById(R.id.tv);
        
        //增加 首控件高度
//        setlayoutParamsChangeStatus();
        
        
        mTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTv.setBackgroundColor(Color.argb((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));
                //修改字体颜色
                setAndroidNativeLightStatusBar(ImmerseActivity.this, change = !change);
            }
        });
    }
    
    private void setlayoutParamsChangeStatus() {
        ViewGroup.LayoutParams layoutParams = mTv.getLayoutParams();
        int height = layoutParams.height;
        int statusHeight = getStatusBarHeight();
        layoutParams.height = height + statusHeight;
        mTv.setPadding(mTv.getPaddingLeft(), statusHeight, mTv.getPaddingRight(), mTv.getPaddingBottom());
        mTv.setLayoutParams(layoutParams);
    }
    
    private int getStatusBarHeight() {
        try {
            Class<?> aClass = Class.forName("com.android.internal.R$dimen");
            try {
                Object o = aClass.newInstance();
                try {
                    String status_bar_height = aClass.getField("status_bar_height").get(o).toString();
                    int height = Integer.parseInt(status_bar_height);
                    //dp-----px
                    int dimensionPixelSize = this.getResources().getDimensionPixelSize(height);
                    return dimensionPixelSize;
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    protected void setStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0及以上
            View decorView = getWindow().getDecorView();
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4到5.0
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        } //修改字体颜色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {//android6.0以后可以对状态栏文字颜色和图标进行修改
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            setAndroidNativeLightStatusBar(this, true);
        }
    }
    
    private static void setAndroidNativeLightStatusBar(Activity activity, boolean dark) {
        View decor = activity.getWindow().getDecorView();
        if (dark) {
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        } else {
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }
    }
    
}
