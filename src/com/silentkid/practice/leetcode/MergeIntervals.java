package com.silentkid.practice.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {

        PriorityQueue<int[]> pq = new PriorityQueue(intervals.length , ( x, y) -> {
            int[] a = (int[])x;
            int[] b = (int[])y;
            return a[0] - b[0];
        }  );

        for (int[] interval : intervals){
            pq.offer(interval);
        }

        List<int[]> res = new LinkedList<>();

        int currentMaxTime = 0;
        int[] currentInterval = null;
        while(!pq.isEmpty()){
            int[] period = pq.poll();

            if(currentInterval == null){
                currentInterval = period;
                currentMaxTime = period[1];
                continue;
            }
            //if start is over currentMaxTime -> new period
            if(period[0] > currentMaxTime){
                currentInterval[1] = currentMaxTime;
                res.add(currentInterval);

                currentMaxTime = period[1];
                currentInterval= period;

            }else{
                // if start still within currentMaxTime : continuing current period
                currentMaxTime = Math.max(period[1],currentMaxTime);
                currentInterval[1] = currentMaxTime;
            }

        }
        //IMPORTANT: doing this so not to miss the last one !
        res.add(currentInterval);
        int[][] result = new int[res.size()][2];


        return (int[][])res.toArray(result);
    }

    public static void main(String[] args) {

        int[][] intervals = {{1,4},{1,5},{7,9}};

        int[][] answers=  merge(intervals);

        for (int[] interval : answers) {
            System.out.println(interval[0] + " " +interval[1]);
        }
    }
}
