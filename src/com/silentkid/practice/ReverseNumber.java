package com.silentkid.practice;

public class ReverseNumber {
	
	public static void main(String[] argx){
		
		int a= 12341;
		
		int t = getLengthRerc(a);
		
		System.out.println("length:" + t);
		
		int r = getReverse(a);
		
		System.out.println("reversed:" +r);
		
	}
	/**
	 * get by String operation
	 *  
	 * @param a
	 * @return
	 */
	private static int getReverse(int a) {
		// TODO Auto-generated method stub
		String v = String.valueOf(a);
		
		StringBuffer bfr = new StringBuffer();
		
		for(int i = v.length(); i >0 ;i--){
			bfr.append(v.charAt(i - 1));
		}
		
		String str = bfr.toString();
		return Integer.valueOf(str);
	}
	
	/**
	 * Recursively get the number length
	 * 
	 * @param a
	 * @param depth
	 * @return
	 */
	private static int getLengthRerc(int a) {
		
//		int pow = (int)Math.pow(10, depth);
		
		int r = a / 10;
		
		if(a / 10 == 0 && a % 10 ==0)
			return 0;
		
		return 1 + getLengthRerc(r);
	}
}
