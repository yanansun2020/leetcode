package unionfind;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * not very like a union find problem
 */
public class PathWithMaximumMinimumValue {
    public int maximumMinimumPath(int[][] A) {
        return bfs(A);
    }
    int bfs (int[][] A) {
        PriorityQueue<Node> nodes = new PriorityQueue<>((o1, o2)->o2.val - o1.val);
        int rows = A.length;
        int cols = A[0].length;
        int[][] visit = new int[rows][cols];
        int minVal = Math.min(A[0][0], A[rows - 1][cols - 1]);
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Node node = new Node(0, 0, A[0][0]);
        nodes.offer(node);
        while (!nodes.isEmpty()) {
            Node curNode = nodes.poll();
            if (curNode.row == rows -1 && curNode.col == cols -1) {
                return minVal;
            }
            visit[curNode.row][curNode.col] = 1;
            minVal = Math.min(minVal, curNode.val);
            for (int[] direction : directions) {
                int x = curNode.row + direction[0];
                int y = curNode.col + direction[1];
                if (x < 0 || x > rows-1 || y < 0 || y > cols - 1) {
                    continue;
                }
                if (visit[x][y] == 1) {
                    continue;
                }
                nodes.offer(new Node(x, y, A[x][y]));
            }
        }
        return minVal;
    }

    @Test
    public void test() {
        int[][] A = new int[][]{{5,4,5},{1,2,6},{7,4,6}};
        int ans = maximumMinimumPath(A);
        A = new int[][] {{2,2,1,2,2,2},{1,2,2,2,1,2}};
        ans = maximumMinimumPath(A);
        A = new int[][] {{3,4,6,3,4},{0,2,1,1,7},{8,8,3,2,7},{3,2,4,9,8},{4,1,2,0,0},{4,6,5,4,3}};
        ans = maximumMinimumPath(A);
    }
}

class Node {
    Node () {}
    Node (int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
    int row;
    int col;
    int val;
}
