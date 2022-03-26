package oa.gg;

import org.junit.Test;

public class BasicCalculator {
    public int caluclate(String s) {
        int res = 0, num = 0;
        char sign = '+';

        for (int i = 0;  i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                num =  num * 10 + Integer.parseInt(c + "");
            }
            if (c == '+' || c == '-') {
                if (sign == '+') {
                    res += num;
                }
                if (sign == '-') {
                    res -= num;
                }
            }
        }
        return res;
    }

    @Test
    public void test() {

    }
}
