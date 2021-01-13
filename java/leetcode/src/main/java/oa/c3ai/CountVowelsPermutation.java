package oa.c3ai;

import org.junit.Test;

public class CountVowelsPermutation {
    public int countVowelPermutation(int n) {
        //possibility forward the char
        // a ->0 e-1 i-2 o-3 u->4
        //possibility forward the char
        // a ->0 e-1 i-2 o-3 u->4
        double MOD = Math.pow(10, 9) + 7;
        double[] arr = new double[]{1, 1,1,1,1};
        double[] arr2 = new double[5];
        for (int i = 2; i <= n; i++) {
            arr2 = new double[5];
            arr2[0] = (arr[1] + arr[2] + arr[4]) % MOD;
            arr2[1] = (arr[0] + arr[2]) % MOD;
            arr2[2] = (arr[1] + arr[3]) % MOD;
            arr2[3] = arr[2] % MOD;
            arr2[4] = (arr[2] + arr[3]) % MOD;
            arr = arr2;
        }
        double total = 0;
        for (double a : arr){
            total += a;
        }
        return (int)(total % MOD);
    }

    @Test
    public void test(){
        int ans = countVowelPermutation(1);
        ans = countVowelPermutation(2);
        ans = countVowelPermutation(5);
    }

}
