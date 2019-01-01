package me.ivt.com.ui.cusbehavior;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class CusBehavior extends CoordinatorLayout.Behavior<View> {
    public CusBehavior() {
    }
    
    public CusBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    /**
     * @param parent     coorinator
     * @param child      观察者
     * @param dependency 被观察者
     * @return
     */
    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        return dependency instanceof TextView || super.layoutDependsOn(parent, child, dependency);
    }
    
    /**
     * 被监听的view发生改变的时候的回调
     *
     * @param parent
     * @param child
     * @param dependency
     * @return
     */
    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull View child, @NonNull View dependency) {
        //获取被监听view的状态
        int offset = dependency.getTop() - child.getTop();
        //让view 进行平移
        ViewCompat.offsetTopAndBottom(child, offset);
        return true;
    }
}

