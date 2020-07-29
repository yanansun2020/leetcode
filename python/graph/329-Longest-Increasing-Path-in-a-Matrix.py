from typing import List
class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        ans = []
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                res_array = self.dfs(i, j, matrix, None, [])
                if len(res_array) > len(ans):
                    ans = res_array
        return len(ans)

    def dfs(self, i, j, matrix, pre_value, visited):
        if i <0 or j <0 or i >=len(matrix) or j >= len(matrix[0]):
            return []
        if pre_value and matrix[i][j] <= pre_value:
            return []
        if (i, j) in visited:
            return []
        # res_array.append(matrix[i][j])
        visited.append((i, j))
        upper = self.dfs(i-1, j, matrix, matrix[i][j], visited)
        down = self.dfs(i+1, j, matrix , matrix[i][j], visited)
        left = self.dfs(i, j-1, matrix, matrix[i][j], visited)
        right = self.dfs(i, j+1, matrix, matrix[i][j], visited)
        longest_array = []
        if len(upper) > len(down):
            longest_array = upper
        else:
            longest_array = down
        if len(longest_array) < len(left):
            longest_array = left
        if len(longest_array) < len(right):
            longest_array = right
        # + [matrix[i][j]]
        longest_array.append(matrix[i][j])
        return longest_array

def main():
    sol = Solution()
    result = sol.longestIncreasingPath([[3,4,5],[3,2,6],[2,2,1]])
    print(result)
    result = sol.longestIncreasingPath([
  [9,9,4],
  [6,6,8],
  [2,1,1]
] )
    print(result)

if __name__ == "__main__":
    main()
