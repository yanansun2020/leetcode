package oa.ms;

import org.junit.Test;

public class ABeforeB {
    public boolean isABeforeB (String s) {
        boolean b_appreaed = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (b_appreaed && c == 'a') {
                return false;
            }
            if (c == 'b') {
                b_appreaed = true;
            }
        }
        return true;
    }

    @Test
    public void test() {
        String s = "aabbb";
        System.out.println(isABeforeB(s));
        s = "ba";
        System.out.println(isABeforeB(s));
        s = "aaa";
        System.out.println(isABeforeB(s));
        s = "b";
        System.out.println(isABeforeB(s));
        s = "abba";
        System.out.println(isABeforeB(s));
    }
}
