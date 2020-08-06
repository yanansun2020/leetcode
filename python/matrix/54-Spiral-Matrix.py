from typing import List
class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        row1, row2, col1, col2 = 0, len(matrix)-1, 0, len(matrix[0])-1
        i, j = 0, 0
        ans = []
        while row1 <=row2 and col1 <= col2:
            for i in range(col1, col2+1):
                ans.append(matrix[row1][i])
            row1 += 1
            for i in range(row1, row2+1):
                ans.append(matrix[i][col2])
            col2 -= 1
            if row1 <=row2:
                for i in range(col2, col1-1, -1):
                    ans.append(matrix[row2][i])
            row2 -= 1
            if col1 <= col2:
                for i in range(row2, row1-1, -1):
                    ans.append(matrix[i][col1])
            col1 += 1
        return ans
def main():
    sol = Solution()

    result = sol.spiralOrder([[1,2,3,4],[5,6,7,8],[9,10,11,12]])
    print(result)
    result = sol.spiralOrder([
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
])
    print(result)
    # result = sol.minSubArrayLen("ADOABC", "ABC")
    # print(result)
    # result = sol.minSubArrayLen("ADOABCODEBANC", "ABC")
    # print(result)

if __name__ == "__main__":
    main()