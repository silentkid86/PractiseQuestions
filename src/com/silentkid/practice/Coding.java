package com.silentkid.practice;

import java.util.*;

public class Coding {

    public int solve(ArrayList<Integer> A, int B) {
        Collections.sort(A, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int sum = 0;
        for(int i = 0 ; i < B ; i++){
            Integer integer = A.get(i);
            sum += integer;
        }

        return sum;
    }

    public static ArrayList<Interval> merge(List<Interval> intervals) {
        TreeMap<Integer,List<Interval>> treeMap = new TreeMap();
        for (Interval interval : intervals) {
            treeMap.putIfAbsent(interval.start,new ArrayList<>());
            treeMap.putIfAbsent(interval.end,new ArrayList<>());
            treeMap.get(interval.start).add(interval);
            treeMap.get(interval.end).add(interval);
        }
        //iterate thru all points
        ArrayList<Interval> result = new ArrayList<>();

        Iterator<Map.Entry<Integer, List<Interval>>> iterator = treeMap.entrySet().iterator();
        List<Interval> currentInView = new ArrayList<>();
        int lastStartpt = Integer.MIN_VALUE;
        while(iterator.hasNext()){
            Map.Entry<Integer, List<Interval>> next = iterator.next();
            List<Interval> curr_intervals = next.getValue();
            int current_pos =next.getKey();
            for(Interval itv : curr_intervals){
                if(itv.start != itv.end){
                    if(itv.start == current_pos){
                        //start point of one interval
                        currentInView.add(itv);
                    }else{
                        //end point of an interval
                        currentInView.remove(itv);
                    }
                }

            }

            //keep start pt after reset
            if(lastStartpt == Integer.MIN_VALUE)
                lastStartpt = current_pos;

            if(currentInView.isEmpty()){
                result.add(new Interval(lastStartpt,current_pos));
                lastStartpt = Integer.MIN_VALUE;
            }


        }

        return result;
    }

    public static void main(String[] argz){
        ArrayList<Interval> arr = new ArrayList<>();
        arr.add(new Interval(1,10));
        arr.add(new Interval(6,6));
        arr.add(new Interval(2,9));

        System.out.println(merge(arr));
    }

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
