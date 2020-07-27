class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        rows = len(s)
        cols = len(p)
        #dp[i][j] s[0:i] match p[0:j] or not
        #dp[i][j] = dp[i-1][j-1] if s[i] = p[j]
        #dp[i][j] = 0 if if s[i] != p[j]
        #dp[i][j] = dp[i][j-2](when 0 wild char occur) or dp[i-1][j](when wild card occur multi times and s[i]=p[j-1])
        dp = [[0 for col in range(cols +1)] for row in range(rows + 1)]
        dp[0][0] = 1
        for i in range(1, cols + 1):
            if p[i-1] == '*':
                dp[0][i] = dp[0][i-2]
        for i in range(1, rows + 1):
            for j in range(1, cols + 1):
                if p[j-1] == '.' or s[i-1] == p[j-1]:
                    dp[i][j] = dp[i-1][j-1]
                elif p[j-1] == '*':
                    if dp[i][j-2] == 1:
                        dp[i][j] = 1
                    elif s[i-1] == p[j-2] or p[j-2] == '.':
                        dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = 0
        return True if dp[rows][cols]== 1 else False


def main():
    sol = Solution()
    result = sol.isMatch("mississippi","mis*is*p*.")
    print(result)

if __name__ == "__main__":
    main()
