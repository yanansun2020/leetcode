from typing import List
import sys
class Solution:
    def minFallingPathSum(self, arr: List[List[int]]) -> int:
        if not arr:
            return 0
        rows = len(arr)
        cols = len(arr[0])
        dp = [0] * cols
        for row in range(rows):
            tmp = []
            for col in range(cols):
                left = sys.maxsize if col ==0 else min(dp[0:col])
                right = sys.maxsize if col == cols-1 else min(dp[col+1:cols])
                min_value = min(left, right)
                tmp.append(min_value + arr[row][col])
            dp = tmp
        return min(dp)

def main():
    sol = Solution()
    # dp = [1,2,3,0,1,2]
    # x = min(dp[3:5])
    result = sol.minFallingPathSum([[-73,61,43,-48,-36],[3,30,27,57,10],[96,-76,84,59,-15],[5,-49,76,31,-7],[97,91,61,-46,67]] )
    # result = sol.minFallingPathSum([[1,2,3],[4,5,6],[7,8,9]])
    print(result)

if __name__ == "__main__":
    main()