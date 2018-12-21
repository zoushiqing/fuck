package com.fuck;

/**
 * desc:
 */
public interface MyMap<K, V> {
    //大小
    int size();
    
    //是否为空
    boolean isEmpty();
    
    //根据Key获取元素
    Object get(Object key);
    
    //添加元素
    Object put(Object key, Object value);
    
    interface Entry<K, V> {
        K getKey();
        
        V getValue();
    }
}
