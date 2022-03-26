package oa.gg;

import org.junit.Test;

import java.util.*;

/**
 * shortest path without weight->bfs
 * return any shortest path from start to end
 *
 * gas station, start with capacity but on some point, we got gas station
 */
public class ShortestPathNoWeight {
    public List<Integer> getShortestPath(int[][] points, int start, int end) {
        Map<Integer, List<Integer>> nodesMap = getNodeMp(points);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        Map<Integer, Integer> fromMap = new HashMap<>();
        fromMap.put(start, null);
        Set<Integer> set = new HashSet<>();
        set.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curNode = queue.poll();
                if (curNode == end) {
                    break;
                }
                if (!nodesMap.containsKey(curNode)) {
                    continue;
                }
                for (Integer nei : nodesMap.get(curNode)) {
                    if (set.contains(nei)) {
                        continue;
                    }
                    queue.offer(nei);
                    fromMap.putIfAbsent(nei, curNode);
                    set.add(nei);
                }
            }
        }

        return buildPath(fromMap, end, start);

    }

    public List<Integer> getShortestPathWithCapacity(int[][] points, int start, int end, int[] gas, int capacity) {
        Map<Integer, List<Integer>> nodesMap = getNodeMp(points);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, capacity});
        Map<Integer, Integer> fromMap = new HashMap<>();
        fromMap.put(start, null);
        Set<Integer> set = new HashSet<>();
        set.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curNodeAndCapacity = queue.poll();
                int curNode = curNodeAndCapacity[0];
                int curCapacity =  curNodeAndCapacity[1];
                if (curNode == end) {
                    return buildPath(fromMap, end, start);
                }
                if (curCapacity == 0) {
                    continue;
                }
                if (!nodesMap.containsKey(curNode)) {
                    continue;
                }
                for (Integer nei : nodesMap.get(curNode)) {
                    if (set.contains(nei)) {
                        continue;
                    }
                    if (gas[nei] == 1) {
                        queue.offer(new int[]{nei, capacity});
                    } else {
                        queue.offer(new int[]{nei, curCapacity - 1});
                    }
                    fromMap.putIfAbsent(nei, curNode);
                    set.add(nei);
                }
            }
        }
        return new ArrayList<>();
    }

    private Map<Integer, List<Integer>> getNodeMp(int[][] points){
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] point : points) {
            map.putIfAbsent(point[0], new ArrayList<>());
            map.get(point[0]).add(point[1]);
        }
        return map;
    }

    private List<Integer> buildPath(Map<Integer, Integer> fromMap, int end, int start) {
        List<Integer> res = new ArrayList<>();
        res.add(end);
        while (start != end) {
            Integer newEnd = fromMap.get(end);
            res.add(newEnd);
            end = newEnd;
        }
        Collections.reverse(res);
        return res;
    }

    @Test
    public void test() {
        int[][] points = new int[][]{{1,2}, {2,3}, {2,5}, {2, 4}, {2,1}, {1, 4}, {4, 5}};
        List<Integer> res = getShortestPath(points, 1, 5);
        int[] gas = new int[6];
        gas[4] = 1;
        res = getShortestPathWithCapacity(points, 1, 5, gas, 1);
    }

}
