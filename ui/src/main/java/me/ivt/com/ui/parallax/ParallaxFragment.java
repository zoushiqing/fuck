package me.ivt.com.ui.parallax;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ParallaxFragment extends Fragment {
    
    
    public ParallaxFragment() {
        // Required empty public constructor
    }
    
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        int layoutId = arguments.getInt("id");
        ParallaxLayoutInflater parallaxLayoutInflater=new ParallaxLayoutInflater(inflater,getActivity());
        return parallaxLayoutInflater.inflate(layoutId, container, false);
    }
}
    
