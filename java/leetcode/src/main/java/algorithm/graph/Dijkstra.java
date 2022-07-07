package algorithm.graph;

import org.junit.Test;

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


    public int[] dijkstra(int[][] graph, int src) {
        int v = graph.length;//get number of vertex
        int[] distance = new int[v];
        int[] visited = new int[v];
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2)->o1[1] - o2[1]); //[vertex, distance]
        //init disatnce
        for (int i = 0; i < v; i++) {
            if (i != src) distance[i] = Integer.MAX_VALUE;
        }
        //init neighbors
        Map<Integer, List<Integer>> map = new HashMap<>();
        initNeighbors(graph, map);

        //init queue
        queue.offer(new int[]{src, 0});
        while (!queue.isEmpty()) {
            int[] node =  queue.poll();
            int vertex = node[0];
            int d = node[1];
            visited[vertex] = 1;
            List<Integer> neis = map.get(vertex);
            if (neis == null || neis.size() == 0) {
                continue;
            }
            for (int nei : neis) {
                if (visited[nei] == 1) {
                    continue;
                }
                int min_dis = Math.min(distance[nei], d + graph[vertex][nei]);
                distance[nei] = min_dis;
                queue.offer(new int[]{nei,min_dis});
            }

        }
        return distance;

    }

    private void initNeighbors(int[][] g, Map<Integer, List<Integer>> map) {
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                if (g[i][j] < Integer.MAX_VALUE) {
                    List<Integer> tmp = map.getOrDefault(i, new ArrayList<>());
                    tmp.add(j);
                    map.put(i, tmp);
                }
            }
        }
    }

    @Test
    public void test() {
        int[][] graph = new int[][]{{0, 1,4}, {Integer.MAX_VALUE, 0, 1}, {Integer.MAX_VALUE, Integer.MAX_VALUE, 0}};
        int[] dis = dijkstra(graph, 0);
        System.out.println(dis);
    }
}
