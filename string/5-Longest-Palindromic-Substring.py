#dp[i][j] = 1 if s[i:j] is palindrome else 0
class Solution:
    def longestPalindrome(self, s: str) -> str:
        if not s:
            return 0
        N = len(s)
        dp = [[0 for i in range(N)] for j in range(N)]
        dp[0][0] = 0

        start = 0
        end = 0
        range_ = 0
        for col in range(N):
            for row in range(col+1):
                if row == col:
                    dp[row][col] = 1
                elif s[row] == s[col]:
                    row_ = row + 1
                    col_ = col -1
                    if row_ > col_ or dp[row_][col_] == 1:
                        if col - row >= range_:
                            range_ = col - row
                            start = row
                            end = col
                        dp[row][col] = 1
                else:
                    dp[row][col] = 0
        return s[start:end+1]

def main():
    sol = Solution()
    # result = sol.findAnagrams("cbaebabacd", "abc")
    # print(result)
    result = sol.longestPalindrome("cbbd")
    print(result)

if __name__ == "__main__":
    main()