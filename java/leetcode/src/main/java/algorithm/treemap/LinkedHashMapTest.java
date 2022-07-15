package algorithm.treemap;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class LinkedHashMapTest {
    public int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        Set<Character> removed = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (removed.contains(c)) {
                continue;
            }
            if (map.containsKey(c)) {
                map.remove(c);
                removed.add(c);
            } else {
                map.put(c, i);
            }
        }
      //  s.repe
        return -1;
    }
}
