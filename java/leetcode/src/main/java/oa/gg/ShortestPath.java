package oa.gg;

import java.util.*;

/**
 * Given edges, return a random shortest path
 */
public class ShortestPath {
    public List<Integer> getShortesPath(int[][] edges, int start, int end) {
        Map<Integer, List<Integer>> nodes = buildNode(edges);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        Map<Integer, Integer> traceBackMap = new HashMap<>();
        traceBackMap.put(start, null);
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer curNode = queue.poll();
                if (curNode == end) {
                    return buildPath(traceBackMap, end);
                }
                List<Integer> neis = nodes.get(curNode);
                for (Integer nei : neis) {
                    if (visited.contains(nei)) {
                        continue;
                    }
                    visited.add(nei);
                    queue.offer(nei);
                }
            }
        }
        return null;
    }

    public Map<Integer, List<Integer>> buildNode(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> list = map.getOrDefault(edge[0], new ArrayList<>());
            if (list.contains(edge[1])) {
                continue;
            }
            list.add(edge[1]);
            map.put(edge[0], list);
        }
        return map;
    }

    public List<Integer> buildPath(Map<Integer, Integer> traceMap, int end) {
        List<Integer> res = new ArrayList<>();
        while (traceMap.get(end) != null) {
            res.add(end);
            end = traceMap.get(end);
        }
        return res;
    }

}
