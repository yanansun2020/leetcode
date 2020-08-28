package oa.amazon.oa2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemAssociation {
    List<String> count(String[][] items) {
        int n = items.length;

        int index = 0;
        Map<String, Integer> hash = new HashMap<String, Integer>();
        for (int i = 0; i < n; i++) {
            if (!hash.containsKey(items[i][0])) hash.put(items[i][0], index++);
            if (!hash.containsKey(items[i][1])) hash.put(items[i][1], index++);
        }

        UnionFind un = new UnionFind(hash.size());
        for (int i = 0; i < n; i++) {
            un.union(hash.get(items[i][0]), hash.get(items[i][1]));
        }

        int maxIndex = un.findMaxSize();
        List<String> ans = new ArrayList<>();
        System.out.println(maxIndex);
        for (Map.Entry<String, Integer> entry : hash.entrySet()) {
            String key = entry.getKey();
            Integer ind = entry.getValue();
//            System.out.println(key + un.find(ind));
            if (un.find(ind) == maxIndex) {
                ans.add(key);
            }
        }
        return ans;
    }
    @Test
    public void test(){
        String[][] items = {{"itemA", "itemB"}, {"itemB", "itemC"},{"itemD", "itemE"}, {"itemE", "itemF"}, {"itemG", "itemD"}};
        List<String> res = count(items);
    }
}
class UnionFind {
    int[] parents = null;
    int[] size = null;
    UnionFind(int n) {
        parents = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i; //parents is itself
            size[i] = 1;
        }
    }

    void union(int a, int b) {
        int parent_a = find(a);
        int parent_b = find(b);
        if (parent_a != parent_b) {
            parents[parent_b] = parent_a; //parents merge
            size[parent_a] += size[parent_b];
        }
    }

    int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    int findMaxSize() {
        int max = 0;
        int index = 0;
        for (int i = 0; i < size.length; i++) {
//                System.out.println("parents["+i+"]"+parents[i]+" size[" +i +"]"+ size[i]);
            if (size[i] > max) {
                max = size[i];
                index = i;
            }
        }
        return index;
    }

}
