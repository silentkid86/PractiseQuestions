package com.silentkid.practice.leetcode;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int maxarea = 0;

        int lpointer = 0;
        int rpointer = height.length - 1;
        while(lpointer < rpointer){
            int currentMaxArea = Math.min(height[lpointer],height[rpointer]) * (rpointer - lpointer);
            if(currentMaxArea > maxarea){
                maxarea = currentMaxArea;
            }
            if(height[lpointer] > height[rpointer]){
                rpointer--;
            }else{
                lpointer++;
            }

        }

        return maxarea;
    }

    public static void main(String[] argz){
        int result = maxArea(new int[]{4,3,2,1,4});
        System.out.println(result);
    }
}
