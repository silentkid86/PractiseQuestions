package com.silentkid.practice;
// 2, 4, 67, 893...
// sorted, unknown length, fixed length
// given x, find its index i.e. indexOf(int x, int[] arr)
// don't call arr.length


/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class PowerOfTwoSearch {
  public static void main(String[] args) {
    
    int[] arr = {2,4,5,7,8,9,10,11};
    
    int result = searchIndexBy2(arr, 10 ,0);
    

      System.out.print(result + " " );

  }
  
  
  public static int searchIndexBy2(int[] arr,int target,int startIdx){
    
    while(true){
      
      
      int x = twoPower(startIdx);
      int seek = 0;
      try{
        seek = arr[x];
      }catch(ArrayIndexOutOfBoundsException e){
         return binarySearch(arr, twoPower(startIdx -1) , (twoPower(startIdx -1) + x ) / 2,target);
      }
      
      if(seek == target){
        return x;
      }else if(seek < target){
        startIdx++;
      }else{
        return binarySearch(arr, twoPower(startIdx -1) , --startIdx,target);
      }
      
      
    }
  }
  
  public static int twoPower(int e){
    Double result = Math.pow(2.0, 0.0 + e);
    return result.intValue();
  }
  
  public static int binarySearch(int[] arr,int start,int end,int target){
    int mid = (start + end) / 2;
    try{
      
      if(start > end){
        return -1;
      }
      
      if(arr[mid] == target){
        return mid;
      }else if(arr[mid] < target){
        return binarySearch(arr, mid+1 ,end, target);
      }else{
        return binarySearch(arr, start , mid-1 , target);
      }
      
    }catch(ArrayIndexOutOfBoundsException e){
      return binarySearch(arr, start , mid-1,target);
    }
    
      
  }
  
  
    
}
