package com.silentkid.practice.leetcode;

public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length];
        int[] product = new int[nums.length];
        //from left to right
        int sumProduct = 1;
        for(int i =0;i < nums.length ; i ++){
            sumProduct *= nums[i];
            leftProduct[i] = sumProduct;
        }
        //from right to left
        sumProduct = 1;
        for(int i =nums.length - 1;i >= 0 ; i --){
            int leftOp = 1;
            if(i > 0){
                leftOp = leftProduct[i - 1];
            }

            product[i] = leftOp * sumProduct;
            sumProduct *= nums[i];
        }

        return product;

    }


    public static void main(String[] argz){
        int[] res = productExceptSelf(new int[]{0,0});
        //System.out.println(res);
        printArray(res) ;
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}
