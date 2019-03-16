package com.company;

import java.util.*;

public class ArrayListPractice {

    public static void main(String[] args){

        List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1,2,3,4,6,5,2,1));
        numbers.add(29);
        numbers.add(32);
        numbers.add(11);

        // Iterate a list
        Iterator<Integer> it = numbers.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        // Reverse a list
        List<Integer> num_reverse = new ArrayList<Integer>(numbers.size());
        ListIterator<Integer> itr = numbers.listIterator(numbers.size());
        while(itr.hasPrevious()){
            num_reverse.add(itr.previous());
        }

        System.out.println("Original: " + numbers.toString());
        System.out.println("Reverse: " + num_reverse.toString());

        // Sort a list
        Collections.sort(numbers);
        System.out.println("Sorted: " + numbers.toString());

        // Search a list
        System.out.println("Contains 5: " + numbers.contains(5));
        System.out.println("Last index of 1 is " + numbers.lastIndexOf(1));
        System.out.println("Location of 1 in sorted list: " + Collections.binarySearch(numbers, 1));

        // Remove item
        numbers.remove(5);
        // Remove based on value
        it = numbers.iterator();
        while (it.hasNext()){
            if(it.next() == 1)
                it.remove();
        }
        System.out.println(numbers.toString());

        List<Integer> new_list = new ArrayList<Integer>(Arrays.asList(3,5));
        System.out.println("Contains all list element or not? " + num_reverse.containsAll(new_list));

        // Arraylist to Arrays
        int[] arr = new int[num_reverse.size()];
        Iterator<Integer> it1 = num_reverse.iterator();
        for(int i=0; i<arr.length; i++){
            arr[i] = it1.next();
        }
        System.out.println(Arrays.toString(arr));

        // Sublist
        List<Integer> sublist = num_reverse.subList(3,8);
        System.out.println(sublist.toString());

        // Swap and Shuffle elements in List
        System.out.println("Current: " + numbers.toString());
        Collections.swap(numbers,1,numbers.size()-1);
        System.out.println("Swap first and last: " + numbers.toString());
        Collections.shuffle(numbers);
        System.out.println("Shuffled: " + numbers.toString());

    }
}
