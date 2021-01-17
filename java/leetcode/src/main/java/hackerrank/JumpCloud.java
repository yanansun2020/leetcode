package hackerrank;

import org.junit.Test;

public class JumpCloud {
    static int jumpingOnClouds(int[] c) {
        int i = 0;
        int count = 0;
        int n = c.length;
        while (i < n) {
            if (i + 2 < n && c[i + 2] == 0) {
                i = i + 2;
            } else {
                i = i + 1;
            }
            count++;
        }
        return count;
    }
    @Test
    public void test(){
        int[] c = new int[]{0, 0, 1 ,0 ,0 ,1, 0};
        int ans = jumpingOnClouds(c);
    }
}
