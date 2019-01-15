package com.company;

public class RearrangePositiveNegative {

    public static void rearrangePositiveNegative(int[] arr, int n){
        int val;

        for(int i=1; i<n; i++){
            val = arr[i];
            if(val > 0){
                continue;
            }
            int j = i-1;
            while(j>=0 && arr[j]>0){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = val;
        }
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args){
        int arr[] = { 3, 11, -13, -5, 6, -7, 5, -3, -6 };
        int n = arr.length;
        rearrangePositiveNegative(arr, n);
    }

}
