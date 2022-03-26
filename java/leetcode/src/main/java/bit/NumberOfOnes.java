package bit;

import org.junit.Test;

public class NumberOfOnes {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i =1; i< num+1; i++){
            result[i] = result[(i & (i-1))] + 1;
        }
        return result;
    }

    public int getOnes(int num) {
        int count = 0;
        while (num < 0) {
            num = (num & num - 1);
            count++;
        }
        return count;
    }

    @Test
    public void test() {
        int[] res = countBits(2);
        System.out.println(getOnes((-1)));
    }
}
