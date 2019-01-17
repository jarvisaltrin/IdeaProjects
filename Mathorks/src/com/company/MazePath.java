package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MazePath {

    public static void main(String[] args){
        List<List<Integer>> maze = new ArrayList<>();
        maze.add(Arrays.asList(1, 1, 1, 1));
        maze.add(Arrays.asList(1, 0, 1, 1));
        maze.add(Arrays.asList(1, 1, 0, 1));

        int paths = numberOfPaths(maze);
        System.out.println("Number of paths (from source to destination): " + paths);

        int shortest_length = shortestPathLength(maze);
        System.out.println("Shortest Path Length (from source (0,0) to destination(3,4)): " + shortest_length);
    }

    // Count the number of paths from source to destination
    public static int numberOfPaths(List<List<Integer>> maze){
        Integer[][] array = new Integer[maze.size()][];
        Integer[] blankArray = new Integer[0];
        for(int i=0; i < maze.size(); i++) {
            array[i] = maze.get(i).toArray(blankArray);
        }
        /*
        // Print Array
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
        */
        int x = 0, y = 0; // start position
        int noOfRows = array.length;
        int noOfCols = array[0].length;
        int count = 0; // initial count
        boolean[][] visited = new boolean[noOfRows][noOfCols];

        int noOfPaths = countPaths(array, x, y, visited, count, noOfRows, noOfCols);
        return noOfPaths;
    }
    public static int countPaths(Integer maze[][], int x, int y, boolean visited[][], int count, int noOfRows, int noOfCols){
        // If destination reached
        if(x == noOfRows-1 && y == noOfCols -1){
            count++;
            return count;
        }
        visited[x][y] = true; //mark current cell as visited
        // if current cell is a valid and open cell
        if (isValidCell(x, y, noOfRows, noOfCols) && maze[x][y] == 1)
        {
            // go down (x, y) --> (x + 1, y)
            if (x + 1 < noOfRows && !visited[x + 1][y])
                count = countPaths(maze, x + 1, y, visited, count, noOfRows, noOfCols);
            // go right (x, y) --> (x, y + 1)
            if (y + 1 < noOfCols && !visited[x][y + 1])
                count = countPaths(maze, x, y + 1, visited, count, noOfRows, noOfCols);
            /*
            // go up (x, y) --> (x - 1, y)
            if (x - 1 >= 0 && !visited[x - 1][y])
                count = countPaths(maze, x - 1, y, visited, count, noOfRows, noOfCols);
            // go left (x, y) --> (x, y - 1)
            if (y - 1 >= 0 && !visited[x][y - 1])
                count = countPaths(maze, x, y - 1, visited, count, noOfRows, noOfCols);
            */
        }
        // backtrack from current cell and remove it from current path
        visited[x][y] = false;
        return count;
    }

    // Check if cell (x, y) is valid or not
    private static boolean isValidCell(int x, int y, int noOfRows, int noOfCols){
        if (x < 0 || y < 0 || x >= noOfRows || y >= noOfCols)
            return false;
        return true;
    }

    // Check if it is possible to go to (x, y) from current position. The
    // function returns false if the cell has value 0 or already visited
    private static boolean isSafe(Integer maze[][], int visited[][], int x, int y){
        return !(maze[x][y] == 0 || visited[x][y] != 0);
    }

    // Find the shortest path in a matrix from (0,0) to (x,y)
    public static int shortestPathLength(List<List<Integer>> maze){
        // Convert list of list to 2D array
        Integer[][] array = new Integer[maze.size()][];
        Integer[] blankArray = new Integer[0];
        for(int i=0; i < maze.size(); i++) {
            array[i] = maze.get(i).toArray(blankArray);
        }

        int curr_x = 0, curr_y = 0; // start position
        int noOfRows = array.length;
        int noOfCols = array[0].length;
        System.out.println("Rows: " + noOfRows + " Columns: " + noOfCols);
        int x = array.length-1, y =array[0].length-1; // destination position
        int dist = 0; // initial distance
        int[][] visited = new int[noOfRows][noOfCols];

        int shortestLength = findShortestPathLength(array, curr_x, curr_y, x, y, visited, Integer.MAX_VALUE, dist, noOfRows, noOfCols);
        return shortestLength;
    }
    public static int findShortestPathLength(Integer maze[][], int curr_x, int curr_y, int x, int y, int visited[][], int min_dist, int dist, int noOfRows, int noOfCols){
        // if destination is found, update min_dist
        if (curr_x == x && curr_y == y)
        {
            return (dist > min_dist) ? min_dist : dist ;
        }

        visited[curr_x][curr_y] = 1;
        // go to bottom cell
        if (isValidCell(curr_x + 1, curr_y, noOfRows, noOfCols) && isSafe(maze, visited, curr_x + 1, curr_y)) {
            min_dist = findShortestPathLength(maze, curr_x + 1, curr_y, x, y, visited, min_dist, dist + 1, noOfRows, noOfCols);
        }

        // go to right cell
        if (isValidCell(curr_x, curr_y + 1, noOfRows, noOfCols) && isSafe(maze, visited, curr_x, curr_y + 1)) {
            min_dist = findShortestPathLength(maze, curr_x, curr_y+1, x, y, visited, min_dist, dist + 1, noOfRows, noOfCols);
        }

        // go to top cell
        if (isValidCell(curr_x - 1, curr_y, noOfRows, noOfCols) && isSafe(maze, visited, curr_x - 1, curr_y)) {
            min_dist = findShortestPathLength(maze, curr_x - 1, curr_y, x, y, visited, min_dist, dist + 1, noOfRows, noOfCols);
        }

        // go to left cell
        if (isValidCell(curr_x, curr_y - 1, noOfRows, noOfCols) && isSafe(maze, visited, curr_x, curr_y - 1)) {
            min_dist = findShortestPathLength(maze, curr_x, curr_y-1, x, y, visited, min_dist, dist + 1, noOfRows, noOfCols);
        }

        // Backtrack - Remove (curr_x, curr_j) from visited matrix
        visited[curr_x][curr_y] = 0;
        return min_dist;
    }

}
