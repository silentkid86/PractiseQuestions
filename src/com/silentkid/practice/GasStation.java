package com.silentkid.practice;

import java.util.Arrays;
import java.util.List;

//https://www.interviewbit.com/problems/gas-station/
public class GasStation {

    //brute force
    public static int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {

        for(int i = 0 ; i < A.size() ; i++){
            int tank = 0;
            boolean possible = true;
            for(int j = 0 ; j < B.size() ; j++){
                int index_Station =(i + j) % A.size();

                tank = tank + A.get(index_Station) - B.get(index_Station);

                if(tank < 0){
                    possible = false;
                    break;
                }
            }

            if(possible)
                return i;
        }

        return -1;

    }

    // optimized to traverse only 1 times because traversed is no longer a valid starting point.
    public static int canCompleteCircuit_2(final List<Integer> A, final List<Integer> B) {
        int total_diff = 0;
        int tank = 0;
        int startPt = 0;
        for(int i = 0 ; i < A.size() ; i++){
            tank = tank + A.get(i) - B.get(i);
            total_diff = total_diff + A.get(i) - B.get(i);

            if(tank < 0){
                tank = 0;
                startPt = i + 1;
            }
        }

        if(total_diff < 0)
            return -1;
        else
            return startPt;
    }

    public static void main(String[] argz){
        List<Integer> arr_a = Arrays.asList( 1, 2, 3, 4, 5 );
        List<Integer> arr_b = Arrays.asList( 3, 4, 5, 1, 2 );

        System.out.println(canCompleteCircuit_2(arr_a,arr_b));
    }
}
