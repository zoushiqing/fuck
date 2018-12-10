package peropt.me.com.performaceoptimization.performanceOptimization;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import peropt.me.com.performaceoptimization.R;


public class PerformanceMainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performance_main);
        //单利模式导致内存对象无法释放而导致内存泄漏
        CommUtil commUtil=CommUtil.getInstacnce(this);
    }
}
