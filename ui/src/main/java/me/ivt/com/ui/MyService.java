package me.ivt.com.ui;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;


public class MyService extends Service {
    
    private OnProgessUpdateListener mOnProgessUpdateListener;
    
    public void setOnProgessUpdateListener(OnProgessUpdateListener onProgessUpdateListener) {
        mOnProgessUpdateListener = onProgessUpdateListener;
    }
    
    public interface OnProgessUpdateListener {
        void onProgressUpdate(int progress);
    }
    
    public class MyBinder extends Binder {
        public MyService getService() {
            return MyService.this;
        }
    }
    
    @Override
    public void onCreate() {
        super.onCreate();
    }
    
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                for (int i = 0; i < 100; i++) {
                    if (mOnProgessUpdateListener != null) {
                        mOnProgessUpdateListener.onProgressUpdate(i);
                    }
                }
            }
        }.start();
        return super.onStartCommand(intent, flags, startId);
    }
    
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }
}
