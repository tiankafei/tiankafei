package com.googlecode.aviator.utils;

import java.util.LinkedHashMap;


/**
 * Thread-safe LRU map
 *
 * @param <K>
 * @param <V>
 * @author apple
 */
public class SyncLruMap<K, V> extends LinkedHashMap<K, V> {
    static final long serialVersionUID = -1L;

    private int maxCapacity;


    public SyncLruMap(int maxCapacity) {
        super(16, 0.75f, true);
        this.maxCapacity = maxCapacity;

    }


    @Override
    public synchronized V remove(Object key) {
        return super.remove(key);
    }


    @Override
    public synchronized int size() {
        return super.size();
    }


    @Override
    public synchronized V put(K k, V v) {
        return super.put(k, v);
    }


    @Override
    public synchronized V get(Object k) {
        return super.get(k);
    }


    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
        return this.size() > this.maxCapacity;
    }

}
