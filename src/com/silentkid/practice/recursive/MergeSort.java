package com.silentkid.practice.recursive;


public class MergeSort {

	public static void main(String[] argx){
		int[] arr={ 1, 5,2,9,3,6,7,0 };

		mergeSort(arr,0,arr.length-1);
		
		for(int i : arr){
			System.out.print(i + ",");
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

	private static void merge( int[] arr, int l,int h, int m) {

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
