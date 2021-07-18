package com.silentkid.practice.hard;


public class NumOfIslands {

    public static int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; ++i) {
            for(int j = 0; j < grid[i].length; ++j) {
                if(grid[i][j] == '1') {
                    count += dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private static int dfs(char[][] grid, int i, int j) {

        // Find land surrounded by water
        if(i >= 0 && j >= 0 && i < grid.length && j < grid[i].length && grid[i][j] == '1') {
            grid[i][j] = '0';
            dfs(grid, i, j + 1);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i - 1, j);
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] argz) {
        char[][] testcase = {
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}
        };

        int l = numIslands(testcase);
        System.out.println(l);
    }
}
