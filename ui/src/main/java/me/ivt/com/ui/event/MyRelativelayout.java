package me.ivt.com.ui.event;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Scroller;

/**
 * desc:
 */
public class MyRelativelayout extends RelativeLayout implements GestureDetector.OnGestureListener {
    public static final String TAG = "MyRelativelayout";
    private VelocityTracker mVelocityTracker;
    private GestureDetector mGestureDetector;
    
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }
    
    
    public MyRelativelayout(Context context) {
        super(context);
    }
    
    public MyRelativelayout(Context context, AttributeSet attrs) {
        super(context, attrs);
//        int scaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
//        Log.e(TAG, "scaledTouchSlop = " + scaledTouchSlop);
        mGestureDetector = new GestureDetector(this);
        
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
    
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
        
    }
    
    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }
    
    @Override
    public void onShowPress(MotionEvent e) {
        
    }
    
    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }
    
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }
    
    @Override
    public void onLongPress(MotionEvent e) {
        
    }
    
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
    
    //    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                mVelocityTracker = VelocityTracker.obtain();
//                mVelocityTracker.addMovement(event);
//                
//                break;
//            case MotionEvent.ACTION_MOVE:
//                mVelocityTracker.addMovement(event);
//                mVelocityTracker.computeCurrentVelocity(100);
//                float xVelocity = mVelocityTracker.getXVelocity();
//                float yVelocity = mVelocityTracker.getYVelocity();
//                if (BuildConfig.DEBUG) Log.e(TAG, "xVelocity = " + xVelocity);
//                System.out.println();
//                if (BuildConfig.DEBUG) Log.e(TAG, "yVelocity = " + yVelocity);
//                break;
//            case MotionEvent.ACTION_UP:
//                mVelocityTracker.clear();
//                mVelocityTracker.recycle();
//                break;
//        }
//        return super.onTouchEvent(event);
//    }
    Scroller mScroller = new Scroller(getContext());
    
    public void scrollTo(int destX, int destY) {
        int scrollX = getScrollX();
        int delta = destX - scrollX;
//        int startX, int startY, int dx, int dy, int duration
        mScroller.startScroll(scrollX, 0, delta, 0, 100);
        invalidate();
    }
    Button mButton;
    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
        final int startX=0;
        final int destX=100;
        ValueAnimator animator=ValueAnimator.ofInt(0,1).setDuration(1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float animatedFraction = animation.getAnimatedFraction();
                mButton.scrollTo((int) (startX+destX*animatedFraction),0);
            }
        });
        animator.start();
    }

    
}
