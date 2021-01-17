package oa.amazon.ftoa;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringsofSizeKwithK1DistinctChars {
    public List<String> substr_of_size_k(String s, int k){
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        List<String> ans = new ArrayList<>();
        while (right < s.length()) {
            Character c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (right - left + 1 == k) {
                if (map.size() == k - 1) {
                    ans.add(s.substring(left, right + 1));
                }
                Character leftC = s.charAt(left);
                map.put(leftC, map.get(leftC) - 1);
                if (map.get(leftC) == 0) {
                    map.remove(leftC);
                }
                left++;
            }
            right++;
        }
        return ans;
    }
    @Test
    public void test(){
        String s = "abacab";
        List<String> lst = substr_of_size_k(s, 3);
    }
}
