package slidingwindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LongestSunstringWIthoutRepeatingC {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int res_length = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int j = 0; j < s.length() && i < s.length(); j++) {
            String c = s.charAt(j) + "";
            if (map.containsKey(c)) {
                res_length = Math.max(res_length, j - i);
                int k = map.get(c);
                for (int m = i; m <= k; m++) {
                    map.remove(s.charAt(m) + "");
                }
                i = k + 1;
            }
            map.put(c, j);
        }
        return Math.max(res_length, map.size());
    }

    @Test
    public void test(){
        System.out.println(lengthOfLongestSubstring("aab"));
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(""));
    }
}
