package oa.amazon.ftoa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class LargestItemAssociation {

    public static void main(String[] args) {
        System.out.println(largestItemAssociation(Arrays.asList(
            new PairString("Item1", "Item2"),
            new PairString("Item3", "Item4"),
            new PairString("Item4", "Item5")
        )));

        System.out.println(largestItemAssociation(Arrays.asList(
            new PairString("Item1", "Item2"),
            new PairString("Item2", "Item8"),
            new PairString("Item2", "Item10"),
            new PairString("Item10", "Item12"),
            new PairString("Item10", "Item4"),
            new PairString("Item10", "Item3"),
            new PairString("Item3", "Item4"),
            new PairString("Item4", "Item5")
        )));
    }
    public static List<String> largestItemAssociation(List<PairString> itemAssociation) {
        Map<String, Set<String>> associationMap = getAdjacentMap(itemAssociation);
        List<String> result = new ArrayList<>();
        for (String name : associationMap.keySet()) {
            Set<String> visited = new HashSet<>();
            List<String> cur = dfs(name, associationMap, visited);
            if (cur.size() > result.size()) {
                result = cur;
            }
        }
        return result;
    }

    /**
     * dfs bottom- up
     * @param name
     * @param map
     * @param visited
     * @return
     */
    private static List<String> dfs(String name, Map<String, Set<String>> map, Set<String> visited) {
        if (!visited.add(name)) {
            return new ArrayList<>();
        }
        List<String> cur = new ArrayList<>();
        for (String dep : map.get(name)) {
            List<String> next = dfs(dep, map, visited);
            if (next.size() > cur.size()) {
                cur = next;
            }
        }
        visited.remove(name);
        cur.add(0, name);
        return cur;
    }


    private static Map<String, Set<String>> getAdjacentMap(List<PairString> itemAssociation) {
        Map<String, Set<String>> map = new TreeMap<>((a, b)->a.compareTo(b));
        for (PairString pairs : itemAssociation) {
            if (!pairs.first.equals(pairs.second)){
                map.computeIfAbsent(pairs.first, val -> new HashSet<>()).add(pairs.second);
                map.computeIfAbsent(pairs.second, val -> new HashSet<>()).add(pairs.first);
            }
        }
        return map;
    }
}

class PairString{
    String first;
    String second;
    public PairString(String first, String second) {
        this.first = first;
        this.second = second;
    }
}
