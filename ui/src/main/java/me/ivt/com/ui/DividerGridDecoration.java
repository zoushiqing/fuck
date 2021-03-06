package me.ivt.com.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * desc:
 */
public class DividerGridDecoration extends RecyclerView.ItemDecoration {
    private Drawable mDivider;
    private int[] attrs = new int[]{
            android.R.attr.listDivider
    };
    
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        drawVertical(c, parent);
        drawHorizontal(c, parent);
    }
    
    private void drawVertical(Canvas c, RecyclerView parent) {
        //绘制垂直间隔线
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            int left = childAt.getRight() + layoutParams.rightMargin;
            int right = left + mDivider.getIntrinsicWidth();
            int top = childAt.getTop() - layoutParams.topMargin;
            int bottom = childAt.getBottom() + layoutParams.bottomMargin;
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }
    
    private void drawHorizontal(Canvas c, RecyclerView parent) {
        //绘制水平间隔线
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            
            int left = childAt.getLeft() - layoutParams.leftMargin;
            int right = childAt.getRight() + layoutParams.rightMargin;
            int top = childAt.getBottom() + layoutParams.bottomMargin;
            int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
            
        }
    }
    
    public DividerGridDecoration(Context context, int oritation) {
        TypedArray array = context.obtainStyledAttributes(attrs);
        mDivider = array.getDrawable(0);
        array.recycle();
    }
    
    @Override
    public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent) {
        int right = mDivider.getIntrinsicWidth();
        int bottom = mDivider.getIntrinsicHeight();
        
        if (isLastColumn(itemPosition, parent)) {
            right = 0;
        }
        if (isLastRow(itemPosition, parent)) {
            bottom = 0;
        }
        outRect.set(0, 0, right, bottom);
    }
    
    private boolean isLastRow(int itemPosition, RecyclerView parent) {
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            int spanCount = gridLayoutManager.getSpanCount();
            
            int childCount = parent.getAdapter().getItemCount();
            int lastRowCount = childCount % spanCount;
            //最后一行的数量小于spanCount
            return lastRowCount == 0 || lastRowCount < spanCount;
        }
        return false;
    }
    
    private boolean isLastColumn(int itemPosition, RecyclerView parent) {
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            int spanCount = gridLayoutManager.getSpanCount();
            return (itemPosition + 1) % spanCount == 0;
        }
        return false;
    }
}
