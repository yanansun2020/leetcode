from typing import List
import math
#dp[i] = min(dp[i - 1] + costs[0], dp[i - 7] + costs[1], dp[i - 30] + costs[2])
class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        N = days[-1] + 1
        dp = [0 for i in range(N)]
        for i in range(1, N):
            if i in days:
                index_1 = i-7 if i-7>= 0 else 0
                index_2 = i-30 if i-30>= 0 else 0
                value_1 = costs[0] + dp[i -1]
                value_2 = costs[1] + dp[index_1]
                value_3 = costs[2] + dp[index_2]
                dp[i] = min(value_1, value_2, value_3)
            else:
                dp[i] = dp[i-1]
        return dp[days[-1]]

def main():
    sol = Solution()
    result = sol.mincostTickets([1,4,6,9,10,11,12,13,14,15,16,17,18,20,21,22,23,27,28],[3,13,45])
    print(result)

if __name__ == "__main__":
    main()