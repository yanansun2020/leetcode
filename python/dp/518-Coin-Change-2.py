
from typing import List
class Solution:
    #This solution is Time Limit Exceeded
    # def change(self, amount: int, coins: List[int]) -> int:
    #     return self.changeAmount(0, amount, coins)
    # def changeAmount(self, index, amount, coins):
    #     if amount == 0:
    #         return 1
    #     if amount < 0 or index == len(coins):
    #         return 0
    #     left = self.changeAmount(index, amount -coins[index], coins)
    #     right = self.changeAmount(index + 1, amount, coins)
    #     return  left + right

    def change(self, amount: int, coins: List[int]) -> int:
        N = len(coins) + 1
        dp = [[0] * (amount + 1) for _ in range(N)]
        for i in range(N):
            dp[i][0] = 1
        for i in range(1, N):
            for j in range(1, amount + 1):
                pivot = coins[i-1]
                #不选择pivot有多少种方式
                combination_1 =dp[i-1][j]
                #选择pivot有多少中方式, 方式的数量是 amount-pivot 所对应的数量
                combination_2 = 0
                if j-pivot >= 0:
                    combination_2 = dp[i][j-pivot]
                dp[i][j]= combination_1 + combination_2
        return dp[N-1][amount]
def main():
    sol = Solution()
    result = sol.change(5, [1, 2, 5])
    print(result)

if __name__ == "__main__":
    main()