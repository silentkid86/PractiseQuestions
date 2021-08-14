package com.silentkid.practice.ttd;

import java.util.*;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class BishopMove {

    //32 x 32 chess board
    private static int[][] chess = new int[32][32];
    public static int[][] bishopMove(int[] bishopXY){
        int posX = bishopXY[0];
        int posY = bishopXY[1];
        LinkedList<int[]> l = new LinkedList<>();
        int currX = posX, currY = posY;
        generateMove(posX,posY,l,( (x) -> x+1),( (x) -> x+1));
        generateMove(posX,posY,l,( (x) -> x+1),( (x) -> x-1));
        generateMove(posX,posY,l,( (x) -> x-1),( (x) -> x+1));
        generateMove(posX,posY,l,( (x) -> x-1),( (x) -> x-1));

        return (int[][])l.toArray();
    }

    public static void generateMove(int posX , int posY , LinkedList<int[]> l,
                                    Function<Integer,Integer> opX , Function<Integer,Integer> opY){
        int currX = posX, currY = posY;
        while(currX < 32 && currY < 32 && currX >=0 && currY >=0){
            if(currX != posX && currY !=posY){
                //enemy
                if(chess[currX][currY] != 2){
                    l.add(new int[]{currX,currY});
                    break;
                }
                //friend
                if(chess[currX][currY] != 2){
                    break;
                }
                l.add(new int[]{currX,currY});
            }

            currX = opX.apply(currX);
            currY = opY.apply(currY);
        }
    }

    public static boolean[] stopDirection = new boolean[]{false,false,false,false};
    public static void generateMove1(int posX , int posY ){
        List<Integer[]> coordinates = new LinkedList<>();

        for(int dir = 0 ; dir < stopDirection.length ; dir++){
            dfs(new Integer[]{posX,posY},dir,coordinates);
        }




    }

    private static void dfs(Integer[] pos, int dir,Collection<Integer[]> res) {

        if(pos == null || pos[0] >= 32 || pos[1] >= 32 || pos[0] < 0 || pos[1] < 0){
            stopDirection[dir] = true;
            return;
        }

        if(chess[pos[0]][pos[1]] == 2){
            //enemy
            res.add(pos);
            stopDirection[dir] = true;
            return;
        }else if(chess[pos[0]][pos[1]] == 1){
            //friend
            stopDirection[dir] = true;
            return;
        }else{
            res.add(pos);
            dfs(getNextNode(pos,dir),dir,res);
        }

    }


    private static Integer[] getNextNode(Integer[] node, int direction) {
        int[] deltaRow = new int[]{1,1,-1,-1};
        int[] deltaCol = new int[]{-1,1,-1,1};

        if(!stopDirection[direction]){
            return new Integer[]{node[0] + deltaRow[direction],node[1] + deltaCol[direction]};
        }

        return null;
    }

}
