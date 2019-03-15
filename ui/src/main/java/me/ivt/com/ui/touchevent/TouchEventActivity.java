package me.ivt.com.ui.touchevent;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import me.ivt.com.ui.R;

public class TouchEventActivity extends AppCompatActivity {
    private NestedScrollView mSv;
    private ListView mLv;
    
    
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_event);
        mSv = (NestedScrollView) findViewById(R.id.sv);
        mLv = (ListView) findViewById(R.id.lv);
        List<String> mStrings = new ArrayList<>();
        for (int i = 'A'; i <= 'Z'; i++) {
            mStrings.add("当前是数据--------------->" + (char) i);
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mStrings);
        mLv.setAdapter(arrayAdapter);
    }
}
