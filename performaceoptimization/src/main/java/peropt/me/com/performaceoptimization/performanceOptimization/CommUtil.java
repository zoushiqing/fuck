package peropt.me.com.performaceoptimization.performanceOptimization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * desc:
 */
public class CommUtil {
    private volatile static CommUtil instance;
    
    private CommUtil() {
        Lock lock = new ReentrantLock();
        lock.lock();
    }
    
    public static CommUtil getInstance() {
        if (instance == null) {
            synchronized (CommUtil.class) {
                if (instance == null) {
                    instance = new CommUtil();
                }
            }
        }
        return instance;
    }
    
    public static class intanceHandler {
        public static final CommUtil COMM_UTIL = new CommUtil();
    }
    
    public static CommUtil getInstance1() {
        return intanceHandler.COMM_UTIL;
    }
    
}
