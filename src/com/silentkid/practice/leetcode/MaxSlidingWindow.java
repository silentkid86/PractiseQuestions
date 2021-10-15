package com.silentkid.practice.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int[] maxes = new int[nums.length - k + 1];
        int i = 0;
        for(; i < k ;i++){
            while(dq.size() != 0 && nums[i] >= nums[dq.peekLast()]){
                dq.removeLast();
            }

            dq.addLast(i);
        }


        while(i < nums.length){

            maxes[i - k] = nums[dq.peek()];

            //i - k is the last window size index
            while(dq.size() != 0 && dq.peek().intValue() <= i - k){
                dq.removeFirst();
            }

            while(dq.size() != 0 && nums[i] >= nums[dq.peekLast()]){
                dq.removeLast();
            }

            dq.addLast(i);

            i++;
        }

        maxes[i - k] = nums[dq.peek()];

        return maxes;
    }

    public static void main(String[] args)
    {
        int arr[] = { 12, 1, 78, 90, 57, 89, 56 };
        int k = 3;
        int[] res = maxSlidingWindow(arr, k);
        Arrays.stream(res).forEach(i -> System.out.print( i + " "));
    }
}
