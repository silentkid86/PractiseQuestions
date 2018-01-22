package com.silentkid.practice.frombook;

public class CountKidSteps {
	
	static int ways = 0;
	
	public static void main(String[] args) {
		
		int steps = 3;
		
		int countKidsStep = countKidsStep(steps, 0);
		
		System.out.println(countKidsStep);
	}

	private static int countKidsStep(int steps, int currentStep) {
		
		
		if(steps - currentStep == 0) {
			return 1;
		}else if(steps - currentStep < 0){
			return 0;
		}
		
		return countKidsStep(steps - currentStep,1) + countKidsStep(steps - currentStep,2) + countKidsStep(steps - currentStep,3);
		
	}
}
