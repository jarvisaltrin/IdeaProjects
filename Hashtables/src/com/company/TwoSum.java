package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSum {

    public static void twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int complement;
        boolean flag = false;
        for (int i = 0; i<nums.length; i++) {
            complement = target - nums[i];
            if (map.containsKey(complement)) {
                //return new int[] {i, map.get(complement)};
                System.out.println(nums[i] + " " + nums[map.get(complement)]);
                flag = true;
            }
            map.put(nums[i], i);
        }
        if (flag == false)
            System.out.println("No Solution");
    }

    public static void main(String[] args){
        int[] nums = {2,5,7,3,-1,6,4,11};
        twoSum(nums,10);

    }
}
