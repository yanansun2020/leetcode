package oa.amazon.ftoa;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class WallsandGates {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++){
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        bfs(rooms, queue);
    }
    void bfs(int[][] rooms, Queue<int[]> queue){
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] visited = new int[rooms.length][rooms[0].length];
        int distance = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            distance++;
            for (int i = 0; i < size; i++) {
                int[] topEle = queue.poll();
                for (int[] dir : directions) {
                    int x = topEle[0] + dir[0];
                    int y = topEle[1] + dir[1];
                    if (!isValidPos(x, y, rooms, visited)) {
                        continue;
                    }
                    visited[x][y] = 1;
                    rooms[x][y] = Math.min(rooms[x][y], distance);
                    queue.offer(new int[]{x, y});
                }
            }
        }
    }

    private boolean isValidPos(int x, int y, int[][] rooms, int[][] visited) {
        int rows = rooms.length;
        int cols = rooms[0].length;
        if (x < 0 || x > rows - 1 || y < 0 || y > cols -1) {
            return false;
        }
        if (visited[x][y] == 1) {
            return false;
        }
        if (rooms[x][y] == -1) {
            return false;
        }
        return true;
    }
    @Test
    public void test(){
        int[][] rooms = new int[][]{{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        wallsAndGates(rooms);
    }
}
