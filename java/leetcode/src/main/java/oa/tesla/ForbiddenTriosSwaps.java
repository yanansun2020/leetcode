package oa.tesla;

import org.junit.Test;

//Given a string S consisting of letters 'a' and 'b',
// return the minimum number of swaps needed to obtain a string with no instances of three identical consecutive letters.(20 mins)
public class ForbiddenTriosSwaps {

    public int minSwap(String s) {
        int res = 0;
        for (int i = 0; i < s.length() - 1;) {
            char cur = s.charAt(i);
            int j = i;
            while (j < s.length() && s.charAt(j) == cur) {
                j++;
            }
            int len = j - i;
            if (len >= 3) {
                res += len/3;
            }
            i = j;
        }
        return res;
    }
    @Test
    public void test() {
        String s = "baaab";
        System.out.println(minSwap(s));
        s = "baaaab";
        System.out.println(minSwap(s));
        s = "baaaaaab";
        System.out.println(minSwap(s));
        s = "baaaaaaaaaab";
        System.out.println(minSwap(s));
        s = "baaabbaabbba";
        System.out.println(minSwap(s));
    }
}
