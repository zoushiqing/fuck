package me.ivt.com.ui.coordinatorlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import me.ivt.com.ui.R;
import me.ivt.com.ui.tablayout.ItemFragment;

public class TablyoutViewpagerToolabrActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private TabLayout mTab;
    private ViewPager mVp;
    private ArrayList<String> mMStrings;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabalyout_viewpager_toolabr);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTab = (TabLayout) findViewById(R.id.tab);
        mVp = (ViewPager) findViewById(R.id.vp);
        setSupportActionBar(mToolbar);
        mMStrings = new ArrayList<>();
        for (int i = 'A'; i <= 'Z'; i++) {
            mMStrings.add("" + (char) i);
        }
        mVp.setAdapter(new MyAdapter(getSupportFragmentManager()));
        mTab.setupWithViewPager(mVp);
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
