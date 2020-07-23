from typing import List
class Solution:
    # check the matrix[i][j] == matrinx[i-1][j-1]
    def isToeplitzMatrix(self, matrix: List[List[int]]) -> bool:
        rows = len(matrix)
        cols = len(matrix[0])
        for i in range(1, rows):
            for j in range(cols):
                if i-1 < 0 or j-1 <0:
                    continue
                if matrix[i-1][j-1] != matrix[i][j]:
                    return False
        return True
def main():
    sol = Solution()
    result = sol.isToeplitzMatrix([
  [1,2,3,4],
  [5,1,2,3],
  [9,5,1,2]
])
    print(result)
    result = sol.isToeplitzMatrix([
  [1,2],
  [2,2]
])
    print(result)
if __name__ == "__main__":
    main()