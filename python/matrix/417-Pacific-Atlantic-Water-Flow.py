from typing import List
import sys
class Solution:
    def pacificAtlantic(self, matrix: List[List[int]]) -> List[List[int]]:
        if not matrix:
            return []
        rows = len(matrix)
        cols = len(matrix[0])
        dp = [[[None, None] for i in range(cols)] for j in range(rows)]
        result = []
        # visited_1 = set()
        # visited_2 = set()
        def dfs_pacific(height, i, j):
            # if (i, j) in visited_1:
            #     return
            # visited_1.add((i, j))
            if i == rows or j == cols or height < matrix[i][j]:
                return False
            if i == 0 or j == 0:
                return True
            if dp[i][j][0] is not None:
                return dp[i][j][0]
            tmp = matrix[i][ j]
            matrix[i][ j] = sys.maxsize
            result =  dfs_pacific(tmp, i+1, j) or dfs_pacific(tmp, i, j-1) \
                        or dfs_pacific(tmp, i, j + 1) or dfs_pacific(tmp, i-1, j)
            dp[i][j][0] = result
            matrix[i][ j] = tmp
            return result

        def dfs_atlantic(height, i, j ):
            # if (i, j) in visited_2:
            #     return
            # visited_2.add((i, j))
            if i<0  or j < 0 or height < matrix[i][j]:
                return False
            if i == rows- 1 or j == cols -1:
                return True
            if dp[i][j][1] is not None:
                return dp[i][j][1]
            tmp = matrix[i][j]
            matrix[i][j] = sys.maxsize
            result =  dfs_atlantic(tmp, i, j + 1) or dfs_atlantic(tmp, i+1, j) \
                        or dfs_atlantic(tmp, i, j-1) or dfs_atlantic(tmp, i-1, j)
            dp[i][j][1] = result
            matrix[i][j] = tmp
            return result

        # dp_1 = [[[None, None] for i in range(cols)] for j in range(rows)]
        for i in range(rows):
            for j in range(cols):
                if i == 0 or j == 0:
                    dp[i][j][0] = True
                else:
                    dp[i][j][0] = dfs_pacific(matrix[i][j], i, j)

        for i in range(rows-1, -1, -1):
            for j in range(cols-1, -1, -1):
                if i == rows -1 or j == cols -1:
                    dp[i][j][1] = True
                else:
                    dp[i][j][1] = dfs_atlantic(matrix[i][j], i, j)
                if dp[i][j] == [True, True]:
                    result.append([i, j])
        return result


def main():
    sol = Solution()
    result = sol.pacificAtlantic([[1, 2, 3], [8,9,4], [7,6,5]])
    print(result)
    # result = sol.pacificAtlantic([[1, 2,2,3,5], [3,2,3,4,4], [2,4,5,3,1], [6,7,1,4,5], [5,1,1,2,4]])
    # result = sol.pacificAtlantic([[12,7,7,14,6,17,12,17,8,18,9,5],[6,8,12,5,3,6,2,14,19,6,18,13],[0,6,3,8,8,10,8,17,13,13,13,12],[5,6,8,8,15,16,19,14,7,11,2,3],[7,18,2,7,10,10,3,14,13,15,15,7],[18,6,19,4,12,3,3,2,6,6,19,6],[3,18,5,16,19,6,3,12,6,0,14,11],[9,10,17,12,10,11,11,9,0,0,12,0],[4,13,3,0,4,12,9,5,6,17,10,11],[18,3,5,0,8,19,18,4,8,19,1,3],[16,2,14,6,4,14,7,2,9,7,13,18],[0,16,19,16,16,4,15,19,7,0,3,16],[13,8,12,8,2,3,5,18,6,15,18,6],[4,10,8,1,16,0,6,0,14,10,11,8],[7,1,3,4,11,12,9,0,6,2,17,5],[1,16,6,1,0,19,11,1,5,7,8,2],[4,1,14,13,14,7,3,7,1,9,15,18],[14,11,6,14,14,14,4,0,11,17,1,9],[3,14,2,10,3,1,9,16,1,13,0,15],[8,9,13,5,5,7,10,1,4,5,0,9],[13,16,15,5,17,6,16,13,5,7,3,15],[5,1,12,19,3,13,0,0,3,10,6,13],[12,17,9,16,16,6,2,6,12,15,14,16],[7,7,0,6,4,15,1,7,17,5,2,12],[3,17,0,2,4,5,11,7,16,16,16,13],[3,7,16,11,2,16,14,9,16,17,10,3],[12,18,17,17,5,15,1,2,12,12,5,7],[11,10,10,0,11,7,17,14,5,15,2,16],[7,19,14,7,6,2,4,16,11,19,14,14],[6,17,6,6,6,15,9,12,8,13,1,7],[16,3,15,0,18,17,0,11,3,16,11,12],[15,12,4,6,19,15,17,7,3,9,2,11]])
    # print(result)
    # tmp = [[12,7,7,14,6,17,12,17,8,18,9,5],[6,8,12,5,3,6,2,14,19,6,18,13],[0,6,3,8,8,10,8,17,13,13,13,12],[5,6,8,8,15,16,19,14,7,11,2,3],[7,18,2,7,10,10,3,14,13,15,15,7],[18,6,19,4,12,3,3,2,6,6,19,6],[3,18,5,16,19,6,3,12,6,0,14,11],[9,10,17,12,10,11,11,9,0,0,12,0],[4,13,3,0,4,12,9,5,6,17,10,11],[18,3,5,0,8,19,18,4,8,19,1,3],[16,2,14,6,4,14,7,2,9,7,13,18],[0,16,19,16,16,4,15,19,7,0,3,16],[13,8,12,8,2,3,5,18,6,15,18,6],[4,10,8,1,16,0,6,0,14,10,11,8],[7,1,3,4,11,12,9,0,6,2,17,5],[1,16,6,1,0,19,11,1,5,7,8,2],[4,1,14,13,14,7,3,7,1,9,15,18],[14,11,6,14,14,14,4,0,11,17,1,9],[3,14,2,10,3,1,9,16,1,13,0,15],[8,9,13,5,5,7,10,1,4,5,0,9],[13,16,15,5,17,6,16,13,5,7,3,15],[5,1,12,19,3,13,0,0,3,10,6,13],[12,17,9,16,16,6,2,6,12,15,14,16],[7,7,0,6,4,15,1,7,17,5,2,12],[3,17,0,2,4,5,11,7,16,16,16,13],[3,7,16,11,2,16,14,9,16,17,10,3],[12,18,17,17,5,15,1,2,12,12,5,7],[11,10,10,0,11,7,17,14,5,15,2,16],[7,19,14,7,6,2,4,16,11,19,14,14],[6,17,6,6,6,15,9,12,8,13,1,7],[16,3,15,0,18,17,0,11,3,16,11,12],[15,12,4,6,19,15,17,7,3,9,2,11]]
    # print(len(tmp))
if __name__ == "__main__":
    main()

    # dp not work water can got to right then up to pacific ocean
    def pacificAtlantic_wrong(self, matrix: List[List[int]]) -> List[List[int]]:
        rows = len(matrix)
        cols = len(matrix[0])
        # (can go to pacific, can go to atlantic)
        result = []
        dp = [[[None, None] for i in range(cols)] for j in range(rows)]
        for row in range(rows):
            for col in range(cols):
                if row == 0 or col == 0:
                    dp[row][col] = [True, None]
                else:
                    to_up = (matrix[row][col] >= matrix[row-1][col] and dp[row-1][col][0] == True)
                    to_left = (matrix[row][col] >= matrix[row][col-1] and dp[row][col-1][0] == True)
                    dp[row][col][0] = to_up or to_left

        for row in range(rows-1, -1, -1):
            for col in range(cols -1, -1, -1):
                if row == rows - 1 or col == cols -1:
                    dp[row][col][1] = True
                else:
                    to_right = matrix[row][col] >= matrix[row][col+1] and dp[row][col+1][1] == True
                    to_bottom = matrix[row][col] >= matrix[row+1][col] and dp[row + 1][col][1] == True
                    dp[row][col][1] = to_right or to_bottom
                if dp[row][col] == [True, True]:
                    result.append([row, col])
        return result

