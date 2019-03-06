package com.company;

public class Overlap {

    class ListNode<T> {
        public T data;
        public ListNode<T> next;
    }

    private static int length(ListNode<Integer> L) {
        int len = 0;
        while (L != null) {
            len++;
            L = L.next;
        }
        return len;
    }

    public static ListNode <Integer> advanceListByK(int k, ListNode<Integer> L) {
        while (k-- > 0) {
            L = L.next;
        }
        return L;
    }

    /*
    The lists overlap if and only if both have the same tail node: once the lists converge
    at a node, they cannot diverge at a later node. Therefore, checking for overlap amounts
    to finding the tail nodes for each list.
    To find the first overlapping node, we first compute the length of each list. The
    first overlapping node is determined by advancing through the longer list by the
    difference in lengths, and then advancing through both lists in tandem, stopping at
    the first common node. If we reach the end of a list without finding a common node,
    the lists do not overlap.
     */
    // Time Complexity - O(n) and Space Complexity - O(1)
    public static ListNode<Integer> overlappingNoCycleList(ListNode<Integer> L1, ListNode<Integer> L2){
        int L1Length = length(L1), L2Length = length(L2);

        // Advances the longer list to get equal length lists
        if(L1Length > L2Length){
            L1 = advanceListByK(L1Length - L2Length, L1);
        }else{
            L2 = advanceListByK(L2Length - L1Length, L2);
        }

        while(L1 != null && L2 != null && L1 != L2){
            L1 = L1.next;
            L2 = L2.next;
        }
        return L1; // null pointer implies that there is no overlap between L1 and L2
    }

}
