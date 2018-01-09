package com.silentkid.practice;
import java.util.stream.IntStream;

public class Multiply {
    public static Double multiply(Double a, Double b) {
    	
    	IntStream.of(10).reduce( (i,t) -> i * t );
    	
    	
        return a * b;
    }
}