package me.ivt.com.ui.palette;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * desc:
 */
public class MyScrollerView extends ScrollView {
    OnScrollListener mOnScrollListener;
    
    public void setOnScrollListener(OnScrollListener onScrollListener) {
        mOnScrollListener = onScrollListener;
    }
    
    public MyScrollerView(Context context) {
        super(context);
    }
    
    public MyScrollerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //屏幕的高度
        
        
    }
    
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if(mOnScrollListener!=null){
            int scrollY = getScrollY();
            int screen_height = getContext().getResources().getDisplayMetrics().heightPixels;
            if(scrollY<=screen_height/3f){//0~1f,而透明度应该是1~0f
                mOnScrollListener.onScroll(1-scrollY/(screen_height/3f));//alpha=滑出去的高度/(screen_height/3f)
            }
        }
    }
}
