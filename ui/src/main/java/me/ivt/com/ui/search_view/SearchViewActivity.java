package me.ivt.com.ui.search_view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import me.ivt.com.ui.R;

public class SearchViewActivity extends AppCompatActivity {
    private MySearchView mMySearchView;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);
        mMySearchView = (MySearchView) findViewById(R.id.my_searchView);
        mMySearchView.setBaseController(new Controller1());
    }
    
    
    public void go1(View view) {
        mMySearchView.startAnimation();
    }
    
    public void go2(View view) {
        mMySearchView.resetAnimation();
    }
}
