package oa.amazon.ftoa;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/reorder-data-in-log-files/
 */
public class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1.substring(o1.indexOf(" ")).trim();
                String s2 = o2.substring(o2.indexOf(" ")).trim();
                Character s1c = s1.charAt(0);
                Character s2c = s2.charAt(0);
                if (Character.isLetter(s1c) && Character.isLetter(s2c)) {
                    if (s1.compareTo(s2) != 0) {
                        return s1.compareTo(s2);
                    }
                    return o1.substring(0, o1.indexOf(" ")).compareTo(o2.substring(0, o2.indexOf(" ")));
                }
                // normal 123 < abc
                // goal abc < 123
                if (Character.isLetter(s1c) && Character.isDigit(s2c)) {
                    return -1;
                }
                if (Character.isLetter(s2c) && Character.isDigit(s1c)) {
                    return 1;
                }
                return 0;
            }
        });
        return logs;
    }

    @Test
    public void test(){
        String a = "1";
        String b = "a";
        int res = a.compareTo(b);
        String[] logs = new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] ans = reorderLogFiles(logs);
    }
}
