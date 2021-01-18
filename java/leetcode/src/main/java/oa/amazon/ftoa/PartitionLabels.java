package oa.amazon.ftoa;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        //the max index of each char
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), i);
        }
        List<Integer> ans = new ArrayList<>();
        int end = map.get(S.charAt(0));
        int startIndex = 0;
        for (int i = 0; i < S.length(); i++) {
            if (i == end) {
                ans.add(i - startIndex + 1);
                startIndex = i + 1;
                if (startIndex < S.length()){
                    end = map.get(S.charAt(startIndex));
                }
            } else {
                Character c = S.charAt(i);
                end = Math.max(end, map.get(c));
            }
        }
        return ans;
    }
    @Test
    public void test(){
        String s = "ababcbacadefegdehijhklij";
        List<Integer> ans = partitionLabels(s);
    }
}
