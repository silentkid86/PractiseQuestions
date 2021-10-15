package com.silentkid.practice.leetcode;

public class FindKthLargestElement {

    public static int findKthLargest(int[] nums, int k) {

        int n = nums.length ;
        quickSelect(nums, 0, n - 1, n - k);

        return nums[n-k];

    }

    public static void quickSelect(int[] nums, int l, int h, int k){

        if(l == h){
            return;
        }

        int pivotIndex = partition(nums,l,h);

        if(pivotIndex == k){
            return;
        }else if(pivotIndex > k){
            //go left
            quickSelect(nums, l, pivotIndex-1, k);
        }else{
            //go right
            quickSelect(nums, pivotIndex+1, h, k);
        }

    }

    private static int partition(int[] nums, int l, int h) {
        int pivotValue = nums[h];
        int pivotIndex = l;
        // move all smaller elements to the left
        for(int i = l ; i <= h ; i++ ){
            if(nums[i] < pivotValue){
                swap(nums,pivotIndex,i);
                pivotIndex++;
            }
        }
        swap(nums,pivotIndex,h);

        return pivotIndex;
    }

    private static void swap(int[] nums,int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] argz){

        int[] nums={3,2,3,1,2,4,5,5,6};

        int kth=findKthLargest(nums,4);

        System.out.println(kth);
    }
}
