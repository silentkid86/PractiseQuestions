package com.silentkid.practice.frombook;

public class StringCompression {
	
	public static void main(String[] args) {
		
		String ab = "abBBc";
		
		String result = compresString(ab);
		
		System.out.println(result);
	}

	private static String compresString(String ab) {
		
		char[] input = ab.toCharArray();
		
		char curr = input[0];
		int occurrance = 1;
		
		StringBuffer sb= new StringBuffer();
		for(int i=1;i < input.length;i++){
			if(input[i] == curr){
				occurrance++;
			}else{
				sb.append(curr).append(occurrance);
				curr = input[i];
				occurrance = 1;
			}
			
			
		}
		sb.append(curr).append(occurrance);
		
		String result = sb.toString();
		
		if(ab.length() < result.length())
			return ab;
		else
			return result;
	}

}
