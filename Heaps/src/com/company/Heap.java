package com.company;

public class Heap {

    private int[] heap;
    private int size;

    public Heap(int capacity){
        heap = new int[capacity];
    }


    // Time Complexity - O(log n)
    public void insert(int value){
        if(isFull())
            throw new IndexOutOfBoundsException("Heap is full");

        heap[size] = value;
        fixHeapAbove(size);
        size++;
    }

    /* Delete
    Must choose a replacement value
    Will take the rightmost value, so that the tree remains complete
    Then we must heapify the heap
    When replacement value is greater than parent, fix heap above(swap replacement value with parent).
    Otherwise fix heap below(swap replacement value with the larger of its two child)
    Rinse and repeat in both cases until the replacement value is in its correct position
    Will only need to fix up or down, not both
    */
    // Time Complexity - O(n log n) - n for linear search
    // To remove root, Time Complexity - O(log n) as it is first element and to fix heap it is O(log n)
    public int delete(int index){
        if(isEmpty())
            throw new IndexOutOfBoundsException("Heap is empty");

        int parent = getParent(index);
        int deletedValue = heap[index];

        // rightmost value in the heap will replace the value at index
        heap[index] = heap[size-1];

        if(index == 0 || heap[index] < heap[parent]){
            fixHeapBelow(index, size-1);
        }else{
            fixHeapAbove(index);
        }
        size--;
        return deletedValue;
    }


    // If parent is greater than child, swap it with child
    private void fixHeapAbove(int index){
        int newValue = heap[index];
        while(index > 0 && newValue > heap[getParent(index)]){
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }
        heap[index] = newValue;
    }

    // swap replacement value with the larger of its two child
    private void fixHeapBelow(int index, int lastHeapIndex){
        int childToSwap;
        while(index <= lastHeapIndex){
            int leftChild = getChild(index,true);
            int rightChild = getChild(index, false);
            if(leftChild <= lastHeapIndex) {
                // If this condition passes, only left child present
                if (rightChild > lastHeapIndex) {
                    childToSwap = leftChild;
                } else {
                    childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
                }
                if (heap[index] < heap[childToSwap]) {
                    int temp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = temp;
                } else {
                    break;
                }
                index = childToSwap;
            }else{
                break;
            }
        }
    }

    public int peek(){
        if(isEmpty())
            throw new IndexOutOfBoundsException("Heap is empty");

        return heap[0];
    }

    public boolean isFull(){
        return size == heap.length;
    }

    public int getParent(int index){
        return (index-1)/2;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getChild(int index, boolean left){
        return 2*index + (left ? 1:2);
    }

    public void printHeap(){
        for(int i=0;i<size;i++){
            System.out.print(heap[i]);
            System.out.print(", ");
        }
        System.out.println();
    }

}

