class Solution:
    def findBeforeMatrix(self, after):
        # Write your code here
        rows = len(after)
        cols = len(after[0])
        before_matrix = [[0 for i in range(cols)] for j in range(rows)]
        before_matrix[0][0] = after[0][0]
        for j in range(1, cols):
            before_matrix[0][j] = after[0][j] - before_matrix[0][j-1]
        for i in range(1, rows):
            before_matrix[i][0] = after[i][0] - before_matrix[i-1][0]
        for i in range(1, rows):
            for j in range(1, cols):
                before_matrix[i][j] = after[i][j] - before_matrix[i-1][j-1] - before_matrix[i-1][j] - before_matrix[i][j-1]
        return before_matrix

def main():
    sol = Solution()
    result = sol.findBeforeMatrix(
        [[33, 94, 56, 34, 77],
[89, 27, 55, 74, 3],
[38, 20, 90, 45, 60],
[98, 65, 58, 18, 14],
[2, 64, 11, 1, 79],
[4, 67, 78, 13, 53],
[98, 68, 90, 2, 62],
[13, 1, 34, 75, 95],
[23, 16, 39, 95, 42]]
    )
    print(result)

if __name__ == "__main__":
    main()