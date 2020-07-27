from typing import List
import sys
class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        if not A:
            return 0
        rows = len(A)
        cols = len(A[0])
        dp = [0] * cols
        for row in range(rows):
            tmp = []
            for col in range(cols):
                left = sys.maxsize if col-1 < 0 else dp[col-1]
                right = sys.maxsize if col+1 >= cols else dp[col+1]
                tmp.append(min(left, dp[col], right) + A[row][col])
            dp = tmp
        return min(dp)

def main():
    sol = Solution()
    result = sol.minFallingPathSum([[1,2,3],[4,5,6],[7,8,9]])
    print(result)

if __name__ == "__main__":
    main()
