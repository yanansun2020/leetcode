package backtracking;

import java.util.HashMap;
import java.util.Map;

public class WordPatternII {
    public boolean wordPatternMatch(String pattern, String s) {
        Map<String, String> pMap = new HashMap<>();
        Map<String, String> sMap = new HashMap<>();
        return dfs(pattern, s, 0, 0, pMap, sMap);
    }

    private boolean dfs(String p, String s, int pIndex, int sIndex, Map<String, String> pMap, Map<String, String> sMap) {
        if (pIndex == p.length()) {
            if(sIndex == s.length()) return true;
            return false;
        }
        String ch = p.charAt(pIndex) + "";
        for (int i = sIndex; i < s.length(); i++) {
            String sLeft = s.substring(sIndex, i + 1);
            if (pMap.get(ch) == null && sMap.get(sLeft) == null) {
                pMap.put(ch, sLeft);
                sMap.put(sLeft, ch);
                boolean res = dfs(p, s, pIndex+1, i + 1, pMap, sMap);
                if (res) {
                    return true;
                }
                pMap.remove(ch);
                sMap.remove(sLeft);
            }
            if (match(ch, pMap, sLeft, sMap)) {
                boolean res = dfs(p, s, pIndex+1, i + 1, pMap, sMap);
                if (res) {
                    return true;
                }
                //cannot remove keys not added by it
//                pMap.remove(ch);
//                sMap.remove(sLeft);
            }
        }
        return false;
    }

    private boolean match(String ch, Map<String, String> pMap, String s, Map<String, String> sMap) {
        String s1 = pMap.get(ch);
        String c1 = sMap.get(s);
        if (s1 != null && c1 != null && s1.equals(s) && c1.equals(ch)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String p = "abab";
        String s = "redblueredblue";
        p = "aabb";
        s = "xyzabcxzyabc";
        p = "abab";
        s = "asdasdasdasd";
        p = "sucks";
        s = "tsmmmmts";
        WordPatternII wordPatternII = new WordPatternII();
        boolean res = wordPatternII.wordPatternMatch(p, s);
        System.out.println(res);
    }
}
