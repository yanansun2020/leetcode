from typing import List
#explanation:https://leetcode.com/problems/two-city-scheduling/discuss/667786/Java-or-C%2B%2B-or-Python3-or-With-detailed-explanation
class Solution:
    def twoCitySchedCost(self, costs: List[List[int]]) -> int:
        refund = []
        final_cost = 0
        for a,b in costs:
            refund.append(b-a)
            final_cost += a
        refund.sort()
        N = len(costs)//2
        for index in range(N):
            final_cost += refund[index]
        return final_cost


def main():
    sol = Solution()
    result = sol.twoCitySchedCost([[10,20],[30,200],[400,50],[30,20]])
    print(result)

if __name__ == "__main__":
    main()
