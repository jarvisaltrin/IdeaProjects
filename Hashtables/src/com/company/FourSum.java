package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Pair{
    public int x, y;
    Pair(int x, int y){
        this.x=x;
        this.y=y;
    }
}
/*
Given an unsorted array, print all the four elements (quadruplets) which add up to a sum
 */

public class FourSum {

    public static void fourSum(int[] A, int sum){
        Map<Integer, List<Pair>> map = new HashMap<>();
        int n = A.length;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                int val = sum - (A[i]+A[j]); // remaining sum
                if(map.containsKey(val)){
                    for (Pair pair: map.get(val)){
                        int x = pair.x;
                        int y = pair.y;
                        // If Quadruplet don't overlap, print it
                        if ((x!=i && x!=j) && (y!=i && y!=j)){
                            System.out.println(A[i] + " " + A[j] + " " + A[x] + " " + A[y]);
                        }
                    }
                }
                // insert pair into the map
                map.putIfAbsent(A[i]+A[j], new ArrayList<>());
                map.get(A[i]+A[j]).add(new Pair(i, j));
            }
        }
    }

    public static void main(String[] args){
        int[] A = {2, -7, -4, 0, 9, 5, 1, 3};
        int sum = 0;
        fourSum(A, sum);
    }
}
