from typing import List
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        if not matrix:
            return 0
        rows = len(matrix)
        cols = len(matrix[0])
        left, right = matrix[0][0], matrix[rows-1][cols-1]
        while left < right:
            mid = left + (right-left)//2
            count = 0
            for i in range(len(matrix)):
                index = self.upper_bound_count(mid, matrix[i])
                count += index
            if count < k:
                left = mid + 1
            else:
                right = mid
        return left
    def upper_bound_count(self, target, nums):
        l, r = 0, len(nums)
        while l < r:
            mid = l + (r-l)//2
            if nums[mid] <= target:
                l = mid + 1
            else:
                r = mid
        return l


def main():
    sol = Solution()
    result = sol.kthSmallest([
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],8)
    print(result)


if __name__ == "__main__":
    main()

