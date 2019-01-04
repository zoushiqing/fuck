package me.ivt.com.ui.parallax;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * desc:
 */
public class ParallaxAdapter extends FragmentPagerAdapter {
    private List<ParallaxFragment> mFragments;
    
    public ParallaxAdapter(FragmentManager fm, List<ParallaxFragment> mFragments) {
        super(fm);
        this.mFragments = mFragments;
    }
    
    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i);
    }
    
    @Override
    public int getCount() {
        return mFragments.size();
    }
}
