package com.silentkid.practice.leetcode;

import java.util.*;

/*
https://leetcode.com/problems/course-schedule/
 */
public class CourseSchedule {

    static boolean[] totalVisited;
    static Map<Integer, List<Integer>> graph;

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new HashMap<>();

        if(prerequisites.length == 0) return true;

        for(int[] arr : prerequisites){
            List<Integer> ints=graph.getOrDefault(arr[0],new LinkedList<>());
            ints.add(arr[1]);
            if(arr[1] == arr[0])
                return false;
            graph.put(arr[0],ints);
        }

        totalVisited = new boolean[numCourses];
        for(int[] arr : prerequisites){
            if(!totalVisited[arr[0]]){
                if(!dfs(arr[0], new HashSet<Integer>()))
                    return false;
            }
        }

        return true;
    }

    public static boolean dfs(Integer node , Set<Integer> visited){

        List<Integer> l =graph.get(node);
        if(totalVisited[node] || l==null) return true;

        for(int n : l){
            if(visited.contains(n)) return false;
            visited.add(n);

            if(!dfs(n,visited)) return false;

            visited.remove(n);
        }

        totalVisited[node] = true;

        return true;
    }

    public static void main(String[] arg){
        int[][] n = {
                {0,1},
                {1,0}
        };
        boolean res = canFinish(2, n);
        System.out.println(res);
    }
}
