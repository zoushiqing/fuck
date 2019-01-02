package me.ivt.com.ui.tablayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

import me.ivt.com.ui.DividerDecoration;
import me.ivt.com.ui.R;
import me.ivt.com.ui.coordinatorlayout.CoordninatorRecyAdapter;

public class ItemFragment extends Fragment {
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item, container, false);
        RecyclerView mRv = (RecyclerView) view.findViewById(R.id.rv);
        ArrayList<String> mStrings = new ArrayList<>();
        for (int i = 'A'; i <= 'Z'; i++) {
            mStrings.add("当前是数据--------------->" + (char) i);
        }
        for (int i = 'A'; i <= 'Z'; i++) {
            mStrings.add("当前是数据--------------->" + (char) i);
        }
        mRv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRv.addItemDecoration(new DividerDecoration(getActivity(),LinearLayout.VERTICAL));
        mRv.setAdapter(new CoordninatorRecyAdapter(mStrings));
        
        return view;
    }
}
