package com.silentkid.practice.leetcode;

import java.util.HashSet;

public class CandyType {
    public static int distributeCandies(int[] candyType) {
        HashSet<Integer> set = new HashSet<>();
        for(int candy : candyType){
            set.add(candy);
        }

        return set.size() > candyType.length/2 ?  candyType.length/2 : set.size();
    }

    public static void main(String[] argx){
        //[[3,4],[1,2],[2,4],[3,5],[2,5]]
        //[[9,10],[5,8],[2,6],[1,5],[3,8],[4,9],[8,10],[4,10],[6,8],[7,9]]
        int[] arr={ 5,4,3,2,1,0};

        int result=distributeCandies(arr);
        System.out.print(result);
        //printArray(result);
    }
}
