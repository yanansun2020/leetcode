package slidingwindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * first find a satisfied string, then shrink
 * count record thr number of uniq char -is important
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int count = 0;
        int left = 0;
        String res = "";
        Map<Character, Integer> map_for_t = getMapForT(t);
        for (int right = 0; right < s.length(); right++) {
            Character c_right = s.charAt(right);
            if (map_for_t.containsKey(c_right)) {
                int tmp_right = map_for_t.get(c_right) - 1;
                map_for_t.put(c_right, tmp_right);
                if (tmp_right >= 0) {
                    count++;
                }
            }
            // already find a satisfied string, then start to shrink
            while (count == t.length()) {
                if (res.length() == 0 || right - left + 1 < res.length()) {
                    res = s.substring(left, right + 1);
                }
                Character c_left = s.charAt(left);
                if (map_for_t.containsKey(c_left)) {
                    int tmp_left = map_for_t.get(c_left) + 1;
                    map_for_t.put(c_left, tmp_left);
                    if (tmp_left > 0) {
                        count--;
                    }
                }
                left++;
            }
        }
        return res;
    }

    private Map<Character, Integer> getMapForT(String t){
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    @Test
    public void test(){
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "aa"));
    }
}
