package com.silentkid.practice.ttd;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

class Solution {
    public static void main(String[] args) throws IOException {
        File f = new File("/Users/Tidus/Downloads/input004.txt");
        InputStream is = new FileInputStream(f);

        SetAssociativeCacheRunner.parseInput(is);
    }

    /**
     * Parses Test Case input to instantiate and invoke a SetAssociativeCache
     * <p>
     * NOTE: You can typically ignore anything in here. Feel free to collapse...
     */
    static class SetAssociativeCacheRunner {
        public static void parseInput(InputStream inputStream) throws IOException {
            InputStreamReader inputReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputReader);

            String line;
            int lineCount = 0;
            SetAssociativeCache<String, String> cache = null;

            while (!isNullOrEmpty(line = reader.readLine())) {
                lineCount++;
                OutParam<String> replacementAlgoName = new OutParam<>();

                if (lineCount == 1) {

                    cache = createCache(line, replacementAlgoName);

                } else {

                    // All remaining lines invoke instance methods on the SetAssociativeCache
                    Object retValue = SetAssociativeCacheFactory.InvokeCacheMethod(line, cache);

                    // Write the method's return value (if any) to stdout
                    if (retValue != null) {
                        System.out.println(retValue);
                    }
                }
            }
        }
    }

    private static SetAssociativeCache<String, String> createCache(String inputLine, OutParam<String> replacementAlgoName) {
        String[] cacheParams = Arrays.stream(inputLine.split(",")).map(s -> s.trim()).toArray(n -> new String[n]);
        int setCount = Integer.parseInt(cacheParams[0]);
        int setSize = Integer.parseInt(cacheParams[1]);
        replacementAlgoName.value = cacheParams[2];
        return SetAssociativeCacheFactory.CreateStringCache(setCount, setSize, replacementAlgoName.value);
    }


    // ############################ BEGIN Solution Classes ############################

    /**
     * NOTE: You are free to modify anything below, except for class names and generic interface.
     * Other public interface changes may require updating one or more of the helper classes above
     * for test cases to run and pass.
     * <p>
     * A Set-Associative Cache data structure with fixed capacity.
     * <p>
     * - Data is structured into setCount # of setSize-sized sets.
     * - Every possible key is associated with exactly one set via a hashing algorithm
     * - If more items are added to a set than it has capacity for (i.e. > setSize items),
     * a replacement victim is chosen from that set using an LRU algorithm.
     * <p>
     * NOTE: Part of the exercise is to allow for different kinds of replacement algorithms...
     */
    public static class SetAssociativeCache<TKey, TValue> {
        int Capacity;
        int SetSize;
        int SetCount;
        CacheSet<TKey, TValue>[] Sets;
        private long[] cutIndex;

        public SetAssociativeCache(int setCount, int setSize, String replacementAlgoName) {
            this.SetCount = setCount;
            this.SetSize = setSize;
            this.Capacity = this.SetCount * this.SetSize;

            // Initialize the sets
            this.Sets = new CacheSet[this.SetCount];
            for (int i = 0; i < this.SetCount; i++) {
                Sets[i] = new CacheSet<>(setSize,
                        ReplacementAlgoFactory.createReplacementAlgo(replacementAlgoName, this.SetSize));
            }
        }

        /**
         * Gets the value associated with `key`. Throws if key not found.
         */
        public TValue get(TKey key) {
            int setIndex = this.getSetIndex(key);
            CacheSet<TKey, TValue> set = this.Sets[setIndex];
            return set.get(key);
        }

        /**
         * Adds the `key` to the cache with the associated value, or overwrites the existing key.
         * If adding would exceed capacity, an existing key is chosen to replace using an LRU algorithm
         * (NOTE: It is part of this exercise to allow for more replacement algos)
         */
        public void set(TKey key, TValue value) {
            int setIndex = this.getSetIndex(key);
            CacheSet<TKey, TValue> set = this.Sets[setIndex];
            set.set(key, value);
        }

        /**
         * Returns the count of items in the cache
         */
        public int getCount() {
            int count = Arrays.stream(this.Sets).parallel()
                    .mapToInt(CacheSet::getCount)
                    .sum();
            return count;
        }

        /**
         * Returns `true` if the given `key` is present in the set; otherwise, `false`.
         */
        public boolean containsKey(TKey key) {
            int setIndex = this.getSetIndex(key);
            CacheSet<TKey, TValue> set = this.Sets[setIndex];
            return set.containsKey(key);
        }

        /**
         * Maps a key to a set by dividing the positive int space.
         */
        private int getSetIndex(TKey key) {
            int index = Math.abs(key.hashCode()) % this.SetCount;
            return index;
        }

    }

    /**
     * An internal data structure representing one set in a N-Way Set-Associative Cache
     */
    static class CacheSet<TKey, TValue> {
        int Capacity;
        private IReplacementAlgo<TKey> replacementAlgo;
        ConcurrentHashMap<TKey, TValue> Cache;

        public CacheSet(int capacity, IReplacementAlgo<TKey> replacementAlgo) {
            this.Capacity = capacity;
            this.replacementAlgo = replacementAlgo;
            this.Cache = new ConcurrentHashMap<>(capacity);
        }

        /**
         * Gets the value associated with `key`. Throws if key not found.
         */
        public TValue get(TKey key) {

            TValue value = Cache.getOrDefault(key, null);

            if (null != value) {
                this.replacementAlgo.onGet(key);
            } else {
                throw new RuntimeException(String.format("The key '%s' was not found", key));
            }

            return value;
        }

        /**
         * Adds the `key` to the cache with the associated value, or overwrites the existing key.
         * If adding would exceed capacity, an existing key is chosen to replace using an LRU algorithm
         * (NOTE: It is part of this exercise to allow for more replacement algos)
         */
        public void set(TKey key, TValue value) {
            //Not cached and cache is full.
            if (!Cache.containsKey(key) && Cache.size() >= this.Capacity) {
                TKey evictKey = this.replacementAlgo.getEvictCandidate();
                if(null != evictKey){
                    //prevent null pointer
                    Cache.remove(evictKey);
                }
            }

            Cache.put(key, value);
            this.replacementAlgo.onSet(key);
        }

        /**
         * Returns `true` if the given `key` is present in the set; otherwise, `false`.
         */
        public boolean containsKey(TKey key) {
            return Cache.containsKey(key);
        }

        public int getCount() {
            return Cache.size();
        }

    }

    /**
     * An internal data structure representing a single item in an N-Way Set-Associative Cache
     */
    static class CacheItem<TKey, TValue> {
        public TKey key;
        public TValue value;

        public CacheItem(TKey key, TValue value) {
            this.key = key;
            this.value = value;
        }
    }

    public final static String LruAlgorithm = "LRUReplacementAlgo";
    public final static String MruAlgorithm = "MRUReplacementAlgo";

    private static class Node<TKey> {
        TKey key_value;
        Node<TKey> next;
        Node<TKey> prev;

        public Node() {
            next = null;
            prev = null;
        }

        public Node(TKey key_value) {
            next = null;
            prev = null;
            this.key_value = key_value;

        }

    }

    /**
     * A list to maintain the access order by least recently used to most recently used.
     */
    private static class AccessOrderList<TKey> {
        Node<TKey> head = new Node<>();
        Node<TKey> tail = new Node<>();

        public AccessOrderList() {
            head.next = tail;
            tail.prev = head;
        }

        /**
         * passing in the reference of the node in the list.
         */
        public void justAccessed(Node<TKey> current) {
            //remove previous link
            if(null != current.next && null != current.prev){
                current.next.prev = current.prev;
                current.prev.next = current.next;
            }
            /**
             * adding to tail
             * 1.set current node point to tail and the existing last;
             * 2.set existing last to be second last.
             * 3.set tail pointing to current node.
             */
            current.next = tail;
            current.prev = tail.prev;
            tail.prev.next = current;
            tail.prev = current;

        }

        // AKA get Head
        public Node<TKey> removeLeastRecentlyUsed() {
            Node<TKey> front = head.next;

            //no item to return
            if(front.equals(tail)){
                return null;
            }

            front.next.prev = head;
            head.next = front.next;

            return front;
        }

        // AKA get Tail
        public Node<TKey> removeMostRecentlyUsed() {
            Node<TKey> rear = tail.prev;

            //no item to return
            if(rear.equals(head)){
                return null;
            }

            rear.prev.next = tail;
            tail.prev = rear.prev;

            return rear;
        }

    }

    /**
     * A common interface for replacement algos, which decide which item in a CacheSet to evict
     */
    interface IReplacementAlgo<TKey> {
        /**
         * Hook for Successful Get operation.
         */
        void onGet(TKey key);

        void onSet(TKey key);

        TKey getEvictCandidate();

        /**
         * For debugging purpose.
         */
        int getSize();
    }

    static class LRUReplacementAlgo<TKey> implements IReplacementAlgo<TKey> {
        private final ConcurrentHashMap<TKey, Node<TKey>> nodeMap;
        private final AccessOrderList<TKey> accessOrderList;

        ReentrantLock lock = new ReentrantLock();

        public LRUReplacementAlgo(int capacity) {
            this.nodeMap = new ConcurrentHashMap<>();
            this.accessOrderList = new AccessOrderList<>();
        }

        @Override
        public void onGet(TKey tKey) {
            lock.lock();
            try {
                Node<TKey> node = nodeMap.get(tKey);
                if(null != node){
                    updateRecency(node);
                }
            } finally {
                lock.unlock();
            }
        }

        @Override
        public void onSet(TKey tKey) {
            lock.lock();
            try {
                Node<TKey> newNode = new Node(tKey);
                if(null == nodeMap.putIfAbsent(tKey, newNode)){
                    //not being added by another node
                    updateRecency(newNode);
                }else{
                    //added by another node , so update recency only.
                    updateRecency(nodeMap.get(tKey));
                }
            } finally {
                lock.unlock();
            }
        }

        @Override
        public TKey getEvictCandidate() {
            lock.lock();
            try {
                Node<TKey> tKeyNode = accessOrderList.removeLeastRecentlyUsed();
                if(null == tKeyNode){
                    return null;
                }
                nodeMap.remove(tKeyNode.key_value);
                return tKeyNode.key_value;
            } finally {
                lock.unlock();
            }
        }

        private void updateRecency(Node<TKey> node) {
            accessOrderList.justAccessed(node);
        }

        @Override
        public int getSize() {
            return nodeMap.size();
        }
    }

    static class MRUReplacementAlgo<TKey> implements IReplacementAlgo<TKey> {
        private final ConcurrentHashMap<TKey, Node<TKey>> nodeMap;
        private final AccessOrderList<TKey> accessOrderList;

        ReentrantLock lock = new ReentrantLock();

        public MRUReplacementAlgo(int capacity) {
            this.nodeMap = new ConcurrentHashMap<>();
            this.accessOrderList = new AccessOrderList<>();
        }

        @Override
        public void onGet(TKey tKey) {
            lock.lock();
            try {
                Node<TKey> node = nodeMap.get(tKey);
                if(null != node){
                    updateRecency(node);
                }
            } finally {
                lock.unlock();
            }
        }

        @Override
        public void onSet(TKey tKey) {
            lock.lock();
            try {
                Node<TKey> newNode = new Node<>(tKey);
                if(null == nodeMap.putIfAbsent(tKey, newNode)){
                    //not being added by another node
                    updateRecency(newNode);
                }else{
                    //added by another node , so update recency only.
                    updateRecency(nodeMap.get(tKey));
                }
            } finally {
                lock.unlock();
            }

        }

        @Override
        public TKey getEvictCandidate() {
            lock.lock();
            try {
                Node<TKey> tKeyNode = accessOrderList.removeMostRecentlyUsed();
                if(null == tKeyNode){
                    return null;
                }
                nodeMap.remove(tKeyNode.key_value);
                return tKeyNode.key_value;
            } finally {
                lock.unlock();
            }
        }

        private void updateRecency(Node<TKey> node) {
            accessOrderList.justAccessed(node);
        }

        @Override
        public int getSize() {
            return nodeMap.size();
        }
    }

    // ############################ BEGIN Helper Classes ############################
    // NOTE: Your code in the classes below will not be evaluated as part of the exericse.
    // They are just used by the stub code in the header to help run HackerRank test cases.
    // You may need to make small modifications to these classes, depending on your interface design,
    // for tests to run and pass, but it is not a core part of the exercise
    //
    static class OutParam<T> {
        public T value;
    }

    private static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }

    public static class SetAssociativeCacheFactory {
        /// NOTE: replacementAlgoName is provided in case you need it here. Whether you do will depend on your interface design.
        public static SetAssociativeCache<String, String> CreateStringCache(int setCount, int setSize, String replacementAlgoName) {
            return new SetAssociativeCache<>(setCount, setSize, replacementAlgoName);
        }

        /// NOTE: Modify only if you change the main interface of SetAssociativeCache
        public static Object InvokeCacheMethod(String inputLine, SetAssociativeCache<String, String> cacheInstance) {
            String[] callArgs = Arrays.stream(inputLine.split(",", -1)).map(a -> a.trim()).toArray(n -> new String[n]);

            String methodName = callArgs[0].toLowerCase();
            //String[] callParams = Arrays.copyOfRange(callArgs, 1, callArgs.length - 1); // TODO: This is unused

            switch (methodName) {
                case "get":
                    return cacheInstance.get(callArgs[1]);
                case "set":
                    cacheInstance.set(callArgs[1], callArgs[2]);
                    return null;
                case "containskey":
                    return cacheInstance.containsKey(callArgs[1]);
                case "getcount":
                    return cacheInstance.getCount();

                // TODO: If you want to add and test other public methods to SetAssociativeCache,
                //  add them to the switch statement here... (this is not common)

                default:
                    throw new RuntimeException(String.format("Unknown method name '{%s}'", methodName));
            }
        }
    }

    // TODO: Consider making use of this in the `SetAssociativeCacheFactory` above to map replacement algo name
    // to a IReplacementAlgo instance for the interface you design
    public static class ReplacementAlgoFactory {
        static IReplacementAlgo createReplacementAlgo(String replacementAlgoName, int capacity) {
            switch (replacementAlgoName) {
                case LruAlgorithm:
                    return new LRUReplacementAlgo<String>(capacity);
                case MruAlgorithm:
                    return new MRUReplacementAlgo<String>(capacity);
                default:
                    // TODO: If you want to test other replacement algos, add them to the switch statement here...
                    throw new RuntimeException(String.format("Unknown replacement algo '%s'", replacementAlgoName));
            }
        }
    }

    // ^^ ######################### END Helper Classes ######################### ^^

}