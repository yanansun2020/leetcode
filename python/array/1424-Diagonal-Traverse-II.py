from collections import defaultdict
from typing import List
class Solution:
    def findDiagonalOrder(self, nums: List[List[int]]) -> List[int]:
        memo = defaultdict(list)
        for i in range(len(nums)):
            for j in range(len(nums[i])):
                memo[i+j].append(nums[i][j])
        result = []
        for key, value in sorted(memo.items()):
            result.extend(value[::-1])
        return result

def main():
    sol = Solution()
    result = sol.findDiagonalOrder([[1,2,3],[4,5,6],[7,8,9]])
    print(result)
    result = sol.findDiagonalOrder([[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]])
    print(result)
    result = sol.findDiagonalOrder([[1,2,3],[4],[5,6,7],[8],[9,10,11]])
    print(result)
    result = sol.findDiagonalOrder([[1,2,3,4,5,6]])
    print(result)
if __name__ == "__main__":
    main()
