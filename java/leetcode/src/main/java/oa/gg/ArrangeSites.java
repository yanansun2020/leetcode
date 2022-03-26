package oa.gg;

import org.junit.Test;

import java.util.*;

/**
 * 排座问题，给n个人名和一些不能挨着坐的人，要求把他们安排到n个座位里，输出所有可能性。还是DFS。
 */
public class ArrangeSites {
    public List<List<Integer>> arrange(int n, int[][] enemies) {
        LinkedList<Integer> row = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> enemyMap = getMap(enemies);
        dfs(n, row, res, enemyMap);
        return res;
    }

    private void dfs(int n, LinkedList<Integer> row, List<List<Integer>> res, Map<Integer, List<Integer>> map) {
        if (row.size() == n) {
            res.add(new ArrayList<>(row));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (canSelect(i, row, map)) {
                //option1. select i on position i
                row.add(i);
                dfs(n, row, res, map);
                row.removeLast();
                //option2. not select i on position i
                //dfs(n, row, res, map);
            }
        }
    }

    private boolean canSelect(int i, LinkedList<Integer> visited, Map<Integer, List<Integer>> map) {
        if (visited.contains(i)) {
            return false;
        }
        if (visited == null || visited.size() == 0) {
            return true;
        }
        int lastEle = visited.getLast();
        if (map.containsKey(lastEle)) {
            if (map.get(lastEle).contains(i)) {
                return false;
            }
        }
        return true;
    }

    private Map<Integer, List<Integer>> getMap(int[][] enemies) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] enemy : enemies) {
            int p1 = enemy[0];
            int p2 = enemy[1];
            map.putIfAbsent(p1, new ArrayList<>());
            map.putIfAbsent(p2, new ArrayList<>());
            map.get(p1).add(p2);
            map.get(p2).add(p1);
        }
        return map;
    }
    @Test
    public void test() {
        int n = 4;
        int[][] enemy = new int[][]{{2, 3}};
        List<List<Integer>> res = arrange(n, enemy);
    }
}
