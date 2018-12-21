package me.ivt.com.ui;

import android.support.v7.widget.RecyclerView;

/**
 * desc:
 */
public interface StartDragListener {
    //用于需要主动回调主动拖拽效果
    public void onStartDrag(RecyclerView.ViewHolder viewHolder);
}
