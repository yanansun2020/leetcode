from typing import List
class Solution:
    # calculate from bottom-right to top-left
    #dp[i][j] = minimum blood in need to go from (i, j) to bottom-right
    def calculateMinimumHP(self, dungeon: List[List[int]]) -> int:
        rows = len(dungeon)
        cols = len(dungeon[0])
        dp = [[0 for col in range(cols)] for row in range(rows)]
        dp[-1][-1] = 1 if dungeon[-1][-1] >=0 else 1 - dungeon[-1][-1]
        for i in range(rows-1, -1, -1):
            for j in range(cols-1, -1, -1):
                if i == rows -1 and j == cols -1:
                    continue
                if i == rows -1:
                    in_need =  dp[i][j+1] - dungeon[i][j]
                    dp[i][j] = 1 if in_need < 0 else in_need
                    continue
                if j == cols -1:
                    in_need = dp[i+1][j] - dungeon[i][j]
                    dp[i][j] = 1 if in_need < 0 else in_need
                    continue
                in_need = min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j]
                dp[i][j] = 1 if in_need < 0 else in_need
        return dp[0][0]
def main():
    sol = Solution()
    result = sol.calculateMinimumHP([[-2, -3, 3], [-5, -10, 1], [10, 30, -5]])
    print(result)

if __name__ == "__main__":
    main()