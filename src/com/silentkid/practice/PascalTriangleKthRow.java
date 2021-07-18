package com.silentkid.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class PascalTriangleKthRow {
    public static ArrayList<Integer> getRow(int A) {
        ArrayList<Integer> result = new ArrayList<>();

        result.add(1);
        if(A == 0)
            return result;

        ArrayList<Integer> intermediate = getRow(A - 1);

        for(int i = 1 ; i <= A; i++){
            result.add(intermediate.get(i-1)+intermediate.get(i));
        }

        return result;
    }

    public static void main(String[] argz){
        ArrayList<Integer> arrayList= getRow(5);
        System.out.println(arrayList);
    }

}
