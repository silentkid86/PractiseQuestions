package com.silentkid.practice.leetcode;

/*
https://leetcode.com/problems/maximum-subarray/
 */
public class Maximum_Subarray {

    public static int maxSubArray(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }

        int max = nums[0];
        int sum = nums[0];

        //Kadane Algorithm
        for(int i = 1 ; i < nums.length ; i++){
            //decide based on if adding this number improves the total
            if(sum + nums[i] > nums[i]){
                //continue sequence
                sum += nums[i];
            }else{
                //init a new sequence
                sum = nums[i];
            }

            max = Math.max(sum,max);

        }


        return max;

    }

//    public static int recursiveCount(int[] nums, int low, int high){
//
//        if(low == high){
//            return nums[low];
//        }
//
//        int mid = ( low + high ) / 2;
//        //left half
//        int maxLeft = recursiveCount(nums, low , mid);
//
//        //right half
//        int maxRight = recursiveCount(nums, mid + 1, high);
//
//        int maxFromEither = Math.max(maxLeft,maxRight);
//        int maxFromBoth = maxLeft + maxRight ;
//        if(maxFromBoth > maxFromEither){
//            int leftSum = nums[low], rightSum = nums[mid+1];
//            for(int i = low + 1 ; i <= mid;i++){
//                leftSum += nums[i];
//            }
//            for(int i = mid + 2 ; i <= high;i++){
//                rightSum += nums[i];
//            }
//            maxFromBoth = leftSum + rightSum;
//        }
//        return maxFromBoth > maxFromEither ? maxFromBoth : maxFromEither;
//
//    }

    public static void main(String[] argz){
        int res = maxSubArray(new int[]{8,-11,1,1 });

        System.out.println(res);

    }
}
