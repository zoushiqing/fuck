package me.ivt.com.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * desc:
 */
public class DividerDecoration extends RecyclerView.ItemDecoration {
    private int[] attrs = new int[]{
            android.R.attr.listDivider
    };
    private int mOritation;
    private Drawable mDivider;
    
    public DividerDecoration(Context context, int oritation) {
        TypedArray array = context.obtainStyledAttributes(attrs);
        mDivider = array.getDrawable(0);
        array.recycle();
        setOritation(oritation);
    }
    
    private void setOritation(int oritation) {
        if (oritation != LinearLayoutManager.VERTICAL && oritation != LinearLayoutManager.HORIZONTAL) {
            throw new IllegalArgumentException("只能设置锤子或者水平的布局");
        }
        this.mOritation = oritation;
    }
    
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        if (mOritation == LinearLayoutManager.VERTICAL) {
            drawVertical(c, parent);
        } else {
        }
    }
    
    private void drawVertical(Canvas c, RecyclerView parent) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount - 1; i++) {
            View childAt = parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            
            int top = childAt.getBottom() + layoutParams.bottomMargin+Math.round(ViewCompat.getTranslationY(childAt));
            int bottom = top + mDivider.getIntrinsicHeight();
            
            
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }
    
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if (mOritation == LinearLayoutManager.VERTICAL) {
            outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
        } else {
            outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
        }
    }
}
