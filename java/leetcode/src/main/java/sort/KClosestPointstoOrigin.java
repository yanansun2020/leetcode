package sort;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * k smallest use maxheap
 */
public class KClosestPointstoOrigin {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Coordinate> queue = new PriorityQueue<Coordinate>(K, ((o1, o2) -> o2.distance - o1.distance));
        for (int[] point : points) {
            Coordinate coordinate = new Coordinate(point[0], point[1]);
            if (queue.size() < K) {
                queue.offer(coordinate);
            } else {
                if (queue.peek().distance > coordinate.distance) {
                    queue.poll();
                    queue.offer(coordinate);
                }
            }
        }
        int[][] ans = new int[K][2];
        int i = 0;
        while (queue.size() > 0) {
            Coordinate coordinate = queue.poll();
            ans[i++] = new int[]{coordinate.i, coordinate.j};
        }
        return ans;
    }
    @Test
    public void test(){
        int[][] arrs = new int[][]{{3,3},{5,-1},{-2,4}};
        int[][] ans = kClosest(arrs, 2);
        arrs = new int[][]{{6,10},{-3,3},{-2,5},{0,2}};
        ans = kClosest(arrs, 3);
    }
}

class Coordinate{
    int i;
    int j;
    int distance;
    Coordinate(int i, int j){
        this.i = i;
        this.j = j;
        this.distance = i * i + j * j;
    }
}
