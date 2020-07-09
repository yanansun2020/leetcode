from typing import List
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        visited = 'V'
        rows = len(grid)
        cols = len(grid[0])
        result = 0
        def dfs(i, j):
            if i < 0 or j < 0 or i>=rows or j >= cols:
                return
            if grid[i][j] == '0' or grid[i][j] == visited:
                return
            grid[i][j] = visited
            dfs(i-1, j)
            dfs(i+1, j)
            dfs(i, j-1)
            dfs(i, j+1)
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == '1':
                    dfs(i, j)
                    result += 1
        return result

def main():
    sol = Solution()
    result = sol.numIslands([['1', '0'], ['0','1']])
    print(result)
    result = sol.numIslands([
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
])
    print(result)
    result = sol.numIslands([
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
])
    print(result)

if __name__ == "__main__":
    main()
