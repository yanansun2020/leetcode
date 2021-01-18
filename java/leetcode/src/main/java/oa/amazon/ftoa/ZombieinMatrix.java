package oa.amazon.ftoa;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2D grid, each cell is either a zombie 1 or a human 0.
 * Zombies can turn adjacent (up/down/left/right) human beings into zombies every hour.
 * Find out how many hours does it take to infect all humans?
 */
public class ZombieinMatrix {
    int minHours(int rows, int columns, int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++){
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int hour = 0;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
           int size =  queue.size();
           int flag = 0;
           for (int k = 0; k < size; k++) {
               int[] cur = queue.poll();
               for (int[] dir : dirs) {
                   int x = cur[0] + dir[0];
                   int y = cur[1] + dir[1];
                   if (x <0 || x > rows - 1 || y < 0 || y > columns -1) {
                       continue;
                   }
                   if (grid[x][y] == 0) {
                       grid[x][y] = 1;
                       flag = 1;
                       queue.offer(new int[]{x, y});
                   }
               }
           }
           if (flag == 1) {
               hour++;
           }
        }
        return hour;
    }
    @Test
    public void test(){
        int[][] nums = new int[][]{{0, 1, 1, 0, 1},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 0, 1},
            {0, 1, 0, 0, 0}};
        int ans = minHours(4, 5, nums);
    }
}
