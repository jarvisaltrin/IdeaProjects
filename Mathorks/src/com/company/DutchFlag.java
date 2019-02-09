package com.company;

import java.util.Arrays;

public class DutchFlag {

    public static void main(String[] args){
        int arr[] = {0,1,2,1,0,2,0,2,1,1,0,2,1,0};
        dutchFlagProblem(arr);
    }

    public static void dutchFlagProblem(int[] arr){
        int low = 0, high = arr.length-1, mid = 0;
        while (mid<=high){
            switch (arr[mid]){
                case 0: {
                    swap(arr, low, mid);
                    low++;
                    mid++;
                    break;
                }
                case 1: {
                    mid++;
                    break;
                }
                case 2: {
                    swap(arr, mid, high);
                    high--;
                    break;
                }
            }
        }
        System.out.println("Solved solution: ");
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
