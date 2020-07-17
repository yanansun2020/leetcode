class Solution:
    def numDecodings(self, s: str) -> int:
        dp = [0] * (len(s) + 1)
        dp[0] = 1
        for i in range(1, len(dp)):
            if s[i-1] != '0':
                dp[i] = dp[i-1]
            if i != 1 and '09' < s[i-2:i] < '27':
                dp[i] += dp[i-2]
        return dp[-1]

def main():
    sol = Solution()
    # result = sol.numDecodings("226")
    # print(result)
    result = sol.numDecodings("01")
    print(result)

if __name__ == "__main__":
    main()