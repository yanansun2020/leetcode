from collections import deque
from typing import List
import itertools
class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        if not grid:
            return 0
        visited = 0
        rows = len(grid)
        cols = len(grid[0])
        result = 0

        def bfs(i, j):
            if grid[i][j] == 0:
                return
            queue = deque()
            queue.append((i, j))
            grid[i][j] = 0
            length = 0
            while queue:
                length += 1
                top_ele = queue.pop()
                x = top_ele[0]
                y = top_ele[1]
                if x-1 >= 0 and grid[x-1][y] == 1:
                    queue.append((x-1, y))
                    grid[x-1][y] = 0
                if x+1 < rows and grid[x+1][y] == 1:
                    queue.append((x+1, y))
                    grid[x+1][y] = 0
                if y-1 >= 0 and grid[x][y-1] == 1:
                    queue.append((x, y-1))
                    grid[x][y-1] = 0
                if y+1<cols and grid[x][y+1] == 1:
                    queue.append((x, y+1))
                    grid[x][y+1] = 0
            return length

        for i,j in itertools.product(range(rows), range(cols)):
            if grid[i][j] == 1:
                result = max(result, bfs(i, j))
        return result

def main():
    sol = Solution()
    result = sol.maxAreaOfIsland([[1, 0], [0,1]])
    print(result)
    result = sol.maxAreaOfIsland([
  [1,1,0,0,0],
  [1,1,0,0,0],
  [0,0,1,0,0],
  [0,0,0,1,1]
])
    print(result)
    result = sol.maxAreaOfIsland([
  [1,1,1,1,0],
  [1,1,0,1,0],
  [1,1,0,0,0],
  [0,0,0,0,0]
])
    print(result)
    result = sol.maxAreaOfIsland([[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]])
    print(result)
    result = sol.maxAreaOfIsland([[0,0,0,0,0,0,0,0]])
    print(result)

if __name__ == "__main__":
    main()
