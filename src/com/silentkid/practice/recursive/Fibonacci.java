package com.silentkid.practice.recursive;

public class Fibonacci {
	int nth;
	
	public Fibonacci(int idx){
		nth = idx;
	}
	
	public int recor(){
		return recursiveCal(nth);
	}

	private int recursiveCal(int id) {
		if(id == 0) return 0;
		if(id == 1) return 1;
		return recursiveCal(id - 1) + recursiveCal(id - 2);
	}
	
}
