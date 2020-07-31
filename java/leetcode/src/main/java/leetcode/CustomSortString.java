package leetcode;

import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
    public String customSortString(String S, String T) {
        Map<String, Integer> map = new HashMap<>();
        for(int index =0; index < S.length(); index++){
            map.put(S.charAt(index) + "", index);
        }
    }
}
