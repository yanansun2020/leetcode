package slidingwindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * divide and conquer
 */
public class LongestSubstringwithKRepeatingCharacters395 {
    public int longestSubstring(String s, int k) {
        return longestSubstring(s, k, 0, s.length());
    }

    public int longestSubstring(String s, int k, int start, int end) {
        if (s.length() < k) {
            return 0;
        }
        Map<Character, Integer> map = get_ch_count(s, start, end);
        for (int i = start; i < end; i++) {
            Character c = s.charAt(i);
            int count = map.get(c);
            if (count < k) {
                int left_res = longestSubstring(s, k, start, i);
                int right_res = longestSubstring(s, k, i + 1, end);
                return Math.max(left_res, right_res);
            }
        }
        return end -start;
    }

    private Map<Character, Integer> get_ch_count(String s, int start, int end){
        Map<Character, Integer> map = new HashMap<>();
        for (int i = start; i < end; i++) {
            Character c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
    @Test
    public void test(){
        int result = longestSubstring("aaabb", 3);
        result = longestSubstring("aaabb", 2);
        result = longestSubstring("ababbc", 2);
        result = longestSubstring("bbbbbb", 3);
    }
}
