package com.silentkid.practice.leetcode;

import com.silentkid.practice.P;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindUsersWithError {

    List<String> findErrorUsers(String[][] actionsUsers, String errOrder) {
        Map<String,String> map = new HashMap<>();
        for(String[] actionUser : actionsUsers){
           String actions = map.getOrDefault(actionUser[1],"");
           StringBuilder sb = new StringBuilder(actions);
           sb.append(actionUser[0]);
           map.put(actionUser[1],sb.toString());
        }

        List<String> res = new ArrayList<>();
        for(Map.Entry<String,String> entry : map.entrySet()){
            String s = entry.getValue();
            if(s.indexOf(errOrder) != -1){
                res.add(entry.getKey());
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String[][] strs = {
            {"A", "1"},
            {"B", "1"},
            {"B", "2"},
            {"C", "1"},
            {"C", "2"},
            {"C", "3"},
            {"A", "2"},
            {"A", "3"},
            {"A", "2"},
            {"B", "2"},
            {"C", "2"}
        };

        FindUsersWithError fe = new FindUsersWithError();
        List<String> abc = fe.findErrorUsers(strs, "ABC");
        for(String s : abc){
            System.out.println(s);
        }

    }
}
