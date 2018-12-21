package me.ivt.com.ui;

/**
 * desc:
 */
public interface ItemTouchListener {
    //当拖拽的时候回调
     boolean onItemMove(int fromPosition, int toPosition);
    //侧滑的时候的监听
     boolean onItemRemove(int position);
}
