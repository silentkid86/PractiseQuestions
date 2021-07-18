package com.silentkid.practice.caching;

public interface RecencyPolicy<K> {

    void onGet(K key);

    void onPut(K key);

    K getEvictCandidate();

    int getSize();
}
