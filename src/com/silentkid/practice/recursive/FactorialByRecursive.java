package com.silentkid.practice.recursive;

public class FactorialByRecursive {
	
	public static void main(String[] args){
		
		long sum = factorial(9);
		
		System.out.println(sum);
		
		
	}

	private static long factorial(int i) {
		
		if(i == 1){
			return 1;
		}
		return i * factorial(i - 1);
	}
}
