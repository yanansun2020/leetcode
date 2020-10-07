package unionfind;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostStonesRemovedwithSameRoworColumn {
    public int removeStones(int[][] stones) {
        Map<Integer, List<Integer>> rowMap = new HashMap<>();
        Map<Integer, List<Integer>> colMap = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            int[] stone = stones[i];
            int x = stone[0];
            int y = stone[1];
            List<Integer> rows = rowMap.getOrDefault(x, new ArrayList<>());
            rows.add(i);
            rowMap.put(x, rows);
            List<Integer> cols = colMap.getOrDefault(y, new ArrayList<>());
            cols.add(i);
            colMap.put(y, cols);
        }
        UnionFind unionFind = new UnionFind(stones.length);
        unionRowAndColumn(unionFind, rowMap);
        unionRowAndColumn(unionFind, colMap);
        int cycle = unionFind.getCircle();
        return stones.length - cycle;
    }

    private void unionRowAndColumn(UnionFind unionFind, Map<Integer, List<Integer>> map) {
        for (Map.Entry<Integer, List<Integer>> row : map.entrySet()) {
            List<Integer> unionList = row.getValue();
            Integer seed = unionList.get(0);
            for (int i = 1; i < unionList.size(); i++) {
                unionFind.union(seed, unionList.get(i));
            }
        }
    }

    @Test
    public void test() {
        int[][] stones = new int[][]{{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        int ans = removeStones(stones);
        stones = new int[][]{{0,0},{0,2},{1,1},{2,0},{2,2}};
        ans = removeStones(stones);
        stones = new int[][]{{0, 0}};
        ans = removeStones(stones);
    }
}
