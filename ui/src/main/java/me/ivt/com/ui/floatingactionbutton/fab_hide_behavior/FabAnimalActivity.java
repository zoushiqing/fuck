package me.ivt.com.ui.floatingactionbutton.fab_hide_behavior;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;

import me.ivt.com.ui.DividerDecoration;
import me.ivt.com.ui.R;

public class FabAnimalActivity extends AppCompatActivity{
    private RecyclerView mRv;
    private Toolbar mToolbar;
    private ImageButton mFab;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab_animal_behavior);
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
    }
    
}
