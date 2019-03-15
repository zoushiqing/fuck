package me.ivt.com.ui.filter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MaskFilterActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MaskFilterView maskFilter=new MaskFilterView(this);
        setContentView(maskFilter);
    }
}
