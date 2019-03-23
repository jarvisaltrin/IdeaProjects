package com.company;

import java.util.Arrays;

public class NQueen {
    final static int N = 8;

    public static void main(String[] args){
        int board[][] = new int[N][N];
        for(int[] row : board)
            Arrays.fill(row, 0);
        if (solveNQueen(board, 0) == false) {
            System.out.print("Solution does not exist");
        }else {
            printSolution(board);
        }
    }

    private static boolean solveNQueen(int[][] board, int col) {
        if(col >= N) // if all queens are placed, return true
            return true;
        for(int row=0; row<N; row++){
            if(isSafe(board, row, col)){
                board[row][col] = 1;
                // recur to place rest of the queens
                if(solveNQueen(board, col+1))
                    return true;
                // Backtrack if this place doesn't lead to a solution
                board[row][col] = 0;
            }
        }
        return false; // if queen cannot be placed in any row in this column
    }

    /*
       A utility function to check if a queen can
       be placed on board[row][col]. Note that this
       function is called when "col" queens are already
       placed in columns from 0 to col -1. So we need
       to check only left side for attacking queens
    */
    private static boolean isSafe(int[][] board, int row, int col) {
        int i,j;
        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    private static void printSolution(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j] + " ");
            System.out.println();
        }
    }
}
