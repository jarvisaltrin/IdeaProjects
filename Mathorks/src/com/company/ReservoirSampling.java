package com.company;

import java.util.Arrays;
import java.util.Random;

/*
Reservoir sampling is a family of randomized algorithms for randomly choosing k samples from
a list of n items, where n is either a very large or unknown number. Typically n is large enough
that the list doesn’t fit into main memory. For example, a list of search queries in Google and Facebook.

So we are given a big array (or stream) of numbers (to simplify),
and we need to write an efficient function to randomly select k numbers where 1 <= k <= n.
Let the input array be stream[].

 */

public class ReservoirSampling {

    public static void main(String[] args){
        int[] stream = {1,2,3,4,5,6,7,8,9,10,11,12};
        int n = stream.length;
        int k = 5; // size of the reservoir
        selectingKItems(stream, n, k);
    }

    public static void selectingKItems(int[] stream, int n, int k){
        int i;
        int [] reservoir = new int[k];
        // initialize it with 1st k elements of stream
        for(i=0;i<k;i++)
            reservoir[i] = stream[k];

        Random r = new Random();

        for(;i<n;i++){
            // Pick a random index from 0 to i
            int j = r.nextInt(i+1);

            // If the randomly  picked index is smaller than k,
            // then replace the element present at the index
            // with new element from stream
            if(j<k){
                reservoir[j] = stream[i];
            }
        }
        System.out.println("Following are k randomly selected items");
        System.out.println(Arrays.toString(reservoir));
    }
}
