from typing import List
class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        result = 0
        rows = len(grid)
        cols = len(grid[0])

        def get_water_edge(i, j):
            default_edge = 4
            if i-1>= 0 and grid[i-1][j] == 1:
                default_edge -= 1
            if i + 1 <  rows and grid[i+1][j] ==1:
                default_edge -= 1
            if j -1 >= 0 and grid[i][j-1] == 1:
                default_edge -= 1
            if j+1<cols and grid[i][j+1] == 1:
                default_edge -= 1
            return default_edge


        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == 1:
                    result += get_water_edge(i, j)
        return result

def main():
    sol = Solution()
    result = sol.islandPerimeter([[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]])
    print(result)

if __name__ == "__main__":
    main()
