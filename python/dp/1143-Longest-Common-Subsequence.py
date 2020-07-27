class Solution:
    #dp[i][j] = longest common subsequence from text1[0-i] to text2[0-j]
    #if text1[i] != text2[j] dp[i][j] = max(dp[i-1][j], dp[i][j-1]) else dp[i][j] = dp[i-1][j-1] + 1
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        if not text1 or not text2:
            return 0
        rows = len(text2)
        cols = len(text1)
        dp = [[0 for col in range(cols + 1)] for row in range(rows + 1)]
        for i in range(rows):
            for j in range(cols):
                if text2[i] == text1[j]:
                    dp[i+1][j+1] = dp[i][j] + 1
                else:
                    dp[i + 1][j + 1] = max(dp[i][j + 1], dp[i + 1][j])
        return dp[rows][cols]
def main():
    sol = Solution()
    result = sol.longestCommonSubsequence("abc","def")
    print(result)

if __name__ == "__main__":
    main()