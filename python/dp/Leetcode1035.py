from typing import List
from collections import defaultdict
from itertools import product


class Solution:
    def maxUncrossedLines(self, A: List[int], B: List[int]) -> int:
        dp, n, m = defaultdict(int), len(A), len(B)
        for a,b in product(range(n), range(m)):
          dp[a,b] = max(dp[a-1,b-1] + (A[a]==B[b]), dp[a-1,b], dp[a,b-1])
        return dp[n-1, m-1]
def main():
    sol = Solution()
    result = sol.maxUncrossedLines([5,1,2,5,1,2,2,3,1,1,1,1,1,3,1], [2,5,1,3,4,5,5,2,2,4,5,2,2,3])
    print(result)
    # result = sol.maxUncrossedLines([2,5,1,2,5], [10,5,2,1,5,2])
    # print(result)

if __name__ == "__main__":
    main()