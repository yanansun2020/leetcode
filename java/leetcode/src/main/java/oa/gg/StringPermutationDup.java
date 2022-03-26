package oa.gg;

import org.junit.Test;
import sun.util.resources.cldr.zh.CalendarData_zh_Hans_SG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringPermutationDup {
    public List<String> pemutation(String s) {
        HashMap<Character, Integer> map = buildFreq(s);
        List<String> res = new ArrayList<>();
        dfs(map, "", s.length(), res);
        return res;
    }

    private HashMap<Character, Integer> buildFreq(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }
        return map;
    }

    public void dfs(HashMap<Character, Integer> map, String s, int remaining, List<String> res) {
        if (remaining == 0) {
            res.add(s);
            return ;
        }
        for (Character c : map.keySet()) {
            int count = map.get(c);
            if (count > 0) {
                map.put(c, count - 1);
                dfs(map, s + c, remaining - 1, res);
                map.put(c, count);
            }
        }
    }

    @Test
    public void test() {
        String s = "aab";
        List<String> sl = pemutation(s);

    }

}
