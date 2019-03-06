package com.company;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class QueueUsingStacks {

    private Deque<Integer> enque = new LinkedList<Integer>();
    private Deque<Integer> deque = new LinkedList<Integer>();

    public void enqueue(Integer x){
        enque.addFirst(x);
    }

    public Integer dequeue(){
        if(deque.isEmpty()){
            // Transfer the elements from enque to deque
            while(!enque.isEmpty()){
                deque.addFirst(enque.removeFirst());
            }
        }
        if(!deque.isEmpty()){
            return deque.removeFirst();
        }
        throw new NoSuchElementException("Cannot pop empty queue");
    }


}
