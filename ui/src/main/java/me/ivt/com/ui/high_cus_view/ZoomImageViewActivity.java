package me.ivt.com.ui.high_cus_view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ZoomImageViewActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyRadialGradient zoomImageview = new MyRadialGradient(this);
        setContentView(zoomImageview);
//        setContentView(R.layout.activity_zoom_image_view);
    }
}
