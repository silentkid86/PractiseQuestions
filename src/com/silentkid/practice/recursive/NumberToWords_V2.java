package com.silentkid.practice.recursive;
import java.util.HashMap;


public class NumberToWords_V2 {

	private static final String SPACE = " ";
	private static HashMap<String,String> map;

	public static void main(String[] argx){
		
		long t = 1752;
		initMap();
		
		String word = numberToWordsRerc(t,1);
		System.out.println(word);
		
	}
	
	private static String numberToWordsRerc(long t,int depth) {
		long remain = t % 1000;
		long next = t / 1000;
		
		if(next == 0)
			return getWordInHundred(remain);
		
		return numberToWordsRerc(next, depth+1) + " " + determineSuffixByDepth(depth) + getWordInHundred(remain) ;
		
	}
	
	
	
	private static String determineSuffixByDepth(int d) {
		
		if(d == 3){
			return "billion ";
		}else if(d == 2){
			return "million ";
		}else if( d == 1){
			return "thousand ";
		}
		
		return "";
	}


	private static String getWordInHundred(long remaining) {
		String hundred= String.valueOf(remaining / 100);
		
		long decimal = remaining % 100;
		
		StringBuffer sb = new StringBuffer();
		if(remaining / 100 > 0){
			sb.append(map.get(hundred)).append(SPACE).append("hundred").append(SPACE);
		}
		
		sb.append(getDecimal(decimal));
		
		return sb.toString();
	}

	private static String getDecimal(long decimal) {
		
		if(decimal < 21){
			return map.get(String.valueOf(decimal));
		}else{
			String tenth = String.valueOf((decimal / 10) * 10);
			
			String digit = String.valueOf(decimal % 10);
			
			return map.get(tenth) + " " + map.get(digit);
		}
		
	}

	private static void initMap(){
		map = new HashMap<>();
		
		map.put("0", "");
		map.put("1", "one");
		map.put("2", "two");
		map.put("3", "three");
		map.put("4", "four");
		map.put("5", "five");
		map.put("6", "six");
		map.put("7", "seven");
		map.put("8", "eight");
		map.put("9", "nine");
		map.put("10", "ten");
		map.put("11", "eleven");
		map.put("12", "twelve");
		map.put("13", "thirteen");
		map.put("14", "fourteen");
		map.put("15", "fiftheen");
		map.put("16", "sixteen");
		map.put("17", "seventeen");
		map.put("18", "eighteen");
		map.put("19", "nineteen");
		map.put("20", "twenty");
		
		map.put("30", "thirty");
		map.put("40", "fourty");
		map.put("50", "fifty");
		map.put("60", "sixty");
		map.put("70", "seventy");
		map.put("80", "eighty");
		map.put("90", "ninety");
	}
}
