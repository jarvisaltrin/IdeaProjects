package com.company;

import java.util.PriorityQueue;

public class MainPriorityQueue {

    public static void main(String[] args){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        pq.add(25);
        pq.add(-22);
        pq.add(1343);
        pq.add(54);
        pq.add(0);
        pq.add(-3524);
        pq.add(429);

        System.out.println("Peek: " + pq.peek());
        System.out.println("Remove: " + pq.remove()); // can pass value as parameter to be removed
        System.out.println("Peek: " + pq.peek());
        System.out.println("Poll: " + pq.poll()); // same as remove()
        System.out.println("Peek: " + pq.peek());

        Object[] arr = pq.toArray();
        for(Object num: arr){
            System.out.println(num);
        }

    }

}
