package com.silentkid.practice.leetcode;

import java.util.LinkedList;
import java.util.List;

// [[1,3],[2,6],[8,10],[15,18]]
// [[2,4],[7,8],[11,13],[20,25] ]
public class MergeTwoSortedIntervalList {

    public List<Integer[]> merge(int[][] intervals1,int[][] intervals2) {

        List<Integer[]> res = new LinkedList<>();

        int[] itv = new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE};
        int p1 = 0;
        int p2 = 0;

        int maxTime = Integer.MIN_VALUE;
        
        while(p1 < intervals1.length || p2 < intervals2.length){
            int[] i1 = p1 < intervals1.length ? intervals1[p1] : new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE};
            int[] i2 = p2 < intervals2.length ? intervals2[p2] : new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE};

            int start = -1;
            int end = -1;
            if(i1[1] < i2[0] || i2[1] < i1[0]){
                start = Math.min(i1[0],i2[0]);
                end = Math.max(i2[1],i1[1]);

                p1++;
                p2++;
            }else if(i1[1] > i2[0]){
                start = i1[0];
                end = i1[1];
                p1++;
            }else{
                start = i2[0];
                end = i2[1];
                p2++;
            }

            if(maxTime > start){
                res.add(new Integer[]{itv[0],itv[1]});
                itv = new int[]{start,end};
                maxTime = end;
            }else{
                itv[0] = Math.min(start , itv[0]);
                itv[1] = Math.max(end, itv[1]);
                maxTime = itv[1];
            }


        }

        res.add(new Integer[]{itv[0],itv[1]});
        
        return res;
    }




}
