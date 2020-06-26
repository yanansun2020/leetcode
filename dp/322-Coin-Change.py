import sys
from typing import List
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        N = len(coins) + 1
        dp = [[0] * (amount + 1) for _ in range(N)]
        for j in range(amount + 1):
            dp[0][j] = sys.maxsize
        for i in range(1, N):
            pivot = coins[i-1]
            for j in range(1, amount + 1):
                # do not use pivot
                coin_num_1 = dp[i-1][j]
                # use pivot
                coin_num_2 = sys.maxsize
                if j-pivot >= 0:
                    coin_num_2 = 1 + dp[i][j-pivot]
                dp[i][j] = min(coin_num_1, coin_num_2)
        result = sys.maxsize
        for i in range(N):
            if dp[i][amount] < result:
                result = dp[i][amount]
        return result if result < sys.maxsize else -1

def main():
    sol = Solution()
    days = [1,4,5]
    dayset = set(days)
    result = sol.coinChange([2], 3)
    print(result)

if __name__ == "__main__":
    main()