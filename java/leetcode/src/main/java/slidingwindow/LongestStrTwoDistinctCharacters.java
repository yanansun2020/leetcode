package slidingwindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LongestStrTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int MIN_SIZE = 2;
        int res = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            Character c_right = s.charAt(right);
            map.put(c_right, map.getOrDefault(c_right, 0) + 1);
            while (map.size() > MIN_SIZE) {
                Character c_left = s.charAt(left);
                if (map.get(c_left) > 0) {
                    map.put(c_left, map.get(c_left) - 1);
                }
                if (map.get(c_left) == 0) {
                    map.remove(c_left);
                }
                left++;
            }
            if (map.size() <= MIN_SIZE) {
                res = Math.max(res, right - left + 1);
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(lengthOfLongestSubstringTwoDistinct("a"));
        System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
        System.out.println(lengthOfLongestSubstringTwoDistinct("ccaabbb"));
        System.out.println(lengthOfLongestSubstringTwoDistinct("ecebaeeeeeeee"));
    }
}
