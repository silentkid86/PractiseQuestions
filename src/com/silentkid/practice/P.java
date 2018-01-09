package com.silentkid.practice;
import java.util.List;
import java.util.NoSuchElementException;


public class P {

	
	public static <T> T last(List<T> a){
		if(!a.isEmpty())
			return a.get(a.size() - 1);
		else
			return null;
	}

	public static <T> T  secondLast(List<T> a){
		// TODO Auto-generated method stub
		if(a.size() > 1)
			return a.get(a.size() - 2);
		else if(a.size() == 1)
			throw new NoSuchElementException();
		else
			throw new IllegalArgumentException();
	}

}
