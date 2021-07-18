package com.silentkid.practice.leetcode;

import java.util.*;

public class RedundantConnection {

    public static int[] findRedundantConnection(int[][] edges) {
        int[] redundant = new int[2];

        HashMap<Integer, List<Integer>> connectivity =new HashMap<>();


        for(int i = 0 ; i < edges.length ; i++){
            int[] edge = edges[i];
            int nodeA = edge[0];
            int nodeB = edge[1];

            if(connectivity.containsKey(nodeA) && connectivity.containsKey(nodeB)){
                if(dfsCheck(nodeA,nodeB,connectivity)){
                    redundant=edge;
                }else{
                    updateConnectivity(connectivity, nodeA, nodeB);
                }
            }else{
                updateConnectivity(connectivity, nodeA, nodeB);
            }


        }

        return redundant;
    }

    private static void updateConnectivity(HashMap<Integer, List<Integer>> connectivity, int nodeA, int nodeB) {
        List a = connectivity.get(nodeA);
        if (a == null) a = new ArrayList();
        a.remove((Integer) nodeB);
        a.add(nodeB);
        connectivity.put(nodeA, a);

        List b = connectivity.get(nodeB);
        if (b == null) b = new ArrayList();
        b.remove((Integer) nodeA);
        b.add(nodeA);
        connectivity.put(nodeB, b);
    }

    private static boolean dfsCheck(int startNode, int endNode, HashMap<Integer, List<Integer>> connectivity) {
        Set<Integer> visited = new HashSet<>();

        Stack<Integer> toBeVisited = new Stack<>();
        toBeVisited.push(startNode);
        while(!toBeVisited.isEmpty()){
            Integer currentNodeVisited = toBeVisited.pop();
            visited.add(currentNodeVisited);

            List<Integer> edgeList = connectivity.get(currentNodeVisited);
            for(int node : edgeList){
                if(node == endNode){
                    return true;
                }

                if(!visited.contains(node)){
                    toBeVisited.push(node);
                }
            }

        }
        return false;

    }


    public static void main(String[] argx){
        //[[3,4],[1,2],[2,4],[3,5],[2,5]]
        //[[9,10],[5,8],[2,6],[1,5],[3,8],[4,9],[8,10],[4,10],[6,8],[7,9]]
        int[][] arr={ new int[]{3,4} , new int[]{1,2}, new int[]{2,4}
                , new int[]{3,5} , new int[]{2,5}};

        int[] result=findRedundantConnection(arr);
        printArray(result);
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}
