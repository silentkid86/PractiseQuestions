package com.silentkid.practice.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    final PriorityQueue<Integer> lo ;
    final PriorityQueue<Integer> hi ;

    public MedianFinder() {
        lo = new PriorityQueue<>(Collections.reverseOrder());
        hi = new PriorityQueue<>();
    }

    public void addNum(int num) {
        lo.add(num);
        hi.add(lo.poll());

        if(hi.size() > lo.size()){
            lo.offer(hi.poll());
        }

    }

    public double findMedian() {
        double median = 0.0;
        if(lo.size() > hi.size()){
            median = lo.peek();
        }else{
            median = ((double)hi.peek() + (double)lo.peek())/2;
        }

        return median;
    }

    public static void main(String[] args){
        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(3);    // arr = [3]
        double res = medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
        System.out.println(res);
        medianFinder.addNum(4);    // arr = [3, 4]
        res = medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
        System.out.println(res);
        medianFinder.addNum(32);    // arr[3, 4, 2]
        res = medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
        System.out.println(res);
        medianFinder.addNum(1);    // arr[3, 4, 2, 1]
        res = medianFinder.findMedian(); // return 2.0

        System.out.println(res);

    }
}
