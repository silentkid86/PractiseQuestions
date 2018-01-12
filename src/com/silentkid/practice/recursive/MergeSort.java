package com.silentkid.practice.recursive;


public class MergeSort {

	public static void main(String[] argx){
		int[] arr={ 1, 5,2,9,3,6,7,0 };
		
		
		mergeSort(arr,0,arr.length-1);
		
		for(int i : arr){
			System.out.print(i);
		}
	}

	private static void mergeSort(int[] arr, int low, int high) {
		
		if( low < high){
			int middle = (low + high) / 2;
			
			mergeSort( arr, low, middle);
			mergeSort( arr, middle + 1,high);
			merge(arr , low , high , middle);
			
		}
		
	}

	private static void merge( int[] arr, int low, int high,
			int middle) {
		
		int[] helperArr= new int[arr.length];
		
		for(int i=low; i<= high ; i++)
			helperArr[i] = arr[i];
		
		int leftC = low;
		int rightC = middle + 1;
		int current = low;
		
		while(leftC <= middle && rightC <= high){
			if(helperArr[leftC] > helperArr[rightC]){
				arr[current] = helperArr[rightC];
				rightC++;
			}else{
				arr[current] = helperArr[leftC];
				leftC++;
			}
			current++;
		}
		
		int remaining = middle - leftC;
		
		for(int i = 0 ; i <=remaining; i++){
			arr[current + i] = helperArr[leftC + i];
		}
		
//		for(int i : helperArr){
//			System.out.print(i);
//		}
//		System.out.println("");
		
	}

	
	

	
}
