from typing import List
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices:
            return 0
        stack = []
        max_profit = 0
        for price in prices:
            if not stack:
                stack.append(price)
                continue
            top_ele = stack[-1]
            if top_ele > price:
                first_ele = stack[0]
                profit = top_ele - first_ele
                max_profit += profit
                stack = []
            stack.append(price)
        return max_profit + (stack[-1] - stack[0])



def main():
    sol = Solution()
    result = sol.maxProfit([7,6,4,3,1])
    print(result)

if __name__ == "__main__":
    main()