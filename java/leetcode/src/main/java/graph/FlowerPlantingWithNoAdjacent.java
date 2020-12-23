package graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FlowerPlantingWithNoAdjacent {
    public int[] gardenNoAdj(int n, int[][] paths) {
        if (paths == null ||paths.length == 0) {
            int[] res = new int[n];
            Arrays.fill(res, 1);
            return res;
        }
        Map<Integer, List<Integer>> map = getAdjancentList(paths);
        //0-not filled
        int[] color = new int[n];
        color[0] = 1;
        for (int i = 2; i <= n; i++) {
            List<Integer> adjancent = map.get(i);
            Set<Integer> availableColor = getAvailableColor(adjancent, color);
            List<Integer> tmp = new ArrayList<>(availableColor);
            color[i - 1] = tmp.get(0);
        }
        return color;
    }
    Set<Integer> getAvailableColor(List<Integer> adjancent, int[] color){
        Set<Integer> availableColor = new HashSet<>();
        for (int i = 1; i<=4; i++) {
            availableColor.add(i);
        }
        if (adjancent == null) {
            return availableColor;
        }
        for (int node : adjancent) {
            if (color[node-1] != 0) {
                availableColor.remove(color[node - 1]);
            }
        }
        return availableColor;
    }
    Map<Integer, List<Integer>> getAdjancentList(int[][] paths){
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < paths.length; i++) {
            int source = paths[i][0];
            int dest = paths[i][1];
            List<Integer> lst1 = map.getOrDefault(source, new ArrayList<>());
            List<Integer> lst2 = map.getOrDefault(dest, new ArrayList<>());
            lst1.add(dest);
            lst2.add(source);
            map.put(source, lst1);
            map.put(dest, lst2);
        }
        return map;
    }

    @Test
    public void test(){
        int[] res = gardenNoAdj(3, new int[][]{{1,2},{2,3},{3,1}});
    }
}
