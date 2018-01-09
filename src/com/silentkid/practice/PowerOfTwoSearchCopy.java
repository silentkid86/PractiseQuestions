package com.silentkid.practice;

public class PowerOfTwoSearchCopy {
		  public static void main(String[] args) {
		    
		    int[] arr = {2,4,5,7,8,9,10,11};
		    
		    int result = searchIndexBy2(arr, 10);
		    

		    System.out.print(result + " " );

		  }

		private static int searchIndexBy2(int[] arr, int target) {
			int currentIdx = 0;
			
			if(arr[currentIdx] == target){
				return currentIdx;
			}

			while(true){

				int x = increaseByPowerOfTwo(currentIdx);
				try{
					int seek = arr[x];
					if(seek == target){
						return x;
					}else if(seek > target) {
						return binarySearch(arr,getPreviousCheckpoint(x),x-1,target);
					}	
				
				}catch(ArrayIndexOutOfBoundsException e){
					return binarySearch(arr,getPreviousCheckpoint(x),x-1,target);
				}
				currentIdx++;
				
				
			}
			
		}

		private static int getPreviousCheckpoint(int currentIdx) {
			return (int)Math.sqrt(currentIdx);
		}

		private static int binarySearch(int[] arr, int start, int end, int target) {
			int mid = ( end + start ) / 2;
			
			try{
				
				if(start > end){
					return -1;
				}else if(arr[mid] == target){
					return mid;
				}else if(arr[mid] > target){
					return binarySearch(arr,start,mid - 1,target);
				}else{
					return binarySearch(arr,mid+1,end,target);
				}
			}catch(ArrayIndexOutOfBoundsException e){
				return binarySearch(arr,start,mid - 1,target);
			}

			
		}

		private static int increaseByPowerOfTwo(int currentIdx) {
			
			double pow = Math.pow(2.0, 0.0 + currentIdx);
			
			return (int)pow;
		}
}
