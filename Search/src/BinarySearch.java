import java.util.Arrays;
import java.util.List;

// Java implementation of recursive Binary Search
class BinarySearch
{
    // Returns index of x if it is present in arr[l.. 
    // r], else return -1 
    int binarySearch(int arr[], int l, int r, int x)
    {
        if (r>=l)
        {
            int mid = l + (r - l)/2;

            // If the element is present at the  
            // middle itself 
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then  
            // it can only be present in left subarray 
            if (arr[mid] > x)
                return binarySearch(arr, l, mid-1, x);

            // Else the element can only be present 
            // in right subarray 
            return binarySearch(arr, mid+1, r, x);
        }

        // We reach here when element is not present 
        //  in array 
        return -1;
    }


    // Search a 2D matrix sorted in row and column order
    public static boolean matrixSearch(List<List<Integer>> A, int x){
        int row = 0, col = A.get(0).size()-1;
        while(row < A.size() && col >= 0){
            if(A.get(row).get(col).equals(x)){
                return true;
            }else if (A.get(row).get(col) < x){
                row++;
            }else{
                col--;
            }
        }
        return false;
    }

    // Driver method to test above 
    public static void main(String args[])
    {
        BinarySearch ob = new BinarySearch();
        int arr[] = {2,3,4,10,40};
        int n = arr.length;
        int val = 10;
        int result = ob.binarySearch(arr,0,n-1,val);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " +
                    result);

        List<List<Integer>> A = Arrays.asList(Arrays.asList(1,2,3),Arrays.asList(1,2,4),Arrays.asList(3,5,6));
        System.out.println(matrixSearch(A, 5));
    }
} 