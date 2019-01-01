package me.ivt.com.ui.cusbehavior;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import me.ivt.com.ui.R;

public class CusBehaivorActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cus_behaivor);
        TextView tv1 = (TextView)findViewById(R.id.tv1);
        tv1.setOnClickListener(new View.OnClickListener() {
        
            @Override
            public void onClick(View v) {
                ViewCompat.offsetTopAndBottom(v, 9);
            }
        });
    }
}
