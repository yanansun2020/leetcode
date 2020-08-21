package string;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k){
        int n = s.length();
        if (n*k == 0) return 0;
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();
        int max_len = 1;
        while (right < n) {
            // add new character and move right pointer
            hashmap.put(s.charAt(right), right++);

            // slidewindow contains 3 characters
            if (hashmap.size() == k + 1) {
                // delete the leftmost character
                int del_idx = Collections.min(hashmap.values());
                hashmap.remove(s.charAt(del_idx));
                // move left pointer of the slidewindow
                left = del_idx + 1;
            }
            max_len = Math.max(max_len, right - left);
        }
        return max_len;
    }
    public int lengthOfLongestSubstringKDistinct_1(String s, int k) {
        if(s== null|| s.length() == 0 || k <=0){
            return 0;
        }
        int globalCount = 0;
        int count = 0;
        for(int i =0; i<s.length(); i++){
            Set<Character> set = new HashSet<>();
            count = 0;
            for(int j=i; j< s.length(); j++){
                set.add(s.charAt(j));
                if(set.size() <= k){
                    count++;
                    globalCount = Math.max(count, globalCount);
                }else{
                    break;
                }
            }
        }
        return globalCount;
    }
    @Test
    public void test(){
        int a = lengthOfLongestSubstringKDistinct("eceba", 2);
        int b = lengthOfLongestSubstringKDistinct("aa", 1);
    }
}
