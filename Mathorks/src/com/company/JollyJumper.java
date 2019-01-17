package com.company;

import java.util.HashMap;
import java.util.Map;

/*
A sequence of n numbers (n < 3000) is called Jolly Jumper if the absolute values of
the differences between the successive elements take on all possible values from 1
through n-1.
 */
public class JollyJumper {

    public static boolean isJolly(int[] array) {
        Map<Integer, Boolean> seenIt = new HashMap<>();
        int m = array.length;
        for(int i=1; i<=m; i++){
            seenIt.put(i,false);
        }
        seenIt.remove(m);
        for(int i=1; i<m; i++){
            int diff = Math.abs(array[i-1]-array[i]);
            seenIt.put(diff, true);
        }
        boolean flag = true;
        for(int i=1; i<m; i++){
            if(seenIt.get(i) == false)
                return false;
        }
        return flag;
    }

    public static void main(String[] args){
        int arr[] = {15, 11, 8, 6, 5, 10};
        System.out.println(isJolly(arr) ? "Jolly" : "Not jolly");
    }
}
