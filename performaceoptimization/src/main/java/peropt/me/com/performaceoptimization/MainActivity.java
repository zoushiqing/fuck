package peropt.me.com.performaceoptimization;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView=null;
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
        
            }
        });
        textView.getViewTreeObserver().removeOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
        
            }
        });
        MyHandler myHandler = new MyHandler(this);
    }
    
    private static class MyHandler extends Handler {
        WeakReference<MainActivity> mMainActivityWeakReference;
        
        private MyHandler(MainActivity mainActivity) {
            mMainActivityWeakReference = new WeakReference<>(mainActivity);
        }
        
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    MainActivity mainActivity = mMainActivityWeakReference.get();
                    if (mainActivity != null) {
                        System.out.println("不错哟");
                    }
                    break;
            }
        }
    }
    
    private static final Runnable RUNNABLE = new Runnable() {
        @Override
        public void run() {
            
        }
    };
    /**
     * GPU刷新：GPU帮我们将UI等组件计算出成纹理Textrue和三维图形Polygons
     * 同时会使用OpenGL------会将纹理和polygons缓存在GPU内存里面
     * Refresh rate
     * viewTree：
     */
}
