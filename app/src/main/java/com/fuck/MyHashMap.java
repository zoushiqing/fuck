package com.fuck;

import java.util.Set;

/**
 * desc:
 */
public class MyHashMap<K, V> implements MyMap {
    //默认容量 为16
    public final int DEFAULT_CAPACITY = 16;
    //内部结构
    Node[] table = new Node[DEFAULT_CAPACITY];
    //长度
    private int size = 0;
    //keySet
    Set<K> keySet;
    
    
    @Override
    public int size() {
        return this.size;
    }
    
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    @Override
    public Object get(Object key) {
        int hashValue = hash(key);
        int i = indexFor(hashValue, table.length);
        for (Node node = table[i]; node != null; node = node.next) {
            if (node.key.equals(key) && hashValue == node.hash) {
                return node.value;
            }
        }
        return null;
    }
    
    //获取插入的位置
    public int indexFor(int hashValue, int length) {
        return hashValue % length;
    }
    
    //获取hash值
    public int hash(Object key) {
        return key.hashCode();
    }
    
    @Override
    public Object put(Object key, Object value) {
        //通过Key，求hash值
        int hashValue = hash(key);
        //通过hash，找到这个key应该在的位置
        int i = indexFor(hashValue, table.length);
        //i位置已经有数据了，往链表添加数据
        for (Node node = table[i]; node != null; node = node.next) {
            Object k = null;
            //且数组中有这个key，覆盖其value
            if (node.hash == hashValue && (k = node.key) == key || key.equals(k)) {
                Object oldValue = node.value;
                node.value = value;
                //返回oldValue
                return oldValue;
            }
        }
        //如果i位置么有数据，或i位置有数据，但是key是新的key，新增节点
        addEntry(key, value, hashValue, i);
        return null;
    }
    
    private void addEntry(Object key, Object value, int hashValue, int i) {
        //如果超过了原数组的大小，则扩大数组
        if (++size == table.length) {
            Node[] newTable = new Node[table.length * 2];
            System.arraycopy(table, 0, newTable, 0, table.length);
            table = newTable;
        }
        Node node = table[i];
        table[i] = new Node(hashValue, key, value, node);
    }
    
    //静态内部类：Node节点实现Entry接口
    static class Node implements MyMap.Entry {
        int hash;//hash值
        Object key;//key
        Object value;//value
        Node next;//指向下一个节点(但例表)
        
        public Node(int hash, Object key, Object value, Node next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
        
        @Override
        public Object getKey() {
            return this.key;
        }
        
        @Override
        public Object getValue() {
            return this.value;
        }
    }
}
