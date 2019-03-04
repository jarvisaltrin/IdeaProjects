package com.company;

import java.util.Arrays;
import java.util.List;

public class RotateMatrix {

    // 90 degree rotate to right
    // Time Complexity - O(n^2)
    public static List<List<Integer>> rotateMatrix(List<List<Integer>> matrix){
        final int matrixSize = matrix.size() - 1;
        for(int i=0; i < matrix.size()/2; i++){
            for(int j=i; j<matrixSize-i; j++){
                // perform a 4 way exchange
                int temp1 = matrix.get(matrixSize - j).get(i);
                int temp2 = matrix.get(matrixSize - i).get(matrixSize - j);
                int temp3 = matrix.get(j).get(matrixSize - i);
                int temp4 = matrix.get(i).get(j);
                matrix.get(i).set(j, temp1);
                matrix.get(matrixSize - j).set(i, temp2);
                matrix.get(matrixSize - i).set(matrixSize - j, temp3);
                matrix.get(j).set(matrixSize - i, temp4);
            }
        }
        return matrix;
    }

    public static void main(String[] args){
        List<List<Integer>> list = Arrays.asList(Arrays.asList(1,2,3),Arrays.asList(4,5,6),Arrays.asList(7,8,9));
        System.out.println(rotateMatrix(list).toString());
        List<List<Integer>> list1 = Arrays.asList(Arrays.asList(1,2,3,4),Arrays.asList(5,6,7,8),Arrays.asList(9,10,11,12),Arrays.asList(13,14,15,16));
        System.out.println(rotateMatrix(list1).toString());
    }
}
