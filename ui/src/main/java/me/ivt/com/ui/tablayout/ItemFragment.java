package me.ivt.com.ui.tablayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.ivt.com.ui.R;

public class ItemFragment extends Fragment {
    private TextView mTv;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item, container, false);
        mTv = (TextView) view.findViewById(R.id.tv);
        mTv.setBackgroundColor(Color.argb((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));
        Bundle arguments = getArguments();
        String key = arguments.getString("key");
        mTv.setText(key);
        return view;
    }
}
