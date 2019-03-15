package me.ivt.com.ui;

import org.junit.Test;

import java.io.IOException;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    
    @Test
    public void addition_isCorrect() throws IOException {
        MyObject myObject=new MyObject();
        new ThreadB(myObject).start();
        new ThreadA(myObject).start();
    }
    
    public class MyObject{
           public void methodA(){
            System.out.println("执行了AAAAAAAAAAAAAA");
        }
         public void methodB(){
            System.out.println("执行了BBBBBBBBBBBBBB");
        }
    }
    public class ThreadA extends Thread{
        private MyObject mMyObject;
        public ThreadA(MyObject myObject){
            mMyObject=myObject;
        }
    
        @Override
        public void run() {
            super.run();
            while (true){
                mMyObject.methodA();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public class ThreadB extends Thread{
        private MyObject mMyObject;
        public ThreadB(MyObject myObject){
            mMyObject=myObject;
        }
        
        @Override
        public void run() {
            super.run();
            while (true){
                mMyObject.methodB();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}