package peropt.me.com.performaceoptimization.performanceOptimization;

import android.content.Context;

/**
 * desc:
 */
public class CommUtil {
    private static CommUtil instacnce;
    private Context mContext;
    
    private CommUtil(Context context) {
        mContext = context;
    }
    
    public static CommUtil getInstacnce(Context context) {
        if (instacnce == null) {
            synchronized (CommUtil.class) {
                if (instacnce == null) {
                    instacnce = new CommUtil(context);
                }
            }
        }
        return instacnce;
    }
}
