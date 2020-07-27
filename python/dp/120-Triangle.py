import sys
from typing import List
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if not triangle:
            return 0
        N = len(triangle)
        if N == 1:
            return triangle[0][0]
        min_length = [triangle[0][0]]
        for i in range(1, N):
            tmp_list = [min_length[0] + triangle[i][0]]
            for j in range(1, len(triangle[i])):
                min_length_j = min_length[j] if j < len(min_length) else sys.maxsize
                minimum_total = min(min_length[j-1], min_length_j) + triangle[i][j]
                tmp_list.append(minimum_total)
            min_length = tmp_list
        return min(min_length)


def main():
    sol = Solution()
    result = sol.minimumTotal([
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
])
    print(result)

if __name__ == "__main__":
    main()