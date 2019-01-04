package me.ivt.com.ui.parallax;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import me.ivt.com.ui.R;

public class ParallaxActivity extends AppCompatActivity {
    
    private ParallaxContainer mParallaxContainer;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parallax);
        mParallaxContainer = findViewById(R.id.parallax_container);
        
        mParallaxContainer.setUp();
    }
}
