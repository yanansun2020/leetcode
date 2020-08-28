package oa.amazon.oa2;

import org.junit.Test;

import java.util.Arrays;

//leading zero
public class PrimeNumber {
    public int waysToGetPrime(String s) {
        int MOD = 1000000007;
        int[] dpArray = new int[s.length()];
        if (isPrime(Integer.parseInt(s.charAt(0) + ""))) {
            dpArray[0] = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            for(int j =Math.max(i-6, 0); j<i; j++){
//            for (int j = 0; j < i; j++) {
                String next = s.substring(j + 1, i + 1);
                if (!next.startsWith("0") && isPrime(Integer.parseInt(next))) {
                    dpArray[i] += dpArray[j];
                }
            }
            String cur = s.substring(0, i + 1);
            if (isPrime(Integer.parseInt(cur))) {
                dpArray[i] += 1;
            }
            dpArray[i] %= MOD;
        }
        return dpArray[s.length() - 1];
    }

    boolean isPrime(int num) {
        if (num == 1 || num == 0) {
            return false;
        }
//        if(num > 100){
//            return false;
//        }
        for (int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }


    static final int MOD = 1000000007;
    static boolean[] sieve = new boolean[1000000];

    // Function to check whether a number
// is a prime number or not
//    boolean isPrime(String number) {
//        int num = Integer.valueOf(number);
//        for (int i = 2; i * i <= num; i++) {
//            if ((num % i) == 0)
//                return false;
//        }
//        return num > 1 ? true : false;
//    }
    boolean isPrime(String number) {
        int num = Integer.valueOf(number);
        return sieve[num];
    }

    void buildSieve() {
        Arrays.fill(sieve, true);
        sieve[0] = false;
        sieve[1] = false;

        for (int p = 2; p * p <= 1000000; p++) {
            // If p is a prime
            if (sieve[p] == true) {
                // Update all multiples
                // of p as non prime
                for (int i = p * p; i < 1000000;i += p)
                    sieve[i] = false;
            }
        }
    }

    // Function to find the count
// of ways to split String
// into prime numbers
    int countPrimeStrings(String number) {
        buildSieve();
        int n = number.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return rec(number, n, dp);
    }

    int rec(String number, int i, int[] dp) {
        if (dp[i] != -1)
            return dp[i];
        int cnt = 0;

        for (int j = 1; j <= 6; j++) {

            // Number should not have a
            // leading zero and it
            // should be a prime number
            if (i - j >= 0 &&
                number.charAt(i - j) != '0' &&
                isPrime(number.substring(i - j, i))) {
                cnt += rec(number, i - j, dp);
                cnt %= MOD;
            }
        }
        return dp[i] = cnt;
    }


    @Test
    public void test() {
        int c = waysToGetPrime("202");
        int a = waysToGetPrime("3175");
        int b = waysToGetPrime("2");
        int d = waysToGetPrime("11373");

        int c1 = countPrimeStrings("202");
        int a1 = countPrimeStrings("3175");
        int b1 = countPrimeStrings("2");
        int d1 = countPrimeStrings("11373");

    }
}
