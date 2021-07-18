package com.silentkid.practice.ttd;

import java.util.LinkedList;
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

    public static void main(String[] argx){

    }
}
