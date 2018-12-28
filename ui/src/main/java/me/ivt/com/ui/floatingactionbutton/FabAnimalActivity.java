package me.ivt.com.ui.floatingactionbutton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import me.ivt.com.ui.DividerDecoration;
import me.ivt.com.ui.R;

public class FabAnimalActivity extends AppCompatActivity implements HideScrollListener {
    private RecyclerView mRv;
    private Toolbar mToolbar;
    private ImageButton mFab;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab_animal);
        mRv = (RecyclerView) findViewById(R.id.rv);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mFab = (ImageButton) findViewById(R.id.fab);
        setSupportActionBar(mToolbar);
        setTitle("邹世清");
        ArrayList<String> mStrings = new ArrayList<>();
        for (int i = 'A'; i <= 'Z'; i++) {
            mStrings.add("当前是数据--------------->" + (char) i);
        }
        for (int i = 'A'; i <= 'Z'; i++) {
            mStrings.add("当前是数据--------------->" + (char) i);
        }
        mRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRv.setAdapter(new FABRecyAdapter(mStrings));
        mRv.addItemDecoration(new DividerDecoration(this,LinearLayout.VERTICAL));
        mRv.addOnScrollListener(new FABScrollListener(this));
    }
    
    @Override
    public void onHide() {
        mToolbar.animate().translationY(-mToolbar.getHeight()).setInterpolator(new AccelerateInterpolator(3));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mFab.getLayoutParams();
        mFab.animate().translationY(mFab.getHeight() + layoutParams.bottomMargin).setInterpolator(new AccelerateInterpolator(3));
    }
    
    @Override
    public void onShow() {
        mToolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(3));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mFab.getLayoutParams();
        mFab.animate().translationY(0).setInterpolator(new DecelerateInterpolator(3));
    }
}
