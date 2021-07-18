package com.silentkid.practice.leetcode;

public class NeighbourDistributeCandy {

    public static int distributeCandies(int[] candyType) {
        int[] candy=new int[candyType.length];

        for(int i=0; i < candy.length; i++){
            candy[i] = 1;
        }

        for(int i=candy.length - 1; i > 0  ;i--){
            if(candyType[i - 1] > candyType[i]) {
                candy[i - 1] = candy[i] + 1;
            }
        }

        for(int i= 0; i < candy.length - 1  ;i++){
            if(candyType[i + 1] > candyType[i]) {
                candy[i + 1] = Math.max(candy[i + 1],candy[i] + 1);
            }
        }
        int sum = 0;
        for(int i=0; i < candy.length; i++){
            sum += candy[i];
        }

        return sum;
    }


    public static void main(String[] argx){
        //[[3,4],[1,2],[2,4],[3,5],[2,5]]
        //[[9,10],[5,8],[2,6],[1,5],[3,8],[4,9],[8,10],[4,10],[6,8],[7,9]]
        int[] arr={ 5,4,3,2,1,0};

        int result=distributeCandies(arr);
        System.out.print(result);
        //printArray(result);
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}
