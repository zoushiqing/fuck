package peropt.me.com.performaceoptimization;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    public  volatile int inc=0;
    public  void increase(){
        if (inc==0){
            inc++;
            inc--; 
        }
       
    }
    @Test
    public void addition_isCorrect() {
        final ExampleUnitTest exampleUnitTest=new ExampleUnitTest();
        for (int i = 0; i < 10; i++) {
            new Thread(){
                @Override
                public void run() {
                    super.run();
                    for (int i1 = 0; i1 < 100000; i1++) {
                        exampleUnitTest.increase();
                    }
                }
            }.start();
        }
        if (Thread.activeCount()>1) {
            Thread.yield();
        }
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(exampleUnitTest.inc);
    }
    
    
    
}