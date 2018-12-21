package com.fuck;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    /**
     * HashMap的底层主要是通过数组和链表来实现的，hashMap中通过Ke的hashCode来计算hash值的，由这个hash值计算在数组中的位置
     * 将新插入的元素放在数组的这个位置，如果新插入的元素的hash值跟这个位置已有元素的hash值相同，就会出现hash冲突，这时候，
     * 就在该位置通过链表来插入新的元素
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HashMap hashMap=new HashMap();
        
    }
}
