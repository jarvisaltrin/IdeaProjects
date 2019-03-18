package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListPractice {

    public static void main(String[] args) {

        LinkedList<String> ll = new LinkedList<String>();
        ll.add("Orange");
        ll.add("Apple");
        ll.add("Grape");
        ll.add("Banana");

        System.out.println(ll);
        System.out.println("Size of the linked list: "+ll.size());
        System.out.println("Is LinkedList empty? "+ll.isEmpty());
        System.out.println("Does LinkedList contains 'Grape'? " + ll.contains("Grape"));

        // Iterate through a LinkedList
        Iterator<String> itr = ll.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        // Copy or clone a LinkedList
        LinkedList<String> copy = (LinkedList<String>) ll.clone();
        System.out.println("Cloned LinkedList:" + copy);

        List<String> list = new ArrayList<String>();
        list.add("One");
        list.add("Two");
        ll.addAll(list);
        System.out.println("After Copy: " + ll);

        list.clear();

        // Copy LinkedList to String Array
        String[] strArr = new String[ll.size()];
        ll.toArray(strArr);
        System.out.println("Created Array content:");
        for(String str:strArr) {
            System.out.println(str);
        }

        // Add to first
        ll.addFirst("First");
        // Add to end
        ll.addLast("AddLast");
        ll.offerLast("OfferLast");
        ll.offer("Offer");
        System.out.println(ll);


    }

}
