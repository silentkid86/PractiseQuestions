package com.silentkid.practice.caching;

import java.util.concurrent.ConcurrentLinkedDeque;

public class MruRecencyPolicy<K> implements RecencyPolicy<K> {
    ConcurrentLinkedDeque<K> queue;

    public MruRecencyPolicy(){
        queue = new ConcurrentLinkedDeque<>();
    }

    @Override
    public void onGet(K key) {
        updateMruQueue(key);
    }

    @Override
    public void onPut(K key) {
        updateMruQueue(key);
    }

    private void updateMruQueue(K key){
        queue.remove(key);
        queue.add(key);
    }

    @Override
    public K getEvictCandidate() {
        return queue.getLast();
    }

    @Override
    public int getSize() {
        return queue.size();
    }
}
