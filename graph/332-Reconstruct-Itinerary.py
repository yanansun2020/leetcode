from collections import defaultdict
from typing import List
# Euler path
class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        memo = defaultdict(list)
        result = []
        for src, des in tickets:
            memo[src].append(des)
        for key in memo:
            memo[key] = sorted(memo[key])
        src = "JFK"
        self.dfs(src, memo, result)
        return result[::-1]
    def dfs(self, src, memo, result):
        while memo[src]:
            des = memo[src][0]
            memo[src].pop(0)
            self.dfs(des, memo, result)
        result.append(src)

def main():
    sol = Solution()
    result = sol.findItinerary([["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]])
    print(result)
    result = sol.findItinerary([["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]])
    print(result)
    result = sol.findItinerary([["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]])

    print(result)

if __name__ == "__main__":
    main()
