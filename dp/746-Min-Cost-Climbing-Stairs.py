from typing import List
class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        #f(n) = w(n) + min(f(n-1), f(n-2))
        min_cost = []
        min_cost.append(cost[0])
        min_cost.append(cost[1])
        length = len(cost)
        for index in range(2, length):
            min_cost.append(cost[index] + min(min_cost[index-1], min_cost[index-2]))
        return min(min_cost[length-1], min_cost[length-2])



def main():
    sol = Solution()
    result = sol.minCostClimbingStairs([1, 100, 1, 1, 1, 100, 1, 1, 100, 1])
    print(result)

if __name__ == "__main__":
    main()
