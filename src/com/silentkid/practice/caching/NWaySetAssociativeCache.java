package com.silentkid.practice.caching;

public class NWaySetAssociativeCache<K, V> implements Cache<K, V> {
    CacheBlock<K, V>[] cacheBlocks;
    int cacheBlockNum;
    int cacheBlockSize;
    private RecencyPolicy<K> policy;

    public NWaySetAssociativeCache(int blockNum, int blockSize, RecencyPolicy<K> policy) {
        this.cacheBlockNum = blockNum;
        this.cacheBlockSize = blockSize;
        this.policy = policy;

        initialize();
    }

    private void initialize() {
        cacheBlocks = new CacheBlock[this.cacheBlockNum];
        for (int i = 0; i < cacheBlocks.length; i++) {
            cacheBlocks[i] = new CacheBlock<>(cacheBlockSize,policy);
        }
    }

    @Override
    public void put(K key, V value) {
        int blockIndex = getBlockIndex(key);
        cacheBlocks[blockIndex].put(key, value);
    }

    @Override
    public V get(K key) {
        int blockIndex = getBlockIndex(key);
        return cacheBlocks[blockIndex].get(key);
    }

    private int getBlockIndex(K key) {
        return key.hashCode() % this.cacheBlockNum;
    }
}
