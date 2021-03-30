package oa.goldenman;

import org.junit.Test;

public class StringCompression {
    public int compress(char[] chars) {
        int i = 0, j = 0, k = 0;
        while (j < chars.length) {
            if (chars[i] != chars[j]) {
                int length = j - k;
                if (length == 1) {
                    chars[i+1] = chars[j];
                    i += 1;
                } else {
                    String s = String.valueOf(length);
                    fillNumbers(s, chars, i);
                    chars[i + s.length() + 1] = chars[j];
                    i = i + s.length() + 1;
                }
                k = j;
            }
            j++;
        }
        if (j - k > 1) {
            int length = j - k;
            String s = String.valueOf(length);
            fillNumbers(s, chars, i);
            i = i + s.length() + 1;
        }
        return i;
    }

    private void fillNumbers(String s, char[] chars, int i) {
        for (int m = 0; m < s.length(); m++) {
            chars[i + m + 1] = s.charAt(m);
        }
    }
    @Test
    public void test() {
        char[] chars = new char[] {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int ans = compress(chars);
    }
}
