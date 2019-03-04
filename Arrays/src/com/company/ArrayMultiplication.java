package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Write a program that takes two arrays representing integers, and
returns an integer representing their product. For example, since
193707721 X -761838257287 = -147573952589676412927
 */
public class ArrayMultiplication {

    public static List<Integer> multiply(List<Integer> num1, List<Integer> num2){
        final int sign = num1.get(0) < 0 ^ num2.get(0) < 0 ? -1 : 1;
        num1.set(0, Math.abs(num1.get(0)));
        num2.set(0, Math.abs(num2.get(0)));

        List<Integer> res = new ArrayList<Integer>(Collections.nCopies(num1.size()+num2.size(), 0));
        for(int i=num1.size()-1; i>=0; --i){
            for(int j=num2.size()-1; j>=0; --j){
                res.set(i+j+1, res.get(i+j+1)+num1.get(i)*num2.get(j));
                res.set(i+j, res.get(i+j)+res.get(i+j+1)/10);
                res.set(i+j+1, res.get(i+j+1)%10);
            }
        }
        // Remove the leading zeros
        int first_not_zero = 0;
        while(first_not_zero < res.size() && res.get(first_not_zero)==0){
            ++first_not_zero;
        }
        res = res.subList(first_not_zero, res.size());
        if(res.isEmpty())
            return Arrays.asList(0);
        res.set(0, res.get(0)*sign);
        return res;
    }

    public static void main(String[] args){
        List<Integer> A = new ArrayList<Integer>();
        A.add(9);
        A.add(9);

        List<Integer> B = new ArrayList<Integer>();
        B.add(1);
        B.add(2);
        B.add(9);

        System.out.println(multiply(A, B));
    }
}
