package me.ivt.com.ui.tablayout;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import me.ivt.com.ui.R;

public class Tablelayout_Activity extends AppCompatActivity {
    private TabLayout mTablayout;
    private ViewPager mViewpager;
    private List<String> mMStrings;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
        mTablayout = (TabLayout) findViewById(R.id.tablayout);
        mViewpager = (ViewPager) findViewById(R.id.viewpager);
        mMStrings = new ArrayList<>();
        for (int i = 'A'; i <= 'Z'; i++) {
            mMStrings.add("" + (char) i);
        }
        LinearLayout childAt = (LinearLayout) mTablayout.getChildAt(0);
        childAt.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        Drawable drawable =  ContextCompat.getDrawable(this, R.drawable.diver_love);
        childAt.setDividerDrawable(drawable);
        childAt.setDividerPadding(10);
        mViewpager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        mTablayout.setupWithViewPager(mViewpager);
    }
 
    
    class MyAdapter extends FragmentPagerAdapter {
        
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }
        
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mMStrings.get(position);
        }
        
        @Override
        public Fragment getItem(int i) {
            ItemFragment itemFragment = new ItemFragment();
            Bundle bundle = new Bundle();
            bundle.putString("key", mMStrings.get(i));
            itemFragment.setArguments(bundle);
            return itemFragment;
        }
        
        @Override
        public int getCount() {
            return mMStrings.size();
        }
    }
}
