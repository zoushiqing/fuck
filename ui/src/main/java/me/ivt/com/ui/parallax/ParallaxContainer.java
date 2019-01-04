package me.ivt.com.ui.parallax;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * desc:
 */
public class ParallaxContainer extends FrameLayout {
    private List<ParallaxFragment> mFragments;
    
    public ParallaxContainer(Context context) {
        super(context);
    }
    
    public ParallaxContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    public void setUp(int... ids) {
        mFragments = new ArrayList<>();
        for (int id : ids) {
            ParallaxFragment parallaxFragment = new ParallaxFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("id", id);
            parallaxFragment.setArguments(bundle);
            mFragments.add(parallaxFragment);
        }
        ViewPager viewPager = new ViewPager(getContext());
        ParallaxAdapter parallaxAdapter = new ParallaxAdapter(((FragmentActivity) getContext()).getSupportFragmentManager(), mFragments);
        
        viewPager.setAdapter(parallaxAdapter);
        addView(viewPager, 0);
        
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
        
            }
    
            @Override
            public void onPageSelected(int i) {
        
            }
    
            @Override
            public void onPageScrollStateChanged(int i) {
        
            }
        });
    }
    
}
