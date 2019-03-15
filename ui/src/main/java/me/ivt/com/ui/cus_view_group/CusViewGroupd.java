package me.ivt.com.ui.cus_view_group;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * desc:
 */
public class CusViewGroupd extends ViewGroup {
    private static final int OFFSET = 80;
    
    public CusViewGroupd(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        // 摆放
        int left = 0;
        int right = 0;
        int top = 0;
        int bottom = 0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            left = i*OFFSET;
            right = left + child.getMeasuredWidth();
            bottom = top + child.getMeasuredHeight();
            child.layout(left, top, right, bottom);
            
            top += child.getMeasuredHeight();
        }
        
    }
    
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        
        int width = 0;
        int height = 0;
        //1.测量自己的尺寸
//		ViewGroup.onMeasure();
        //1.1 为每一个child计算测量规格信息(MeasureSpec)
//		ViewGroup.getChildMeasureSpec();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            LayoutParams lp = child.getLayoutParams();
            int childWidthSpec = getChildMeasureSpec(widthMeasureSpec, 0, lp.width);
            int childHeightSpec = getChildMeasureSpec(heightMeasureSpec, 0, lp.height);
            //1.2 将上面测量后的结果，传给每一个子View，子view测量自己的尺寸
            child.measure(childWidthSpec, childHeightSpec);
        }
//		//1.3 子View测量完，ViewGroup就可以拿到这个子View的测量后的尺寸了
//		child.getChildMeasuredSize();//child.getMeasuredWidth()和child.getMeasuredHeight()
//		//1.4ViewGroup自己就可以根据自身的情况(Padding等等),来计算自己的尺寸(mode,value)
//		ViewGroup.calculateSelfSize();
        
        switch (widthMode) {
            case MeasureSpec.EXACTLY:
                width = widthSize;
                break;
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                for (int i = 0; i < childCount; i++) {
                    View child = getChildAt(i);
                    int widthAndOffset = i*OFFSET + child.getMeasuredWidth();
                    width = Math.max(width, widthAndOffset);
                }
                break;
            default:
                break;
        }
        
        
        switch (heightMode) {
            case MeasureSpec.EXACTLY:
                height = heightSize;
                break;
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                for (int i = 0; i < childCount; i++) {
                    View child = getChildAt(i);
                    height = height + child.getMeasuredHeight();
                }
                break;
            default:
                break;
        }
        //2.保存自己的尺寸
//				ViewGroup.setMeasuredDimension(size);
        setMeasuredDimension(width, height);
    }
    
    
}
