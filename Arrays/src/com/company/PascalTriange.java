package com.company;

import java.util.ArrayList;
import java.util.List;

public class PascalTriange {

    // Time and space Complexity - O(n^2)
    public static List<List<Integer>> pascalTriangle(int numRows){
        List<List<Integer>> pascal = new ArrayList<List<Integer>>();
        for(int i=0; i<numRows; i++){
            List<Integer> curRow = new ArrayList<Integer>();
            for(int j=0; j<=i; j++){
                // set this entry to the sum of two above adjacent entries if they exist
                curRow.add((0 < j && j<i)
                        ? pascal.get(i-1).get(j-1) + pascal.get(i-1).get(j)
                        : 1 );
            }
            pascal.add(curRow);
        }
        return pascal;
    }

    public static void main(String[] args){
        System.out.println(pascalTriangle(5).toString());
    }
}
