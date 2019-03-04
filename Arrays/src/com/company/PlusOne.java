package com.company;

import java.util.ArrayList;
import java.util.List;
/*
Write a program which takes as input an array of digits encoding a decimal number
D and updates the array to represent the number D + 1.
<1,2,9> becomes <1,3,0>
 */
public class PlusOne {

    public static List<Integer> plusOne(List<Integer> A){
        int n = A.size() - 1;
        A.set(n, A.get(n) + 1);
        for(int i=n; i>0 && A.get(i)==10; --i){
            A.set(i,0);
            A.set(i-1, A.get(i-1)+1);
        }
        if(A.get(0) == 10){
            A.set(0,0);
            A.add(0, 1);
        }
        return A;
    }

    public static void main(String[] args) {
	    List<Integer> A = new ArrayList<Integer>();
	    A.add(9);
	    A.add(9);
	    System.out.println(plusOne(A));
        List<Integer> B = new ArrayList<Integer>();
	    B.add(1);
	    B.add(2);
        B.add(9);
	    System.out.println(plusOne(B));
    }
}
