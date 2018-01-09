package com.silentkid.practice;

public class MoveToEndAllZero {
	
	public static void main(String[] argx){
		int[] arr={ 0,6, 0, 8, 2, 3, 0, 4, 0, 1 };
		
		int start = 0;
		int end = arr.length - 1;
		
		while(start < end){
			while(arr[start] > 0 ){
				start++;
			}
			
			while(arr[end] == 0)
				end--;
			
			if(start < end)
				swap(arr,start,end);
			
		}
		
		for(int i : arr){
			System.out.print(i);
		}
		
	}
	
	public static void swap(int[] arr , int i, int j)
	{
	 int temp = arr[i];
	 arr[i] = arr[j];
	 arr[j] = temp;
	}
}
