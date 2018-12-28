package me.ivt.com.ui.coordinatorlayout;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import me.ivt.com.ui.R;

/**
 * desc:
 */
public class CoordninatorRecyAdapter extends RecyclerView.Adapter<CoordninatorRecyAdapter.FABHoler> {
    private ArrayList<String> mStringArrayList;
    
    public CoordninatorRecyAdapter(ArrayList<String> stringArrayList) {
        mStringArrayList = stringArrayList;
    }
    
    @NonNull
    @Override
    public FABHoler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new FABHoler(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false));
    }
    
    @Override
    public void onBindViewHolder(@NonNull FABHoler fabHolder, int i) {
        fabHolder.mTv.setText(mStringArrayList.get(i));
    }
    
    @Override
    public int getItemCount() {
        return mStringArrayList.size();
    }
    
    class FABHoler extends RecyclerView.ViewHolder {
        private TextView mTv;
        
        
        public FABHoler(@NonNull View itemView) {
            super(itemView);
            mTv = (TextView) itemView.findViewById(R.id.tv);
        }
    }
}
