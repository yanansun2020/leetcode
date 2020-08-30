package graph;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {
//    keypoint: when to set maze[x][y] as visited
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return bfs(maze, start, destination);
    }
    boolean bfs(int[][] maze, int[] start, int[] destination){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        visited[start[0]][start[1]] = true;
        while(!queue.isEmpty()){
            int[] topEle = queue.poll();
            if(topEle[0] == destination[0] && topEle[1] == destination[1]){
                return true;
            }
            for(int[] direction : directions){
                int x = topEle[0];
                int y = topEle[1];
                while(x>=0 && x <=maze.length-1 && y >= 0 && y <= maze[0].length-1&& maze[x][y] == 0){
                    x += direction[0];
                    y +=  direction[1];
                }
                x -= direction[0];
                y -= direction[1];
                if(!visited[x][y]){
                    visited[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return false;
    }
//    int[] dfs(int[][] maze,int x, int y, int prevX, int prevY){
//        if(x <0 || y < 0 || x > maze.length-1 || y > maze[0].length-1){
//            return null;
//        }
//        if(maze[x][y] == 2){
//            return null;
//        }
//        if(maze[x][y] == 1){
//            return new int[]{prevX, prevY};
//        }
//        maze[x][y] = 2;
//        int[] up = dfs(maze, x-1, y, x, y);
//        int[] down = dfs(maze, x+1, y, x, y);
//        int[] left = dfs(maze, x, y-1, x, y);
//        int[] right = dfs(maze, x, y+1, x, y);
//    }
    @Test
    public void test(){
        int[][] maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        boolean ans =hasPath(maze, new int[]{0,4}, new int[]{3,2});
    }
}
