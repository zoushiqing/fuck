package me.ivt.com.ui.snackbar;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import me.ivt.com.ui.R;

public class SnackbarActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);
    }
    
    public void go1(View view) {
        Toast result = new Toast(this);
        
        LayoutInflater inflate = (LayoutInflater)
                this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflate.inflate(R.layout.custom_toast, null);
        TextView tv = (TextView) v.findViewById(R.id.tv1);
        tv.setText("我是吐司");
        result.setView(v);
        result.setDuration(Toast.LENGTH_SHORT);
        result.show();
    }
    
    public void go2(View view) {
        Snackbar s = Snackbar.make(view, "是否打开GPS", Snackbar.LENGTH_LONG);
        s.setAction("确定", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SnackbarActivity.this, "哈哈哈哈哈", Toast.LENGTH_SHORT).show();      
            }
        });
        s.setCallback(new Snackbar.Callback(){
            @Override
            public void onDismissed(Snackbar transientBottomBar, int event) {
                super.onDismissed(transientBottomBar, event);
            }
    
            @Override
            public void onShown(Snackbar sb) {
                super.onShown(sb);
            }
            
        });
        s.show();
    }
    
    public void go3(View view) {
        
        
    }
    
    public void go4(View view) {
        
        
    }
}
