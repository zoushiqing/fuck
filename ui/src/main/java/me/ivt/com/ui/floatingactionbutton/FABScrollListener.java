package me.ivt.com.ui.floatingactionbutton;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

/**
 * desc:
 */
public class FABScrollListener extends RecyclerView.OnScrollListener {
    private static final int THRESHOLD = 20;
    private int distance = 0;
    private HideScrollListener mHideScrollListener;
    private boolean visiable = true;
    
    public FABScrollListener(HideScrollListener hideScrollListener) {
        mHideScrollListener = hideScrollListener;
    }
    
    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        /**
         * dy y轴方向的增量  有正和负
         */
        if (distance > THRESHOLD && visiable) {
            //隐藏
            visiable=false;
            mHideScrollListener.onHide();
            distance = 0;
        } else if (distance < -THRESHOLD && !visiable) {
            //显示
            visiable=true;
            mHideScrollListener.onShow();
            distance = 0;
        }
        if ((visiable && dy > 0) || (!visiable && dy < 0)) {
            distance += dy;
        }
    }
}
