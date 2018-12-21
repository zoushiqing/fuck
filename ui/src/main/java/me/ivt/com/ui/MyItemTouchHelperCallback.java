package me.ivt.com.ui;

import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * desc:
 */
public class MyItemTouchHelperCallback extends ItemTouchHelper.Callback {
    private ItemTouchListener mItemTouchListener;
    
    public MyItemTouchHelperCallback(ItemTouchListener itemTouchListener) {
        mItemTouchListener = itemTouchListener;
    }
    
    //callback回调监听时 先调用的方法  判断是什么动作 比如判断方向(监听哪个方向的拖动)
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        //我要拖拽是是哪两个方向
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        //监听swipe侧滑的方向
        int swipeFlags = ItemTouchHelper.LEFT;
        return makeMovementFlags(dragFlags, swipeFlags);
    }
    
    //当移动的时候回调的方法----拖拽
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        if (viewHolder.getItemViewType() != target.getItemViewType()) {
            return false;
        }
        //在拖拽的过程中不断的调用 recyclerView的notifyItemMoved（from,to）
        mItemTouchListener.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }
    
    //是否长按执行拖拽
    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }
    
    //滑动的时候的回调
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        mItemTouchListener.onItemRemove(viewHolder.getAdapterPosition());
    }
    
    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        //不是闲置状态
        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
            viewHolder.itemView.setBackgroundColor(viewHolder.itemView.getContext().getResources().getColor(R.color.colorPrimary_pink));
        }
        super.onSelectedChanged(viewHolder, actionState);
    }
    
    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        //恢复
        viewHolder.itemView.setBackgroundColor(Color.WHITE);
        //透明度动画
        viewHolder.itemView.setAlpha(1);//1~0
        viewHolder.itemView.setScaleX(1);
        viewHolder.itemView.setScaleY(1);
        super.clearView(recyclerView, viewHolder);
    }
    
    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        System.out.println("actionState = " + actionState);
        //dx:
        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
            float alpha = 1 - Math.abs(dX) / viewHolder.itemView.getWidth();
            //透明度动画
            viewHolder.itemView.setAlpha(alpha);//1~0
            viewHolder.itemView.setScaleX(alpha);
            viewHolder.itemView.setScaleY(alpha);
        }
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }
}
