package com.company;

import java.util.LinkedList;

public class LinkedQueue {

    private LinkedList<Employee> queue;

    public LinkedQueue(){
        queue = new LinkedList<Employee>();
    }

    public void add(Employee employee){
        queue.add(employee);
    }

    public Employee remove(){
        return queue.remove();
    }

    public Employee peek(){
        return queue.peek();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

}