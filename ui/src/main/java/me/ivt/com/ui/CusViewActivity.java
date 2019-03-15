package me.ivt.com.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;

public class CusViewActivity extends AppCompatActivity {
    private MyService mMyService;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cus_view);
        Intent intent = new Intent(this, MyService.class);
        bindService(intent, mServiceConnection, BIND_AUTO_CREATE);
    }
    
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.MyBinder myBinder = (MyService.MyBinder) service;
            mMyService = myBinder.getService();
            mMyService.setOnProgessUpdateListener(new MyService.OnProgessUpdateListener() {
                @Override
                public void onProgressUpdate(int progress) {
        
                }
            });
        }
        
        @Override
        public void onServiceDisconnected(ComponentName name) {
            
        }
    };
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
