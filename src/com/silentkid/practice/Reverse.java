package com.silentkid.practice;


public class Reverse {

	public static void main(String[] argx){
		
		int[] arr = {1 ,2, 4, 5,3};
		
		
		arr =bubbleSort(arr);
		
		arr =reverse(arr);
		
		for(int i : arr){
			System.out.print(i);
		}

	}
	
	public static int[] reverse(int[] arr){
		int temp =0;
		for(int i=0;i <= (arr.length - 1) / 2; i++){
			temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1- i] = temp;
			
		}
		
		return arr;
	}
	
	
	public static int[] bubbleSort(int[] arr){
		for(int i = 1;i < arr.length;i++){
			for(int j = 1;j< arr.length;j++){
				if(arr[j -1] > arr[j])
					swap(arr,j-1,j);
			}
			
		}
		
		return arr;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
	
}
