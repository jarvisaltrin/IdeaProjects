package com.company;

public class MinimumCostPath {

    public static int min(int x, int y, int z){
        if(x<y)
            return (x<z)? x:z;
        else
            return (y<z)? y:z;
    }

    public static int minCost(int[][] cost, int dest_x, int dest_y){
        int i,j;
        int[][] tc = new int[dest_x + 1][dest_y + 1];

        // Initialize the first column of total cost (tc) array
        for(i=1; i<=dest_x; i++)
            tc[i][0] = tc[i-1][0] + cost[i][0];
        // Initialize the first row of total cost (tc) array
        for(j=1; j<=dest_y; j++)
            tc[0][j] = tc[0][j-1] + cost[0][j];

        for(i=1;i<=dest_x;i++){
            for(j=1;j<=dest_y;j++){
                tc[i][j] = min(tc[i-1][j-1], tc[i-1][j], tc[i][j-1]) + cost[i][j];
            }
        }
        for (i=0;i<=dest_x;i++){
            for(j=0;j<=dest_y;j++){
                System.out.print(tc[i][j] + "\t");
            }
            System.out.println();
        }
        return tc[dest_x][dest_y];
    }

    public static void main(String[] args){
        int[][] cost = {{1,2,3,4},
                        {4,3,2,1},
                        {2,4,8,5},
                        {5,7,3,6}};
        int dest_x = 3, dest_y = 3;
        System.out.println("Cost from (0,0) to (" + dest_x + "," + dest_y
                + ") is: " + minCost(cost, dest_x, dest_y));
    }
}
