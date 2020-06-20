from typing import List
class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        if not obstacleGrid or obstacleGrid[0][0] == 1:
            return 0
        rows = len(obstacleGrid)
        cols = len(obstacleGrid[0])
        dp = [[0 for col in range(cols)] for row in range(rows)]
        for i in range(rows):
            for j in range(cols):
                if obstacleGrid[i][j] == 0 :
                    if(i ==0 and j==0):
                        dp[i][j] =1
                    else:
                        dp[i][j] = (dp[i-1][j] if i-1 >=0 else 0) + (dp[i][j-1] if j -1>= 0 else 0)
        return dp[rows-1][cols-1]

def main():
    sol = Solution()
    result = sol.uniquePathsWithObstacles([
  [0,0,0],
  [0,1,0],
  [0,0,0]
])
    print(result)

if __name__ == "__main__":
    main()