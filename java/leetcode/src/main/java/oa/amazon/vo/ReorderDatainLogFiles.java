package oa.amazon.vo;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderDatainLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        return null;
    }
    @Test
    public void test() {
        int[] a = new int[]{1,2};
        String s = Arrays.toString(a);
        System.out.println(s);
    }
}
