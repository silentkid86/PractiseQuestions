package com.silentkid.practice.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestDistanceFromAllBuidling {

    public int shortestDistance(int[][] grid) {
        int[][] distanceMatrix = new int[grid.length][grid[0].length];

        int m = grid.length;
        int n = grid[0].length;

        int min = Integer.MAX_VALUE;

        List<Integer[]> houses = new ArrayList<>();

        //find all houses , O(n^2) here
        for(int i=0; i < grid.length ; i++){
            for(int j=0;j< grid[i].length;j++){
                if(grid[i][j] == 1){
                    houses.add(new Integer[]{i,j});
                }
            }
        }

        for(int h = 0 ; h < houses.size() ; h++){

            Queue<Integer[]> q = new LinkedList<>();
            q.offer(houses.get(h));

            int level = 0;
            while(!q.isEmpty()){

                int queueSize = q.size();

                for(int i = 0 ; i < queueSize ; i++){
                    Integer[] position=q.poll();
                    int posX = position[0];
                    int posY = position[1];

                    if(h > 0 && grid[posX][posY] == 0){
                        return -1;
                    }

                    distanceMatrix[posX][posY] += level;

                    if(grid[posX][posY]<=0){
                        grid[posX][posY]--;
                        if(h == houses.size() - 1)
                            min = Math.min(min,distanceMatrix[posX][posY]);
                    }

                    for(Integer[] next : getNeighbour(position,m,n)){

                        if(grid[next[0]][next[1]] <= 0 && Math.abs(grid[next[0]][next[1]]) < h + 1){
                            q.offer(next);
                        }
                    }
                }

                level++;

            }


        }

        return min;

    }

    public List<Integer[]> getNeighbour(Integer[] gridPos , int m , int n ){
        int[] deltaRow = { -1,0,1,0};
        int[] deltaCol = { 0,1,0,-1};

        List<Integer[]> res = new ArrayList<>();
        for(int i = 0 ; i  < deltaCol.length ; i++){
            int x = gridPos[0] + deltaRow[i];
            int y = gridPos[1] + deltaCol[i];

            if( ( x < m && x >=0 ) && ( y < n && y >=0 ) ){
                res.add(new Integer[]{x,y});
            }
        }
        return res;
    }

    public static void main(String[] argz){
        int[][] grid = new int[][]{{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        ShortestDistanceFromAllBuidling r = new ShortestDistanceFromAllBuidling();
        int n = r.shortestDistance(grid);

        System.out.println(n);

    }


}
