import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// Time complexity = (n log k)
public class KClosest {

    public static void main(String[] args){
        int[][] points = {{3,3}, {5,-1}, {-2,4}};
        int k = 2;
        int[][] res = kClosest(points, k);
        for(int[] row : res){
            System.out.println(Arrays.toString(row));
        }
    }

    // Here we maintain a max heap of size k
    private static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0]-b[1]*b[1]);
            }
        });
        for(int[] point: points)
            pq.offer(point); // add element to priority queue

        int[][] result = new int[k][2];
        for(int i=0;i<k;i++){
            int[] point = pq.poll();
            result[i][0] = point[0];
            result[i][1] = point[1];
        }
        return result;
    }


}
