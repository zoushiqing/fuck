package me.ivt.com.ui.cus_view_group;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * desc:
 */
public class TagLayout extends ViewGroup {
    List<Integer> lineHeights = new ArrayList<>();
    List<List<View>> views = new ArrayList<>();
    
    
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //该行有多少列数据
        List<View> lineViews = new ArrayList<>();
        int width = getMeasuredWidth();//容器自己的宽
        int lineWidth = 0;
        int lineHeight = 0;
        
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            MarginLayoutParams marginLayoutParam = (MarginLayoutParams) child.getLayoutParams();
            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();
            if (lineWidth + childWidth + marginLayoutParam.leftMargin + marginLayoutParam.rightMargin > width) {
                //超出一行
                lineHeights.add(lineHeight);
                views.add(lineViews);
                lineWidth = 0;
                lineViews = new ArrayList<>();
            }
            lineWidth += childWidth + marginLayoutParam.leftMargin + marginLayoutParam.rightMargin;
            lineHeight = Math.max(lineHeight, childHeight + marginLayoutParam.topMargin + marginLayoutParam.bottomMargin);
            lineViews.add(child);
        }
        lineHeights.add(lineHeight);
        views.add(lineViews);
        int left = 0;
        int top = 0;
        for (int i = 0; i < views.size(); i++) {
            lineViews = views.get(i);
            lineHeight = lineHeights.get(i);
            for (int j = 0; j < lineViews.size(); j++) {
                View child = lineViews.get(j);
                MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
                int lc = left + lp.leftMargin;
                int lt = top + lp.topMargin;
                int lr = lc + child.getMeasuredWidth();
                int lb = lt + child.getMeasuredHeight();
                child.layout(lc, lt, lr, lb);
                left += child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
            }
            left = 0;
            top += lineHeight;
        }
    }
    
    public TagLayout(Context context) {
        super(context);
    }
    
    public TagLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int modewidth = MeasureSpec.getMode(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);
        
        int width = 0;//width 所有行里面最宽的一行
        int height = 0;//所有行的高度相加
        
        //一行的宽度=一行的所有的view的宽度的和
        int lineWidth = 0;
        int lineHeight = 0;
        
        
        //1.测量所有子控件的大小
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            measureChild(child, widthMeasureSpec, heightMeasureSpec);//View child, int parentWidthMeasureSpec,int parentHeightMeasureSpec
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
            
            int childWidth = child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
            int childHeight = child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;
            if (lineWidth + childWidth > sizeWidth) {
                //换行
                width = Math.max(lineWidth, width);
                lineWidth = childWidth;
                lineHeight = childHeight;
                height += lineHeight;
            } else {
                //累加
                lineWidth += childWidth;
                lineHeight = Math.max(lineHeight, childHeight);
            }
            if (i == childCount - 1) {
                width = Math.max(width, width);
                height += lineHeight;
            }
        }
        
        //2.测量自身的大小
        int measuredWidth = (modewidth == MeasureSpec.EXACTLY ? sizeWidth : width);
        int measuredHeight = (modeHeight == MeasureSpec.EXACTLY ? sizeHeight : height);
        setMeasuredDimension(measuredWidth, measuredHeight);//int measuredWidth, int measuredHeight
    }
    
    /**
     * 与当前ViewGroup对应的LayoutParams
     */
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }
    
}
