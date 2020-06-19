from typing import List
class NumMatrix:
    def __init__(self, matrix: List[List[int]]):
        if matrix:
            rows = len(matrix) + 1
            cols = len(matrix[0]) + 1
            self.sum_matrix = [[0 for col in range(cols)] for row in range(rows)]
            for row in range(1, rows):
                for col in range(1, cols):
                    self.sum_matrix[row][col] = self.sum_matrix[row][col-1] + self.sum_matrix[row-1][col] \
                        -  self.sum_matrix[row-1][col-1] + matrix[row-1][col-1]

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        if self.sum_matrix:
            return self.sum_matrix[row2+1][col2+1] - self.sum_matrix[row1][col2 + 1] -\
                self.sum_matrix[row2 + 1][col1] + self.sum_matrix[row1][col1]
        return 0


# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix(matrix)
# param_1 = obj.sumRegion(row1,col1,row2,col2)
def main():
    sol = NumMatrix([
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
])
    result = sol.sumRegion(2, 1, 4, 3)
    print(result)
    result = sol.sumRegion(1, 1, 2, 2)
    print(result)
    result = sol.sumRegion(1,2,2,4)
    print(result)

if __name__ == "__main__":
    main()
