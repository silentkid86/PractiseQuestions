package com.silentkid.practice.recursive;

public class MaxSubArraySum {

    public static void main(String[] args)
    {
        int arr[] = { -2, -5, 6, -2, -3, 1, 5, -6 };
        int n = arr.length;
        maxSubArraySum(arr, 0, n - 1);

        printArray(arr);
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    private static void maxSubArraySum(int[] arr, int l, int h) {
        if(l < h){
            int middle = (l + h) / 2;

            maxSubArraySum(arr , l , middle);
            maxSubArraySum(arr , middle + 1 , h);

            maxCrossSubArray(arr , l , middle ,h);
        }

    }

    private static void maxCrossSubArray(int[] arr, int l, int m, int h) {
        int leftSize = m - l + 1;
        int rightSize = h + 1 - (m + 1);  // h - m

        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        for(int f = 0; f < leftSize ; f++){
            left[f] = arr[l + f];
        }
        for(int f=0;f < rightSize; f++){
            right[f] = arr[m + 1 + f];
        }

        int current = l;
        int leftC = 0;
        int rightC = 0;
        while(leftC < leftSize && rightC < rightSize){
            if(left[leftC] <= right[rightC]){
                arr[current] = left[leftC];
                leftC++;
            }else{
                arr[current] = right[rightC];
                rightC++;
            }
            current++;
        }

        while(leftC < leftSize){
            arr[current] = left[leftC];
            current++;
            leftC++;
        }
        while(rightC < rightSize){
            arr[current] = right[rightC];
            current++;
            rightC++;
        }

    }
}
