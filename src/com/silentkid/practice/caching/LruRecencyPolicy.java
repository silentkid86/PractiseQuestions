package com.silentkid.practice.caching;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LruRecencyPolicy<K> implements RecencyPolicy<K> {
    ConcurrentLinkedQueue<K> queue;

    public LruRecencyPolicy(){
        queue = new ConcurrentLinkedQueue<>();
    }

    @Override
    public void onGet(K key) {
        updateLruQueue(key);
    }

    @Override
    public void onPut(K key) {
        updateLruQueue(key);
    }

    private void updateLruQueue(K key){
        queue.remove(key);
        queue.add(key);
    }

    @Override
    public K getEvictCandidate() {
        K head = queue.poll();
        return head;
    }

    @Override
    public int getSize() {
        return queue.size();
    }
}
