package com.silentkid.practice.leetcode;

public class WordSearch {
    int m = 0;
    int n = 0;
    int[] deltaX = {0, 1, 0, -1};
    int[] deltaY = {1, 0, -1, 0};

    public boolean exist(char[][] board, String word) {
        char[] ca = word.toCharArray();

        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == ca[0]) {
                    boolean[][] visited = new boolean[m][n];
                    visited[i][j] = true;
                    if (dfs(i, j, 0, ca, board, visited)) return true;
                }

            }
        }
        return false;
    }

    public boolean dfs(int i, int j, int index, char[] word, char[][] board, boolean[][] path) {
        if (index == word.length - 1) {
            return true;
        }

        for (int t = 0; t < deltaX.length; t++) {
            int posX = i + deltaX[t];
            int posY = j + deltaY[t];

            if (posX >= 0 && posX < m && posY >= 0 && posY < n) {
                if (board[posX][posY] == word[index + 1] && !path[posX][posY]) {
                    path[posX][posY] = true;
                    if (dfs(posX, posY, index + 1, word, board, path)) return true;
                    path[posX][posY] = false;
                }

            }
        }


        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}};
        WordSearch ws = new WordSearch();
        System.out.println(ws.exist(board, "ABCEFSADEESE"));
    }
}
