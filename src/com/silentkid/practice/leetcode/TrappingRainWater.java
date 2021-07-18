package com.silentkid.practice.leetcode;

public class TrappingRainWater {
    public static int trap(int[] height) {
        int[] cheight = new int[height.length];
        int maxheight = 0;
        for(int i  = 0 ; i < height.length ; i++){

            maxheight = Math.max(maxheight , height[i]);
            cheight[i] = maxheight;

        }
        maxheight = 0;
        for(int i  = height.length - 1 ; i >= 0 ; i--){

            maxheight = Math.max(maxheight , height[i]);
            cheight[i] = Math.min(cheight[i],maxheight);

        }
        int sum = 0;
        for(int i  = 0 ; i < height.length ; i++){

            sum += cheight[i] - height[i];

        }

        printArray(cheight);

        return sum;
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] argx){
        int[] arr = new int[]{4,2,0,3,2,5};
        int result = trap(arr);

        System.out.println(result);
    }

}
