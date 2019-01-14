package com.company;

public class Main {

    public static int max(int a, int b){
        return (a>b)?a:b;
    }

    public static int min(int x,int y,int z)
    {
        if (x <= y && x <= z) return x;
        if (y <= x && y <= z) return y;
        else return z;
    }

    /* Returns length of LCS for X[0..m-1], Y[0..n-1]
    * Time Complexity O(mn)
    * */
    public static int longestCommonSubsequence(char[] X, char[] Y, int m, int n){

        int L[][] = new int[m+1][n+1];
        /* Following steps build L[m+1][n+1] in bottom up fashion. Note
        that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X[i-1] == Y[j-1])
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    L[i][j] = max(L[i-1][j], L[i][j-1]);
            }
        }
        return L[m][n];
    }

    /*
    * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest
    * subsequence of a given sequence such that all elements of the subsequence are sorted in increasing order.
    * For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and
    * LIS is {10, 22, 33, 50, 60, 80}.
    *
    * Time Complexity O(n^2)
    * */
    public static int longestIncreasingSubsequence(int[] arr, int n){
        int[] lis = new int[n];
        int i,j,max = 0;
        /* Initialize LIS values for all indexes */
        for(i=0;i<n;i++)
            lis[i] = 1;
        /* Compute optimized LIS values in bottom up manner */
        for(i=1;i<n;i++)
            for(j=0;j<i;j++)
                if(arr[i]>arr[j] && lis[i]<lis[j]+1)
                    lis[i] = lis[j] + 1;
        /* Pick maximum of all LIS values */
        for ( i = 0; i < n; i++ )
            if ( max < lis[i] )
                max = lis[i];
        return max;
    }

    /*
    * Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits
    * (operations - insert, remove, replace) required to convert ‘str1’ into ‘str2’.
    *
    * Time Complexity - O(mn)
    * */
    public static int editDistDP(String str1, String str2, int m, int n)
    {
        // Create a table to store results of sub-problems
        int dp[][] = new int[m+1][n+1];

        // Fill d[][] in bottom up manner
        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                // If first string is empty, only option is to
                // insert all characters of second string
                if (i==0)
                    dp[i][j] = j;  // Min. operations = j

                // If second string is empty, only option is to
                // remove all characters of second string
                else if (j==0)
                    dp[i][j] = i; // Min. operations = i

                // If last characters are same, ignore last char
                // and recur for remaining string
                else if (str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];

                // If the last character is different, consider all
                // possibilities and find the minimum
                else
                    dp[i][j] = 1 + min(dp[i][j-1],  // Insert
                            dp[i-1][j],  // Remove
                            dp[i-1][j-1]); // Replace
            }
        }

        return dp[m][n];
    }

    /*
    * Given a set of integers, the task is to divide it into two sets S1 and S2
    * such that the absolute difference between their sums is minimum.
    *
    * Time Complexity - O(n*sum)
    * */
    public static int findMin(int arr[], int n)
    {
        // Calculate sum of all elements
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];

        // Create an array to store results of sub-problems
        boolean dp[][] = new boolean[n + 1][sum + 1];

        // Initialize first column as true.
        // 0 sum is possible with all elements.
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;

        // Initialize top row, except dp[0][0],
        // as false. With 0 elements, no other
        // sum except 0 is possible
        for (int i = 1; i <= sum; i++)
            dp[0][i] = false;

        // Fill the partition table in bottom up manner
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= sum; j++)
            {
                // If i'th element is excluded
                dp[i][j] = dp[i - 1][j];

                // If i'th element is included
                if (arr[i - 1] <= j)
                    dp[i][j] |= dp[i - 1][j - arr[i - 1]];
            }
        }

        // Initialize difference of two sums.
        int diff = Integer.MAX_VALUE;

        // Find the largest j such that dp[n][j]
        // is true where j loops from sum/2 t0 0
        for (int j = sum / 2; j >= 0; j--)
        {
            // Find the
            if (dp[n][j] == true)
            {
                diff = sum - 2 * j;
                break;
            }
        }
        return diff;
    }



    public static void main(String[] args) {

        Main m1 = new Main();
        String s1 = "AGGTB";
        String s2 = "GXTXAYB";
        char[] X =  s1.toCharArray();
        char[] Y =  s2.toCharArray();
        int m = X.length, n = Y.length;
        System.out.println("The length of longest common subsequence is: "
                + longestCommonSubsequence(X,Y,m,n) + "\n");


        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        System.out.println("The length of longest increasing subsequence is: "
                + longestIncreasingSubsequence( arr, arr.length ) + "\n");


        String str1 = "sunday";
        String str2 = "saturday";
        System.out.println("Edit Distance: " +
                editDistDP( str1 , str2 , str1.length(), str2.length()) + "\n");

    }
}
