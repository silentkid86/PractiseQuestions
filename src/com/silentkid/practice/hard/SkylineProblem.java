package com.silentkid.practice.hard;

import java.util.*;

public class SkylineProblem {

    public static List<List<Integer>> getSkyline(int[][] buildings) {

        /**
         * 1.sort the buildings by X
         * 2.iterate thru the sorted buildings from X=0
         * 3.push building into a collection if it is at its start point
         * 4.pop building from collection if it is at its end point
         * 5.find the total max of the height of all buildings in the collection
         * 6.record change points whenever there is a change in height
         */

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                if(a1[2] == a2[2]) return 0;
                //max heap
                return a2[2] - a1[2];
            }
        });

        TreeMap<Integer,List<int[]>> treemap = new TreeMap<>();

        //push all points in sorted treemap
        for(int i =0 ; i < buildings.length ; i++){
            int start = buildings[i][0];
            int end = buildings[i][1];
            if(!treemap.containsKey(start)){
                List<int[]> list = new ArrayList<>();
                list.add(buildings[i]);
                treemap.put(start, list); //start
            }else{
                List<int[]> a=treemap.get(start);
                a.add(buildings[i]);
                treemap.put(start, a); //start
            }

            if(!treemap.containsKey(end)){
                List<int[]> list = new ArrayList<>();
                list.add(buildings[i]);
                treemap.put(end, list);
            }else{
                List<int[]> a=treemap.get(end);
                a.add(buildings[i]);
                treemap.put(end, a);
            }
        }

        Iterator<Map.Entry<Integer, List<int[]>>> iterator = treemap.entrySet().iterator();
        int height = 0;
        List<List<Integer>> list = new ArrayList<>();

        while(iterator.hasNext()){
            Map.Entry<Integer, List<int[]>> entry = iterator.next();
            List<int[]> towers = entry.getValue();
            Integer posX = entry.getKey();

            for(int[] arr : towers){
                if(arr[0] == posX){
                    //start index
                    pq.add(arr);
                }else{
                    //end index
                    pq.remove(arr);
                }

            }
            int new_height = -1;
            if(!pq.isEmpty()){
                int[] maxHeightTower = pq.peek();
                new_height = maxHeightTower[2];
                if(new_height != height){
                    height = new_height;
                    list.add(Arrays.asList(posX,height));
                }
            }else{
                new_height = 0;
                list.add(Arrays.asList(posX,new_height));
            }

        }

        return list;
    }

    public static void main(String[] argz) {
        int[][] testcase = {
                {2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}
        };

        List<List<Integer>> skyline = getSkyline(testcase);
        System.out.println(skyline);
    }
}
