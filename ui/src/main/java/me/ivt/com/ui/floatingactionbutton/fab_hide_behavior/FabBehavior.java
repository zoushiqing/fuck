package me.ivt.com.ui.floatingactionbutton.fab_hide_behavior;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;

/**
 * desc:
 */
public class FabBehavior extends FloatingActionButton.Behavior {
    private boolean isAnimaltingOut = false;
    
    public FabBehavior() {
    }
    
    public FabBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    // 当观察的view 开始滑动的时候   
    // type 滑动关联的轴 我们只关心锤子的滑动
    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        return type == ViewCompat.SCROLL_AXIS_VERTICAL || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type);
    }
    
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        System.out.println("dependency = " + dependency);
        return super.onDependentViewChanged(parent, child, dependency);
    }
    
    //当观察的view 滑动的时候
    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton child, @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);
        System.out.println("dyConsumed = " + dyConsumed);
        //show
        if (dyConsumed > 0&&isAnimaltingOut) {
            //hide
            isAnimaltingOut=false;
            onHide(child);
        } else if (dyConsumed < 0) {
            isAnimaltingOut=true;
            onShow(child);
        }
        
    }
    public void onHide(FloatingActionButton mFab) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mFab.getLayoutParams();
        mFab.animate().translationY(mFab.getHeight() + layoutParams.bottomMargin).setInterpolator(new AccelerateInterpolator(3));
    }
    
    public void onShow(FloatingActionButton mFab) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mFab.getLayoutParams();
        mFab.animate().translationY(0).setInterpolator(new DecelerateInterpolator(3));
    }
}
