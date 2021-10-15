package com.silentkid.practice.leetcode;

import java.util.*;

/*
https://leetcode.com/problems/course-schedule-ii/
 */
public class CourseScheduleTopologicalSort {

    static boolean[] totalVisited;
    static Map<Integer, List<Integer>> graph;
    static Stack<Integer> stack = new Stack<>();

    public static int[] canFinish(int numCourses, int[][] prerequisites) {
        int[] zero = {};
        graph = new HashMap<>();
        boolean isPossible = true;

        for(int[] arr : prerequisites){
            List<Integer> ints=graph.getOrDefault(arr[0],new LinkedList<>());
            ints.add(arr[1]);
            if(arr[1] == arr[0])
                isPossible = false;
            graph.put(arr[0],ints);
        }

        totalVisited = new boolean[numCourses];
        Arrays.fill(totalVisited,false);
        for(int i =0; i < numCourses ; i++){
            if(!totalVisited[i]){
                if(!dfs(i, new HashSet<Integer>())){
                    isPossible = false;
                    break;
                }
            }
        }

        if(!isPossible) return new int[0];

        int[] ans = new int[stack.size()];
        int ptr = stack.size() - 1 ;
        while(!stack.isEmpty()){
            ans[ptr] = stack.pop();
            ptr--;
        }

        return ans;
    }

    public static boolean dfs(Integer node , Set<Integer> visited){

        List<Integer> l =graph.get(node);
        if(totalVisited[node] ) return true;
        if(l != null){

            for(int n : l){
                if(visited.contains(n)) return false;
                visited.add(n);

                if(!dfs(n,visited)) return false;

                visited.remove(n);
            }
        }

        totalVisited[node] = true;
        stack.push(node);

        return true;
    }

    public static void main(String[] arg){
        int[][] n = {

        };
        int[] res = canFinish(1, n);
        Arrays.stream(res).forEach(t -> System.out.println(t));

    }
}
