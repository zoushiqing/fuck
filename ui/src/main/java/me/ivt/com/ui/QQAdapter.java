package me.ivt.com.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * desc:
 */
public class QQAdapter extends RecyclerView.Adapter<QQAdapter.MyHolder> implements ItemTouchListener {
    StartDragListener mContext;
    private List<QQMessage> mQQMessageList;
    
    public QQAdapter(StartDragListener context, List<QQMessage> QQMessageList) {
        mContext = context;
        mQQMessageList = QQMessageList;
    }
    
    @NonNull
    @Override
    public QQAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from((Context) mContext).inflate(R.layout.listitem, parent, false));
    }
    
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(@NonNull final QQAdapter.MyHolder holder, int position) {
        QQMessage qqMessage = mQQMessageList.get(position);
        holder.mIvLogo.setImageResource(qqMessage.getLogo());
        holder.mTvName.setText(qqMessage.getName());
        holder.mTvLastMsg.setText(qqMessage.getLastMsg());
        holder.mTvTime.setText(qqMessage.getTime());
        holder.mIvLogo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //传递触摸情况给
                    mContext.onStartDrag(holder);
                }
                return false;
            }
        });
    }
    
    @Override
    public int getItemCount() {
        return mQQMessageList.size();
    }
    
    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        //1.数据交换  2.刷新
        Collections.swap(mQQMessageList, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return false;
    }
    
    @Override
    public boolean onItemRemove(int position) {
        mQQMessageList.remove(position);
        notifyItemRemoved(position);
        return false;
    }
    
    class MyHolder extends RecyclerView.ViewHolder {
        
        private ImageView mIvLogo;
        private TextView mTvName;
        private TextView mTvTime;
        private TextView mTvLastMsg;
        private ImageView mIvPop;
        
        public MyHolder(View itemView) {
            super(itemView);
            mIvLogo = itemView.findViewById(R.id.iv_logo);
            mTvName = itemView.findViewById(R.id.tv_name);
            mTvTime = itemView.findViewById(R.id.tv_time);
            mTvLastMsg = itemView.findViewById(R.id.tv_lastMsg);
            mIvPop = itemView.findViewById(R.id.iv_pop);
        }
    }
}
