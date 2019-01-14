import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Sorting {

    // Bubble Sort
    void bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }

    // Selection Sort
    void selectionSort(int arr[])
    {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    // Insertion Sort
    void insertionSort(int arr[])
    {
        int n = arr.length;
        for (int i=1; i<n; ++i)
        {
            int key = arr[i];
            int j = i-1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j>=0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }

    // Merge Sort
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int left, int mid, int right)
    {
        // Find sizes of two sub-arrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[left + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[mid + 1 + j];

        /* Merge the temp arrays */
        // Initial indexes of first and second sub-arrays
        int i = 0, j = 0;

        // Initial index of merged sub-array
        int k = left;

        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    // Main function that sorts arr[l..r] using
    // merge()
    void mergeSort(int arr[], int left, int right)
    {
        if (left < right)
        {
            // Find the middle point
            int mid = (left+right)/2;
            // Sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr , mid+1, right);
            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }


    // Quick Sort
    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    int partition(int arr[], int start, int end)
    {
        int pivot = arr[end];
        int i = (start-1); // index of smaller element
        for (int j=start; j<end; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = temp;
        return i+1;
    }
    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    void quickSort(int arr[], int start, int end)
    {
        if (start - end < 2)
            return;
        if (start < end)
        {
            /* pivotIdx is partitioning index, arr[pivotIdx] is now at right place */
            int pivotIdx = partition(arr, start, end);

            // Recursively sort elements before partition and after partition
            quickSort(arr, start, pivotIdx-1);
            quickSort(arr, pivotIdx+1, end);
        }
    }


    // Heap Sort
    public void heapSort(int arr[])
    {
        int n = arr.length;
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int arr[], int n, int i)
    {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2
        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;
        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;
        // If largest is not root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }


    // Shell Sort
    public void shellSort(int[] intArray){
        for(int gap = intArray.length/2; gap > 0; gap/=2){
            for(int i =gap; i<intArray.length; i++){
                int newElement = intArray[i];
                int j=i;
                while(j>=gap && intArray[j-gap]>newElement){
                    intArray[j]= intArray[j-gap];
                    j -= gap;
                }
                intArray[j] = newElement;
            }
        }
    }

    // Counting Sort
    public void countingSort(int[] input, int min, int max){
        int[] countArray = new int[(max-min)+1];
        for(int i=0;i<input.length;i++){
            countArray[input[i] - min]++;
        }
        int j=0;
        for(int i=min;i<=max;i++){
            while(countArray[i-min]>0){
                input[j++] = i; // write the output back to input array
                countArray[i-min]--; // decrement the count in countArray
            }
        }
    }

    // Radix Sort
    public void radixSort(int[] input, int radix, int width){
        for(int i=0;i<width;i++){
            radixSingleSort(input, i, radix);
        }
    }
    public void radixSingleSort(int[] input, int position, int radix){
        int numItems = input.length;
        int[] countArray = new int[radix];
        for(int value: input){
            countArray[getDigit(position, value, radix)]++;
        }
        // Adjust the count array
        for(int j=1;j<radix;j++){
            countArray[j] += countArray[j-1];
        }
        int[] temp = new int[numItems];
        // Writing from right to left to preserve order
        for(int tempIdx = numItems-1; tempIdx>=0; tempIdx--){
            temp[--countArray[getDigit(position,input[tempIdx],radix)]] = input[tempIdx];
        }
        for(int tempIdx = 0; tempIdx<numItems; tempIdx++){
            input[tempIdx] = temp[tempIdx];
        }
    }
    public int getDigit(int position, int value, int radix){
        return value/(int) Math.pow(radix,position) % radix;
    }


    // Bucket Sort
    public void bucketSort(int[] input){
        List<Integer>[] buckets = new List[10];
        for(int i=0;i<buckets.length;i++){
            // Using LinkedList for buckets
            //buckets[i] = new LinkedList<Integer>();
            // Using ArrayList for buckets
            buckets[i] = new ArrayList<Integer>();
        }
        for(int i=0;i<input.length;i++){
            buckets[hash(input[i])].add(input[i]);
        }
        for(List bucket: buckets){
            Collections.sort(bucket);
        }
        int j=0;
        for(int i=0;i<buckets.length;i++){
            for(int value:buckets[i]){
                input[j++] = value;
            }
        }
    }
    private int hash(int value){
        return value/(int)10;
    }


    public static void main(String[] args) {

        Sorting obj = new Sorting();
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        obj.bubbleSort(arr);
        System.out.println("Sorted array (Bubble Sort)");
        obj.printArray(arr);

        int arr1[] = {64,25,12,22,11};
        obj.selectionSort(arr1);
        System.out.println("Sorted array (Selection Sort)");
        obj.printArray(arr1);

        int arr2[] = {12, 11, 13, 5, 6};
        obj.insertionSort(arr2);
        System.out.println("Sorted array (Insertion Sort)");
        obj.printArray(arr2);

        int arr3[] = {12, 11, 13, 5, 6, 7};
        obj.mergeSort(arr3, 0, arr3.length-1);
        System.out.println("Sorted array (Merge Sort)");
        obj.printArray(arr3);

        int arr4[] = {10, 7, 8, 9, 1, 5};
        obj.quickSort(arr4, 0, arr4.length-1);
        System.out.println("Sorted array (Quick Sort)");
        obj.printArray(arr4);

        int arr5[] = {12, 11, 13, 5, 6, 7};
        obj.heapSort(arr5);
        System.out.println("Sorted array (Heap Sort)");
        obj.printArray(arr5);

        int arr6[] = {12, 11, 13, 5, 6, 7};
        obj.shellSort(arr6);
        System.out.println("Sorted array (Shell Sort)");
        obj.printArray(arr6);

        // Counting Sort
        /*
        makes assumption about the data
        doesn't use comparison
        counts the number of occurrences of each value
        only works with non negative discrete values (can't work with float and String)
        values must be within a specific range
        It is not an in-place algorithm
        Time complexity - O(n)
         */
        int[] intArray = {2,5,9,8,2,8,7,10,4,3};
        obj.countingSort(intArray,1,10);
        System.out.println("Sorted array (Counting Sort)");
        obj.printArray(intArray);

        //Radix Sort
        /*
        makes assumption about the data
        data must have same radix and width (hence data must be integers or strings)
        sort based on each individual digit or letter position
        start at the rightmost position
        must use a stable sort algorithm at each stage
        Counting Sort is often used as the sort algorithm for radix sort - must be stable counting sort
        Time Complexity - O(n)
        It often runs slower than O(nlogn) algorithms because of the overhead involved
        */
        int[] radixArray = {4725, 4586, 1330, 8792, 1594, 5729};
        obj.radixSort(radixArray,10,4);
        System.out.println("Sorted array (Radix Sort)");
        obj.printArray(radixArray);

        //Bucket Sort
        int bucketArr[] = {64, 34, 25, 12, 22, 11, 90};
        obj.bucketSort(bucketArr);
        System.out.println("Sorted array (Bucket Sort)");
        obj.printArray(bucketArr);

    }

    /* Prints the array */
    void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
