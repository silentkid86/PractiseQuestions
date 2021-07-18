package com.silentkid.practice.caching;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheBlock<K,V> implements Cache<K,V>{
    private final int cacheSize;
    ConcurrentHashMap<K,V> cache;
    RecencyPolicy<K> recencyPolicy;
    ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();

    public CacheBlock(int cacheSize,RecencyPolicy<K> recencyPolicy){
        this.recencyPolicy = recencyPolicy;
        this.cacheSize = cacheSize;
        cache = new ConcurrentHashMap<>(cacheSize);
    }


    @Override
    public void put(K key, V value) {
        rwlock.writeLock().lock();
        try {
            if (!cache.contains(key) && cache.size() > cacheSize) {
                K candidateKey = recencyPolicy.getEvictCandidate();
                System.out.printf("PUT %s, Evicting %s.\n", key,  candidateKey);
                cache.remove(candidateKey);
            }

            cache.putIfAbsent(key, value);
            recencyPolicy.onPut(key);
        }finally {
            rwlock.writeLock().unlock();
        }
        System.out.printf("PUT %s :Size of the recency policy is %s.\n" , key ,recencyPolicy.getSize());
        System.out.printf("PUT %s :Size of the hashmap is %s.\n" ,key ,cache.size());

    }

    @Override
    public V get(K key) {
        rwlock.readLock().lock();
        try{
            V value = cache.get(key);
            /**
             * Change point for Write Through cache here.
             */
            if(null == value){
                throw new CacheMissException("Key missed" + key);
            }
            recencyPolicy.onGet(key);
            System.out.printf("GET %s:Size of the recency policy is %s.\n" , key  ,recencyPolicy.getSize());
            System.out.printf("GET %s:Size of the hashmap is %s.\n" , key ,cache.size());
            return value;
        }finally {
            rwlock.readLock().unlock();
        }

    }
}
