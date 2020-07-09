from typing import List
import sys
class Solution:
    # suppose two people go from top-left to bottom-right
    # One person is on the position (x1, y1) the other one will be on position(x2, x1+y1 -x2), because they have same steps
    #
    def cherryPickup(self, grid: List[List[int]]) -> int:
        if not grid:
            return 0
        rows = len(grid)
        cols = len(grid[0])
        x1, y1, x2, y2 = 0, 0, 0, 0
        final_result = grid[0][0]
        while x1 < rows and y1 < cols and x2 < rows and y2 < cols:
            if x1 == x2 == rows-1 and y1 == y2 == cols-1:
                break
            result, x1, y1, x2, y2 = self.get_max_cherry( x1, y1, x2, y2, grid, rows, cols)
            # no valid path
            if result < 0:
                return 0
            final_result += result
        return final_result

    def get_max_cherry(self, x1, y1, x2, y2, grid, rows, cols):
        # four ways to get cherry
        # p1 p2 happened to on the same position
        # 1. p1 p2 both go downward
        down_down = self.get_cherries(x1+1, y1, x2+1, y2, grid, rows, cols)
        result, x1_, y1_, x2_, y2_ = down_down, x1+1, y1, x2+1, y2
        # 2 p1 goes down and p2 goes right
        down_right = self.get_cherries(x1+1, y1, x2, y2 + 1, grid, rows, cols)
        if down_right > result:
            result, x1_, y1_, x2_, y2_ = down_right, x1+1, y1, x2, y2 + 1
        # 3 p1 goes right and p2 goes right
        right_right = self.get_cherries(x1, y1+1, x2, y2 + 1, grid, rows, cols)
        if right_right > result:
            result, x1_, y1_, x2_, y2_ = right_right, x1, y1+1, x2, y2 + 1
        # 4 p1 goes right and p2 goes down
        right_down = self.get_cherries(x1, y1+1, x2+1, y2, grid, rows, cols)
        if right_down > result:
            result, x1_, y1_, x2_, y2_ = right_down, x1, y1+1, x2+1, y2
        return result, x1_, y1_, x2_, y2_

    def get_cherries(self, x1, y1, x2, y2, grid, rows, cols):
        if x1 >= rows or y1 >= cols or x2 >= rows or y2 >= cols or grid[x1][y1] == -1 or grid[x2][y2] == -1:
            return -sys.maxsize -1
        if x1 == x2 and y1 == y2:
            return grid[x1][y1]
        return grid[x1][y1] + grid[x2][y2]

def main():
    sol = Solution()
    result = sol.cherryPickup([[0, 1, -1],
 [1, 0, -1],
 [1, 1,  1]])
    print(result)
    result = sol.cherryPickup([[0, 1, -1],
    [1, 0, -1],
    [1, -1,  1]])
    print(result)
    result = sol.cherryPickup([[1, 1, 1, 1, 0, 0, 0],
[0, 0, 0, 1, 0, 0, 0],
[0, 0, 0, 1, 0, 0, 1],
[1, 0, 0, 1, 0, 0, 0],
[0, 0, 0, 1, 0, 0, 0],
[0, 0, 0, 1, 0, 0, 0],
[0, 0, 0, 1, 1, 1, 1]])
    print(result)

if __name__ == "__main__":
    main()


    #below is wrong
    def cherryPickup_wrong(self, grid: List[List[int]]) -> int:
        rows = len(grid)
        cols = len(grid[0])
        dp = [0 for i in range(cols)]
        for i in range(rows):
            tmp = list(dp)
            for j in range(cols):
                if grid[i][j] == -1:
                    tmp[j] = -1
                else:
                    previous = tmp[j-1] if j >=1 else 0
                    tmp[j] = max(dp[j], previous) + grid[i][j]
            dp = tmp
        result_1 = dp[-1]

        #backtracking

        dp = [0 for i in range(cols)]
        for i in range(rows-1, -1, -1):
            tmp = list(dp)
            for j in range(cols-1, -1, -1):
                if grid[i][j] == -1:
                    tmp[j] = -1
                else:
                    previous = tmp[j+1] if j <cols -1 else 0
                    tmp[j] = max(tmp[j+1], dp[j]) + grid[i][j]
            dp = tmp
        result_2 = dp[0]
        return result_1 + result_2


