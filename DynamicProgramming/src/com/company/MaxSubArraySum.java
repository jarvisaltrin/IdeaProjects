package com.company;

import java.util.HashMap;

public class MaxSubArraySum {

    public static void maxSubArraySum(int[] a, int n){
        int maxSoFar = Integer.MIN_VALUE, max_ending_here = 0, start = 0, end = 0, s =0;
        for(int i=0;i<n;i++){
            max_ending_here += a[i];
            if(maxSoFar < max_ending_here){
                maxSoFar = max_ending_here;
                start = s;
                end = i;
            }
            if(max_ending_here < 0){
                max_ending_here = 0;
                s = i+1;
            }
        }
        System.out.println("Maximum contiguous sum is "
                + maxSoFar);
        System.out.println("Starting index " + start);
        System.out.println("Ending index " + end);
    }

    // Sub array with a given sum
    public static void subArrayGivenTarget(int[] arr, int sum){
        int curr_sum =0, start=0, end=-1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<arr.length; i++){
            curr_sum = curr_sum + arr[i];
            if(curr_sum - sum == 0){
                start = 0;
                end = i;
                break;
            }
            // if hashMap already has the value, means we already
            // have subarray with the sum
            if(map.containsKey(curr_sum - sum)){
                start = map.get(curr_sum - sum) + 1;
                end = i;
                break;
            }
            map.put(curr_sum, i); // if value not present, add to hashmap
        }
        if (end == -1) {
            System.out.println("No subarray with given sum exists");
        } else {
            System.out.println("Sum found between indexes "
                    + start + " to " + end);
        }
    }

    public static void main(String[] args){
        int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        int n = a.length;
        maxSubArraySum(a, n);

        int[] arr = {10, 2, -2, -20, 10};
        int sum = 0;
        subArrayGivenTarget(arr, sum);

    }
}
