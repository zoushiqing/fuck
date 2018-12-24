package me.ivt.com.ui.palette;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import me.ivt.com.ui.R;

public class TranslationToolbarActivity extends AppCompatActivity implements OnScrollListener {
    
    private Toolbar mToolbar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation_toolbar);
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        MyScrollerView myScrollerView = findViewById(R.id.scrollView);
        myScrollerView.setOnScrollListener(this);
    }
    
    @Override
    public void onScroll(float alpha) {
        mToolbar.setAlpha(alpha);
    }
}
