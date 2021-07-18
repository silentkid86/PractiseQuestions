package com.silentkid.practice.stack;

import java.util.Stack;

public class SortingStack {
	
	private static Stack tempS;
	private static Stack s;

	public static void main(String[] argz){
		
		s = new Stack();
		tempS = new Stack();
		
		
		s.push(4);
		s.push(3);
		s.push(1);
		s.push(2);
		s.push(6);
		int length = sortStack();
		int loopCount = length / 2;
		
		for(int i=0 ; i < loopCount ; i++){
			sortStack();
		}
		
		System.out.println(s);
		
	}

	private static int sortStack() {
		int length = 0;
		int temp = -1;
		
		temp = (Integer)s.pop();
		length++;
		while (!s.isEmpty()) {
			int t = (Integer)s.pop();
			if(temp > t){
				tempS.push(temp);
				temp = t;
			}else{
				tempS.push(t);
			}
			length++;
			
		}
		length++;
		tempS.push(temp);
		
		temp = (Integer)tempS.pop();
		while(!tempS.isEmpty()){
			int t = (Integer)tempS.pop();
			if(temp < t){
				s.push(temp);
				temp = t;
			}else{
				s.push(t);
			}
			
		}
		s.push(temp);
		
		
		return length;
	}
	
}
