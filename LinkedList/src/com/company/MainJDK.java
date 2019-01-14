package com.company;

import java.util.Iterator;
import java.util.LinkedList;

public class MainJDK {

    public static void main(String[] args){
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 123);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        LinkedList<Employee> list = new LinkedList<>();

        list.addFirst(janeJones);
        list.addFirst(johnDoe);
        list.addFirst(marySmith);
        list.addFirst(mikeWilson);

        Iterator iter = list.listIterator();
        System.out.print("HEAD -> ");
        while(iter.hasNext()){
            System.out.print(iter.next());
            System.out.print(" <=> ");
        }
        System.out.println("null");

        list.add(billEnd); // Adds to end (same as addLast())
        iter = list.listIterator();
        System.out.print("HEAD -> ");
        while(iter.hasNext()){
            System.out.print(iter.next());
            System.out.print(" <=> ");
        }
        System.out.println("null");


        list.removeLast(); // remove() removes from the front of the list
        iter = list.listIterator();
        System.out.print("HEAD -> ");
        while(iter.hasNext()){
            System.out.print(iter.next());
            System.out.print(" <=> ");
        }
        System.out.println("null");

    }
}
