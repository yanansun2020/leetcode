from typing import List
class Solution:
    def maxProfit(self, prices: List[int], fee: int) -> int:
        if not prices:
            return 0
        N = len(prices)
        sell = []
        hold = []
        sell.append(0)
        hold.append(- prices[0])
        for index in range(1, N):
            sell_value = sell[index-1] if index -1 >= 0 else 0
            hold.append(max(sell_value -prices[index], hold[index-1]))
            sell.append(max(hold[index-1] + prices[index]-fee, sell[index-1]))
        return sell[N -1]
def main():
    sol = Solution()
    result = sol.maxProfit([1, 3, 7,5,10,3], 3)
    print(result)
    result = sol.maxProfit([1, 3, 2, 8, 4, 9], 2)
    print(result)

if __name__ == "__main__":
    main()