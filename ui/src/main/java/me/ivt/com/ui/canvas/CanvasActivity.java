package me.ivt.com.ui.canvas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class CanvasActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }
}
