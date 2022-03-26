package algorithm.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//single source shortest path, shortest path to all other vertexes
//works on directed and undirected graph
//weight should not be negative
//bfs approach
public class Dijkstra {
    public int shortestPath(int[][] edges, int start, int end){

        //used to select the least distance data
        PriorityQueue<int[]> queue = new PriorityQueue<>((n1, n2) ->n1[1]-n2[1]);
        Map<Integer, List<int[]>> distanceMap = getDisMap(edges);
        Map<Integer, Integer> visitedMap = new HashMap<>();
        queue.offer(new int[]{start, 0});

        while(!queue.isEmpty()){
           int[] nodeAndLength = queue.poll();
           int node = nodeAndLength[0];
           int length = nodeAndLength[1];
           if (visitedMap.containsKey(node)) {
               continue;
           }
           if (node == end) {
               return length;
           }
           visitedMap.put(node, length);
           if (distanceMap.containsKey(node)) {
               for (int[] nei : distanceMap.get(node)) {
                   if (visitedMap.containsKey(nei[0])) {
                       continue;
                   }
                   queue.offer(new int[]{nei[0],  nei[1] + length});
               }
           }
        }
        return -1;
    }

    private Map<Integer, List<int[]>> getDisMap(int[][] edges) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        return map;
    }
}
