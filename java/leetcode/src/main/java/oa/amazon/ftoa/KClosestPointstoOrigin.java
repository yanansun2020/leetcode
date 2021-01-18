package oa.amazon.ftoa;

import java.util.PriorityQueue;

/**
 * max heap
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
