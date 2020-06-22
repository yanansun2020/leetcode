import sys
from typing import List
class Solution:
    #dp[k][v] = minimum cost from src to v with k steps
    #dp[k][v] = min(dp[k-1][u] + c[u][v], dp[k-1][v])
    def findCheapestPrice(self, n, flights, src, dst, K):
        kInfCost = 1e9
        cost = [kInfCost for _ in range(n)]
        cost[src] = 0

        for i in range(K + 1):
            tmp = list(cost)
            for p in flights:
                tmp[p[1]] = min(tmp[p[1]], cost[p[0]] + p[2])
            cost = tmp
        return -1 if cost[dst] >= 1e9 else cost[dst]

def main():
    sol = Solution()
    result = sol.findCheapestPrice(3, [[0,1,100],[1,2,100],[0,2,500]], 0, 2, 0)
    print(result)

if __name__ == "__main__":
    main()
