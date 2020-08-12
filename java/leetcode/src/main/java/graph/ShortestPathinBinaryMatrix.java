package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathinBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid == null || grid.length ==0 || grid[0].length == 0){
            return -1;
        }
        if(grid[0][0] == 1){
            return -1;
        }
        Queue<Path> queue = new LinkedList<>();
        Path path = new Path(0,0,1);
        queue.offer(path);
        List<List<Integer>> visited = new ArrayList<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        while(!queue.isEmpty()){
            Path topEle = queue.poll();
            if (topEle.x == grid.length-1 && topEle.y == grid[0].length-1){
                return topEle.depth;
            }
            for(int[] direction : directions){
                Integer x = topEle.x + direction[0];
                Integer y = topEle.y + direction[1];
                if (x <0 || x > grid.length-1 || y < 0 || y > grid[0].length -1){
                    continue;
                }
                if(grid[x][y] != 0){
                    continue;
                }
                grid[x][y] = 2;
                // List<Integer> tmp = new ArrayList<>();
                // tmp.add(x);
                // tmp.add(y);
                // if(visited.contains(tmp)){
                //     continue;
                // }
                // visited.add(tmp);
                Path new_path = new Path(x, y, topEle.depth + 1);
                queue.offer(new_path);
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        ShortestPathinBinaryMatrix test = new ShortestPathinBinaryMatrix();
        int[][] array0 = {{0}};
        System.out.println(test.shortestPathBinaryMatrix(array0));
        int[][] array = {{0,1},{1,0}};
        System.out.println(test.shortestPathBinaryMatrix(array));
        int[][] array1 = {{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(test.shortestPathBinaryMatrix(array1));
    }

}
class Path{
    Integer x;
    Integer y;
    Integer depth;
    Path(){}
    Path(Integer x, Integer y, Integer depth){
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}
