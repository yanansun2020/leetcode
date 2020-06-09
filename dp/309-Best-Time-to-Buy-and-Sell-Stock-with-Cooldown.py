from typing import List
class Solution:
    #b profit for each day
    # hold[i] = max(unhold[i-2] -price[i], hold[i-1]) 第i天持有股票的最大profit
    # unhold[i] =max(hold[i-1] + prices[i], unhold[i-1])第i天不持有股票的最大profit
    def maxProfit(self, prices: List[int]) -> int:
        if not prices:
            return 0
        N = len(prices)
        unhold = []
        hold = []
        unhold.append(0)
        hold.append(- prices[0])
        for index in range(1, N):
            unhold_value = unhold[index-2] if index -2 >= 0 else 0
            hold.append(max(unhold_value -prices[index], hold[index-1]))
            unhold.append(max(hold[index-1] + prices[index], unhold[index-1]))
        return unhold[N -1]





def main():
    sol = Solution()
    result = sol.maxProfit([1,2,3,0,2])
    print(result)

if __name__ == "__main__":
    main()