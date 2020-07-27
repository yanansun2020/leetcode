from typing import List
class Solution:
    #elements on diagonal position have same (i+j)
    def findDiagonalOrder(self, matrix: List[List[int]]) -> List[int]:
        if not matrix:
            return []
        rows = len(matrix)
        cols = len(matrix[0])
        tmp_array = [[]for i in range(2 * max(cols, rows)-1)]
        for i in range(rows):
            for j in range(cols):
                tmp_array[i+j].append(matrix[i][j])
        result = []
        for index, array in enumerate(tmp_array):
            if not array:
                continue
            if index%2 == 0:
                result.extend(array[::-1])
            else:
                result.extend(array)
        return result

def main():
    sol = Solution()
    result = sol.findDiagonalOrder(
[[3],[2]])
    print(result)

    result = sol.findDiagonalOrder([
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
])
    print(result)
    # result = sol.findDiagonalOrder(7, -3)
    # print(result)
    # result = sol.findDiagonalOrder(3, 10)
    # print(result)
    # result = sol.findDiagonalOrder(3, -10)
    # print(result)
    # result = sol.findDiagonalOrder(-7, -3)
    # print(result)
if __name__ == "__main__":
    main()
