package com.silentkid.practice;
import java.util.HashMap;


public class NumberToWords {

	private static final String SPACE = " ";
	private static HashMap<String,String> map;

	public static void main(String[] argx){
		
		long t = 13165752;
		initMap();
		
		String word = numberToWords(t);
		
	}

	private static String numberToWords(long t) {
		
		String num = String.valueOf(t);
		num = leftPad(num);
		
		String s =recursiveWordAppend(num, 0, 3);
		System.out.println(s);
		
		StringBuffer sb = new StringBuffer();
		return sb.toString();
	}

	private static String leftPad(String num) {
		int remains = num.length() % 3;
		if(num.length() % 3 != 0){
			int padding = 3 - remains;
			
			String s= padding > 1 ? "00" : "0";
			
			num = s + num;
		}
		return num;
	}
	
	private static String recursiveWordAppend(String num , int start , int end) {
		if(end > num.length()) return "";
		
		return getWords(num.substring(start, end)) + determineSuffix(num.length() - start) + recursiveWordAppend(num, start + 3, end + 3);
		
	}
	
	private static String determineSuffix(int i) {
		StringBuffer sb = new StringBuffer();
		
		if(i > 9){
			sb.append("billion ");
		}else if(i > 6){
			sb.append("million ");
		}else if(i > 3){
			sb.append("thousand ");
		}
		
		return sb.toString();
		
	}

	private static String getWords(String s) {
		StringBuffer sb = new StringBuffer();
		int h = Integer.parseInt(s);
		
		if(h > 99){
			sb.append(map.get(String.valueOf(h / 100)));
			sb.append(SPACE);
			sb.append("hundred ");
		}
		
		int small = h % 100 ;
		
		if(small < 21){
			sb.append(map.get(String.valueOf(small % 100)));
			sb.append(SPACE);
		}else{
			sb.append(map.get(String.valueOf((small / 10) * 10)));
			sb.append(SPACE);
			sb.append(map.get(String.valueOf(small % 10)));
			sb.append(SPACE);
		}
		
		return sb.toString();
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
