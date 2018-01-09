package com.silentkid.practice;

public class BST_v2 {
	
	public static void main(String[] argx){
		
		int[] a = {0,1,2,3,5,6,7,9};
		
		int result = binarySearch( a , 2 , 0 , a.length - 1);
		
		System.out.println(result);
		
	}

	private static int binarySearch(int[] a, int search , int start , int end) {
		
		if( end < start )
			return -1;
		
		int middle = start + (end - start) / 2;
		
		if( a[middle] == search){
			return middle;
		}else if( a[middle] > search){
			return binarySearch(a, search, start, middle-1);
		}else{
			return binarySearch(a, search, middle+1, end);
		}
		
	}
	
}
