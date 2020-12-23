package graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *
 */
public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        Map<Integer, Integer> group = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int j = 0;
        while (j < graph.length) {
            if (group.get(j) == null) {
                queue.offer(j);
                group.put(j, 1);
            }
            List<Integer> visited = new ArrayList<>();
            while (!queue.isEmpty()) {
                Integer topElement = queue.poll();
                visited.add(topElement);
                int[] neighbors = graph[topElement];
                int neighbor_gid = 1;
                if (group.get(topElement) == 1) {
                    neighbor_gid = 2;
                }
                for (int i = 0; i < neighbors.length; i++ ) {
                    if (visited.contains(neighbors[i])) {
                        continue;
                    }
                    if (group.get(neighbors[i]) != null && group.get(neighbors[i]) != neighbor_gid) {
                        return false;
                    }
                    group.put(neighbors[i], neighbor_gid);
                    queue.offer(neighbors[i]);
                }
            }
            j++;
        }
        return true;
    }

    @Test
    public void test(){
        int[][] graph = new int[][]{{1,3},{0,2},{1,3},{0,2}};
        graph = new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}};
        graph = new int[][]{{},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}};
        boolean res = isBipartite(graph);
    }
}
