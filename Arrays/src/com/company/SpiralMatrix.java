package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {
    // Time Complexity - O(n^2)
    public static List<Integer> spiralMatrix(List<List<Integer>> sqMatrix){
        final int[][] SHIFT ={{0,1},{1,0},{0,-1},{-1,0}};
        int dir = 0, x=0, y=0;
        List<Integer> spiralOrdering = new ArrayList<Integer>();

        for(int i=0; i<sqMatrix.size()*sqMatrix.size(); i++){
            spiralOrdering.add(sqMatrix.get(x).get(y));
            sqMatrix.get(x).set(y,0);
            int nextX = x + SHIFT[dir][0];
            int nextY = y + SHIFT[dir][1];
            if(nextX < 0 || nextX >= sqMatrix.size() ||
            nextY < 0 || nextY >= sqMatrix.size() || sqMatrix.get(nextX).get(nextY)==0){
                dir = (dir + 1) % 4;
                nextX = x + SHIFT[dir][0];
                nextY = y + SHIFT[dir][1];
            }
            x = nextX;
            y = nextY;
        }
        return spiralOrdering;
    }

    public static void main(String[] args){
        List<List<Integer>> list = Arrays.asList(Arrays.asList(1,2,3),Arrays.asList(4,5,6),Arrays.asList(7,8,9));
        System.out.println(spiralMatrix(list).toString());
        List<List<Integer>> list1 = Arrays.asList(Arrays.asList(1,2,3,4),Arrays.asList(5,6,7,8),Arrays.asList(9,10,11,12),Arrays.asList(13,14,15,16));
        System.out.println(spiralMatrix(list1).toString());
    }
}
