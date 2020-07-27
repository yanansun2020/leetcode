from typing import List
class Solution:
    #b[i]前i个数中最小值
    def maxProfit(self, prices: List[int]) -> int:
        N = len(prices)
        if N == 0:
            return 0
        b = [0] * N
        b[0] = prices[0]
        max_profit = 0
        for index in range(1, N):
            cur_profit = prices[index] - b[index-1]
            if cur_profit > max_profit:
                max_profit = cur_profit
            if prices[index] < b[index - 1]:
                b[index] = prices[index]
            else:
                b[index] = b[index -1]
        return max_profit if max_profit > 0 else 0


def main():
    sol = Solution()
    result = sol.maxProfit([7,6,4,3,1])
    print(result)

if __name__ == "__main__":
    main()