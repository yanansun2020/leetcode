package unionfind;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmallestStringWithSwaps {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        char[] chars = s.toCharArray();
        UnionFind unionFind = new UnionFind(n);
        for (List<Integer> pair : pairs) {
            int x = pair.get(0);
            int y = pair.get(1);
            unionFind.union(x, y);
        }
        Map<Integer, List<Character>> charGroups = new HashMap<>();
        Map<Integer, List<Integer>> idGroups = new HashMap<>();
        for (int i =0; i < n; i++) {
            int parent = unionFind.find(i);
            List<Character> characterList = charGroups.getOrDefault(parent, new ArrayList<>());
            characterList.add(chars[i]);
            charGroups.put(parent, characterList);
            List<Integer> intList = idGroups.getOrDefault(parent, new ArrayList<>());
            intList.add(i);
            idGroups.put(parent, intList);
        }
        for (Map.Entry<Integer, List<Character>> charGroupMap : charGroups.entrySet()) {
            List<Character> values = charGroupMap.getValue();
            Collections.sort(values);
            List<Integer> ids = idGroups.get(charGroupMap.getKey());
            for (int i =0; i < values.size(); i++) {
                chars[ids.get(i)] = values.get(i);
            }
        }
        return String.valueOf(chars);
    }

    @Test
    public void test(){
        int[][] pairs = new int[][]{{0,3},{1,2}, {0, 2}};
        String ans = smallestStringWithSwaps("dcab", getList(pairs));
        pairs = new int[][]{{0,1}, {1,2}};
        ans = smallestStringWithSwaps("cba", getList(pairs));
    }

    public List<List<Integer>> getList(int[][] array){
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < array[i].length; j++) {
                row.add(array[i][j]);
            }
            ans.add(row);
        }
        return ans;
    }
}
