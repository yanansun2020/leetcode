package string;

/**
 * 从下向上填充
 * 同 leetcode 156
 */
public class ValidPalindromeIII {
    public boolean isValidPalindrome(String s, int k) {
        int N = s.length();
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; ++i) {
            dp[i][i] = 1;
        }
        for (int i = N - 1; i >= 0; --i) {
            for (int j = i + 1; j < N; ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return N - dp[0][N - 1] <= k;
    }
}
