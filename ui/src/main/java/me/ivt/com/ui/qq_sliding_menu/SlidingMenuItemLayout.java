package me.ivt.com.ui.qq_sliding_menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.Scroller;

/**
 * desc:
 */
public class SlidingMenuItemLayout extends LinearLayout {
    
    private Scroller mScroller;
    private View mLeftView;
    private View mRightView;
    private float mDx;
    private float mDy;
    
    public SlidingMenuItemLayout(Context context) {
        super(context);
    }
    
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mLeftView = getChildAt(0);
        mRightView = getChildAt(1);
    }
    
    public SlidingMenuItemLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(LinearLayout.HORIZONTAL);
        mScroller = new Scroller(context, null, true);
    }
    
    private float startX;
    private float startY;
    
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = ev.getX();
                startY = ev.getY();
                super.dispatchTouchEvent(ev);
                return true;
            case MotionEvent.ACTION_MOVE:
                mDx = ev.getX() - startX;
                mDy = ev.getY() - startY;
                if (Math.abs(mDx) - Math.abs(mDy) > ViewConfiguration.getTouchSlop()) {
                    if (getScrollX() + (-mDx) > mRightView.getWidth() || getScrollX() + (-mDx) < 0) {
                        return true;
                    }
                    scrollBy((int) -mDx, 0);
                    startX = ev.getX();
                    startY = ev.getY();
                    return true;
                }
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("getScrollX() = " + getScrollX());
                System.out.println(" mRightView.getWidth() = " +  mRightView.getWidth());
                
                int offset = getScrollX() / (float)mRightView.getWidth() > 0.5f ? mRightView.getWidth() - getScrollX() : -getScrollX();
                System.out.println("offset = " + offset);
                mScroller.startScroll(getScrollX(), getScrollY(), offset, 0);
                invalidate();
                startX = 0;
                startY = 0;
                mDx = 0;
                mDy = 0;
                break;
            
        }
        return super.dispatchTouchEvent(ev);
    }
    
    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
    }
}
