package oa.ms.vo;

import org.junit.Test;

public class StringConcatenation {

    private String concatenate(String s1, String s2) {
        int i  = s1.length() - 1;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j <= s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                sb.append(s1.charAt(i));
                i--;
                j++;
            } else {
                break;
            }
        }
        return s1.substring(0, i+1) + sb.toString() + s2.substring(j);
    }

    @Test
    public void test() {
        String s = concatenate("abc", "cda");
        System.out.println(s);
        s = concatenate("aaa", "aaa");
        System.out.println(s);
    }
}
