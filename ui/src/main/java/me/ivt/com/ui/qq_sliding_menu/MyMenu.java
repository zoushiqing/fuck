package me.ivt.com.ui.qq_sliding_menu;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.nineoldandroids.view.ViewHelper;

/**
 * desc:
 */
public class MyMenu extends HorizontalScrollView {
    
    private final int mScreenWidth;
    private ViewGroup mMenu;
    private int mMenuWidth;
    private boolean isOnce;
    private ViewGroup mMain;
    
    public MyMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        mScreenWidth = displayMetrics.widthPixels;
    }
    
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!isOnce) {
            LinearLayout linearLayout = (LinearLayout) getChildAt(0);
            mMenu = (ViewGroup) linearLayout.getChildAt(0);
            mMain = (ViewGroup) linearLayout.getChildAt(1);
            mMenuWidth = mScreenWidth - 100;
            mMenu.getLayoutParams().width = mMenuWidth;
            mMain.getLayoutParams().width = mScreenWidth;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (changed) {
            scrollTo(mMenuWidth, 0);
            isOnce = true;
        }
    }
    
    private float downx;
    
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downx = ev.getX();
                break;
            case MotionEvent.ACTION_UP:
                float dx = ev.getX() - downx;
                if (dx < mScreenWidth / 3) {
                    smoothScrollTo(mMenuWidth, 0);
                } else {
                    smoothScrollTo(0, 0);
                }
                return true;
        }
        return super.onTouchEvent(ev);
    }
    
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
//        1->0
        float factor = (float) l / mMenuWidth;
        //0.6->0
//        mMenu.setTranslationX(0.6f * factor * mMenuWidth);
        ViewHelper.setTranslationX(mMenu, 0.6f * factor * mMenuWidth);
        //0.3->1
        mMenu.setScaleX(1 - 0.7f * factor);
        mMenu.setScaleY(1 - 0.7f * factor);
        //0.6->1
        mMenu.setAlpha(1 - 0.4f * factor);
        //1->0.8
        mMain.setScaleY(0.8f + 0.2f * factor);
        
    }
}
