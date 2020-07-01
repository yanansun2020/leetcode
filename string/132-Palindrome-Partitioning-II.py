from typing import List
import sys
class Solution:
    def minCut(self, s: str) -> int:
        # if self.isPalindrome(s):
        #     return 0
        N = len(s)
        dp = [[0 for col in range(N)] for row in range(N)]
        for length in range(N):
            for row in range(N):
                col = row + length
                if col >= N:
                    continue
                if length == 0:
                    dp[row][col] = 0
                    continue
                if self.isPali(row, col, dp, s):
                    dp[row][col] = 0
                else:
                    dp[row][col] = self.findMin(row, col, dp)
        return dp[0][N-1]

    def findMin(self, i, j, dp):
        min_value = sys.maxsize
        for k in range(i, j):
            val = dp[i][k] + dp[k+1][j]
            if val < min_value:
                min_value = val
        return min_value + 1

    def isPali(self, i, j, dp, s):
        if s[i] == s[j]:
            if i + 1 < len(s) and j -1 >=0:
                return  dp[i+ 1][j-1] == 0 or i + 1 == j
        return False

    # def isPalindrome(self, s):
    #     left = 0
    #     right = len(s) -1
    #     while left < right:
    #         if s[left] == s[right]:
    #             left += 1
    #             right -= 1
    #         else:
    #             return False
    #     return True


def main():
    sol = Solution()
    # result = sol.minCut("banana")
    # print(result)
    # result = sol.minCut("abcbm")
    # print(result)
    # result = sol.minCut("a")
    # print(result)
    # result = sol.minCut("cab")
    # print(result)
    # result = sol.minCut("cabababcbc")
    # print(result)
    result = sol.minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
    print(result)
    result = sol.minCut("bb")
    print(result)
if __name__ == "__main__":
    main()

    # below TEL
    # memo = {}
    # def minCut(self, s: str) -> int:
    #     partitions = self.partition(s)
    #     length = min(len(ele) for ele in partitions)
    #     self.memo = {}
    #     return length -1

    # def partition(self, s: str) -> List[List[str]]:
    #     self.result = []
    #     self.dfs(s, [])
    #     return self.result

    # def dfs(self, s, tmp):
    #     if not s:
    #         self.result.append(tmp[:])
    #         return
    #     for i in range(1, len(s) + 1):
    #         if not self.isPalindrome(s[:i]):
    #             continue
    #         tmp.append(s[:i])
    #         self.dfs(s[i:], tmp)
    #         tmp.pop()

    # def isPalindrome(self, s):
    #     if self.memo.get(s):
    #         return self.memo.get(s)
    #     isPali = s == s[::-1]
    #     self.memo[s] = isPali
    #     return isPali
