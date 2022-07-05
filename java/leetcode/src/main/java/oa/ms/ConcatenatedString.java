package oa.ms;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/discuss/interview-question/2209201/Microsoft-Online-Assessment-Questions-3
public class ConcatenatedString {

    public int concatinate(String[] arr) {
        Set<String> set = new HashSet<>();
        for (String s :arr) {
            if (noRepeat(s)) {
                set.add(s);
            }
        }
        if (set.size() == 0) {
            return 0;
        }
        Set<String> res = new HashSet<>();
        for (String s: set) {
            String sameS = hasSame(s, res);
            if (sameS.length() > 0) {
                if (sameS.length() < s.length()) {
                    res.remove(sameS);
                    res.add(s);
                }
            } else {
                res.add(s);
            }
        }
        int resLength = 0;
        for (String s : res) {
            resLength += s.length();
        }
        return resLength;
    }

    private String hasSame(String s, Set<String> set) {
        String sameC = "";
        for (String s1 : set) {
            if ((getMask(s) & getMask(s1)) != 0) {
                return s1;
            }
        }
        return sameC;
    }

    private boolean noRepeat(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    private int getMask(String s) {
        int mask = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int k = c - 'a';
            mask |= (1 << (25 - k));
        }
        return mask;
    }

    @Test
    public void test() {
       String[] arr = {"un","iq","ue"};
       arr = new String[] {"cha","r","act","ers"};
       arr = new String[] {"abcdefghijklmnopqrstuvwxyz"};
       arr = new String[] {"aa","bb"};
       System.out.println(concatinate(arr));
    }
}
