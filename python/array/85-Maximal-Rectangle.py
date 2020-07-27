from typing import List
class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0
        rows = len(matrix)
        cols = len(matrix[0])
        max_area = 0
        dp = [0 for j in range(cols)]
        for i in range(rows):
            tmp_dp = []
            for j in range(cols):
                if matrix[i][j] == '1':
                    tmp_dp.append(dp[j] + 1)
                else:
                    tmp_dp.append(0)
            max_area = max(max_area, self.largestRectangleArea(tmp_dp))
            dp = tmp_dp
        return max_area

    def largestRectangleArea(self, heights: List[int]) -> int:
        if not heights:
            return 0
        heights.append(0)
        stack = []
        max_area = 0
        for i, height in enumerate(heights):
            if not stack or stack[-1][1] < height:
                stack.append((i, height))
                continue
            while stack and stack[-1][1] >= height:
                top_index, top_ele = stack[-1]
                stack.pop(-1)
                width = i if not stack else i- stack[-1][0]-1
                area = width * top_ele
                max_area = max(max_area, area)
            stack.append((i, height))
        return max_area

def main():
    sol = Solution()
    result = sol.maximalRectangle([
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
])
    print(result)
    # result = sol.largestRectangleArea([2,1,5,6,2,2,2,3])
    # print(result)
    # result = sol.largestRectangleArea([2,1,1])
    # print(result)
if __name__ == "__main__":
    main()