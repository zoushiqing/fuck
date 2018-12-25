package me.ivt.com.ui.tablayout;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;

/**
 * desc:
 */
public class MyTabLayout extends TabLayout {
    public MyTabLayout(Context context) {
        super(context);
    }
    
    public MyTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandspec=MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandspec);
    }
}
