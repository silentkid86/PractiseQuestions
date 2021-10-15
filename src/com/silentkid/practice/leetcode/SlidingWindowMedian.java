package com.silentkid.practice.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> min = new PriorityQueue<>();

    public double[] findSlidingWindowMedian(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        for(int i=0; i < nums.length ; i++){
            //add to heaps
            max.offer(nums[i]);
            min.offer(max.poll());

            if(min.size() > max.size()){
                max.offer(min.poll());
            }

            if(max.size() + min.size() >= k ){
                // find median
                double median;
                if(max.size() > min.size()){
                    median = max.peek();
                }else{
                    median = ((double)min.peek() + (double)max.peek()) / 2;
                }
                res[i - k + 1] = median;

                //remove the last element extreme left before next run
                int toRemove = nums[i - k + 1];
                if(toRemove <= max.peek() ){
                    max.remove(toRemove);
                }else{
                    min.remove(toRemove);
                }

                //rebalance
                if(max.size() > min.size() + 1){
                    min.offer(max.poll());
                }else if(min.size() > max.size()){
                    max.offer(min.poll());
                }

            }

        }
        return res;
    }

    public static void main(String[] args)
    {
        int arr[] = { 1, 2, -1, 3, 5 };
        int k = 3;
        SlidingWindowMedian win = new SlidingWindowMedian();
        double[] res = win.findSlidingWindowMedian(arr, k);
        Arrays.stream(res).forEach(i -> System.out.print( i + " "));
    }
}
