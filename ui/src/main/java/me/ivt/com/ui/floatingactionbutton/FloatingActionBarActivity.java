package me.ivt.com.ui.floatingactionbutton;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import me.ivt.com.ui.R;

public class FloatingActionBarActivity extends AppCompatActivity {
    private ListView mListView;
    private FloatingActionButton mFloatingbar;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_action_bar);
        mListView = (ListView) findViewById(R.id.lv);
        
        List<String> mStrings = new ArrayList<>();
        for (int i = 'A'; i <= 'Z'; i++) {
            mStrings.add("当前是数据--------------->" + (char) i);
            
        }
        mListView = (ListView) this.findViewById(R.id.lv);
        mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStrings));
        mFloatingbar = (FloatingActionButton) findViewById(R.id.floatingbar);
    }
}
