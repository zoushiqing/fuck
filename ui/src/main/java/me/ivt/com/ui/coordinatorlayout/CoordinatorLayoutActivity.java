package me.ivt.com.ui.coordinatorlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import java.util.ArrayList;

import me.ivt.com.ui.DividerDecoration;
import me.ivt.com.ui.R;

public class CoordinatorLayoutActivity extends AppCompatActivity {
    private RecyclerView mRv;
    private Toolbar mToolbar;
    
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout2);
        mRv = (RecyclerView) findViewById(R.id.tv);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("CoordinateLayout");
        setSupportActionBar(mToolbar);
        ArrayList<String> mStrings = new ArrayList<>();
        for (int i = 'A'; i <= 'Z'; i++) {
            mStrings.add("当前是数据--------------->" + (char) i);
        }
        for (int i = 'A'; i <= 'Z'; i++) {
            mStrings.add("当前是数据--------------->" + (char) i);
        }
        mRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRv.addItemDecoration(new DividerDecoration(this,LinearLayout.VERTICAL));
        mRv.setAdapter(new CoordninatorRecyAdapter(mStrings));
    }
}
