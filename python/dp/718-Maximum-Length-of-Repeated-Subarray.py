from typing import List
class Solution:
    def findLength(self, A: List[int], B: List[int]) -> int:
        max_length = 0
        rows, cols = len(B), len(A)
        dp = [[0 for col in range(cols + 1)]  for row in range(rows + 1)]
        for row in range(1, rows + 1):
            for col in range(1, cols + 1):
                if A[col-1] == B[row-1]:
                    dp[row][col] = dp[row -1][col-1] + 1
                    if dp[row][col] > max_length:
                        max_length = dp[row][col]
        return max_length

def main():
    sol = Solution()
    result = sol.findLength([1,2,3,2,1], [3,2,1,4,7])
    print(result)
    result = sol.findLength([1,2,1], [1, 0, 1])
    print(result)
    result = sol.findLength([1,2, 3], [1, 0])
    print(result)
    result = sol.findLength([0,0,0,0,1],[1,0,0,0,0])
    print(result)

if __name__ == "__main__":
    main()