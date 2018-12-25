package me.ivt.com.ui.tablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.ivt.com.ui.R;

public class BottomNavigationBarActivity extends AppCompatActivity {
    private MyTabLayout mTablayout;
    private ViewPager mViewpager;
    private List<String> mMStrings;
    private List<Fragment> mFragmentList=new ArrayList<>();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_bar);
        mTablayout = (MyTabLayout) findViewById(R.id.tablayout);
        mViewpager = (ViewPager) findViewById(R.id.viewpager);
        mMStrings = new ArrayList<>();
        for (int i = 'A'; i <= 'C'; i++) {
            mMStrings.add("" + (char) i+(char) i);
            ItemFragment itemFragment = new ItemFragment();
            Bundle bundle = new Bundle();
            bundle.putString("key", "" + (char) i+(char) i);
            itemFragment.setArguments(bundle);
            mFragmentList.add(itemFragment);
        }
        mViewpager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        mTablayout.setupWithViewPager(mViewpager);
        for (int i = 0; i < mTablayout.getTabCount(); i++) {
            TabLayout.Tab tabAt = mTablayout.getTabAt(i);
            View view=View.inflate(this,R.layout.bottom_navigation_tab,null);
            TextView tvName=view.findViewById(R.id.tv_name);
            tvName.setText(mMStrings.get(i));
            tabAt.setCustomView(view);
    
        }
    }
    
    
    class MyAdapter extends FragmentPagerAdapter {
        MyAdapter(FragmentManager fm) {
            super(fm);
        }
        
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mMStrings.get(position);
        }
        
        @Override
        public Fragment getItem(int i) {
            return mFragmentList.get(i);
        }
        
        @Override
        public int getCount() {
            return mMStrings.size();
        }
    }
}
