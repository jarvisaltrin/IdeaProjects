package com.company;

import java.util.ArrayList;
import java.util.List;

/*
You are given an array of integers and must compute the maximum difference between any item and any lower indexed smaller item for all the possible pairs, i.e., for a given array a, find the maximum value of a[j] - a[i] for all i, j where 0 ≤ i < j < n and a[i] < a[j]. If there are no lower indexed smaller items for all the items, then return -1.



For example, given an array [ 1, 2, 6, 4], you would first compare 2 to the elements to its left.  1 is smaller, so calculate the difference 2 - 1 = 1.  6 is bigger than 2 and 1, so calculate the differences 4 and 5.  4 is only bigger than 2 and 1, and the differences are 2 and 3.  The largest difference was 6 - 1 = 5.



Function Description

Complete the function maxDifference in the editor below.
The function must return an integer representing the maximum difference in a.



maxDifference has the following parameter(s):

    a[a[0],a[1],...a[n-1]]:  an array of integers



Constraints

1 ≤ n ≤ 2 × 105
−106 ≤ a[i] ≤ 106 ∀ i ∈ [0, n − 1]


Sample Case 0

Sample Input 0

a = [2, 3, 10, 2, 4, 8, 1]
Sample Output

8
Explanation

a = [2, 3, 10, 2, 4, 8, 1]

Differences are calculated as:

3 - [2] = [1]
10 - [3, 2] = [7, 8]
4 - [2, 3, 2] = [2, 1, 2]
8 - [4, 2, 3, 2] = [4, 6, 5, 6]
The maximum is found at 10 - 2 = 8.

 */

public class MainArray {

    public static void main(String[] args) {
        List<Integer> source = new ArrayList<>();
        source.add(2);
        source.add(3);
        source.add(10);
        source.add(2);
        source.add(4);
        source.add(8);
        source.add(1);


        int diff = maxDifference(source);

        System.out.println(diff);
    }


    static int maxDifference(List<Integer> a) {
        int i = 1;
        int max_diff = a.get(i) - a.get(i-1);
        int min_element = a.get(i-1);

        while(i < a.size()){
            if(a.get(i) - min_element > max_diff) {
                max_diff = a.get(i) - min_element;
                //System.out.println(max_diff);
            }
            if(a.get(i) < min_element){
                min_element = a.get(i);
            }
            i++;
        }
        return max_diff;
    }

}
