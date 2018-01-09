package com.silentkid.practice;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;




public class Stair {

	public static void main(String[] argx){
		int n =6;
		
		MathContext mathCtx = new MathContext(5, RoundingMode.HALF_UP);
		
		BigDecimal v = new BigDecimal("41",mathCtx);
		
		printDecimal(v);
		
		BigDecimal s = new BigDecimal("3",mathCtx);
		
		printDecimal(s);
		
		BigDecimal divided = v.divide(s, 5, RoundingMode.HALF_UP);
		printDecimal(divided);
		
		
	}
	
	static void printDecimal(BigDecimal bd) {
		DecimalFormat df = new DecimalFormat("##.00000");
		System.out.println(df.format(bd));
		
	}
	
	
	static void StairCase(int n) {
		char[] resultArr = new char[n];
		
		for(int i=0;i< n ;i++){
			resultArr[i] =' ';
		}
		
        for(int i=1; i<= n ;i++){
        	resultArr[n-i]='#';
        	
        	System.out.println(new String(resultArr));
        }
        

    }

}
