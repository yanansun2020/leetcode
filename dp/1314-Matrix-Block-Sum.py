from typing import List
class Solution:
    def matrixBlockSum(self, mat: List[List[int]], K: int) -> List[List[int]]:
        if not mat:
            return []
        rows = len(mat)
        cols = len(mat[0])
        answer = [[0 for col in range(cols)] for row in range(rows)]
        init_matrix = self.initMatrix(mat)
        for row in range(rows):
            for col in range(cols):
                row1 = row - K if row-K >=0 else 0
                col1 = col -K if col -K >= 0 else 0
                row2 = row + K if row + K < rows else rows -1
                col2 = col + K if col + K < cols else cols -1
                answer[row][col] = self.sumRegion(row1, col1, row2, col2, init_matrix)
        return answer

    def initMatrix(self, matrix: List[List[int]]):
        if matrix:
            rows = len(matrix) + 1
            cols = len(matrix[0]) + 1
            sum_matrix = [[0 for col in range(cols)] for row in range(rows)]
            for row in range(1, rows):
                for col in range(1, cols):
                    sum_matrix[row][col] = sum_matrix[row][col-1] + sum_matrix[row-1][col] \
                        -  sum_matrix[row-1][col-1] + matrix[row-1][col-1]
            return sum_matrix

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int, sum_matrix) -> int:
        if sum_matrix:
            return sum_matrix[row2+1][col2+1] - sum_matrix[row1][col2 + 1] -\
                sum_matrix[row2 + 1][col1] + sum_matrix[row1][col1]
        return 0
def main():
    sol = Solution()
    result = sol.matrixBlockSum([[1,2,3],[4,5,6],[7,8,9]], 1)
    print(result)

if __name__ == "__main__":
    main()
