package oa.ms;

import org.junit.Test;

//baaabbabbb 7
public class LongestSemiSubString {
    public int longestSemiAlternatingSubstring(String s) {
        // write your code here
        int res = 0, count = 0;
        char ch = 0;

        for (int i = 0, j = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i) != ch) {
                ch = s.charAt(i);
                count = 1;
            } else {
                count++;
                if (count >= 3) {
                    j = i - 1;
                }
            }

            res = Math.max(res, i - j + 1);
        }

        return res;
    }

    @Test
    public void test() {
        String s = "baaabbabbb";
        System.out.println(longestSemiAlternatingSubstring(s));
    }
}
