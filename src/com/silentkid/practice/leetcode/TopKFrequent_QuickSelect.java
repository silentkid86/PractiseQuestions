package com.silentkid.practice.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

public class TopKFrequent_QuickSelect {
    static HashMap<Integer, Integer> freq = null;
    static int[] unique;

    public static int[] topKFrequent(int[] nums, int k) {
        //build Hash map of frequency
        freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // array of unique elements
        unique = new int[freq.size()];
        int i = 0;
        for (int num: freq.keySet()) {
            unique[i] = num;
            i++;
        }

        //Quick Selection
        int n = freq.size() - 1 ;
        quickSelect(0, n, n - k );

        return Arrays.copyOfRange(unique, n-k +1 , n + 1);

    }

    private static void quickSelect(int left, int right, int k) {
        /*
        Sort a list within left..right till kth less frequent element
        takes its place.
        */

        if (left == right) return;

        int pivotIndex = partition(left,right);

        if(k == pivotIndex ) {
            return;
        }else if(k < pivotIndex){
            //first half
            quickSelect(left,pivotIndex-1,k);

        }else{
            //second half
            quickSelect(pivotIndex+1,right,k);
        }
    }

    private static int partition(int left, int right) {

        int pivotValue = freq.get(unique[right]);
        int pivotIndex = left;

        for(int i = left ; i <= right ; i++){
            if(freq.get(unique[i]) < pivotValue){
                swap(pivotIndex , i);
                pivotIndex++;
            }

        }
        //move the pivotValue to its rightful place
        swap(pivotIndex,right);

        return pivotIndex;
    }

    private static void swap(int a, int b) {
        int cnt = unique[a];
        unique[a] = unique[b];
        unique[b] = cnt;
    }

    public static void main(String[] argz) {
        int[] nums = {1, 1, 1, 2, 2, 3,4, 5, 6};

        int[] ans = topKFrequent(nums, 2);
        IntStream.of(ans).forEach(System.out::print);
    }

}
